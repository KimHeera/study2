package sketchbook;
//
//import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//
//import javax.swing.JMenuItem;
//String[] itemprotext = {"Thickness", "Color"};

public class Eraser implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "All clear" :{
				Sketch.str3 = "All clear";
				
			
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
