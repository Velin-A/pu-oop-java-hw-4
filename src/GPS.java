import java.awt.*;
import java.util.Random;

public class GPS {
    private int row;
    private int col;
    private Color color;
    private int size = 50;

    public GPS (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
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
}
