package chap19.composite.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义有枝节点行为，用来存储子部件
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        // 显示其枝节点名称，并对其下级进行遍历
        System.out.println(StringUtil.repeatableString("-", depth) + this.name);

        for (Component component : children) {
            component.display(depth + 2);
        }

    }

}
