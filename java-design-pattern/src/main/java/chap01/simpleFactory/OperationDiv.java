package chap01.simpleFactory;

public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (numberB == 0) {
            throw new RuntimeException("divided by 0");
        }
        return numberA / numberB;
    }
}