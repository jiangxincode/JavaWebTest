package chap10.templateMethod.demo1;

/**
 * 具体类B
 */
public class ConcreteClassB extends AbstractTemplate {

    @Override
    public void primitiveOperation1() {
        System.out.println("具体类B的方法1实现");
    }

    @Override
    public void primitiveOperation2() {
        System.out.println("具体类B的方法2实现");
    }

}
