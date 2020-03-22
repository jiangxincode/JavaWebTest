package chap06.decorator.demo2;

public class Sneaker extends Finery {

    @Override
    public void show() {
        System.out.print(" sneaker ");
        super.show();
    }
}
