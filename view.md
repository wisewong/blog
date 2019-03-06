
# 基础


## 基本功

- 常见的排序算法,查找算法
- 设计模式

### 网络相关
- http协议,握手挥手
- https 握手非对称加密,传输对称加密
- cookie与session、token 应用+分布式一致性问题

### Linux相关
- 文件的权限和操作
- 常用命令,top awk netstat sort uniq
- 线上日志文件的删除和清空
- 性能瓶颈 load cpu swap 磁盘
- shell脚本

## Java相关

### JDK源码
- HashMap,ConcurrentHashMap 原理,1.7 1.8区别,死循环问题
- 对不同锁的理解，按不同维度，重量/轻量级所,可重入锁,公平/非公平锁
- AQS原理,在并发包中的地位,常用的几种锁的封装
- CAS与自旋,应用以及优缺点  ABA问题
- synchronized原理,可重入性,锁的级别
- volatile关键字
- 集合,list,map,set  内部排序算法实现
- ThreadLocal

### Java基本功
- 基础数据类型以及封装类型 装箱拆箱 Integer内部cache
- hashCode与equals方法 
- 异常处理 error与exception，运行时异常以及受检异常
- 四种引用类型，强软弱虚
- 重载与重写，动态多态性与静态多态性
- 父子类 构造方法 静态代码块 字段 初始化顺序
- interface与abstract区别
- 反射
- 泛型
- 类加载机制


### JVM相关
- 运行时数据区
- 内存模型
- 垃圾回收算法
- 调优 问题排查



# 框架相关

## Spring
## Mybatis
## Dubbo
## 消息队列
## 调度框架


# 服务相关

## 负载均衡 
- ng
- or
- lvs
## 微服务
## 分布式事务 CAP原理 zk
- CAP定理
- TCC解决方案
- 消息队列解决方案
##服务降级与隔离
- 限流、熔断 
- dubbo group隔离
## 幂等
## 异步与NIO



# 数据库相关

## Mysql
## ES
## 缓存 redis memcache
## sql优化

# 容器相关
## servlet原理 jsp原理
## Tomcat原理







# 问题


## 基本功
- 设计模式 单例 工厂 适配器责任链 观察者

### 网络相关
- http协议,握手挥手
   1. 三次握手：为什么不是两次握手或四次握手?
      + 防止失效的连接请求报文段被服务端接受，从而产生错误。
   2. 四次挥手：等待2MSL的原因：
      + 防止最后一个ACK包对方没有收到；
      + 防止已经失效的连接请求报文出现在连接中
   3. 拥塞控制
   4. 粘包拆包问题

- https 握手非对称加密,传输对称加密
- cookie与session、token 应用+分布式一致性问题
   1. 服务端生成token,给客户端
   2. 客户端带着token来,服务端使用相同的算法,验证token的有效性
   3. 不需要单独的服务器存储会话

### Linux相关
- 文件的权限和操作
   1. 权限 拥有者-用户组-其他人 chmod 666 file ;chmod +x file;chown use file
- 常用命令,top awk netstat sort uniq
   1. top -H -p pid
   2. awk -F ' ' '{pring $1}'
   3. uniq -c 每个出现的数量
   4. sort -nr 按数字从大到校排序
- 线上日志文件的删除和清空
   1. du -sh * |grep G
   2. echo ' ' > file
   3. echo " " | sudo tee f.txt 
- 性能瓶颈 load cpu swap 磁盘
- shell脚本

## Java相关

- 八种基本数据类型个和大小
   1. 整型 int 4,short 2,long 8
   2. 浮点型float 4,double 8
   3. 字符 char 2
   4. 布尔 boolean 1
   5. 字节 byte 1

- string
   1. String s = new String("abc");       "abc"在常量池中创建一个,new 在堆区创建一个  创建2个
   2. String s1 = "abc";    直接在常量池创建
   3. String s = new String("abc");  String s2 = new String("abc");     先按1中创建两个,后面再创建一个

