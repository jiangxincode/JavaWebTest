package chap01.simpleFactory;

public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return numberA * numberB;
    }
}