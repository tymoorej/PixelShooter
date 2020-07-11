package BoardHelpers;

public class Board {

    private static Board instance = null;

    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    private Board() {
    }

}
