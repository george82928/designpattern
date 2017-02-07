package test.singleton;

/**
 * The easier way to create a thread-safe singleton class is to make the global access method synchronized, so that only
 * one thread can execute this method at a time. General implementation of this approach is like the below class.
 *
 */
public class ThreadSafeSingleton
{
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton()
    {
    }

    /**
     * works fine and provides thread-safety but it reduces the performance because of cost associated with the
     * synchronized method, although we need it only for the first few threads who might create the separate instances
     * (Read: Java Synchronization).
     */
    // public synchronized ThreadSafeSingleton getInstance()
    // {
    // if (instance == null)
    // {
    // instance = new ThreadSafeSingleton();
    // }
    // return instance;
    // }
    // ////////////////////////////////////////
    /**
     * In this approach, the synchronized block is used inside the if condition with an additional check to ensure that
     * only one instance of singleton class is created.
     */
    public static ThreadSafeSingleton getInstanceUsingDoubleLocking()
    {
        if (instance == null)
        {
            synchronized (ThreadSafeSingleton.class)
            {
                if (instance == null)
                {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
