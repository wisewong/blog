
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
   1. 整型 int 4,short 2,long 8
   2. 浮点型float 4,double 8
   3. 字符 char 2
   4. 布尔 boolean 1
   5. 字节 byte 1
- Java引用 原理 强软弱虚
   1. 不回收
   2. 内存不足时回收
   3. 发现就回收
   4. 相当于不存在

- Object对象的方法 
   + equals hashcode  wait notify toString

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
