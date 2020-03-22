package chap08.factoryMethod.demo2;

public class UndergraduateFactory implements IFactory {

    public LeiFeng createLeiFeng() {
        return new Graduate();
    }

}
