package Environment;

import java.awt.*;

public class ImpassableTile extends Environment {
        /*
            Constructor fot ImpassableTile
            @param row row position
            @param col col position
            @param color tile color
         */
        public ImpassableTile (int row, int col, Color color){
            this.row   = row;
            this.col   = col;
            this.color = color;
        }
}
