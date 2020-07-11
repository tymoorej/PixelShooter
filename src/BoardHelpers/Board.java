package BoardHelpers;

public class Board {

    private static Board instance = null;

    private final int xSize = 10;
    private final int ySize = 10;
    private Location[][] locations = new Location[xSize][ySize];

    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        for (int x = 0; x < xSize; x++){
            for (int y = 0; y < ySize; y++){
                locations[x][y] = new Location(x, y);
            }
        }
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public void setLocation(int x, int y, Location location){
        locations[x][y] = location;
    }

    public Location getLocation(int x, int y){
        int fixedX;
        int fixedY;

        if (x < 0){
            fixedX = xSize - 1;
        }
        else {
            fixedX = x;
        }
        if (y < 0){
            fixedY = ySize - 1;
        }
        else{
            fixedY = y;
        }

        fixedX = fixedX % xSize;
        fixedY = fixedY % ySize;

        return locations[fixedX][fixedY];
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
