package UI;

import BoardHelpers.Board;
import BoardHelpers.Location;
import GameHelper.Game;
import ImageHelpers.ImageHelper;

import java.awt.*;

public class DrawableLocation {
    private Location location;

    public DrawableLocation(Location location) {
        this.location = location;
    }

    public void drawLocation(Graphics g){
        Pixel startPixel = getStartPixel();
        Pixel endPixel = getEndPixel();
        int width = endPixel.getX() - startPixel.getX();
        int height = endPixel.getY() - startPixel.getY();



        if (location.hasPlayer()){
            Image rotatedImage = Game.getInstance().getPlayer().getShip().getImage();
            g.drawImage(rotatedImage, startPixel.getX(), startPixel.getY(), width, height, null);
        }
        else{
            g.setColor(Color.BLACK);
            g.fillRect(startPixel.getX(), startPixel.getY(), width, height);
        }


    }

    private Pixel getStartPixel(){
        int x = ((Screen.getInstance().getWidth()) / Board.getInstance().getxSize()) * location.getX();
        int y = ((Screen.getInstance().getHeight()) / Board.getInstance().getySize()) * location.getY();
        return new Pixel(x, y);
    }

    private Pixel getEndPixel(){
        int x = ((Screen.getInstance().getWidth()) / Board.getInstance().getxSize()) * (location.getX() + 1);
        int y = ((Screen.getInstance().getHeight()) / Board.getInstance().getySize()) * (location.getY() + 1);
        return new Pixel(x, y);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
