package delegator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Client {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws IOException {
        Delegator4Map delegator4Map = new Delegator4Map(new Hashtable());
        Map m = delegator4Map.getProxy();
        m.size();
        m.clear();
        m.toString();

        Delegator4List delegator4List = new Delegator4List(new ArrayList());
        List l = delegator4List.getProxy();
        l.size();
        l.clear();
        l.toString();
    }
}