- Java引用 原理 强软弱虚
   1. 强：不回收
   2. 软：内存不足时回收
   3. 弱：发现就回收
   4. 虚：相当于不存在
   5. 引用在栈中，指向堆区，堆区里面需要实现能找到这个指向的对象以及它的类数据。堆区维护这两者的方式有两种：句柄和直接指针
      + 句柄：堆区维护一个句柄池，引用指向一个句柄，句柄存储了堆区对象池中的具体对象数据，以及方法区的类型数据。好处：对象被移动时，只改变句柄的指针，栈里面的引用不改变
      + 直接指针：引用即直接指向了对象的地址，但是对象的布局中需要考虑如何存放类型数据。 好处：一次定位，速度快

- Object对象的方法 
   + equals hashcode  wait notify toString

- hashmap concurrentHashMap 1.7 1.8

- hashMap
   1. put逻辑：hash到table的位置，查找是否存在key==或者key.equals的方法元素，有就替换，没有就新加
   2. put新元素之后，判断阈值，是否扩容
   2. 7和8的区别
      + 链表过长时采用红黑树
      + 7是在链表头部添加新元素，8是在链表尾部添加新元素
      + 7是先扩容再插入，8是先插入再扩容

- concurrentHashMap 1.7
   1. 分段加锁，每一段都可以存放一个table，支持扩容，默认分段16个
   2. 每个端Segment同时继承了ReentrantLock，实现并发控制


- concurrentHashMap 1.8
   1. 第一次put操作时，才会初始化table
   3. 抛弃分段的设计，使用循环+CAS操作尝试获取sizeCtl的控制权，以达到线程同步的目的，不同的sizeCtl值代表不同的状态
      + -1：table[]正在初始化
      + -N：表示有N-1个线程正在进行扩容操作
      + 非负：如果table[]未初始化，则表示table需要初始化的大小。
      + 非负：如果初始化完成，则表示table扩容的阀值，默认是table容量的0.75 倍。
   4. put时，table[i]==null时，CAS设置值；否则，对当前链表首个元素table[i]加锁，实现该链表中元素值的替换，或者队尾添加元素操作

- hashmap resize 死循环
   1. 在一个线程记录了e和next的情况下,另一个线程完成了链表逆序的扩容,这个线程再扩容的时候就可能出现环

- Overload和Override的区别 
   1. Overload是重载，重载的方法参数列表不同 
   2. Override是重写，子类重写父类方法，参数列表和返回值都一样
- for和foreach性能比较
   1. 对于数组来说，for和foreach循环效率差不多
   2. 对于链表来说，for循环效率明显比foreach低
- 有return的情况下try catch finally的执行顺序 
   1. 不管有没有出现异常，finally块中代码都会执行；
   2. 当try和catch中有return时，finally仍然会执行；
   3. finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，不管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），所以函数返回值是在finally执行前确定的；
   4. finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。
- OOM和stackOverFlow的case
    1. open-price OOM
    2. eb 正则表达式 回溯栈过长

- 泛型擦除机制是怎样的

- 重写compareTo()方法或实现Comparator接口要遵循的原则
   1. 自反性 对称性 传递性 一致性
   2. 不严格遵守的情况下，1.6升1.7会出问题 因为排序算法改成了TimSort
   
- OOP与AOP
   1. OOP（面向对象编程）针对业务处理过程的实体及其属性和行为进行抽象封装，以获得更加清晰高效的逻辑单元划分。
   2. AOP是针对业务处理过程中的切面进行提取，它所面对的是处理过程中的某个步骤或阶段，以获得逻辑过程中各部分之间低耦合性的隔离效果

- 多线程的意义
   - 从逻辑角度来看，多线程的意义在于一个应用程序中，有多个执行部分可以同时执行

- CountDownLatch和CyclicBarrier，Semaphore
   1. CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行
   2. CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行
   3. CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的
   4. Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限

