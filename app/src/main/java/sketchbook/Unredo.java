package sketchbook;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Unredo implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		
		
		switch(cmd) { // 메뉴 아이템 구분
        case "<-":{
        	if(CanversOpen.sv.size()!=0) {
        		CanversOpen.save.push(CanversOpen.sv.get(CanversOpen.sv.size()-1));
            	CanversOpen.sv.remove(CanversOpen.sv.size()-1);
            	
            	CanversOpen.startP=null;
            	CanversOpen.endP=null;
            	
            	Sketch.panel1.repaint();
        		
        	}
  
        	
        	break;
        }
        case "->":{
        	if(CanversOpen.save.size()!=0) {

            	CanversOpen.sv.add(CanversOpen.save.pop());
            	
            	CanversOpen.startP=null;
            	CanversOpen.endP=null;
            	
            	Sketch.panel1.repaint();
        		
        	}
        	
        	
        	
//        	CanversOpen.sv.add(save.pop());
      
        	
        	break;
        }
        
		}
		
		
	}
	
}