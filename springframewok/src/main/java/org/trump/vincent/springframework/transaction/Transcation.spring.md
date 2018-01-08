# 事务管理（Spring事务管理）

```$xslt
  在java中一般存在3种事务模型：本地事务模型、编程事务模型、声明式事务模型。
```

##本地事务模型
```$xslt
   本地事务模型，指事务不由编程者处理（编程框架也不关注事务），事务完全由目标中间件的资源管理器来管理。
   
   如，对于数据库，资源管理器由DBMS与数据库驱动实现，当然包含其本地事务管理模型也要一并实现。
   
   对于JMS（消息系统），完整的JMS一定会实现topic、queue、connection等核心资源，并实现完善的资源管理体系，和本地事务处理。
```
```$xslt
    总体来说，
    本地事务，指的是，中间件基本操作的事务由中间件自身提供；
    编程开发人员，需要管理的只是connection，而不再关注其内部事务处理。
    
    例如，
    原生的JDBC编程时，研发人员只需要获取正确的DBMS的连接就可以了，
    JDBC-Connection默认设置autoCommit；
    当设置autoCommit为false时，我们也只是通过connection做简单的commit、rollback操作。
```

##编程式事务模型(JTA 和 JTS)
```$xslt

    编程式事务一般由Web框架、容器中间件的事务管理器提供事务规范的实现；
    编程开发人员，基于该事务规范实现，进行自己的事务处理。
    
    在编程式事务中，编程者要处理的对象直接是事务对象本身，可通过覆盖事务模型内的处理来达到自己特殊的事务要求。
    相对于本地事务而言，编程式事务让编程者有绝对的控制权；
    事务不再仅仅被目标中间件的事务管理器管理，编程式事务把事务控制移交到编程者手中。
```
```$xslt
    1、EJB
    多数的EJB容器会提供JTA的实现（JBoss），EJB环境里，编码者使用 UserTranscation接口进行事务的主动管理；
    
    2、JavaEE(Spring-Framework)
    由于一般的web容器或Servlet容器（tomcat、Jetty等）未提供编程事务实现；编程中一般需要借助Spring的事务机制做事务托管；
    Spring事务支持编程式事务、声明式事务两种模型。
    先说，Spring中编程式事务依靠TranscationTemplate 和 PlatformTranscationManager 两个核心类。
    
```
##声明式事务