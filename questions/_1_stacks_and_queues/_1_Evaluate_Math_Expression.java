package questions._1_stacks_and_queues;

import ds._1_StackUsingLinkedList;

/*
* Dijkstra’s two stack algorithm to evaluate an expression.
* Find output of ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) using two stacks.
* 1. Keep adding Values to one stack and Operators to another stack. While doing so:
* 2. Ignore all left brackets
* 3. When you encounter a right bracket, pop two values and one operator and evaluate and put the result back to the value stack.
*/
public class _1_Evaluate_Math_Expression {

    // Helper method to evaluate operation on two values
    private static Double evaluate (Double value1, Double value2, Character operator) {
        Double result;
        switch(operator) {
            case '+':
                result = value2 + value1;
                break;
            case '-':
                result = value2 - value1;
                break;
            case '*':
                result = value2 * value1;
                break;
            case '/':
                result = value2 / value1;
                break;
            default:
                result = value2 + value1;
                break;
        }
        return result;
    };

    public static void main (String[] args) {
        // Output should be 101
        String mathExpression = "(1+((2+3)*(4*5)))";

        _1_StackUsingLinkedList<Double> valueStack = new _1_StackUsingLinkedList<Double>();
        _1_StackUsingLinkedList<Character> operatorStack = new _1_StackUsingLinkedList<Character>();

        String tempValue = "";
        for (char c : mathExpression.toCharArray()) {

            // Ignore left bracket
            if (c == '(') continue;

            // If its a digit, keep accumulating subsequent digits (if any)
            if (Character.isDigit(c)) {
                tempValue += c;
                continue;
            }

            // Finalize tempValue to create a value if tempValue isnt empty
            if (tempValue != "") {
                valueStack.push(Double.parseDouble(tempValue));
                tempValue = "";
            }

            // Check if current char is right bracket
            if (c == ')') {
                // Pop two values and one operator and evaluate
                Double value1 = valueStack.pop();
                Double value2 = valueStack.pop();
                Character operator = operatorStack.pop();

                // Add result back to value stack
                valueStack.push(evaluate(value1, value2, operator));
                continue;
            }

            // Finally, its an operator if flow reaches here
            operatorStack.push(c);
        }

        System.out.println(valueStack.pop());
    }

}