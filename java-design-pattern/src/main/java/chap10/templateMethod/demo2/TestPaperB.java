package chap10.templateMethod.demo2;

public class TestPaperB extends TestPaper {
    @Override
    public void answer1() {
        System.out.println("22");
    }

    @Override
    public void answer2() {
        System.out.println("66");
    }
}