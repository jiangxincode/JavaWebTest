package chap07.proxy.demo2;

public class ProxyMain {

    public static void main(String[] args) {
        SchoolGirl mm = new SchoolGirl("jin ");
        Proxy agent = new Proxy(mm);

        agent.giveChocolate();
        agent.giveFlowers();
    }

}
