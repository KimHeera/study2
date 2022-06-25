package sketchbook;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

//import sketchbook.ToolLine.MyPanel.MyMouseListener;

public class ToolPen extends JPanel{
	
	
	
	static Point startP=null;
	static Point endP=null;
	
	static ArrayList<Point> sv = new ArrayList<Point>(); // 시작
	static ArrayList<Point> se = new ArrayList<Point>(); // 끝점
	
	

	public ToolPen(){
		//리스너를 공통으로해야  변수들이 공유된다.
		MyMouseListener ml = new MyMouseListener();
		
		addMouseListener(ml); // 리스너
		addMouseMotionListener(ml);
		setBounds(0, 0, 1200, 700);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); // 부모 페인트호출
		
		if(sv.size() != 0){
			for(int i=0;i<se.size();i++){ //벡터크기만큼
				Point sp = sv.get(i); // 벡터값을꺼내다
				Point ep = se.get(i);	
				g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
			}
		}
		if(startP != null)
			g.drawLine(startP.x, startP.y, endP.x, endP.y);				
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		public void mousePressed(MouseEvent e){
			startP = e.getPoint();
			sv.add(e.getPoint()); // 클릭한부분을 시작점으로
		}
		public void mouseReleased(MouseEvent e){
			se.add(e.getPoint()); // 드래그 한부분을 종료점으로
			endP = e.getPoint();
			repaint(); // 다시그려라
		}
		
		public void mouseDragged(MouseEvent e){
			endP = e.getPoint();
			repaint();
		}
		
		public void mouseMoved(MouseEvent e){
			
		}
	}
}
