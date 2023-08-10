import java.awt.*;
import javax.swing.JPanel;

public class GUI {
    int frameHeight = 394;
    int frameWidth = 328;
    int gameBoardSize = 296;
    int margineSize = 16;
    Color backgroundColor = new Color(255,225,120);

    JFrame frame;
    public GUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameBoard gb = new gameBoard();

        //North panel
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());
        northPanel.setPreferredSize(new Dimension(frameWidth, 80));

        JLabel gameLabel = new JLabel("1024", SwingConstants.CENTER);
        gameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        northPanel.add(gameLabel);
        northPanel.add(new JLabel("<html>Score:<br>524</html>", SwingConstants.CENTER));
        northPanel.add(new JLabel("<html>High Score:<br>22600</html>", SwingConstants.CENTER));
        northPanel.setBackground(backgroundColor);

        JPanel westBuffer = new JPanel();
        southBuffer.setPreferredSize(new Dimention(marginSize, gameBoardSize));
        southBuffer.setBackground(backgroundColor);


        //add panel to frame 
        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        frame.getContentPane().add(northPanel, BorderLayout.WEST);
        frame.getContentPane().add(northPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(northPanel, BorderLayout.EAST);
        frame.getContentPane().add(gb, BorderLayout.CENTER);

        frame.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.pack();
        frame.setVisible(true);
    }

    class gameBoard extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            g.setColor(new Color(20, 20, 20));
            g.fillRect(0, 0, this.getWidth(), this.getHeight)
        }
    }


}
