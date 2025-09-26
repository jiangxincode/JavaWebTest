package chap28.visitor.demo1;

/**
 * 客户端
 */
public class VisitorMain {

    public static void main(String[] args) {
        ObjectStructure o = new ObjectStructure();

        o.attach(new ConcreteElementA());
        o.attach(new ConcreteElementB());

        ConcreteVisitor1 visitor1 = new ConcreteVisitor1();
        ConcreteVisitor2 visitor2 = new ConcreteVisitor2();

        o.accept(visitor1);
        o.accept(visitor2);
    }
}
