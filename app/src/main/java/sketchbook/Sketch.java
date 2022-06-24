package sketchbook;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sketch extends JFrame{
	public static JFrame frame = new JFrame();
	//그림판
	//기본 GUI 만드는 곳
	
	//메인 메소드
	public static void main(String[] args) {
		 
		
		menuu(frame);
	}
	
	public static void menuu(JFrame frame) {
		JMenuBar menu = new JMenuBar();

		JMenu menu_tool = new JMenu("Tool");
		JMenu menu_property = new JMenu("Property");
		JMenu menu_erase = new JMenu("Eraser");
		
		////////////////////////////////////
		
		JMenuItem menu_tool_pen = new JMenuItem("Pen");
		JMenuItem menu_tool_line = new JMenuItem("Line");
		JMenuItem menu_tool_circle = new JMenuItem("Circle");
		JMenuItem menu_tool_rect = new JMenuItem("Rectalgle");
		JMenuItem menu_tool_mouse = new JMenuItem("Mouse");
		
		menu_tool.add(menu_tool_pen);
		menu_tool.add(menu_tool_line);
		menu_tool.add(menu_tool_circle);
		menu_tool.add(menu_tool_rect);
		menu_tool.add(menu_tool_mouse);
		
		/////////////////////////////////////////
		
		JMenuItem menu_property_thickness = new JMenuItem("Thickness");
		JMenuItem menu_property_color = new JMenuItem("Color");
		
		menu_property.add(menu_property_thickness);
		menu_property.add(menu_property_color);
		
		//////////////////////////////////////////
		
		JMenuItem menu_erase_everything = new JMenuItem("Clear All");
		JMenuItem menu_erase_pixel = new JMenuItem("Clear with pixel");
		JMenuItem menu_erase_obgect = new JMenuItem("Clear stroke");
		
		menu_erase.add(menu_erase_everything);
		menu_erase.add(menu_erase_pixel);
		menu_erase.add(menu_erase_obgect);
		
		  
		menu.add(menu_tool);
		menu.add(menu_property);
		menu.add(menu_erase);
		frame.add(menu);
		
		//프레임에 만든 거 넣어주기
		frame.setJMenuBar(menu);
		frame.setJMenuBar(menu);
		frame.setTitle("Grapic Editor"); //타이틀
		frame.setSize(1000, 700); //프레임 초기 사이즈
		frame.setLayout(null); //레이아웃은 null
		frame.setResizable(true); //프레임크기 조절 가능
		frame.setVisible(true); //프레임이 보이도록
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 활성
		
	}
	
}
