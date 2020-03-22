package chap06.decorator.demo2;

public class Hat extends Finery {

    @Override
    public void show() {
        System.out.print(" red hat ");
        super.show();
    }
}
