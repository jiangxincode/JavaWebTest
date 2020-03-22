package chap28.visitor.demo2;

public class Fail extends Action {

    @Override
    public void getManReflection(Man m) {
        System.out.println("When a man failed , they will be driken ");
    }

    @Override
    public void getWomanReaction(Woman w) {
        System.out.println("When a woman failed , they will crying! ");
    }

}
