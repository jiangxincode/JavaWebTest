package chap08.factoryMethod.demo1;

/**
 * 工厂方法客户端
 */
public class FactoryMethodMain {
    public static void main(String[] args) {
        IFactory operFactory = new DivFactory();
        Operation operation = operFactory.createOperation();

        operation.numberA = 3.4;
        operation.numberB = 4.5;

        System.out.println(operation.getResult());

    }
}