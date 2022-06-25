import javax.swing.*;

import java.awt.*;

import java.util.*;

import javax.swing.JFrame;

import java.awt.event.*;



public class Demo2 extends JFrame {

 

 Demo2() {

  setTitle("마우스로 곡선 그리기");

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  MyPanel t = new MyPanel();

  setContentPane(t);

  t.setFocusable(true);

  setSize(300, 300);

  setVisible(true);

 }



 public static void main(String[] args) {

  new Demo2();

 }



 class MyPanel extends JPanel {



  Vector<Point> vStart = new Vector<Point>();



  public MyPanel() {



   addKeyListener(new KeyListener() {



    @Override

    public void keyTyped(KeyEvent e) {

     // TODO Auto-generated method stub



    }



    @Override

    public void keyReleased(KeyEvent e) {

     // TODO Auto-generated method stub



    }



    @Override

    public void keyPressed(KeyEvent e) {

     // TODO Auto-generated method stub

     switch (e.getKeyCode()) {

     case KeyEvent.VK_ENTER:

      vStart.removeAllElements();

      repaint();

      break;

     }

    }

   });



   addMouseMotionListener(new MouseMotionAdapter() {

    public void mouseDragged(MouseEvent e) { 

     vStart.add(e.getPoint());

     repaint();



    }

   });



   // 마우스 이벤트 처리

   addMouseListener(new MouseAdapter() {

    // 마우스를 누르면 호출된다.

    public void mousePressed(MouseEvent e) {

     vStart.add(null);

     vStart.add(e.getPoint());

    }



   });



  }



  public void paintComponent(Graphics g) {



   super.paintComponent(g);

   g.setColor(Color.BLUE); // 파란색을 선택한다.



   for (int i = 1; i < vStart.size(); i++) {



    if (vStart.get(i - 1) == null)

     continue;

    else if (vStart.get(i) == null)

     continue;

    else

     g.drawLine((int) vStart.get(i - 1).getX(), (int) vStart.get(i - 1).getY(),

       (int) vStart.get(i).getX(), (int) vStart.get(i).getY());



   }

  }

 }
}

