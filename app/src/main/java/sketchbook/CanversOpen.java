package sketchbook;

import java.awt.BasicStroke;
import java.awt.Color;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

public class CanversOpen extends JPanel{
	
	static Point startP= null;
	static Point endP=null;
	static Stack<array> save = new Stack<array>();
	static ArrayList<array> allsave = new ArrayList<array>();
	public static BufferedImage image;
	static int count = 0;
	
	static boolean is = false;
	static Image iss;
	
	
	static ArrayList<array> sv = new ArrayList<array>();
	public static boolean isLoaded;
	ArrayList<Point> pp =null;
	
	public CanversOpen(){
		//리스너를 공통으로해야  변수들이 공유된다.
		MyMouseListener ml = new MyMouseListener();
		
		
		this.addMouseListener(ml); // 리스너
		this.addMouseMotionListener(ml);
		
		this.setBounds(0, 0, 1200, 700);
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
		
		if(is) {
			g.drawImage(iss, 0, 0, this);
		}
		
		if(sv.size() != 0){
			if(is) {
				g.drawImage(iss, 0, 0, this);
			}
			
			System.out.println("크기 " + sv.size() );
			for(array c:sv){ //벡터크기만큼
				
				if(c.tool.equals("Clear with pixel")) {
					g2.setStroke(new BasicStroke(c.thick, BasicStroke.CAP_ROUND,0));
					
					g2.setColor(Color.WHITE);
					Point previousPoint = c.p.get(0);
					for(Point Q :c.p) {
						g.drawLine(previousPoint.x, previousPoint.y, Q.x, Q.y);
						previousPoint = Q;
					}
				}
				
				if(c.tool.equals("Pen")) {
					g2.setStroke(new BasicStroke(c.thick, BasicStroke.CAP_ROUND,0));
					
					
					g2.setColor(c.color);
					
					Point previousPoint = c.p.get(0);
					for(Point Q :c.p) {
						g.drawLine(previousPoint.x, previousPoint.y, Q.x, Q.y);
						previousPoint = Q;
					}
					
				}
				if(c.tool.equals("Line")) {
					g2.setStroke(new BasicStroke(c.thick));
					
					
					g2.setColor(c.color);
					g.drawLine(c.sp.x, c.sp.y, c.ep.x, c.ep.y);//그리다
				}
				else if(c.tool.equals("Circle")) {
					g2.setStroke(new BasicStroke(c.thick, BasicStroke.CAP_ROUND,0));
					
					
					
					g2.setColor(c.color);
					g.drawOval(Math.min(c.sp.x, c.ep.x), Math.min(c.sp.y, c.ep.y),Math.abs(c.ep.x- c.sp.x),Math.abs(c.ep.y- c.sp.y));
				}
				else if(c.tool.equals("Rectalgle")) {
					g2.setStroke(new BasicStroke(c.thick, BasicStroke.CAP_ROUND,0));
					
					
					g2.setColor(c.color);
					g.drawRect(Math.min(c.sp.x, c.ep.x), Math.min(c.sp.y, c.ep.y),Math.abs(c.ep.x- c.sp.x),Math.abs(c.ep.y- c.sp.y));
				}
				else if(c.tool.equals("Mouse")) {
					
				}
			}
		}
		
		/////////////////////// 현재 값 그려주는 코드 
		if(startP != null) {
			
			if(Sketch.str1.equals("Clear with pixel")) {
				g2.setStroke(new BasicStroke(Sketch.stroke, BasicStroke.CAP_ROUND,0));
				g2.setColor(Color.WHITE);
				Point previousPoint = pp.get(0);
				for(Point c:pp) {
					g.drawLine(previousPoint.x, previousPoint.y, c.x, c.y);
					previousPoint = c;
				}
			}
			if(Sketch.str1.equals("Pen")) {
				g2.setStroke(new BasicStroke(Sketch.stroke, BasicStroke.CAP_ROUND,0));
				
				g2.setColor(Sketch.color);
				
				Point previousPoint = pp.get(0);
				for(Point c:pp) {
					g.drawLine(previousPoint.x, previousPoint.y, c.x, c.y);
					previousPoint = c;
				}
				
			}
			if(Sketch.str1.equals("Line")) {
				g2.setStroke(new BasicStroke(Sketch.stroke));
				
				g2.setColor(Sketch.color);
				g.drawLine(startP.x, startP.y, endP.x, endP.y);	//그리다
			}
			
			else if(Sketch.str1.equals("Circle")) {
				g2.setStroke(new BasicStroke(Sketch.stroke, BasicStroke.CAP_ROUND,0));
				
				g2.setColor(Sketch.color);
				g.drawOval(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(Sketch.str1.equals("Rectalgle")) {
				g2.setStroke(new BasicStroke(Sketch.stroke, BasicStroke.CAP_ROUND,0));
				
				g2.setColor(Sketch.color);
				g.drawRect(Math.min(startP.x, endP.x), Math.min(startP.y, endP.y),Math.abs(endP.x- startP.x),Math.abs(endP.y- startP.y));
			}
			else if(Sketch.str1.equals("Mouse")) {
				
			}
		}
	}
	
	
	
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener{
		
		
		public void mousePressed(MouseEvent e){
			pp = new ArrayList<Point>();
			
			startP = e.getPoint();
		
		}
		
		public void mouseReleased(MouseEvent e){
			
			endP = e.getPoint();	
			
			pp.add(endP);
			new array(startP, endP);
			
			if(!Sketch.str1.equals("Pen") && !Sketch.str1.equals("Clear with pixel") && !Sketch.str1.equals("Mouse")) {
				array arr = new array(Sketch.color, Sketch.stroke, Sketch.str1, startP, endP);
				sv.add(arr);
			}
			
			if(Sketch.str1.equals("Pen") && !Sketch.str1.equals("Mouse")){
				array arr = new array(Sketch.color, Sketch.stroke,Sketch.str1, startP, endP, pp);
				sv.add(arr);
			}
			
			if(Sketch.str1.equals("Clear with pixel") && !Sketch.str1.equals("Mouse")) {
				array arr = new array(Sketch.color, Sketch.stroke,Sketch.str1, startP, endP, pp);
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
		
		public void mouseClicked(MouseEvent e) {
			pp.add(endP);
		}
	}
	
	public static class array{
		Color color;
		int thick;
		String tool;
		
		
		Point sp;
		Point ep;
		
		ArrayList<Point> p = new ArrayList<Point>();
		
		array(){};
		
		array(Color color, int thick, String tool, Point sp, Point ep){
			this.color = color;
			this.thick = thick;
			this.tool = tool;
			
			this.sp = sp;
			this.ep = ep;
		}
		
		array(Color color, int thick,String tool, Point sp, Point ep, ArrayList<Point> p){
			this.color = color;
			this.thick = thick;
			this.tool = tool;
			
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
