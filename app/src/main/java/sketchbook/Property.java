package sketchbook;

import java.awt.AWTException;
import java.awt.FileDialog;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
			case "저장하기" :{
				CanversOpen.count++;		
				try {
		            CanversOpen.image = new Robot().createScreenCapture(new Rectangle(Sketch.panel1.getLocationOnScreen().x, Sketch.panel1.getLocationOnScreen().y,Sketch.panel1.getWidth(), Sketch.panel1.getHeight()));
		            System.out.println(CanversOpen.image);
		         } catch (AWTException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		         }
				
				
				 File file = new File("/Volumes/Macintosh HD - Data/Heera's drawing" + "/"+ CanversOpen.count+".png");

				 if (!file.exists())
			         try {
			            file.createNewFile();
			         } catch (IOException e1) {
			            // TODO Auto-generated catch block
			            e1.printStackTrace();
			         }
			      try {
			         ImageIO.write(CanversOpen.image, "png", file);
			      } catch (IOException e1) {
			         // TODO Auto-generated catch block
			         e1.printStackTrace();
			      }
			
				break;
			}
			
			case "불러오기" :{
				FileDialog fileDialogOpen = new FileDialog(Sketch.frame, "파일 열기", FileDialog.LOAD);
                fileDialogOpen.setVisible(true);
                String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
                if(filePath.contains(".png")) {
                   try {
                      CanversOpen.is =true;
                      CanversOpen.iss = ImageIO.read(new File(filePath));
                      Sketch.panel1.repaint();
                     } catch (IOException ex) {
                          // handle exception...
                     }
                   

			}
		}
		

		
		System.out.println("Property 선택 : " + Sketch.str2);
		}
	}
	
	

}
