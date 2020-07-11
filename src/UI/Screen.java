package UI;

import BoardHelpers.Board;

import java.awt.*;

public class Screen {
    private static Screen instance = null;
    private int width;
    private int height;

    private int middleX;
    private int middleY;


    private Screen() {
        width = Toolkit.getDefaultToolkit().getScreenSize().width - 100;
        height = Toolkit.getDefaultToolkit().getScreenSize().height - 100;
        middleX = width/2;
        middleY = height/2;
    }

    public static Screen getInstance(){
        if (instance == null){
            instance = new Screen();
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMiddleX() {
        return middleX;
    }

    public int getMiddleY() {
        return middleY;
    }
}
