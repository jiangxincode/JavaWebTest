package chap06.decorator.demo2;

public class TShirt extends Finery {

    @Override
    public void show() {
        System.out.print(" T-Shirt ");
        super.show();
    }
}
