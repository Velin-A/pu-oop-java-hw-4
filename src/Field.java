import Environment.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Field extends JFrame implements MouseListener {
    private int sideTileCount = 8;
    private Environment[][]figures;
    private Environment selected;
    public Field (){

        this.figures = new Environment[sideTileCount][sideTileCount];

        //Payer
        this.figures[7][0] = (new GPS(7,0,Color.YELLOW));
        //CantGoTrough
        this.figures[5][0] = (new ImpassableTile(5,0,Color.BLUE));
        this.figures[5][7] = (new ImpassableTile(5,7,Color.BLUE));
        this.figures[6][4] = (new ImpassableTile(6,4,Color.BLUE));
        this.figures[1][4] = (new ImpassableTile(1,4,Color.BLUE));
        this.figures[2][7] = (new ImpassableTile(2,7,Color.BLUE));
        //SafeZone
        this.figures[0][6] = (new GPSCoordinates(0,6,Color.GREEN));
        this.figures[1][1] = (new GPSCoordinates(1, 1,Color.GREEN));
        this.figures[2][5] = (new GPSCoordinates(2, 5,Color.GREEN));
        this.figures[3][1] = (new GPSCoordinates(3, 1,Color.GREEN));
        this.figures[3][3] = (new GPSCoordinates(3,3,Color.GREEN));
        this.figures[4][6] = (new GPSCoordinates(4,6,Color.GREEN));
        this.figures[5][2] = (new GPSCoordinates(5,2,Color.GREEN));
        this.figures[7][6] = (new GPSCoordinates(7,6,Color.GREEN));

        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int col = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getX());
        int row = this.getFieldDimensionsBasedOnCoordinates(mouseEvent.getY());

        if(this.selected != null) {
            Environment gps = this.selected;

            if (gps.isMoveValid(row, col) && !hasImpassableTile(row, col)) {

                movePlayer(col, row, gps);
                this.repaint();
                return;
            }
            //if (hasGPS(row, col) == isBabaYagaHere(row, col)){
            //    Modal.render(this, "ПОЗДРАВЛЕНИЯ", "Намерихте Баба Яга!!!");
            //    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //    return;
            //}
            else{
                Modal.render(this, "Внимание", "Невалиден ход, по дъската");
                return;
            }
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

    private void movePlayer(int col, int row, Environment gps) {
        int startingRow = gps.getRow();
        int startingCol = gps.getCol();

        gps.move(row, col);

        this.figures[gps.getRow()][gps.getCol()] = this.selected;
        this.figures[startingRow][startingCol] = null;
        this.selected = null;
    }

    private Color getTileColor() {

        return Color.BLACK;

    }

    public void renderField(Graphics g, int row, int col){
        Color tileColor = this.getTileColor();
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }

    private Environment getGPS(int row, int col){
        return this.figures[row][col];
    }

    private boolean hasGPS(int row, int col){
        return this.getGPS(row, col) != null;
    }

    private Environment getImpassableTile(int row, int col){
        return this.figures[row][col];
    }

    private boolean hasImpassableTile(int row, int col){
        return this.getImpassableTile(row, col) != null;
    }

    public void renderGPS(Graphics g, int row, int col) {

        if (this.hasGPS(row, col)) {
            Environment gps = this.getGPS(row, col);
            gps.render(g);
        }
    }

    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                this.renderField(g, row, col);
                this.renderGPS  (g, row, col);
            }
        }
    }

    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Tile.TILE_SIZE;
    }

    private Environment getGPSCoordinates(int row, int col){
        return this.figures[row][col];
    }

    private boolean isBabaYagaHere(int row, int col){
        return this.getImpassableTile(row, col) != null;
    }
}
