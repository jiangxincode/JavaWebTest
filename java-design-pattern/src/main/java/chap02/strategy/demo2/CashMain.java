package chap02.strategy.demo2;

public class CashMain {

    public static void main(String[] args) {
        double price = 100.0;
        double num = 10;
        String s = "normal";

        CashContext cc = new CashContext(s);

        System.out.print(cc.getCash(price * num));
    }

}
