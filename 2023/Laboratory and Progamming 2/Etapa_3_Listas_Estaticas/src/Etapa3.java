import java.util.Stack;

public class Etapa3 {
    public static boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> stack = new Stack<>();

        while (!s1.isEmpty()) {
            char c = s1.pop();

            if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
