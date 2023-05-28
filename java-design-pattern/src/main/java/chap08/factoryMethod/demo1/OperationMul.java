package chap08.factoryMethod.demo1;

public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return numberA * numberB;
    }
}