package blind75;

import java.util.Stack;


public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                characterStack.push(s.charAt(i));
            } else {
                if (characterStack.isEmpty() ||
                        (s.charAt(i) == ')' && characterStack.pop() != '(') ||
                        (s.charAt(i) == ']' && characterStack.pop() != '[') ||
                        (s.charAt(i) == '}' && characterStack.pop() != '{')) {
                    return false;
                }
            }
        }
        if (!characterStack.isEmpty()) {
            return false;
        }
        return true;

    }
}
