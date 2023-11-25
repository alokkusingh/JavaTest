package alok.test.random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Objects;

public class EvaluateExpression {

    public static ScriptEngineManager manager = new ScriptEngineManager();
    public static ScriptEngine engine = manager.getEngineByName("nashorn");
    public static void main(String[] args) {
        String expression1 = "  value < 10";
        String expression2 = " (value >= 10 && value < 20) || (value == 22) ";
        String expression3 = "  value >=20 && value != 22";
        Double value = 23.0;

        // Print the result
        System.out.println("Result: " + evalExpression(expression1, value));
        System.out.println("Result: " + evalExpression(expression2, value));
        System.out.println("Result: " + evalExpression(expression3, value));

    }

    public static boolean evalExpression(String expression, Double value) {

        try {
            synchronized (Object.class) {
                engine.put("value", value);
                return (boolean) engine.eval(expression);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return false;
    }
}
