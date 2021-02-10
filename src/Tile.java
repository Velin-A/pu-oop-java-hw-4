import java.awt.*;

public class Tile{

    int tileSize = 50;
    private int row;
    private int col;
    private Color color;

    public Tile(int row, int col, Color color){
        this.row      = row;
        this.col      = col;
        this.color    = color;
    }

    public void render(Graphics g){

        int tileX    = this.col * tileSize;
        int tileY    = this.row * tileSize;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, tileSize, tileSize);
    }

}
