import java.util.Stack;

public class ValidParenthese {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            char temp;
            switch (c) {
                case ']':
                    temp = stack.empty() ? '\0' : stack.pop();
                    if (temp != '[') {
                        return false;
                    }
                    break;
                case ')':
                    temp = stack.empty() ? '\0' : stack.pop();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                case '}':
                    temp = stack.empty() ? '\0' : stack.pop();
                    if (temp != '{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "]";

        boolean rtn = new ValidParenthese().isValid(s);
        System.out.println(rtn);
    }
}
