package UI;

import GameHelper.Game;

import javax.swing.*;

public class UIHandler{

    private static JFrame jFrame;
    private static UIDrawer uiDrawer;
    private static Screen screen;
    private static boolean isUISetup = false;

    public static void setup(){
        uiDrawer = new UIDrawer();

        jFrame = new JFrame("PXS");
        jFrame.setSize(
                Screen.getInstance().getWidth() + 18,
                Screen.getInstance().getHeight() + 30
        );
        System.out.println("Window size: (" + String.valueOf(Screen.getInstance().getWidth()) + ", " +
                String.valueOf(Screen.getInstance().getHeight()) + ")");

        jFrame.setResizable(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.add(uiDrawer);
        jFrame.addKeyListener(new Listener());
        jFrame.setVisible(true);
        isUISetup = true;

    }

    public static void update(){
        if (isUISetup){
            jFrame.repaint();
        }
    }

}
