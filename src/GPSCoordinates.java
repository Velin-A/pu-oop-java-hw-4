import java.awt.*;

public class GPSCoordinates {
    private int row;
    private int col;
    private Color color;
    private int size = 50;

    public GPSCoordinates (int row, int col, Color color){
        this.row = 7;
        this.col = 0;
        this.color = color;
    }

    public void render(Graphics g){

        int X    = this.col * size;
        int Y    = this.row * size;

        g.setColor(this.color);
        g.fillRect(X, Y, size, size);
    }
}
