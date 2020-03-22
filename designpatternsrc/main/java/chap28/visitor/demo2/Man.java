package chap28.visitor.demo2;

public class Man extends Person {

    @Override
    public void accept(Action visitor) {
        visitor.getManReflection(this);
    }

}