- volatile作用
   1. 保证数据可见性
   2. 防止指令重排
   3. 对于数组和对象，只能保证其引用的可见性，不保证引用中各个元素的可见性
      + 数组可以使用Unsafe.getObjectVolatile来解决
      + 对象可以将字段也设置为volatile
      + 之所以数组存在元素可见性的问题，是因为Java数组在元素层面的元数据设计上的缺失，无法表达元素是final、volatile等语义
   > http://yuanlei.me/2017/11/17/can-we-make-array-volatile-in-java/

   > https://guojohnny.com/2016/05/23/%E4%BD%BF%E7%94%A8volatile%E5%85%B3%E9%94%AE%E5%AD%97%E5%A3%B0%E6%98%8E%E5%BC%95%E7%94%A8%E5%8F%AF%E4%BB%A5%E4%BF%9D%E8%AF%81%E5%BC%95%E7%94%A8%E6%89%80%E6%8C%87%E5%AF%B9%E8%B1%A1%E5%AE%89%E5%85%A8%E5%90%97/

   > https://www.jianshu.com/p/5808db3e2ace

- 什么是线程安全
   + 一个类或者程序所提供的接口对于线程来说是原子操作或者多个线程之间的切换不会导致该接口的执行结果存在二义性
   + 个人理解，多个线程之间对于共享数据的操作结果，不会因为线程的执行顺序以及线程间的切换而导致的数据和结果的不准确性

- ThreadLocal
   1. 当前线程对应的Thread中有一个map用来存threadLocal变量
   2. map的key是threadLocal对象，value是threadLocal对象存放的值
   3. ThreadLocal类的get和set方法提供了访问当前Thread的map中这个threadLocal对应的值
   4. 多线程使用同一个threadLocal对象，往各自的Thread类里面的map塞进去threadLocal这个key对应的值，以达到线程隔离的目的

- FutureTask与Future
   1. Future是用于访问提交给线程执行的任务的状态和执行结果的
   2. FutureTask同时实现了Runnable和Future接口
   3. FutureTask使用的两种方式
      + 线程池submit之后会返回一个Future，默认是FutureTask对象
      + 把自己的Runnable或Callable包一层变成FutureTask对象提交给sumbit方法执行，无需关心submit的返回值
   > https://blog.csdn.net/f641385712/article/details/83546803

- 模拟实现一个死锁
   1. A线程  lock1.lock()   sleep(1000) lock2.lock()    lock2.unlock lock2.unlock
   2. B线程  lock2.lock()   sleep(1000) lock1.lock()    lock1.unlock lock2.unlock
   3. 加锁顺序不同可能导致产生死锁

- 线程池 构造方法参数含义 阻塞队列 任务满了 原理和机制
   1. 高并发、任务执行时间短的业务，线程池线程数可以设置为CPU核数+1，减少线程上下文的切换 
   2. 并发不高、任务执行时间长的业务，根据CPU密集型和IO密集型设置不同的线程池大小

- java的线程调度算法
   + 使用系统调用创建线程，因此实际的线程模型和调度算法依赖于操作系统

- Thread.sleep(0)的作用
   + 当前线程让出cpu

- 伪共享
   1. CPU L1 L2 L3 缓存行 大小8个Long 
   2. 不同CPU分别对各自缓存行的相同数据频繁更新不同区域的内容，导致各CPU缓存行失效
   > https://www.cnblogs.com/cyfonly/p/5800758.html

- dump内存
   + jmap -dump:live,format=b,file=dump.hprof 进程pid

- i++ 底层步骤
   1. int i=0; i=i++
   2. 记录i的值0，将i自增变成1，将0赋值给i

- Object的clone方法

- a = a + b 与 a += b 的区别
   1. +=会进行自动类型转换
   2. +=在cpu计算层面会更快，但是java编译的时候会优化，底层相同快

-  浮点数精度
   1. 0.1*3 ==0.3  fasle
   2. 0.1*1 == 0.1 true
   3. 1* 0.3 == 0.3 true
   4. 原因：浮点数不精确，0.1*3=0.30000000000000004

- int和Integer所占内存
   + Integer更多，因为是一个对象，需要存储对象的元数据


- 64位的JVM当中，int的长度是多少
   + int类型为32位，即4个字节，Java数据类型与平台无关，是统一由JVM适配的

