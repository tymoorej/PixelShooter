package BoardHelpers;

import Entities.PhysicalEntity;
import GameHelper.Semaphores;

import java.util.ArrayList;

public class Board {

    private static Board instance = null;
    private ArrayList<PhysicalEntity> entities;
    private ArrayList<PhysicalEntity> deleteQueue;


    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        entities = new ArrayList<>();
        deleteQueue = new ArrayList<>();
    }

    public ArrayList<PhysicalEntity> getEntities() {
        return entities;
    }

    public void addEntity(PhysicalEntity entity){
        Semaphores.getInstance().aquireEntitiesSemaphore();
        entities.add(entity);
        Semaphores.getInstance().releaseEntitiesSemaphore();
    }

    public void RemoveEntity(PhysicalEntity entity){
        Semaphores.getInstance().aquireEntitiesSemaphore();
        entities.remove(entity);
        Semaphores.getInstance().releaseEntitiesSemaphore();
    }

    public void addToDeleteQueue(PhysicalEntity entity){
        Semaphores.getInstance().aquireDeleteQueueSemaphore();
        deleteQueue.add(entity);
        Semaphores.getInstance().releaseDeleteQueueSemaphore();
    }

    public void clearDeleteQueue(){
        deleteQueue.clear();
    }

    public ArrayList<PhysicalEntity> getDeleteQueue() {
        return deleteQueue;
    }
}
