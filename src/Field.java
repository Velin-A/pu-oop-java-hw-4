import Environment.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Field extends JFrame implements MouseListener {
    private int sideTileCount = 8;
    private Environment[][]figures;
    private Environment selected;

    /*
        Method, creating and constructing the field(board)
     */
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

    /*
        Method, resposible for moving the player around the field
        @param mouseEvent listener for action
     */
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
            this.selected = this.getFigurePosition(row, col);
        }
    }
    /*
        Empty necessary method
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    /*
            Empty necessary method
    */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    /*
        Method respnsible for moving the player and asaigning its ne coordinates
     */
    private void movePlayer(int col, int row, Environment gps) {
        int startingRow = gps.getRow();
        int startingCol = gps.getCol();

        gps.move(row, col);

        this.figures[gps.getRow()][gps.getCol()] = this.selected;
        this.figures[startingRow][startingCol] = null;
        this.selected = null;
    }
    /*
        Method setting the color of the empty spaces on the field(board)
     */
    private Color getTileColor() {

        return Color.BLACK;

    }
    /*
        Method rendering the field(board)
     */
    public void renderField(Graphics g, int row, int col){
        Color tileColor = this.getTileColor();
        Tile tile = new Tile(row, col, tileColor);
        tile.render(g);
    }
    /*
        Method responsible for getting the coordinates of the figures
     */
    private Environment getFigurePosition(int row, int col){
        return this.figures[row][col];
    }
    /*
        Method checking if the GPS is on the field
     */
    private boolean hasGPS(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method checking if the GPSCoordinates
     */
    private boolean hasGPSCoordinates(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method checking if there are ImpassibleTile-s on the field
     */
    private boolean hasImpassableTile(int row, int col){
        return this.getFigurePosition(row, col) != null;
    }
    /*
        Method rendering the PayerTile(GPS)
     */
    public void renderGPS(Graphics g, int row, int col) {

        if (this.hasGPS(row, col)) {
            Environment gps = this.getFigurePosition(row, col);
            gps.render(g);
        }
    }
    /*
        Method painting everything
     */
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                this.renderField(g, row, col);
                this.renderGPS  (g, row, col);
            }
        }
    }

    /*
        Method getting the coordinates for moving the player and placing the Environment
     */
    private int getFieldDimensionsBasedOnCoordinates(int coordinates){
        return coordinates / Tile.TILE_SIZE;
    }

    //private boolean isBabaYagaHere(int row, int col){
    //    return this.getImpassableTile(row, col) != null;
    //}
}
