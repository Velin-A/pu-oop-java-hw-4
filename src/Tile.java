import java.awt.*;

public class Tile{

    public static final int TILE_SIZE = 50;
    public static final int BORDER_OFFSET = 1;
    private int row;
    private int col;
    private Color color;

    /*
        Constructor for Tile
        @param row row coordinate
        @param col col coordinate
        @param color tile color
     */
    public Tile(int row, int col, Color color){
        this.row      = row;
        this.col      = col;
        this.color    = color;
    }
    /*
        Method rendering the tiles
     */
    public void render(Graphics g){

        int tileX    = this.col * TILE_SIZE;
        int tileY    = this.row * TILE_SIZE;

        g.setColor(this.color);
        g.drawRect(tileX, tileY, TILE_SIZE-BORDER_OFFSET,  TILE_SIZE-BORDER_OFFSET);
    }

}
