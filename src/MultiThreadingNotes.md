### Synchronous
Synchronous execution refers to line-by-line execution of code. If a function is invoked, the program execution waits until the function call is completed. Synchronous execution blocks at each method call before proceeding to the next line of code. A program executes in the same sequence as the code in the source code file. Synchronous execution is synonymous to serial execution.

### Asynchronous
Asynchronous (or async) execution refers to execution that doesn't block when invoking subroutines. Or if you prefer the more fancy Wikipedia definition: Asynchronous programming is a means of parallel programming in which a unit of work runs separately from the main application thread and notifies the calling thread of its completion, failure or progress. An asynchronous program doesn’t wait for a task to complete and can move on to the next task.

In contrast to synchronous execution, asynchronous execution doesn't necessarily execute code line by line, that is instructions may not run in the sequence they appear in the code. Async execution can invoke a method and move onto the next line of code without waiting for the invoked function to complete or receive its result. Usually, such methods return an entity sometimes called a future or promise that is a representation of an in-progress computation. The program can query for the status of the computation via the returned future or promise and retrieve the result once completed. Another pattern is to pass a callback function to the asynchronous function call which is invoked with the results when the asynchronous function is done processing. Asynchronous programming is an excellent choice for applications that do extensive network or disk I/O and spend most of their time waiting. As an example, Javascript enables concurrency using AJAX library's asynchronous method calls. In non-threaded environments, asynchronous programming provides an alternative to threads in order to achieve concurrency and fall under the cooperative multitasking model.

Asynchronous programming support in Java has become a lot more robust starting with Java 8, however, the topic is out of scope for this course so we only mention it in passing.

========================================================== 

### Throughput
Throughput is defined as the rate of doing work or how much work gets done per unit of time. If you are an Instagram user, you could define throughput as the number of images your phone or browser downloads per unit of time.

### Latency
Latency is defined as the time required to complete a task or produce a result. Latency is also referred to as response time. The time it takes for a web browser to download Instagram images from the internet is the latency for downloading the images.
 
### Throughput vs Latency
The two terms are more frequently used when describing networking links and have more precise meanings in that domain. In the context of concurrency, throughput can be thought of as time taken to execute a program or computation. For instance, imagine a program that is given hundreds of files containing integers and asked to sum up all the numbers. Since addition is commutative each file can be worked on in parallel. In a single-threaded environment, each file will be sequentially processed but in a concurrent system, several threads can work in parallel on distinct files. Of course, there will be some overhead to manage the state including already processed files. However, such a program will complete the task much faster than a single thread. The performance difference will become more and more apparent as the number of input files increases. The throughput in this example can be defined as the number of files processed by the program in a minute. And latency can be defined as the total time taken to completely process all the files. As you observe in a multithreaded implementation throughput will go up and latency will go down. More work gets done in less amount of time. In general, the two have an inverse relationship.

### 

Logical follies committed in multithreaded code, while trying to avoid race conditions and guarding critical sections, can lead to a host of subtle and hard to find bugs and side-effects. Some of these incorrect usage patterns have their names and are discussed below.

### DeadLock
Deadlocks occur when two or more threads aren’t able to make any progress because the resource required by the first thread is held by the second and the resource required by the second thread is held by the first.

### Liveness
Ability of a program or an application to execute in a timely manner is called liveness. If a program experiences a deadlock then it’s not exhibiting liveness.

### Live-Lock
A live-lock occurs when two threads continuously react in response to the actions by the other thread without making any real progress. The best analogy is to think of two persons trying to cross each other in a hallway. John moves to the left to let Arun pass, and Arun moves to his right to let John pass. Both block each other now. John sees he’s blocking Arun again and moves to his right and Arun moves to his left seeing he’s blocking John. They never cross each other and keep blocking each other. This scenario is an example of a livelock. A process seems to be running and not deadlocked but in reality, isn’t making any progress.

### Starvation
Other than a deadlock, an application thread can also experience starvation, when it never gets CPU time or access to shared resources. Other greedy threads continuously hog shared system resources not letting the starving thread make any progress.

### Deadlock Example
void increment(){

acquire MUTEX_A
acquire MUTEX_B
// do work here
release MUTEX_B
release MUTEX_A

}


void decrement(){

acquire MUTEX_B
acquire MUTEX_A
// do work here
release MUTEX_A
release MUTEX_B

}
The above code can potentially result in a deadlock. Note that deadlock may not always happen, but for certain execution sequences, deadlock can occur. Consider the below execution sequence that ends up in a deadlock:

