package chap06.decorator.demo2;

public class DecoraterMain {

    public static void main(String[] args) {
        Person lin = new Person("Lincoln");
        System.out.println("The first show:");

        Sneaker s = new Sneaker();
        Hat h = new Hat();

        s.decorate(lin);
        h.decorate(s);
        h.show();
    }

}
