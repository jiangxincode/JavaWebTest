package chap23.command.demo2;

public class BakeMuttonCommand extends Command {

    public BakeMuttonCommand(Barbecuer bar) {
        super(bar);
    }

    @Override
    public void excuteCommand() {
        this.getBarbecuer().bakeMutton();
    }

}
