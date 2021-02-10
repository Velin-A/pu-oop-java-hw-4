import java.awt.*;

public class ImpassableTile {
        private int row;
        private int col;
        private Color color;
        private int size = 50;

        public ImpassableTile (int row, int col, Color color){
            Object[][] Field = new Object[row][col];
            Field[4][1] = (new ImpassableTile(4,1,Color.BLUE));
            Field[7][2] = (new ImpassableTile(7,2,Color.BLUE));
            Field[7][5] = (new ImpassableTile(7,5,Color.BLUE));
            Field[0][5] = (new ImpassableTile(0,5,Color.BLUE));
            Field[4][6] = (new ImpassableTile(4,6,Color.BLUE));
        }

        public void render(Graphics g){

            int X    = this.col * size;
            int Y    = this.row * size;

            g.setColor(this.color);
            g.fillRect(X, Y, size, size);
        }
    }
