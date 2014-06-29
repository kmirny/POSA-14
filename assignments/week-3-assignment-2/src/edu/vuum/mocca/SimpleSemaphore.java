package edu.vuum.mocca;


import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject (which is accessed via a Condition). It must
 *        implement both "Fair" and "NonFair" semaphore semantics,
 *        just liked Java Semaphores.
 */
public class SimpleSemaphore {
    /**
     * Define a Lock to protect the critical section.
     */
    // TODO - you fill in here
	private ReentrantLock mLock;
	
    /**
     * Define a Condition that waits while the number of permits is 0.
     */
    // TODO - you fill in here
	private Condition mCond;
    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
	private SimpleAtomicLong mCounter; 
    public SimpleSemaphore(int permits, boolean fair) {
        // TODO - you fill in here to initialize the SimpleSemaphore,
        // making sure to allow both fair and non-fair Semaphore
        // semantics.
    	mCounter = new SimpleAtomicLong(permits);
    	mLock = new ReentrantLock(fair);
    	mCond = mLock.newCondition();
    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
    	mLock.lockInterruptibly();
        try {
            // if no permits available we should wait
            while (mCounter.get() == 0) {
                mCond.await();
            }
            // after wait is over we take a permit and decrease
            // it count after that
            mCounter.decrementAndGet();
        } finally {
            mLock.unlock();
        }
    }

    /**
     * Acquire one permit from the semaphore in a manner that cannot be
     * interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here.
    	 mLock.lock();
         try {
             // if no permits available we should wait
             while (mCounter.get() == 0) {
                 mCond.awaitUninterruptibly();
             }
             // after wait is over we take a permit and decrease
             // it count after that
             mCounter.decrementAndGet();
         } finally {
             mLock.unlock();
         }
    }

    /**
     * Return one permit to the semaphore.
     */
    public void release() {
        // TODO - you fill in here.
    	mLock.lock();
        try {
            // increment permit count
            mCounter.incrementAndGet();
            // letting know all interested in that threads that Condition has been met
            mCond.signal();
        } finally {
            mLock.unlock();
        }
    }

    /**
     * Return the number of permits available.
     */
    public int availablePermits() {
        // TODO - you fill in here by changing null to the appropriate
        // return value.
        return (int)mCounter.get();
    }
}
