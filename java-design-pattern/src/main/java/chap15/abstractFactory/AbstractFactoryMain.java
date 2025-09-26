package chap15.abstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException {
        Operation operation = OperationFactory.createOperation("/");

        operation.numberA = 7;
        operation.numberB = 8;

        System.out.println(operation.getResult());
    }
}
