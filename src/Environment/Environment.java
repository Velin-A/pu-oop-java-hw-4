package Environment;

import java.awt.*;

public class Environment {

    protected int row;
    protected int col;
    protected Color color;
    protected int size = 50;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

        /*
            Checking if move is valid
            @param moveRow new row position
            @param moveCol new col position
            @param color tile color
         */
    public boolean isMoveValid(int moveRow, int moveCol){
        return false;
    }
    /*
        Method rendering the Environment
     */
    public void render(Graphics g){

        int X    = this.col * size;
        int Y    = this.row * size;

        g.setColor(this.color);
        g.fillRect(X, Y, size, size);
    }
    /*
        Method moving the player
     */
    public void move (int row, int col){
        this.row = row;
        this.col = col;
    }
}
