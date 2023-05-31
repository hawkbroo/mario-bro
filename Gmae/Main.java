package Gmae;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {
    private static long lft;
    private static float drop_y = -70;// положение монет
    private static float drop_x = 500; // положение монет
    private static float drop_v = 300;// скорость монет
    private static Image drop4; // монетки
    private static Image mario;
    private static Image mario1;
    private static float x3 = 200;
    private static float y3 = 550;
    private static int speed = 7;
    private static int distanceTraveled = 24;;
    private static Image game_over; //
    private static Image restart;
    private static Main game; // игровое окно
    private static Image bg;// background
    private static int score = 0;// счет
    private static float restart_x = 370; // положение рестарта
    private static float restart_y = 380; // положение рестарта
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            //mario = mario.getImage();
            if (distanceTraveled < 104) speed = -7;
            else speed = -7;
        }

        if (key == KeyEvent.VK_RIGHT) {
            //mario = mario.getImage();
            if (distanceTraveled < 104) speed = 7;
            else speed = 7;
        }
    }
    public static void main(String[] args) throws IOException {

        //JFrame frame = new JFrame("Mario by Yura");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800,613);
        //frame.setResizable(true);
        //frame.setLocation(20, 50);
        //frame.setVisible(true);

        bg = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("whu9z.ScetF.png")));
        mario = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("MarioRight.png")));
        //mario1 = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("MarioLeft.png")));
        drop4 = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("3cc94339-4b68-445c-ab6e-69071dad7449.png")));
        game_over = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("game over.png")));
        restart = ImageIO.read(Objects.requireNonNull(Main.class.getResourceAsStream("restart_2.1Pe76.png")));
        game = new Main();
        JLabel record = new JLabel("Рекорд: "+score);
        record.setSize(420,150);
        record.setPreferredSize(new Dimension(100, 25));
        record.setFont(new Font("Рекорд :"+score, Font.PLAIN,19));
        record.setOpaque(true);
        record.setBackground(Color.white);

        game.setSize(850,700);
        game.setResizable(true);
        lft = System.nanoTime();
        game.setTitle("Mario");
        //game.getContentPane().add(new Gmae.board());
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setLocation(250,45);
        GameField game_field = new GameField();


        game_field.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float drop_x_right = drop_x + drop4.getWidth(null);
                float drop_t_bottom = drop_y + drop4.getHeight(null);
                boolean is_drop = x >= drop_x && x <= drop_x_right && y >= drop_y && y<= drop_t_bottom;
                //int x1 = e.getX();
                //int y1 = e.getY();
                //float nx_right = nx + mario.getWidth(null);
                //float drop_t1_bottom = ny + mario.getHeight(null);
                // boolean is1_drop = x >= nx && x <= nx_right && y >= ny && y<= drop_t1_bottom;

                if (is_drop){
                    drop_y = -70;
                    drop_x = (int) (Math.random()* (game_field.getWidth() - drop4.getHeight(null)));
                    game.setTitle("Рекорд: "+ score);
                    record.setText("Рекорд: "+score);
                    score ++;
                    drop_v = drop_v+10;

                }
                else if (is_drop == false){
                    if (score <= 0){
                        score++;
                    }
                }
                float restart_x_left = restart_x + restart.getWidth(null);
                float restart_y_bottom = restart_y + restart.getHeight(null);
                boolean if_restart = x>= restart_x && x <= restart_x_left && y>= restart_y && y <= restart_y_bottom;
                if (if_restart){
                    drop_y = -70;
                    drop_x = (int)(Math.random() * (game_field.getWidth() - drop4.getHeight(null)));
                    score = 0; drop_v = 200;
                    game.setTitle("Очки: "+score);
                    record.setText("Очки: "+score);

                }
            }
        });

        //game.getContentPane().add(new Gmae.board());
        game_field.add(record);
        game.add(game_field);
        game.setVisible(true);
    }

    public static void onRepaint (Graphics g2d) {
        long corrent_time = System.nanoTime();
        float delta_time = (corrent_time - lft)*0.000000001f;
        lft =corrent_time;
        drop_y = drop_y + drop_v * delta_time;
        g2d.drawImage(bg,0,0,null );
        g2d.drawImage(drop4,(int)drop_x,(int) drop_y,null );
        g2d.drawImage(mario, (int) x3, (int) y3, null);
        if (drop_y>game.getHeight()){
            g2d.drawImage(game_over, 100, 90, null);
           //if (game)
            g2d.drawImage(restart, (int)restart_x, (int) restart_y, null);

        }

    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            onRepaint(g);
            repaint();

        }

    }public class mouseInput implements MouseListener {
        public void mousePressed(MouseEvent e) {
            int mx = e.getX();
            int my = e.getY();

            if (mx >= 10 && mx <= 110) {
                if (my >= 50 && my <= 87) {
                    // Gmae.board.State = Gmae.board.STATE.GAME;
                }
                if (my >= 102 && my <= 139) {
                    //HELP
                }
                if (my >= 154 && my <= 191) {
                    System.exit(1);
                }
            }
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
}







