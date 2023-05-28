package chap10.templateMethod.demo1;

/**
 * 模板方法客户端
 */
public class TemplateMain {
    public static void main(String[] args) {
        AbstractTemplate abstractTemplate;

        abstractTemplate = new ConcreteClassA();
        abstractTemplate.templateMethod();

        abstractTemplate = new ConcreteClassB();
        abstractTemplate.templateMethod();

    }
}
