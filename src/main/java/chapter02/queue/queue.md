### 队列

#### 队列的定义
先进先出的操作受限的线性表结构，需要头指针和尾指针两个指针变量来记录位置 

#### 队列的种类  

- 顺序队列   
用数组实现，不需要搬移数据时入队的时间复杂度是O(1)，空间复杂度O(1)。当发生数据搬移时搬移数据那一次操作的时间
复杂度变成O(n)，所以平均时间复杂度仍是O(1)。

- 链式队列
基于链表实现，不需要扩容时时间复杂度和空间复杂度都是O(1)，扩容时时间复杂度O(n)  

- 循环链表  
链表的特殊实现，尾部节点连接首部节点。这种结构可以避免数据搬移。队满的条件时(tail+1)%n==head  

- 阻塞队列和并发队列  
当队满的时候对入队的操作进行阻塞，当对空的时候对出队的操作阻塞(生产者消费者模式)；
线程安全的队列叫作并发队列，加锁或者CAS

#### 拓展   
- java ThreadPoolExecutors线程池参数  
  - corePoolSize 核心线程数,线程池中，除非设置了allowCoreThreadTimeOut=true，否则会一直再线程池中存活，即使idle  
  - maximumPoolSize 最大线程数（核心线程数+非核心线程池数）,线程池所能创建的最大线程数。  
  - keepAliveTime 存活时间，当线程数目超过核心线程池时，线程所能idle的最大时间，超出时间将被terminating
  - unit 存活时间单位
  - BlockQueue 工作队列，当达到核心线程数后，处理任务的时候会将任务放在工作队列中  
  - RejectedExecutionHandler  当工作队列满并且再有任务请求创建线程时会执行  
    - AbortPolicy 默认的执行策略，当线程数等于最大线程数，再次请求时会抛出RejectedExecutionException，任务也不会被执行  
    - DiscardPolicy 忽略执行策略，当达到最大线程数时，直接忽略，不抛出任何一场
    - CallerRunsPolicy 重试添加任务
    - DiscardOldestPolicy 忽略最先入队咧的任务，并将新的任务入队列

- 五种常见的线程池  
  - newFixedThreadPool 固定大小的线程池，**核心线程池数等于最大线程池数**，此时存活时间已没有意义，线程将一直存活。**队列为LinkedBlockingQueue**，
  是一个无限队列，任务可以一直添加，对于不需要及时返回结果的场景比较适合
  ```
  public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
             return new ThreadPoolExecutor(nThreads, nThreads,
                                           0L, TimeUnit.MILLISECONDS,
                                           new LinkedBlockingQueue<Runnable>(),
                                           threadFactory);
         } 
  ```
  - newCachedThreadPool 缓存线程池.**核心线程数为0，最大线程数时INTEGER.MAX**，意味着线程池可以无限大，但是没有任务的时候没有存活的线程。
  队列采用了**SynchronousQueue**，这个队列只能同时有一个任务执行，当任务入队后，必须等到任务出队之后新的任务才能入队，意味着如果有线程再队列中，
  新的任务会被创建再线程池。**此线程池适合执行时间很短的任务** 
  ```
  public static ExecutorService newCachedThreadPool() {
          return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                        60L, TimeUnit.SECONDS,
                                        new SynchronousQueue<Runnable>());
      }
  ```



