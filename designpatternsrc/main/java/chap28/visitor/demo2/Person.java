package chap28.visitor.demo2;

public abstract class Person {
    public abstract void accept(Action visitor);
}
