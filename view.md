
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
- https 握手非对称加密,传输对称加密
- cookie与session、token 应用+分布式一致性问题

### Linux相关
- 文件的权限和操作
- 常用命令,top awk netstat sort uniq
- 线上日志文件的删除和清空
- 性能瓶颈 load cpu swap 磁盘
- shell脚本

## Java相关

- 八种基本数据类型个和大小
- Java引用 原理 强软弱虚
- Object对象的方法 equals hashcode  wait notify toString
- hashmap concurrentHashMap 1.7 1.8
- hashmap resize 死循环
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
   > http://yuanlei.me/2017/11/17/can-we-make-array-volatile-in-java/

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
- 线程池 构造方法参数含义 阻塞队列 任务满了 原理和机制
- java的线程调度算法
   + 使用系统调用创建线程，因此实际的线程模型和调度算法依赖于操作系统

- Thread.sleep(0)的作用
   + 当前线程让出cpu



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
