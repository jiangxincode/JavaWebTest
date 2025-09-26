package chap15.abstractFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用反射改造简单工厂模式，去掉分支判断的逻辑
 * 注意本例仍然是优化后的工厂方法模式，不是抽象工厂模式
 */
public class OperationFactory {
    private static Map<String, Class<?>> allOperationMaps = new HashMap<String, Class<?>>();

    public static void fillMap() {
        allOperationMaps.put("+", OperationAdd.class);
        allOperationMaps.put("-", OperationSub.class);
        allOperationMaps.put("*", OperationMul.class);
        allOperationMaps.put("/", OperationDiv.class);
    }

    public static Operation createOperation(String operator)
            throws InstantiationException, IllegalAccessException {
        Operation operation;

        fillMap();
        Class<?> operationClass = allOperationMaps.get(operator);

        if (operationClass == null) {
            throw new RuntimeException("unsupported operation");
        }

        operation = (Operation) operationClass.newInstance();

        return operation;
    }

}