T1 enters function increment

T1 acquires MUTEX_A

T1 gets context switched by the operating system

T2 enters function decrement

T2 acquires MUTEX_B

both threads are blocked now
Thread T2 can’t make progress as it requires MUTEX_A which is being held by T1. Now when T1 wakes up, it can’t make progress as it requires MUTEX_B and that is being held up by T2. This is a classic text-book example of a deadlock.

You can come back to the examples presented below as they require an understanding of the synchronized keyword that we cover in later sections. Or you can just run the examples and observe the output for now to get a high-level overview of the concepts we discussed in this lesson.

If you run the code snippet below, you’ll see that the statements for acquiring locks: lock1 and lock2 print out but there’s no progress after that and the execution times out. In this scenario, the deadlock occurs because the locks are being acquired in a nested fashion.


### Example of a Deadlock

```
class Demonstration {

    public static void main(String args[]) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException ie) {
        }
    }
}

class Deadlock {

    private int counter = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Runnable incrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                    System.out.println("Incrementing " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    };

    Runnable decrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    decrementCounter();
                    System.out.println("Decrementing " + i);
                }
            } catch (InterruptedException ie) {
            }

        }
    };

    public void runTest() throws InterruptedException {

        Thread thread1 = new Thread(incrementer);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        // sleep to make sure thread 1 gets a chance to acquire lock1
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + counter);
    }

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Acquired lock1");
            Thread.sleep(100);

            synchronized (lock2) {
                counter++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Acquired lock2");
            
            Thread.sleep(100);
            synchronized (lock1) {
                counter--;
            }
        }
    }
}
```

##### Reentrant Lock
Re-entrant locks allow for re-locking or re-entering of a synchronization lock. This can be best explained with an example. Consider the NonReentrant class below.

Take a minute to read the code and assure yourself that any object of this class if locked twice in succession would result in a deadlock. The same thread gets blocked on itself, and the program is unable to make any further progress. If you click run, the execution would time-out.

If a synchronization primitive doesn’t allow reacquisition of itself by a thread that has already acquired it, then such a thread would block as soon as it attempts to reacquire the primitive a second time.




##### Example of Deadlock with Non-Reentrant Lock
The statement "Acquired second lock" is never printed

#### Mesa vs Hoarse
In Mesa monitors - Mesa being a language developed by Xerox researchers in the 1970s - it is possible that the time gap between thread B calls notify() and releases its mutex and the instant at which the asleep thread A, wakes up and reacquires the mutex, the predicate is changed back to false by another thread different than the signaler and the awoken threads! The woken up thread competes with other threads to acquire the mutex once the signaling thread B empties the monitor. On signaling, thread B doesn't give up the monitor just yet; rather it continues to own the monitor until it exits the monitor section.

### Amdahl's Law
Blindly adding threads to speed up program execution may not always be a good idea. Find out what Amdahl's Law says about parallelizing a program

We'll cover the following

Definition
Example
Definition
No text on concurrency is complete without mentioning the Amdahl's Law. The law specifies the cap on the maximum speedup that can be achieved when parallelizing the execution of a program.

If you have a poultry farm where a hundred hens lay eggs each day, then no matter how many people you hire to process the laid eggs, you still need to wait an entire day for the 100 eggs to be laid. Increasing the number of workers on the farm can't shorten the time it takes for a hen to lay an egg. Similarly, software programs consist of parts which can't be sped up even if the number of processors is increased. These parts of the program must execute serially and aren't amenable to parallelism.

Amdahl's law describes the theoretical speedup a program can achieve at best by using additional computing resources. We'll skip the mathematical derivation and go straight to the simplified equation expressing Amdahl's law:


S(n)=\frac{1}{(1-P)+\frac{P}{n}}


S(n) is the speed-up achieved by using n cores or threads.

P is the fraction of the program that is parallelizable

(1 - P) is the fraction of the program that must be executed serially.

Example
Say our program has a parallelizable portion of P = 90% = 0.9. Now let's see how the speed-up occurs as we increase the number of processes


n = 1 processor S(1) = \frac{1}{(1-P) + \frac{P}{1}} = \frac{1}{1-P + P} = 1

n = 2 processors S(2) = \frac{1}{(1-0.9) + \frac{0.9}{2}} = \frac{1}{0.1 + 0.45} = 1.81

n = 5 processors S(5) = \frac{1}{(1-0.9) + \frac{0.9}{5}} = \frac{1}{0.1 + 0.18} = 3.57

