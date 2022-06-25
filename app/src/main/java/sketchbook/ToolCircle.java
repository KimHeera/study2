package sketchbook;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class ToolCircle extends JPanel{
//	
//	Point startP=null;
//	Point endP=null;
//	
//	ArrayList<Point> sv = new ArrayList<Point>(); // 시작
//	ArrayList<Point> se = new ArrayList<Point>(); // 끝점
////	
//	ArrayList<Integer> s = new ArrayList<Integer>(); // 끝점
//	
//	
//	//int strokes = Sketch.stroke;
//	Color colors = Sketch.color;
//	
//	public ToolCircle(){
//		//리스너를 공통으로해야  변수들이 공유된다.
//		MyMouseListener ml = new MyMouseListener();
//		
//		
//		this.addMouseListener(ml); // 리스너
//		this.addMouseMotionListener(ml);
//		
//		//setBackground(Color.WHITE);
//		
//		this.setBounds(0, 0, 1200, 800);
//		this.setBackground(Color.WHITE);
//		this.setOpaque(true);
//		Sketch.panel1.add(this);
//		
//	}
//	
//	
//	//공통 사용 
//	public void paintComponent(Graphics g){
//		super.paintComponent(g); // 부모 페인트호출
//		
//		Graphics2D g2=(Graphics2D)g;
//		
//		
//		g2.setStroke(new BasicStroke(Sketch.stroke));
//		g2.setColor(Sketch.color);
//		
//		
//		if(sv.size() != 0){
//			for(int i=0;i<se.size();i++){ //벡터크기만큼
//				Point sp = sv.get(i); // 벡터값을꺼내다
//				Point ep = se.get(i);
//			
//				g.drawOval(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y),Math.abs(ep.x- sp.x),Math.abs(ep.y- sp.y));
//				
//				
//			}
//		}
//		if(startP != null) {
//			
//			g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
//			
//		}
//	}
//	
//	
//	
//	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
//		public void mousePressed(MouseEvent e){
//			startP = e.getPoint();
//			sv.add(e.getPoint()); // 클릭한부분을 시작점으로
//		}
//		public void mouseReleased(MouseEvent e){
//			se.add(e.getPoint()); // 드래그 한부분을 종료점으로
//			endP = e.getPoint();
//			repaint(); // 다시그려라
//		}
//		
//		public void mouseDragged(MouseEvent e){
//			endP = e.getPoint();
//			repaint();
//		}
//		
//		public void mouseMoved(MouseEvent e){
//			
//		}
//	}
}
