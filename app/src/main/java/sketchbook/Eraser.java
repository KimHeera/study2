package sketchbook;
import java.awt.Color;
//
//import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
//import javax.swing.JMenuItem;
//String[] itemprotext = {"Thickness", "Color"};

import sketchbook.CanversOpen.array;

public class Eraser implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "All clear" :{
				Sketch.str3 = "All clear";
				
//				CanversOpen.save.clear();
				
				for(int i = CanversOpen.sv.size()-1 ; i >=0;i--) {
					CanversOpen.save.push(CanversOpen.sv.get(i));
				}
				
				CanversOpen.sv.clear();
				
//				for(int i = CanversOpen.sv.size()-1 ; i >=0;i--) {
//					
//					array n =CanversOpen.sv.get(i);
////				
////					CanversOpen.save.push(n);
//					
//					array.color = Color.WHITE;
//				}
				
				CanversOpen.startP=null;
	        	CanversOpen.endP=null;
	        	
	        	Sketch.panel1.repaint();
			
				break;
			}
			case "Clear with pixel" :{
				Sketch.str3 = "Clear with pixel";
				
				
				break;
			}
			case "Clear stroke" :{
				Sketch.str3 = "Clear stroke";
				break;
			}
		}
		
		
		
		System.out.println("Eraser 선택 : " + Sketch.str3);
	}
}
