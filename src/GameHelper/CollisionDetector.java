package GameHelper;

import BoardHelpers.Board;
import Entities.PhysicalEntity;

public class CollisionDetector extends Thread{

    private boolean running = true;

    @Override
    public void run() {
        super.run();
        while (running){
            try {
                Semaphores.getInstance().aquireEntitiesSemaphore();
                for (PhysicalEntity entity1: Board.getInstance().getEntities()){
                    for (PhysicalEntity entity2: Board.getInstance().getEntities()){
                        if (entity1 == entity2){
                            continue;
                        }
                        if (collisionDetected(entity1, entity2)){
                            entity1.handleCollision(entity2);
                            entity2.handleCollision(entity1);
                        }
                    }
                }
                Semaphores.getInstance().releaseEntitiesSemaphore();
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean collisionDetected(PhysicalEntity entity1, PhysicalEntity entity2){
        int minXDist, minYDist;

        if (entity1.getPosition().getX() > entity2.getPosition().getX()){
            minXDist = entity2.getCollisionWidth();
        }
        else {
            minXDist = entity1.getCollisionWidth();
        }

        if (entity1.getPosition().getY() > entity2.getPosition().getY()){
            minYDist = entity2.getCollisionHeight();
        }
        else {
            minYDist = entity1.getCollisionHeight();
        }

        boolean xCollision = Math.abs(entity1.getPosition().getX() - entity2.getPosition().getX())
                < minXDist;
        boolean yCollision = Math.abs(entity1.getPosition().getY() - entity2.getPosition().getY())
                < minYDist;
        return xCollision && yCollision;
    }

    public void end(){
        running = false;
    }
}


