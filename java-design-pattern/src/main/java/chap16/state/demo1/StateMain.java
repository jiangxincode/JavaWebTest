package chap16.state.demo1;

/**
 * 客户端：不断请求，不断更改状态
 */
public class StateMain {
    public static void main(String[] args) {

        Context context = new Context(new ConcreteStateA());

        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}
