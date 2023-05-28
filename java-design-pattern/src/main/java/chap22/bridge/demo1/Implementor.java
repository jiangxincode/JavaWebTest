package chap22.bridge.demo1;

/**
 *
 */
public abstract class Implementor {

    public abstract void operation();

}

class ConcreteImplemtorA extends Implementor {

    @Override
    public void operation() {
        System.out.println("ConcreteImplemtorA的方法执行");

    }

}

class ConcreteImplemtorB extends Implementor {

    @Override
    public void operation() {
        System.out.println("ConcreteImplemtorB的方法执行");

    }

}
