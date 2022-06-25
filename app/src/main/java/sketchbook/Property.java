package sketchbook;

import java.awt.BasicStroke;
//import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JMenuItem;

//String[] itemerasetext = {"All clear", "clear with pixel", "Clear stroke"};

public class Property implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "Thickness" :{
				Sketch.str2 = "Thickness";
				
				StrokeChooser S = new StrokeChooser();
			
		
				System.out.println("Thickness : " + Sketch.stroke);
				break;
			}
			case "Color" :{
				Sketch.str2 = "Color";
				
				ColorChooser C = new ColorChooser();
				
			
				break;
			}
		}
		

		
		System.out.println("Property 선택 : " + Sketch.str2);
	}
	
	

}
