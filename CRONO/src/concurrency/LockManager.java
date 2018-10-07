package concurrency;


import java.util.HashMap;
import java.util.Map;


public class LockManager {
	
	//keeping track of process have lock which 
	
	private final Map<Object, PessimisticLockReadWrite> lockMap;

    private static LockManager mapper;

    private LockManager() {
        lockMap = new HashMap<>();
    }

    public static LockManager getInstance() {
        if (LockManager.mapper == null) {
            LockManager.mapper = new LockManager();
        }
        return LockManager.mapper;
    }

    public synchronized void acquireReadLock(Object toLock)
            throws InterruptedException {
        getPessimisticLock(toLock).lockRead();
    }

    public synchronized void acquireWriteLock(Object toLock)
            throws InterruptedException {
        getPessimisticLock(toLock).lockWrite();
    }

    public synchronized void releaseReadLock(Object toLock) {
        getPessimisticLock(toLock).unlockRead();
    }

    public synchronized void releaseWriteLock(Object toLock) {
        getPessimisticLock(toLock).unlockWrite();
    }

    public synchronized void releaseAllLocksOn(Object toLock) {
        getPessimisticLock(toLock).unlock();
    }

    public synchronized void releaseAllLocks() {
        for (Map.Entry<Object, PessimisticLockReadWrite> entry : lockMap.entrySet()) {
            entry.getValue().unlock();
        }
    }

    private PessimisticLockReadWrite getPessimisticLock(Object toLock) {
        PessimisticLockReadWrite lock = lockMap.get(toLock);
        System.out.println("Hello "+lock);
        if (lock == null) {
        	System.out.println("goodbye");
        	PessimisticLockReadWrite a = new PessimisticLockReadWrite();
        	System.out.println("1");
            lockMap.put(toLock, new PessimisticLockReadWrite());
            System.out.println("2");
            lock = lockMap.get(toLock);
            System.out.println("Hello "+lock);

        }
        return lock;
    }

}
