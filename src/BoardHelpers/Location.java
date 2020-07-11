package BoardHelpers;
import UI.Pixel;
import UI.Screen;

import java.awt.*;
import java.util.Random;

public class Location {
    private int x;
    private int y;
    private boolean hasPlayer;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        hasPlayer = false;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public boolean hasPlayer() {
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer) {
        this.hasPlayer = hasPlayer;
    }

    public Pixel getStartPixel(){
        int x = ((Screen.getInstance().getWidth()) / Board.getInstance().getxSize()) * this.x;
        int y = ((Screen.getInstance().getHeight()) / Board.getInstance().getySize()) * this.y;
        return new Pixel(x, y);
    }

    public Pixel getEndPixel(){
        int x = ((Screen.getInstance().getWidth()) / Board.getInstance().getxSize()) * (this.x + 1);
        int y = ((Screen.getInstance().getHeight()) / Board.getInstance().getySize()) * (this.y + 1);
        return new Pixel(x, y);
    }
}
