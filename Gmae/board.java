/*package Gmae;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class board extends JPanel implements ActionListener {
    player p;
    Image background, menuBg;
    Timer time;
    //private menu Menu;
    private Main Frame;

    public static enum STATE {MENU,GAME};

    public static STATE State = STATE.MENU;

    public board() {
        this.addMouseListener(new mouseInput());
        p = new player();
        //Menu = new Gmae.menu();

        addKeyListener(new AL());
        setFocusable(true);
        //ImageIcon i = new ImageIcon("menu.54SxU.png");
        //menuBg = i.getImage();
        //ImageIcon gribok = new ImageIcon("src/images/e97905af-d5de-47b3-83e6-f8f002b765f1.7GwrM.png");
        //Image mushrooms = gribok.getImage();
        ImageIcon i = new ImageIcon("evilmario_background.qwhBC.png");
        background = i.getImage();

        time = new Timer(20,this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }

    public void paintComponent(Graphics g) {
        if(State==STATE.GAME) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(background, -p.nx, 0, null);
            g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);


            if(-p.nx<-975)
                p.nx=-975;
            else if(-p.nx>975)
                p.nx=975;

            if(-p.nx2<-975)
                p.nx2=-975;
            else if(-p.nx2>975)
                p.nx2=975;

            g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
        } //else {
           // g.drawImage(menuBg, 0, 0, null);
            //menu.render(g);
       // }
    }

    static class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }
}
*/