n = 10 processors S(10) = \frac{1}{(1-0.9) + \frac{0.9}{10}} = \frac{1}{0.1 + 0.45} = 5.26

n = 100 processors S(100) = \frac{1}{(1-0.9) + \frac{0.9}{100}} = \frac{1}{0.1 + 0.45} = 9.17

n = 1000 processors S(1000) = \frac{1}{(1-0.9) + \frac{0.9}{1000}} = \frac{1}{0.1 + 0.0009} = 9.91

n = infinite processors S(infinite) = \frac{1}{(1-0.9) + \frac{0.9}{1000}} = \frac{1}{0.1 + 0.0009} = 9.91


The speed-up steadily increases as we increase the number of processors or threads. However, as you can see the theoretical maximum speed-up for our program with 10% serial execution will be 10. We can't speed-up our program execution more than 10 times compared to when we run the same program on a single CPU or thread. To achieve greater speed-ups than 10 we must optimize or parallelize the serially executed portion of the code.

Another important aspect to realize is that when we speed-up our program execution by roughly 5 times, we do so by employing 10 processors. The utilization of these 10 processors, in turn, decreases by roughly 50% because now the 10 processors remain idle for the rest of the time that a single processor would have been busy. Utilization is defined as the speedup divided by the number of processors.

As an example say the program runs in 10 minutes using a single core. We assumed the parallelizable portion of the program is 90%, which implies 1 minute of the program time must execute serially. The speedup we can achieve with 10 processors is roughly 5 times which comes out to be 2 minutes of total program execution time. Out of those 2 minutes, 1 minute is of mandatory serial execution and the rest can all be parallelized. This implies that 9 of the processors will complete 90% of the non-serial work in 1 minute while 1 processor remains idle and then one out of the 10 processors, will execute the serial portion for another minute. The rest of the 9 processors are idle for that 1 minute during which the serial execution takes place. In effect, the combined utilization of the ten processors drops by 50%.

As N approaches infinity, the Amdahl's law takes the following form:


S(n)=\frac{1}{(1-P)+\frac{P}{n}}


One should take the calculations using Amdahl's law with a grain of salt. If the formula spits out a speed-up of 5x it doesn't imply that in reality one would observe a similar speed-up. There are other factors such as the memory architecture, cache misses, network and disk I/O etc that can affect the execution time of a program and the actual speed-up might be less than the calculated one.

The Amdahl's law works on a problem of fixed size. However as computing resources are improved, algorithms run on larger and even larger datasets. As the dataset size grows, the parallelizable portion of the program grows faster than the serial portion and a more realistic assessment of performance is given by Gustafson's law, which we won't discuss here as it is beyond the scope of this text.


### Java Atomic Operations

Java specification
The question if assignment is atomic or not is a valid one and the confusion is addressed by the Java specification itself, which states:

Assignments and reads for primitive data types except for double and long are always atomic. If two threads are invoking someMethod() and passing in 5 and 7 for the integer counter variable then the variable will hold either 5 or 7 and not any other value. There will be no partial writes of bits from either thread.

The reads and writes to double and long primitive types aren’t atomic. The JVM specification allows implementations to break-up the write of the 64 bit double or long primitive type into two writes, one for each 32 bit half. This can result in a situation where two threads are simultaneously writing a double or long value and a third thread observes the first 32 bits from the write by the first thread and the next 32 bits from the write by the second thread. As a result the third thread reads a value that has neither been written by either of the two threads or is a garbage value. In order to make reads and writes to double or long primitive types atomic, we must mark them as volatile. The specification guarantees writes and reads to volatile double and long primitive types as atomic. Note that some JVM implementations may make the writes and reads to double and long types as atomic but this isn’t universally guaranteed across all the JVM implementations. We’ll cover volatile in a later lesson, for now, just remember that primitive double and long types must be marked as volatile for atomic assignments.

All reference assignments are atomic. By reference we mean a variable holding a memory location address, where an object has been allocated by the JVM. For instance, consider the snippet Thread currentThread = Thread.currentThread(); The variable currentThread holds the address for the current thread’s object. If several threads execute the above snippet, the variable currentThread will hold one valid memory location address and not a garbage value. It can’t happen that the variable currentThread holds some bytes from the assignment operation of one thread and other bytes from the assignment operation of an another thread. Whatever reference the variable holds will reflect an assignment from one of the threads. Reference reads and writes are always atomic whether the reference (memory address) itself consists of 32 or 64 bits.


