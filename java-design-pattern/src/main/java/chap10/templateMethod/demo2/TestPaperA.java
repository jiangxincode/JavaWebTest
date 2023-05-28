package chap10.templateMethod.demo2;

public class TestPaperA extends TestPaper {

    @Override
    public void answer1() {
        System.out.println("33");
    }

    @Override
    public void answer2() {
        System.out.println("55");
    }
}
