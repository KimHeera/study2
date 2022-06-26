package sketchbook;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Sketch extends JFrame{
	public static JFrame frame = new JFrame();
	public static String str1 = "Mouse";
	public static String str2 = "Thickness";
	public static String str3 = "";
	
	public static String str4 = "";
	
	public static int stroke = 10;
	
	static JPanel panel1 = new JPanel();
	static JPanel panel2 = new JPanel();
	
	static JLabel outputTool;
	
	static Color color;
	static JButton colorchange;
	
	static boolean undo;
	static boolean redo;
	
	static int docount = 0;
	
	
	
	
	
	//그림판
	//기본 GUI 만드는 곳
	
	//메인 메소드
	public static void main(String[] args) {
		
		menuu(frame);
		new CanversOpen();
	
		
	}
	
	
	public static void menuu(JFrame frame) {
		
		JMenuBar menu = new JMenuBar();
	
		
		//JMenu 만
		JMenu menu_tool = new JMenu("Tool");
		JMenu menu_property = new JMenu("Property");
		JMenu menu_erase = new JMenu("Eraser");
		
		
//		JMenu menu_undo = new JMenu("<-");
//		JMenu menu_redo = new JMenu("->");
		

		JMenuItem menu_undo = new JMenuItem("<-");
		JMenuItem menu_redo = new JMenuItem("->");
		
		Unredo u = new Unredo();
		menu_undo.addActionListener(u);
		menu_redo.addActionListener(u);
		
		////////////////////////////////////
		
		
		//메뉴 아이템들 만듦, 간단함을 위해 배열로 만들었
		JMenuItem [] menutoolItem = new JMenuItem [5];
		JMenuItem [] menupropertyItem = new JMenuItem [2];
		JMenuItem [] menueraseItem = new JMenuItem [3];
		
		String[] itemtooltext = {"Pen", "Line", "Circle", "Rectalgle", "Mouse"};
		String[] itemprotext = {"Thickness", "Color"};
		String[] itemerasetext = {"All clear", "Clear with pixel", "Clear stroke"};
		
		//////////////////////////////////////

		//Tool 클래스 객체 생성, Tool 메뉴 아이템 누르면 이벤트 되도록
		Tool T = new Tool();
		for(int i=0; i<menutoolItem.length; i++) {
			menutoolItem[i] = new JMenuItem(itemtooltext[i]); 
			menutoolItem[i].addActionListener(T); 
			menu_tool.add(menutoolItem[i]);
		}
		
		//Property 클래스 객체 생성, Tool 메뉴 아이템 누르면 이벤트 되도록
		Property P = new Property();
		for(int i=0; i<menupropertyItem.length; i++) {
			menupropertyItem[i] = new JMenuItem(itemprotext[i]); 
			menupropertyItem[i].addActionListener(P); 
			menu_property.add(menupropertyItem[i]);
		}
		
		//Eraser 클래스 객체 생성, Tool 메뉴 아이템 누르면 이벤트 되도록
		Eraser E = new Eraser();
		for(int i=0; i<menueraseItem.length; i++) {
			menueraseItem[i] = new JMenuItem(itemerasetext[i]); 
			menueraseItem[i].addActionListener(E); 
			menu_erase.add(menueraseItem[i]);
		}
		
		
		//만든 아이템들 모두 메뉴바에 넣기
		menu.add(menu_tool);
		menu_tool.add(menu_erase); //tool 메뉴에 erase메뉴 넣주기
		
		
		menu_tool.add(menu_undo);
		menu_tool.add(menu_redo);
		
		menu.add(menu_property);
		
		
		//프레임에 메뉴넣기 
		frame.add(menu);
		 
//		//패널 사이즈 지정
		panel1.setLayout(null);
    	panel1.setBounds(0, 50, 1200, 800);
//    	//패널 색 바꾸기
		
		panel1.setBackground(Color.WHITE);
		panel1.setOpaque(true);
//		
//		
//		panel2.setLayout(null);
//		panel1.setBounds(0, 0, 1200, 30);
//		panel2.setBackground(Color.BLACK);
//		panel1.setOpaque(true);

//		//현재 뭘 선택했는지 띄우는 라벨 Tool.ver
		outputTool = new JLabel(str1);
		outputTool.setBounds(21, 0, 130, 60);
		outputTool.setHorizontalAlignment(JLabel.LEFT);
		outputTool.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		frame.add(outputTool, BorderLayout.PAGE_END);
		
		colorchange = new JButton();
		colorchange.setOpaque(true);//배경색 적용을 허용하겠다.
		colorchange.setBorderPainted(false);	//포커스 표시 설
		colorchange.setBackground(color);
		
		colorchange.setBackground(Color.BLACK);
		colorchange.setOpaque(true);
		colorchange.setBounds(90, 21, 25, 25);
		colorchange.setVisible(true);//보이게
		frame.add(colorchange, BorderLayout.PAGE_END);
		
		frame.add(panel1);
		
		//프레임에 만든 거 넣어주기
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setJMenuBar(menu);
		frame.setTitle("Grapic Editor"); //타이틀
		frame.setSize(1200, 700); //프레임 초기 사이즈
		frame.setLayout(null); //레이아웃은 null
		frame.setResizable(true); //프레임크기 조절 가능
		frame.setVisible(true); //프레임이 보이도록
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 활성
		
		

		
	}
	
	
	
}
