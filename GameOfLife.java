import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;



class GameOfLife extends JComponent implements MouseListener, MouseMotionListener {
    
    public static final int SIZE = 50;
    private int[][] world = new int[SIZE][SIZE];
    private int[][] newGeneration = new int[SIZE][SIZE];
    private int lockedX = -1;
    private int lockedY = -1;
        
    public GameOfLife() {
        //This is called a constructor. We will talk about them in class..
        
        //Have the object say it is listening for mouse events
        addMouseListener(this);
        addMouseMotionListener(this);
        
        //Start everything as being dead.
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                world[x][y] = 0;
            }
        }
    }
    
    //The public method which checks each individual cell
    public void checkEveryCell() {
        
        //TODO, loop the row from 1 to SIZE - 1 (Remember that we are skipping the ghost cell edges)
        //Then have an inner loop for columns looping from 1 to SIZE - 1.  
        
                //TODO: Count up how many neighbors this cell has
        
                //TODO: Follow the rules according to the game.  Depending on the counts
                //and whether the world's cell was dead or alive,
                //write the alive or dead cell in the newGeneration at row x and column y.
        
        
        
        //Move the newGeneration to become the current world
        for (int x = 1; x < SIZE - 1; x++) {
            for (int y = 1; y < SIZE - 1; y++) {
                world[x][y] = newGeneration[x][y];
                newGeneration[x][y] = 0; //start this cell as dead in the new generation.
            }
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        GameOfLife g = new GameOfLife();
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(GameOfLife.SIZE * 10 + 20,GameOfLife.SIZE * 10 + 50);
        window.add(g);
        window.setVisible(true);
        
        window.repaint();
        
        while(true) {
            g.checkEveryCell();
            window.repaint();
            
            Thread.sleep(3000); //put the game to sleep for 1 seconds.  If you want it less, make this number smaller
        }
        //window.repaint(0,0,0,GameOfLife.SIZE * 10,GameOfLife.SIZE * 10);
        
        
    }
    
    @Override
    public void paint(Graphics g) {
        for (int x = 1; x < SIZE - 1; x++) {
            for (int y = 1; y < SIZE - 1; y++) {
                if (world[x][y] == 1) {
                    g.fillRect(x*10,y*10, 10,10);
                } else {
                    g.drawRect(x*10,y*10, 10,10);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseDragged(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {    
    }

    @Override
    public void mouseExited(MouseEvent e) {  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //this happens only when you hold down a button and move
        int x = e.getX();
        int y = e.getY();
        x /= 10;
        y /= 10;
        //System.out.println("I'm in mouseDragged at (" + x + "," + y + ")");
        
        //See if the mouse click coordinates are valid
        if (x > 0 && x < SIZE - 1 && y > 0 && y < SIZE - 1) {
            //Are we still within the same cell or has the mouse cursor
            //moved into a new cell.
            if (x != lockedX || y != lockedY) {
                //change life status
                if (world[x][y] == 0) {
                    world[x][y] = 1;
                } else {
                    world[x][y] = 0;
                }
                //lock the cell
                lockedX = x;
                lockedY = y;
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
}
