## Spring **Aware interface

```$xslt
    Spring 源码中存在许多以Aware结尾定义的接口，如：ResourceLoaderAware、ApplicationEventPublisherAware、ApplicationEventPublisherAware、
    MessageSourceAware、ApplicationContextAware ....
    查看这些接口的定义，发现往往只有一个setter方法，多是把前缀的类定义的实例注入;
    如，ApplicationContextAware 只有一个 void setApplicationContext(ApplicationContext applicationContext)方法。
```
```$xslt
    其实，细细地品味，这应当是Spring 依赖注入方式中 接口注入方式的应用。
    
    任何实现**Aware接口的类的实例，自然也具备**Aware类型，Spring通常会 instanceof 方法判定一个**Aware 类型，然后将相应的 ** 实例注入。
    如Spring — ApplicationContextAwareProcessor 的 postProcessBeforeInitialization 方法。
    
    再来体会，接口注入方式；
    接口注入的方式，一直以来因其笨重与代码量的膨胀，被人所诟病。
    
    但是，在框架设计中，对于重量级抽象属性的注入，在整个结构上更加清晰；
    而且，在控制权限的转交（IOC）上也及其方便。
    ( 第三方 以 instanceof 方式判定当前对象是否实现了 **Aware 接口，若是，则将调用其 set**（**）方法将 ** 实例注入到该对象中。
```