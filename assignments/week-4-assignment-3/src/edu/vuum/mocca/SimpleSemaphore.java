package edu.vuum.mocca;
<<<<<<< HEAD


import java.util.concurrent.locks.ReentrantLock;
//import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
=======
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393

/**
 * @class SimpleSemaphore
 * 
 * @brief This class provides a simple counting semaphore implementation using
<<<<<<< HEAD
 *        Java a ReentrantLock and a ConditionObject. It must implement both
 *        "Fair" and "NonFair" semaphore semantics, just liked Java Semaphores.
=======
 *        Java a ReentrantLock and a ConditionObject (which is accessed via a
 *        Condition). It must implement both "Fair" and "NonFair" semaphore
 *        semantics, just liked Java Semaphores.
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
 */
public class SimpleSemaphore {
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
<<<<<<< HEAD
	private ReentrantLock mLock;
	
    /**
     * Define a ConditionObject to wait while the number of
     * permits is 0.
     */
    // TODO - you fill in here
	private Condition mCond;
    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
	private volatile int mCounter; 
=======

    /**
     * Define a Condition that waits while the number of permits is 0.
     */
    // TODO - you fill in here

    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here. Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..

>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    public SimpleSemaphore(int permits, boolean fair) {
        // TODO - you fill in here to initialize the SimpleSemaphore,
        // making sure to allow both fair and non-fair Semaphore
        // semantics.
<<<<<<< HEAD
    	mCounter = permits;
    	mLock = new ReentrantLock(fair);
    	mCond = mLock.newCondition();
=======
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    }

    /**
     * Acquire one permit from the semaphore in a manner that can be
     * interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here.
<<<<<<< HEAD
    	mLock.lockInterruptibly();
        try {
            // if no permits available we should wait
            while (mCounter == 0) {
                mCond.await();
            }
            mCounter--;
        } finally {
            mLock.unlock();
        }
=======
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    }

    /**
     * Acquire one permit from the semaphore in a manner that cannot be
     * interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here.
<<<<<<< HEAD
    	 mLock.lock();
         try {
             // if no permits available we should wait
             while (mCounter == 0) {
                 mCond.awaitUninterruptibly();
             }
             mCounter--;
         } finally {
             mLock.unlock();
         }
=======
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here.
<<<<<<< HEAD
    	mLock.lock();
        try {
            // increment permit count
            mCounter++;
            // letting know all interested in that threads that Condition has been met
            mCond.signal();
        } finally {
            mLock.unlock();
        }
=======
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    }

    /**
     * Return the number of permits available.
     */
    public int availablePermits() {
<<<<<<< HEAD
        // TODO - you fill in here by changing null to the appropriate
        // return value.
        return mCounter;
=======
        // TODO - you fill in here to return the correct result
    	return 0;
>>>>>>> 540a6df00b82e8e3bb9b8782b489662400116393
    }
}
