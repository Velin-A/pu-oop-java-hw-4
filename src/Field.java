import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Field extends JFrame implements MouseListener {
    private int sideTileCount = 8;
    private Object[][]figures;
    private Object selected;
    public Field (){

        this.figures = new GPS[sideTileCount][sideTileCount];

        //YELLOW
        this.figures[7][0] = (new GPS(7,0,Color.YELLOW));
        ////blue
        //this.figures[5][0] = (new Tile(5,0,Color.BLUE));
        //this.figures[5][7] = (new Tile(5,7,Color.BLUE));
        //this.figures[6][4] = (new Tile(6,4,Color.BLUE));
        //this.figures[1][4] = (new Tile(1,4,Color.BLUE));
        //this.figures[2][7] = (new Tile(2,7,Color.BLUE));
        ////green
        //this.figures[0][6] = (new Tile(0,6,Color.GREEN));
        //this.figures[1][1] = (new Tile(1, 1,Color.GREEN));
        //this.figures[2][5] = (new Tile(2, 5,Color.GREEN));
        //this.figures[3][1] = (new Tile(3, 1,Color.GREEN));
        //this.figures[3][3] = (new Tile(3,3,Color.GREEN));
        //this.figures[4][6] = (new Tile(4,6,Color.GREEN));
        //this.figures[5][2] = (new Tile(5,2,Color.GREEN));
        //this.figures[7][6] = (new Tile(7,6,Color.GREEN));

        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int col = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getX());
        int row = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getY());

        if(this.selected != null){
            GPS gps = (GPS)this.selected;

            int startingRow = gps.getRow();
            int startingCol = gps.getCol();

            gps.move(row, col);

            this.figures[gps.getRow()][gps.getCol()] = this.selected;
            this.figures[startingRow][startingCol]   = null;
            this.selected = null;
            this.repaint();
            return;
        }
        if (this.hasGPS(row, col)) {
            this.selected = this.getGPS(row, col);
        }
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private Color getTileColor(int row, int col) {

        return Color.RED;

    }

    public void renderField(Graphics g, int row, int col){
        Color tileColor = this.getTileColor(row, col);
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    //public void renderGPS(Graphics g, int row, int col){
    //    Color GPSColor = this.getGPSColor(row, col);
    //    GPS gps = new GPS(row, col, GPSColor);
    //    gps.render(g);
    //}

    private Object getGPS(int row, int col){
        return this.figures[row][col];
    }

    private boolean hasGPS(int row, int col){
        return this.getGPS(row, col) != null;
    }

    public void renderGPS(Graphics g, int row, int col) {

        if (this.hasGPS(row, col)) {
            GPS gps = (GPS) this.getGPS(row, col);
            gps.render(g);
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                this.renderField(g, row, col);
                this.renderGPS  (g, row, col);
                //this.renderTile(g, row, col);
            }
        }
    }

    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / 50; //TODO
    }
}
