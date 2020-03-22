package chap08.factoryMethod.demo2;

public class VolunteerFactory implements IFactory {

    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }

}
