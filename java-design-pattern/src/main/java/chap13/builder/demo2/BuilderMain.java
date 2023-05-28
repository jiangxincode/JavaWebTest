package chap13.builder.demo2;

public class BuilderMain {

    public static void main(String[] args) {
        PersonBuilder thin = new ThinPersonBuilder();
        PersonBuilder fat = new FatPersonBuilder();

        PersonDirector pd = new PersonDirector(thin);
        pd.createPerson();

        pd = new PersonDirector(fat);
        pd.createPerson();

    }

}
