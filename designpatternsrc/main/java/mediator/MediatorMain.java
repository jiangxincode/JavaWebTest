package mediator;

public class MediatorMain {

	public static void main(String[] args) {
		UnionNationsSecurityCouncil unsc = new UnionNationsSecurityCouncil();
		USA usa = new USA(unsc);
		Iraq iraq = new Iraq(unsc);

		unsc.setIraq(iraq);
		unsc.setUsa(usa);

		usa.declare("stop the unclear weapon's development!");
		iraq.declare("I have no nuclear wapons!");
	}

}