- JVM 32位与64位区别
   1. 64位下，寻址能力更强，对象引用指针占用更多内存，通常内存消耗比32位大1.5倍
   2.  -XX:+UseCompressedOops 压缩普通对象指针，节省内存；可能会给JVM增加额外的开销

- hashCode() 和 equals()
   1. equals()判断对象是否相等，Object的实现是判断是否是相同对象，重写之后可用来表示是否是逻辑上相等
   2. hashCode() 是对象的哈希值。对象相等，哈希值一定相等；哈希值相等，对象不一定相等；对象不相等，但哈希值相等的情况下，成为哈希冲突

- 排序的几种方式
   1. 接口的sort方法
   2. 工具类Collections.sort

- 打印数组
   1. int[] array = {1,2,3,4,5};
   2. System.out.println(Arrays.toString(array));或者遍历输出
   3. System.out.println(array);这样是不行的，这样打印是的是数组的首地址。

- 多线程需要注意的什么
   1. 线程安全
   2. 线程池大小，名称，阻塞队列，拒绝策略

- CAS 有什么缺陷，如何解决
   1. ABA问题，添加版本号解决 参见AtomicStampedReference
   2. 自旋循环增加CPU空转开销

- synchronized 和 lock
   1. synchronized是JVM级别的，lock是代码级别的实现
   2. lock粒度更细，支持读写锁分离和公平锁/非公平锁
   3. lock使用了CAS，必须再finally手动释放锁
   4. lock使用condition来通信,实现object的wait notify的等待唤醒,并且可以多条件隔离的等待唤醒

- 如何正确退出一个线程
   1. 通过interrupt()设置中断标记,代码里适当的地方判断线程中断状态,return或break等操作退出;对于处于 wait sleep join状态的线程,中断标记将会被清除,并抛出InterruptedException异常
   2. 使用boolean值的volatile标志位,通过判断标记来终止线程,但无法解决阻塞和sleep状态下的线程
   3. stop()方法，立即停止,已被弃用
   > https://blog.csdn.net/qq_24693837/article/details/71601044
   > https://blog.csdn.net/Smile_Miracle/article/details/71550548

- AQS
   1. 为线程同步,提供了一种通用机制和方法,具有获取锁,释放锁,进入阻塞队列以及唤醒操作的功能,可以方便的利用这些工具实现自己定制化的锁,比如可重入锁,公平非公平锁
   2. AQS本质是采用CHL模型完成了一个先进先出的队列。用volatile修饰共享变量state，线程通过CAS去改变状态值，成功则获取锁成功，失败则进入等待队列，等待被唤醒。
   3. 对于入队，采用CAS操作，每次比较尾节点是否一致，然后插入到尾节点中。对于出队列，等待释放锁的唤醒

- ReadWriteLock
   + 读写分离，在没有写锁的情况下，读锁是无阻塞的，提高了执行效率，它是一种共享锁

