package sketchbook;

import java.awt.BasicStroke;
import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;


public class CanversOpen extends JPanel{
	
	static Point startP= null;
	static Point endP=null;
	static Stack<array> save = new Stack<array>();
	
	
	static ArrayList<array> sv = new ArrayList<array>();
	ArrayList<Point> pp =null;
	

	//int strokes = Sketch.stroke;
//	Color colors = Sketch.color;
	
	public CanversOpen(){
		//리스너를 공통으로해야  변수들이 공유된다.
		MyMouseListener ml = new MyMouseListener();
		
		
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
		
		//setBackground(Color.WHITE);
		
		this.setBounds(0, 0, 1200, 800);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		Sketch.panel1.add(this);
		
	}
	
	
	
	
	//공통 사용 
	public void paintComponent(Graphics g){
		
		
		super.paintComponent(g); // 부모 페인트호출
		
		
		System.out.println("색깔 : " + Sketch.color );
		System.out.println("굵기 : " + Sketch.stroke );
		System.out.println("tool " + Sketch.str1 );
		System.out.println("start point" + startP );
		System.out.println("end point" + endP );
		
		Graphics2D g2=(Graphics2D)g;
		
		array arr = new array();

		
		if(sv.size() != 0){
			
//			if(Sketch.str3.equals("Clear with pixel")) {
//				g2.setColor(Color.WHITE);
//				Point previousPoint = c.p.get(0);
//				for(Point Q :c.p) {
//					g.drawLine(previousPoint.x, previousPoint.y, Q.x, Q.y);
//					previousPoint = Q;
//				}					
//			}
//			
//			if(Sketch.str3.equals("Clear stroke")){
//				g2.setColor(Color.WHITE);
//				g.drawLine(c.sp.x, c.sp.y, c.ep.x, c.ep.y);
//			}
			
			
			System.out.println("크기 " + sv.size() );
			for(array c:sv){ //벡터크기만큼
				
				
				
				g2.setStroke(new BasicStroke(c.thick));
				g2.setColor(c.color);
				
				if(c.er.equals("Clear with pixel")) {
					g2.setColor(Color.WHITE);
					
				}
				
				if(c.tool.equals("Pen")) {
					
					Point previousPoint = c.p.get(0);
					for(Point Q :c.p) {
						g.drawLine(previousPoint.x, previousPoint.y, Q.x, Q.y);
						previousPoint = Q;
					}
					
				}
				if(c.tool.equals("Line")) {
					g.drawLine(c.sp.x, c.sp.y, c.ep.x, c.ep.y);//그리다
				}
				else if(c.tool.equals("Circle")) {
					g.drawOval(Math.min(c.sp.x, c.ep.x), Math.min(c.sp.y, c.ep.y),Math.abs(c.ep.x- c.sp.x),Math.abs(c.ep.y- c.sp.y));
				}
				else if(c.tool.equals("Rectalgle")) {
					g.drawRect(Math.min(c.sp.x, c.ep.x), Math.min(c.sp.y, c.ep.y),Math.abs(c.ep.x- c.sp.x),Math.abs(c.ep.y- c.sp.y));
				}
				else if(c.tool.equals("Mouse")) {
					
				}
			}
		}
		if(startP != null) {
			g2.setStroke(new BasicStroke(Sketch.stroke));
			g2.setColor(Sketch.color);

			if(Sketch.str1.equals("Pen")) {
//				if(Sketch.str3.equals("Clear with pixel")) {
//					g2.setColor(Color.WHITE);
//					
//				}
				
				Point previousPoint = pp.get(0);
				for(Point c:pp) {
					g.drawLine(previousPoint.x, previousPoint.y, c.x, c.y);
					previousPoint = c;
				}
				
			}
			if(Sketch.str1.equals("Line")) {
				g.drawLine(startP.x, startP.y, endP.x, endP.y);	//그리다
			}
			
			else if(Sketch.str1.equals("Circle")) {
				g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(Sketch.str1.equals("Rectalgle")) {
				g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(Sketch.str1.equals("Mouse")) {
				
			}
		}
		
		////////////////////지우개
		
		if(Sketch.str3.equals("Clear with pixel")) {
			g2.setColor(Color.WHITE);
			Point previousPoint = pp.get(0);
			for(Point c:pp) {
				g.drawLine(previousPoint.x, previousPoint.y, c.x, c.y);
				previousPoint = c;
			}
			
		}
		
		if(Sketch.str3.equals("Clear stroke")){
			g2.setColor(Color.WHITE);
			g.drawLine(startP.x, startP.y, endP.x, endP.y);
		}
	}
	
	
	
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		
		
		public void mousePressed(MouseEvent e){
			pp = new ArrayList<Point>();
			
			startP = e.getPoint();
			
			
			
			
		}
		public void mouseReleased(MouseEvent e){
			endP = e.getPoint();	
			new array(startP, endP);
			
			if(!Sketch.str1.equals("Pen")) {
				array arr = new array(Sketch.color, Sketch.stroke, Sketch.str3, Sketch.str1, startP, endP);
				sv.add(arr);
			}
			
			
			if(Sketch.str1.equals("Pen")){
				array arr = new array(Sketch.color, Sketch.stroke, Sketch.str3,Sketch.str1, startP, endP, pp);
				sv.add(arr);
			}
			
			repaint(); // 다시그려라
		}
		
		public void mouseDragged(MouseEvent e){
			
			endP = e.getPoint();
			
			pp.add(endP);
			
			repaint();
			
		}
		
		public void mouseMoved(MouseEvent e){
			
		}
		
		public void mouseEntered(MouseEvent e) {
			startP = e.getPoint();
			endP = e.getPoint();
			
			System.out.println("까꿍");
		}
	}
	
	public static class array{
		static Color color;
		int thick;
		String tool;
		String er;
		
		Point sp;
		Point ep;
		
		ArrayList<Point> p = new ArrayList<Point>();
		
		array(){};
		
		array(Color color, int thick, String er, String tool, Point sp, Point ep){
			this.color = color;
			this.thick = thick;
			this.tool = tool;
			this.er = er;
			
			this.sp = sp;
			this.ep = ep;
		}
		
		array(Color color, int thick, String er,String tool, Point sp, Point ep, ArrayList<Point> p){
			this.color = color;
			this.thick = thick;
			this.tool = tool;
			this.er = er;
			
			this.sp = sp;
			this.ep = ep;
			
			for(int i=0;i<p.size();i++) {
				this.p.add(p.get(i));
			}
			
		}
		
		array(Point sp, Point ep){
			this.sp = sp;
			this.ep = ep;
		}
	}
	
	
}
