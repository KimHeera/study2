package sketchbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;

public class Tool implements ActionListener{

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "Pen" :{
				Sketch.str1 = "Pen";
				
				break;
			}
			case "Line" :{
				Sketch.str1 = "Line";
			
				break;
			}
			case "Circle" :{
				Sketch.str1 = "Circle";
			
				break;
			}
			case "Rectalgle" :{
				Sketch.str1 = "Rectalgle";
				break;
			}
			case "Mouse" :{
				Sketch.str1 = "Mouse";
				break;
			}
		}
		Sketch.outputTool.setText(Sketch.str1);
		System.out.println("Tool 선택 : " + Sketch.str1);
		
	}
	
}