### JVM相关
- 运行时数据区
- 内存模型
- 垃圾回收器
   1. Partial GC：并不收集整个GC堆的模式：Young GC，Old GC(只有CMS才只收集老年代)，Mixed GC(收集整个young gen以及部分old gen,只有G1)
   2. Full GC：收集整个堆，包括young gen、old gen、perm gen
   3. 触发条件
      + young gc:eden空间不足触发young gc
      + full gc:young gc时发现老年代空间不足时；perm gen空间不足时；System.gc()时；heap dump时；
   4. Parallel Scavenge默认是在要触发full GC前先执行一次young GC，并且两次GC之间能让应用程序稍微运行一小下，以期降低full GC的暂停时间
   > https://www.cnblogs.com/jenkov/p/full_gc_old_gc_cms_gc.html
   5. 组合使用
      + 计算密集型的应用可能会考虑计算的吞吐量，在注重吞吐量以及CPU资源敏感的场合，都可以优先考虑Parallel Scavenge加Parallel Old收集器
      + 在要求低延时、系统停顿时间最短的场景下，可以使用ParNew + CMS,CMS可以满足与用户线程并发执行，所以需要在老年代还有一定空间的时候就执行回收。而且使用的是标记清除算法，会产生碎片导致可能因为大对象触发更多full gc
      + CPU总执行时间=用户线程时间+gc线程总时间,而吞吐量是指用户线程时间占cpu总时间的多少
      + gc的目标是`吞吐量高 或者 停顿时间短`
         1. gc总时间=每次gc时间的总和
         2. 由于每次gc都会带来cpu上下文切换等开销,因此通过减少gc次数,来减少总的gc时间开销;由于偶尔才会gc一次,所以gc回收率也相对较高,可能比多次gc所花的时间效率上更高
         3. 若想达到每次停顿比较短,那可以通过增加gc的次数,使每次回收的垃圾比较少,来减少停顿时间
         4. Parallel组合的方式满足第二点的`gc次数少`和`gc效率高`,以使得系统吞吐量比较高
         5. ParNew和CMS组合,满足第三点的`gc次数相对频繁` 和 `gc停顿时间短`,同时由于CMS其中两个阶段是可以`和用户线程并发执行`的,所以`进一步缩短了停顿时间`
         > http://ifeve.com/useful-jvm-flags-part-6-throughput-collector/
      
   6. 并行与并发
      + Parallel 的是并行的，可以同时利用多个cpu.并行指多条垃圾收集线程并行工作，但此时用户线程仍然处于等待状态
      + Concurrent 是并发的，gc线程和用户线程可以交替并发执行.指用户线程与垃圾收集线程同时执行（但不一定是并行的，可能会交替执行）
      > https://crowhawk.github.io/2017/08/15/jvm_3/
   7. stop the world
      + Serial, ParNew, Parallel Scanvange, Parallel Old, Serial Old全程都会Stop the world，JVM这时候只运行GC线程，不运行用户线程
      + CMS主要分为 `初始标记,并发标记,重新标记,并发清除`等阶段，`初始标记`和`重新标记`占整体的时间比较较小，它们会Stop the world. `并发标记 和 并发清楚` 会和用户线程一起运行。
      > https://blog.csdn.net/iter_zc/article/details/41746265
   > https://www.jianshu.com/p/50d5c88b272d

- 调优 问题排查



# 框架相关

## Spring
- bean的生命周期
   1. 在IoC容器启动之后，并不会马上就实例化相应的bean，此时容器仅仅拥有所有对象的BeanDefinition(BeanDefinition：是容器依赖某些工具加载的XML配置信息进行解析和分析，并将分析后的信息编组为相应的BeanDefinition)。只有当getBean()调用时才是有可能触发Bean实例化阶段的活动
   3. 几个大步骤，实例化、初始化、注册回调函数，使用，销毁
   4. 实例化之后会设置对象属性，检查设置Aware接口相关依赖
   4. 初始化前后调用bbp，初始化中调用afterPropertiesSet，初始化方法init method

- 解决循环依赖的问题
   1. 两种注入方式，构造器注入，setter注入，前者循环依赖抛异常，后者可以利用三级缓存实现注入，但只能解决单例作用域的Bean循环依赖
   2. 构造器注入的方式，每一个bean的实例化都依赖下一个bean的实例化，所以就导致这个循环的的bean都无法实例化，所以才会异常
   3. setter注入的方式，是在bean实例化之后，设置属性的阶段操作的，此时对象已经存在了，因此只需要依次设置引用即可

- bean在spring中以BeanDefinition的形式存在
- ApplicationContext作为spring的ioc容器,标识一个应用环境,创建bean,维护bean的关系

- aop
   1. 动态代理
   2. cglib与jdk的区别   前者生成代理对象的子类,生成速度慢,执行速度快.后者实现代理对象的所有接口,生成速度快,执行速度慢
   3. 有接口实现的话,默认走jdk代理,否则走cglib

- spring mvc工作流程
   1. DispatcherServlet->HandlerMapping(根据url查找对应的处理链+HandlerAdapter)
   2. DispatcherServlet->执行处理链-> HandlerAdapter->调用Handler(其实是Controller)->返回ModelAndView


