package BoardHelpers;

import Entities.PhysicalEntity;
import GameHelper.Semaphores;

import java.util.ArrayList;

public class Board {

    private static Board instance = null;
    private ArrayList<PhysicalEntity> entities;
    private ArrayList<PhysicalEntity> entitiesQueue;
    private ArrayList<PhysicalEntity> deleteQueue;


    public static Board getInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        entities = new ArrayList<>();
        entitiesQueue = new ArrayList<>();
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

    public ArrayList<PhysicalEntity> getEntitiesQueue() {
        return entitiesQueue;
    }

    public void addEntityToQueue(PhysicalEntity entity){
        Semaphores.getInstance().aquireEntitiesQueueSemaphore();
        entitiesQueue.add(entity);
        Semaphores.getInstance().releaseEntitiesQueueSemaphore();
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

    public void clearEntitiesQueue() {
        entitiesQueue.clear();
    }

    public boolean containsInDeleteQueue(PhysicalEntity entity){
        return deleteQueue.contains(entity);
    }

}
