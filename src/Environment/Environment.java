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

    public boolean isMoveValid(int moveRow, int moveCol){
        return false;
    }

    public void render(Graphics g){

        int X    = this.col * size;
        int Y    = this.row * size;

        g.setColor(this.color);
        g.fillRect(X, Y, size, size);
    }

    public void move (int row, int col){
        this.row = row;
        this.col = col;
    }

    public boolean isBabaYagaHere(int row, int col){
        return false;
    }
}
