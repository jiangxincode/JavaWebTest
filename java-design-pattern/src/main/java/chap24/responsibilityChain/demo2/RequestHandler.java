package chap24.responsibilityChain.demo2;

public abstract class RequestHandler {

    private RequestHandler nextHandler;

    public void setNextHandler(RequestHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest(Request que);

    public RequestHandler getNextHandler() {
        return nextHandler;
    }
}
