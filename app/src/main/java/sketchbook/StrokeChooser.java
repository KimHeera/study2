package sketchbook;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;

public class StrokeChooser extends JFrame{
   JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100,	Sketch.stroke);
   JLabel l = new JLabel();
   
   public StrokeChooser(){
      this.setTitle("Thickness");
      this.setLocation(400, 200);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
      pack();
      setVisible(true);
      slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        Sketch.stroke = slider.getValue();
        slider.addChangeListener(new MyChangeListener());
        l.setText("선택한 굵기 : " + Sketch.stroke);
        l.setBounds(20,20,150,40);
        this.add(l, BorderLayout.NORTH);
        System.out.println(Sketch.stroke);
        this.add(slider, BorderLayout.CENTER);
        this.setSize(600,300);
        this.setVisible(true);
   }
    class MyChangeListener implements ChangeListener{

      @Override
      public void stateChanged(ChangeEvent e) {
         // TODO Auto-generated method stub
         Sketch.stroke = slider.getValue();
           l.setText("슬라이더를 움직이세요 : "+Sketch.stroke);
           
      }
    }
}