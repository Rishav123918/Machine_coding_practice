package ScheduledThreadPoolExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(2);
        executorService.schedule(()-> System.out.println(Thread.currentThread().getName()),2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(()-> System.out.println("Thread name : "+Thread.currentThread().getName()),1,3,TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(()-> System.out.println("Thread name : "+Thread.currentThread().getName()),1,4,TimeUnit.SECONDS);

        executorService.shutdown();
    }
}

/*
scheduleAtFixedRate
t=0s  → nothing yet
t=1s  → Task 1 starts
t=4s  → Task 2 starts (1 + 3)
t=7s  → Task 3 starts (4 + 3)
t=10s → Task 4 starts (7 + 3)

scheduleWithFixedDelay
t=0s  → nothing
t=1s  → Task 1 starts (ends at 2s)
t=5s  → Task 2 starts (ends at 6s)
t=9s  → Task 3 starts (ends at 10s)
 */


/*
🔹 1. Core Root
Executor (interface)

Part of: java.util.concurrent

Method: void execute(Runnable command)

Divided into:

ExecutorService (interface)

Direct implementations like ThreadPoolExecutor (class)

🔹 2. Extended Interface
ExecutorService (interface)

Extends Executor.

Adds lifecycle & task submission methods: submit(), invokeAll(), invokeAny(), shutdown(), etc.

Divided into:

ScheduledExecutorService (interface)

Implementations like ThreadPoolExecutor and its subclasses.

🔹 3. Scheduling Extension
ScheduledExecutorService (interface)

Extends ExecutorService.

Adds scheduling methods:

schedule()

scheduleAtFixedRate()

scheduleWithFixedDelay()

Divided into:

ScheduledThreadPoolExecutor (class) (main implementation)

🔹 4. Core Implementation
ThreadPoolExecutor (class)

Concrete implementation of ExecutorService.

Provides thread pooling with queue management.

Used via factory methods:

Executors.newFixedThreadPool()

Executors.newCachedThreadPool()

Executors.newSingleThreadExecutor()

🔹 5. Scheduler Implementation
ScheduledThreadPoolExecutor (class)

Subclass of ThreadPoolExecutor.

Implements ScheduledExecutorService.

Allows delayed & periodic tasks.

Usually created with:

Executors.newScheduledThreadPool(int corePoolSize)

3 Interfaces → Executor, ExecutorService, ScheduledExecutorService

2 Classes → ThreadPoolExecutor, ScheduledThreadPoolExecutor
 */