- spring boot自动配置的原理
   1. spring.factories文件中配置上自己时间的配置类,spring容积就会在启动的时候把这个自动配置的类加载进来,执行配置类中的自定义配置逻辑org.springframework.boot.autoconfigure.EnableAutoConfiguration=qunar.tc.qmq.consumer.annotation.QmqConsumerAutoConfiguration

- spring boot与tomcat的整合
   1. 内嵌tomcat  启动boot进程的时候,调用内嵌tomcat的方法,启动tomcat各种组件,并通过代码的方式,动态添加原web.xml中配置的servlet filter等(servlet 3.0支持)
   2. boot程序打war包放到tomcat中执行.war包中自带ServletContainerInitializer实现,tomcat容器启动时,会依次调用所有的SCI,此时实现spring的dispatcherServlet的加载和spring容器的初始化

## Mybatis
## Dubbo
- 服务的暴露
   1. 监听spring容器初始化完成后发布的`刷新容器事件`,Dubbo 会调用 ServiceBean的 父类 ServiceConfig 的 export 方法，而该方法真正实现了服务的（异步或者非异步）发布

- 服务提供者能实现失效踢出是什么原理
   1. 基于zk的临时节点,与客户端的连接终端超过一定的超时时间之后,会删除临时节点

- 安全机制:token机制,防止调用方绕过注册中心调用

- 通讯协议:dubbo,hessian,http,rmi

- 为什么使用zk做注册中心
   + Zookeeper的数据模型很简单，zk将全量数据存储在内存中，性能高，而且支持集群，高可用，能保证数据的一致性和可靠性,能有效的作为一个发布订阅的注册中心

- 遇到的bug
   + 不算bug,dubbo默认数据量限制8m.一个服务同步另一个服务的缓存数据,超过限制,抛异常了
   
- dubbo协议
   + 单连接,长连接,基于tcp,nio,Hessian序列化


   


## 消息队列
## 调度框架


# 服务相关

## 负载均衡 
- ng
- or
- lvs
## 微服务
## 分布式事务 CAP原理 zk
- CAP定理
- TCC解决方案
- 消息队列解决方案
##服务降级与隔离
- 限流、熔断 
- dubbo group隔离
## 幂等
## 异步与NIO



# 数据库相关

## Mysql

### MVCC
- 当一个事务进行写操作的时候，把要操作的数据存一份，作为一个版本，其他事务进行读操作的时候，读取的数据是原有数据的版本，这样读操作并没有没已存在的写操作阻塞住，从而提高了并发度。



## ES
## 缓存 redis memcache

### redis

#### 数据类型
- 5种数据类型：string，list，hash，set，zset
- list，有包含quick list，是ziplist+链表实现的。数据量较少的时候，使用连续内存存储(ziplist),多的时候使用链表，这样既满足了快速的插入删除性能，又不会出现太大的空间冗余。
- hash，同java一样使用的是数组+链表的方式  用法：> hset books java "think in java"  key是map的变量名，之后才是这个map里面的键值
- set，同java一样，一个特殊的map，value都是NULL。
- zset 有序集合，使用hash表+跳跃列表来实现
   1. 当数据较少时，sorted set是由一个ziplist来实现的。
   2. 当数据多的时候，sorted set是由一个dict + 一个skiplist来实现的。简单来讲，dict用来查询数据到分数的对应关系，而skiplist用来根据分数查询数据（可能是范围查找）。
   3. skiplist，指的就是除了最下面第1层链表之外，它会产生若干层稀疏的链表，这些链表里面的指针故意跳过了一些节点（而且越高层的链表跳过的节点越多）。这就使得我们在查找数据的时候能够先在高层的链表中进行查找，然后逐层降低，最终降到第1层链表来精确地确定数据位置。在这个过程中，我们跳过了一些节点，从而也就加快了查找速度。
   4. 创建和插入过程，每一个节点所在的层数（level）是随机出来的，而且新插入一个节点不会影响其它节点的层数。因此，插入操作只需要修改插入节点前后的指针，而不需要对很多节点都进行调整。
   5. 为什么用skiplist而不用平衡树？从内存占用、对范围查找的支持和实现难易程度这三方面结合

#### 规则
- 容器类的通用规则
   1. 如果容器不存在，那就创建一个
   2. 如果容器里元素没有了，那么立即删除容器
