import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class MainWindow extends JPanel implements ActionListener {

    private int time = 0;
    public final int RESOLUTION = 100;
    public Grid grid = new Grid();
    public Grid nextGrid = new Grid();
    public static void main(String[] args) {

        MainWindow c = new MainWindow();

    }



    public void paint(Graphics g){
        time += 1;
        for (int i = 0; i < RESOLUTION; i++){
            for(int j = 0; j < RESOLUTION; j++ ){
                if (nextGrid.getGrid()[i][j].getStatus() == 0){
                    g.setColor(Color.WHITE);
                    g.fillRect(i * 6, j * 6, 5 ,5);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * 6, j * 6, 5 ,5);
                }
            }
        }
        step();

    }

    public void step(){

        int sum = 0;
        for (int i = 1; i < RESOLUTION - 1; i++){
            for(int j = 1; j < RESOLUTION - 1; j++){
                if(grid.getGrid()[i][j].getStatus() == 0){
                    if (aliveCount(grid, i, j) == 3){

                        nextGrid.getGrid()[i][j].setStatus(1);
                    }
                }
                if(grid.getGrid()[i][j].getStatus() == 1) {
                    if (aliveCount(grid, i, j) < 2 || aliveCount(grid, i, j) >= 4) {

                        nextGrid.getGrid()[i][j].setStatus(0);
                    }
                }
            }
        }
        nextGrid.copyGrid(grid);

    }

    public int aliveCount(Grid grid, int i, int j){
        int sum = 0;
        sum = sum + grid.getGrid()[i-1][j-1].getStatus();
        sum = sum + grid.getGrid()[i][j-1].getStatus();
        sum = sum + grid.getGrid()[i+1][j-1].getStatus();
        sum = sum + grid.getGrid()[i-1][j].getStatus();
        sum = sum + grid.getGrid()[i+1][j].getStatus();
        sum = sum + grid.getGrid()[i-1][j+1].getStatus();
        sum = sum + grid.getGrid()[i][j+1].getStatus();
        sum = sum + grid.getGrid()[i+1][j+1].getStatus();

        return sum;
    }

    public MainWindow () {
        JFrame frame = new JFrame("Game of Life");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


        Timer t = new Timer(200, this);
        t.restart();

        frame.add(this);
        frame.setVisible(true);

        grid.copyGrid(nextGrid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}
