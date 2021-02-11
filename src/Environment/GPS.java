package Environment;

import Environment.Environment;

import java.awt.*;

public class GPS extends Environment {

    public GPS (int row, int col, Color color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public boolean isMoveValid(int moveRow, int moveCol){

        int rowCoefficient = Math.abs(moveRow - this.row);
        int colCoefficient = Math.abs(moveCol - this.col);

        return rowCoefficient == 1 || colCoefficient == 1;
    }
}
