package sketchbook;


import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.colorchooser.ColorSelectionModel;

public class ColorChooser extends JFrame implements ChangeListener{
   JColorChooser colorChooser = new JColorChooser();
   
   ColorSelectionModel model = colorChooser.getSelectionModel();

   static boolean colorChange;
  
   
   @Override
   public void stateChanged(ChangeEvent e) {
      Sketch.color = colorChooser.getColor();
      Sketch.colorchange.setBackground(Sketch.color);
      colorChange = true;
   }
   
   public ColorChooser(){
      setTitle("Color");
      setLocation(400, 200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      colorChooser.getSelectionModel().addChangeListener(this);
      
      add(colorChooser);
      pack();
      setVisible(true);
   }

}
