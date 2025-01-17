### Thread Safe
A class and its public APIs are labelled as thread safe 
if multiple threads can consume the exposed APIs 
without causing race conditions or state corruption for 
the class. Note that composition of two or more thread-safe 
classes doesn't guarantee the resulting type to be thread-safe.

### Synchronized
Java’s most fundamental construct for thread synchronization is the synchronized keyword. It can be used to restrict access to critical sections one thread at a time.

Each object in Java has an entity associated with it called the "monitor lock" or just monitor. Think of it as an exclusive lock. Once a thread gets hold of the monitor of an object, it has exclusive access to all the methods marked as synchronized. No other thread will be allowed to invoke a method on the object that is marked as synchronized and will block, till the first thread releases the monitor which is equivalent of the first thread exiting the synchronized method.

Note carefully:

For static methods, the monitor will be the class object, which is distinct from the monitor of each instance of the same class.

If an uncaught exception occurs in a synchronized method, the monitor is still released.

Furthermore, synchronized blocks can be re-entered.

You may think of "synchronized" as the mutex portion of a monitor.


## Illegal Thread Safey


A classic newbie mistake is to synchronize on an object and then somewhere in the code reassign the object. As an example, look at the code below. We synchronize on a Boolean object in the first thread but sleep before we call wait() on the object. While the first thread is asleep, the second thread goes on to change the flag's value. When the first thread wakes up and attempts to invoke wait(), it is met with a IllegalMonitorState exception! The object the first thread synchronized on before going to sleep has been changed, and now it is attempting to call wait() on an entirely different object without having synchronized on it.

```
class Demonstration {
    public static void main( String args[] ) throws InterruptedException {
        IncorrectSynchronization.runExample();
    }
}

class IncorrectSynchronization {

    Boolean flag = new Boolean(true);

    public void example() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                synchronized (flag) {
                    try {
                        while (flag) {
                            System.out.println("First thread about to sleep");
                            Thread.sleep(5000);
                            System.out.println("Woke up and about to invoke wait()");
                            flag.wait();
                        }
                    } catch (InterruptedException ie) {

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                flag = false;
                System.out.println("Boolean assignment done.");
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
    }

    public static void runExample() throws InterruptedException {
        IncorrectSynchronization incorrectSynchronization = new IncorrectSynchronization();
        incorrectSynchronization.example();
    }
}
```

