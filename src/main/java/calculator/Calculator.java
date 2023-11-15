package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("Input String can't be null");
        }

        int result = 0;

        List<String> splittedInput = toIntArray(input);
        for (int i = 1; i < splittedInput.size(); i = i+2) {
            result = compute(result, splittedInput, i);
        }
        return result;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int compute(int result, List<String> splittedInput, int i) {
        if (i == 1) {
            result = runOperator(Integer.parseInt(splittedInput.get(i -1)), splittedInput.get(i), Integer.parseInt(splittedInput.get(i +1)));
        }
        if (i > 1) {
            result = runOperator(result, splittedInput.get(i), Integer.parseInt(splittedInput.get(i +1)));
        }
        return result;
    }

    private static int runOperator(int leftValue, String operator, int rightValue) {
        if (!operator.matches("^[-+*\\/]*$")) {
            throw new IllegalArgumentException("You can't use other operator");
        }

        int result = Arrays.stream(Operator.values())
                .filter(oper -> oper.operator().equals(operator))
                .findFirst()
                .get()
                .calculate(leftValue, rightValue);

        return result;
    }

    public static List<String> toIntArray(String input) {
        String[] splittedString = input.split(" ");
        return List.of(splittedString);
    }

    public static int addNum(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    public static int subtractNum(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }

    public static int multiplyNum(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }

    public static int divideNum(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }
}
