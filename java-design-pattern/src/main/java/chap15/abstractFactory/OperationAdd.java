package chap15.abstractFactory;

import chap08.factoryMethod.demo1.Operation;

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return numberA + numberB;
    }
}
