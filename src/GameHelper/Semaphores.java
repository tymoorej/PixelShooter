package GameHelper;

import java.util.concurrent.Semaphore;

public class Semaphores {
    private Semaphore keysSemaphore;
    private Semaphore entitiesSemaphore;
    private Semaphore entitiesQueueSemaphore;
    private Semaphore deleteQueueSemaphore;
    private static Semaphores instance = null;

    private Semaphores() {
        keysSemaphore = new Semaphore(1);
        entitiesSemaphore = new Semaphore(1);
        deleteQueueSemaphore = new Semaphore(1);
        entitiesQueueSemaphore = new Semaphore(1);
    }

    public static Semaphores getInstance(){
        if (instance == null){
            instance = new Semaphores();
        }
        return instance;
    }

    public void aquireKeysSemaphore(){
        acquireSemaphore(keysSemaphore);
    }

    public void aquireEntitiesSemaphore(){
        acquireSemaphore(entitiesSemaphore);
    }

    public void releaseKeysSemaphore(){
        releaseSemaphore(keysSemaphore);
    }

    public void releaseEntitiesSemaphore(){
        releaseSemaphore(entitiesSemaphore);
    }

    public void aquireDeleteQueueSemaphore(){
        acquireSemaphore(deleteQueueSemaphore);
    }

    public void releaseDeleteQueueSemaphore(){
        releaseSemaphore(deleteQueueSemaphore);
    }

    public void aquireEntitiesQueueSemaphore(){
        acquireSemaphore(entitiesQueueSemaphore);
    }

    public void releaseEntitiesQueueSemaphore(){
        releaseSemaphore(entitiesQueueSemaphore);
    }


    private void acquireSemaphore(Semaphore semaphore){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void releaseSemaphore(Semaphore semaphore){
        semaphore.release();
    }

}
