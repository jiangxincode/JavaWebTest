package adapter;

public class AdapterMain {

	public static void main(String[] args) {

		Player guard = new Guard("Alston");
		guard.attrack();
		guard.defence();

		Player center = new Translator("YM");
		center.attrack();
		center.defence();
	}

}
