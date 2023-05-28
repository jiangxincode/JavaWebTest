package chap23.command.demo2;

public class BakeChickenWingCommand extends Command {

    public BakeChickenWingCommand(Barbecuer bar) {
        super(bar);
    }

    @Override
    public void excuteCommand() {
        this.getBarbecuer().bakeChickenWing();
    }

}
