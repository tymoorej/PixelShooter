package UI;

import BoardHelpers.Board;

import java.awt.*;

public class Screen {
    private static Screen instance = null;
    private int width;
    private int height;

    private Screen() {
        int preFixedWidth = Toolkit.getDefaultToolkit().getScreenSize().width - 100;
        int preFixedHeight = Toolkit.getDefaultToolkit().getScreenSize().height - 100;

        width = preFixedWidth - (preFixedWidth % Board.getInstance().getxSize());
        height = preFixedHeight - (preFixedHeight % Board.getInstance().getySize());
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

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
