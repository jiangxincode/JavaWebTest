package chap14.observer.demo2;

public class ObserverMain {

    public static void main(String[] args) {
        ScretarySubject scretary = new ScretarySubject();
        scretary.setSubjectState("the boss is come back,work hardly!");
        LincolnObserver lin = new LincolnObserver("Lincoln", scretary);

        scretary.attach(lin);
        scretary.notifyObservers();
    }

}
