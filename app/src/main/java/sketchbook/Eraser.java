package sketchbook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Eraser implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "All clear" :{
				Sketch.str1 = "All clear";
				
				for(int i = 0 ; i <= CanversOpen.sv.size()-1;i++) {
					CanversOpen.allsave.add(CanversOpen.sv.get(i));
				}
				CanversOpen.is =false;
				CanversOpen.sv.clear();
				
				CanversOpen.startP=null;
	        	CanversOpen.endP=null;
	        	
	        	Sketch.panel1.repaint();
			
				break;
			}
			case "Clear with pixel" :{
				Sketch.str1 = "Clear with pixel";
				
				
				break;
			}
		}
		
		
		
		System.out.println("Eraser 선택 : " + Sketch.str1);
	}
}