- 过期时间，针对整个redis的容器对象的过期，并非是针对容器中单个元素的过期

## sql优化

# 容器相关
## servlet原理 jsp原理
## Tomcat原理

### NIO
- Connector负责对外的连接
- Connector中的protocolHandler维护协议,IO方式
- NIO控制逻辑在Connector的NioEndpoint中
- Acceptor接受连接请求,Poller轮询channel,都是用的selector,不过前者是阻塞,后者是非阻塞
- acceptor阻塞的接收到请求,封装channel到一个PollerEvent事件里面,把事件加入Poller线程的events列表里
- poller线程不停的轮询事件列表,把注册的事件注册到他的selector读上面,当有读事件接入,就尝试读取数据,若数据没有读完,继续下次循环;若数据读取完毕,则封装成一个SocketProcessor,交给线程池去执行

### os的 select(),poll(),epoll()

- poll() 得到有就绪的IO时，需要遍历去查询哪些IO是已就绪的，然后返回给用户线程去读写。
- select() 同上,但是fd数量比较小,限制的io的数量
- epoll() 如果有IO已经就绪，不需要遍历,就可以直接给用户线程返回所有就绪的事件，可以对这个就绪的IO通道进行读写。




类加载器可以被继承
三个类加载器是继承的关系吗
会出现违背双亲委派机制的情况吗?  tomcat


# 项目相关

## 手百
- 机器扩容,提高可靠性
- 多种类型的服务,发券,查券,下单环节用券    
   1. 做环境隔离,dubbo group隔离+消息监听隔离
   2. 发券消息监听,在非下单机器做
   3. 查券qps高,接近上万,增加限流,调整缓存时间  滑动窗口 guava 令牌桶
   4. 靠近用户端,拦截  登录多步骤
   5. 消息中间件的运用,根据消费能力,动态决定消费速度,即使机器挂掉,重启也可以平滑的消费消息
   6. 调整消费者消费线程数,来调整消费能力,做到发券的服务降级

## 答题
- 响应时间要求,缓存用户答题数据以及题目和答案
- 题目和答案在内存中,用户答题进度在redis中
- 随机派题,n道题,做hash,记录题目索引,存到redis的用户答题信息用
- 反作弊 提前校验用户身份,校验题号,当前题号的答题时间
- 排行榜,总榜和个人排名.答题结束,刷新redis缓存前n个 若没有答题活动或缓存过期,首次请求也都会缓存 若用户数不满足n,防止缓存击穿,判断redis与db是否强一致.


### 消息队列的应用场景
- 手百 削峰处理,异步调用
- 延迟任务
- provider与consumer解耦,比如下单离店发送积分








- 线程池 什么时候销毁线程 
   + 大于coreSize的,超过保活时间的,会销毁

- Spring切面通知执行的顺序
   + 执行doAround方法，doBefore方法。然后执行method方法,doAfter、doAfterReturn

- 事务的传播机制,隔离级别
- mybatis的执行过程

- ACID和脏读 


- spring cloud
- 微服务和soa的区别


- redis 持久化机制  作用,异同点
   + RDB,定时吧数据库内容写到磁盘文件上,fork一个进程,复制一份数据,写到磁盘上,然后替换原来的文件.数据量大或者写入频繁的话,可能会导致内存开销比较大,磁盘io升高
   + AOF,有写库操作或者定时去写,追加到磁盘文件上.文件变大会有重写机制


- redis支持事务吗?怎么实现的?跟传统数据库的区别



- zk节点类型哪几种
- pa.. 协议
- zk如何加锁
   1. zk创建 删除临时节点,若宕机离线会自动删除节点 没抢到锁的可以注册监听器,不需要等待轮询
   2. redis需要考虑setnx和expire的原子性,以及delete和判断value的原子性,以及集群master未同步就宕机的问题,客户端没取到锁还需要等待重试
   3. zk的加锁比较简单
   > https://blog.csdn.net/A_BlackMoon/article/details/85834810is

- 替换文件里的字符  sed  vim


- 设计模式
