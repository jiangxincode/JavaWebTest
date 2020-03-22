package chap17.adapter.demo1;

/**
 * 适配器客户端
 */
public class AdapterMain {

    public static void main(String[] args) {
        Target target;

        target = new Adapter();
        target.request();
    }
}
