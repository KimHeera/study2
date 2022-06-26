package sketchbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;

//String[] itemtooltext = {"Pen", "Line", "Circle", "Rectalgle", "Mouse"};

public class Tool implements ActionListener{

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "Pen" :{
				Sketch.str1 = "Pen";
				Sketch.str3 ="";
				break;
			}
			case "Line" :{
				Sketch.str1 = "Line";
				Sketch.str3 ="";
			
				break;
			}
			case "Circle" :{
				Sketch.str1 = "Circle";
				Sketch.str3 ="";
			
				break;
			}
			case "Rectalgle" :{
				Sketch.str1 = "Rectalgle";
				Sketch.str3 ="";
				break;
			}
			case "Mouse" :{
				Sketch.str1 = "Mouse";
				Sketch.str3 ="";
				break;
			}
		}
		Sketch.outputTool.setText(Sketch.str1);
		System.out.println("Tool 선택 : " + Sketch.str1);
		
	}
	
}


