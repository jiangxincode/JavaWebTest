package delegator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
 * 委托模式是一项基本技巧，许多其他的模式，如状态模式、策略模式、访问者模式 本质上是在更特殊的场合采用了委托模式。
 * 委托模式使得我们可以用聚合来替代继承，它还使我们可以模拟mixin。
 * 委托在C#中是一个语言级特性，而在Java语言中没有直接的对应，但是我们可以通过动态代理来实现委托。
 */
public abstract class Delegator implements InvocationHandler {

    protected Object obj_orgin = null; // 原始对象
    protected Object obj_proxy = null; // 代理对象

    public Delegator() {
    }

    public Delegator(Object orgin) {
        this.createProxy(orgin);
    }

    protected Object createProxy(Object orgin) {
        obj_orgin = orgin;
        // 下面语句中orgin.getClass().getClassLoader()为加载器，orgin.getClass().getInterfaces()为接口集
        obj_proxy = Proxy.newProxyInstance(orgin.getClass().getClassLoader(), orgin.getClass().getInterfaces(), this); // 委托
        return obj_proxy;
    }

    protected Object invokeSuper(Method method, Object[] args) throws Throwable {
        return method.invoke(obj_orgin, args);
    }

    // 实现InvocationHandler接口，要求覆盖
    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        return this.invokeSuper(method, args);
    }
}