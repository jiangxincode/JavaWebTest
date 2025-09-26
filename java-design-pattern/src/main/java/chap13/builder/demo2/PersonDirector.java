package chap13.builder.demo2;

public class PersonDirector {

    private PersonBuilder pb;

    public PersonDirector(PersonBuilder pb) {
        this.pb = pb;
    }

    public void createPerson() {
        pb.createHead();
        pb.createBody();
        pb.createArm();
        pb.createLeg();
    }
}
