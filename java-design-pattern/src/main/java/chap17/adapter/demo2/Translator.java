package chap17.adapter.demo2;

public class Translator extends Player {
    Center wjzf;

    public Translator(String name) {
        wjzf = new Center(name);
    }

    public void attrack() {
        wjzf.jinggong();
    }

    public void defence() {
        wjzf.fangshou();
    }
}
