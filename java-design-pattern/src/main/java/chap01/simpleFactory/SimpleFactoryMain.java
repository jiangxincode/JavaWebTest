package chap01.simpleFactory;

public class SimpleFactoryMain {

    public static void main(String[] args) {
        Operation operAdd = OperationFactory.createOperation('+');
        Operation operSub = OperationFactory.createOperation('-');

        operAdd.setNumberA(11);
        operAdd.setNumberB(22);
        System.out.println(operAdd.getResult());

        operSub.setNumberA(11);
        operSub.setNumberB(22);
        System.out.println(operSub.getResult());
    }
}
