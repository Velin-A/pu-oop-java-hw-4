import javax.swing.*;
import java.awt.*;

public class Field extends JFrame {
    private int col         = 8;
    private int row         = 8;
    private int coordinates = 0;

    public Field (){
        Object[][] Field = new Object[row][col];
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Field[4][1] = (new ImpassableTile(4,1,Color.BLUE));
        Field[7][2] = (new ImpassableTile(7,2,Color.BLUE));
        Field[7][5] = (new ImpassableTile(7,5,Color.BLUE));
        Field[0][5] = (new ImpassableTile(0,5,Color.BLUE));
        Field[4][6] = (new ImpassableTile(4,6,Color.BLUE));
    }

    private Color getTileColor(int row, int col) {

        return Color.RED;

    }

    public void renderTile(Graphics g, int row, int col){
        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    private Color getGPSColor(int row, int col) {

        return Color.YELLOW;

    }

    public void renderGPS(Graphics g, int row, int col){
        Color GPSColor = this.getGPSColor(row, col);
        GPS gps = new GPS(row, col, GPSColor);
        gps.render(g);
    }

    private Color getImpassableTileColor(int row, int col){
        return Color.BLUE;
    }

    public void renderImpassableTile(Graphics g, int row, int col){
        Color ImpassableTileColor = this.getImpassableTileColor(row, col);
        ImpassableTile forbiden = new ImpassableTile(row, col, ImpassableTileColor);
        forbiden.render(g);
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                this.renderTile (g, row, col);
                this.renderGPS  (g, row, col);
            }
        }
    }
}
