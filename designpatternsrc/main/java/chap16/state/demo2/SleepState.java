package chap16.state.demo2;

public class SleepState extends State {

    @Override
    public void writeProgram(Work w) {
        System.out.println("the current time:" + w.getHour() + "Sleeping!");
    }

}
