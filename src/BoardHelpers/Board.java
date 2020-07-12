package BoardHelpers;

import Entities.PhysicalEntity;
import GameHelper.Semaphores;

import java.util.ArrayList;

public class Board {

    private static Board instance = null;
    private ArrayList<PhysicalEntity> entities;

    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        entities = new ArrayList<>();
    }

    public ArrayList<PhysicalEntity> getEntities() {
        return entities;
    }

    public void addEntity(PhysicalEntity entity){
        Semaphores.getInstance().aquireEntitiesSemaphore();
        entities.add(entity);
        Semaphores.getInstance().releaseEntitiesSemaphore();
    }
}
