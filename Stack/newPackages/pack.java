package newPackages;

import java.util.Stack;

public class pack {
    // ==================== reversing the infix String=========================
    public String revInfix(String sequence) {
        StringBuilder strR = new StringBuilder(sequence).reverse();

        for (int i = 0; i < strR.length(); i++) {
            char c = strR.charAt(i);
            if (c == '(') {
                strR.setCharAt(i, ')');
            } else if (c == ')') {
                strR.setCharAt(i, '(');
            }
        }
        return strR.toString();
    }

    // ==================== reversing the String=========================
    public String revString(String sequence) {
        StringBuilder str = new StringBuilder(sequence).reverse();
        return str.toString();
    }

    public void display(String str) {
        System.out.printf("\n%s", str);
    }

    // ==================Postfix to infix code is here:==================
    public boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public String postfixtoin(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (!isOper(c)) {
                stack.push(c + "");
            } else {
                String ope2 = stack.pop();
                String ope1 = stack.pop();
                String post = "(" + ope1 + c + ope2 + ")";
                stack.push(post);
            }
        }
        return stack.pop();
    }

    // ==================infix to postfix code is here:==================

    public String infixtopost(String str) {
        // String str_new;
        StringBuilder postfix = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(' && check(st.peek(), c)) {
                    postfix.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && st.peek() != '(' && check(st.peek(), c)) {
                    postfix.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }
        return postfix.toString();
    }

    public boolean check(char c, char Symbol) {
        return precedence(c) >= precedence(Symbol);
    }

    public int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // ==================infix to prefix code is here:==================

}