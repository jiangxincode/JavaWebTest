package chap16.state.demo2;

public class RestState extends State {

    @Override
    public void writeProgram(Work w) {
        System.out.println("the current time:" + w.getHour() + " work finished,rest");
    }

}
