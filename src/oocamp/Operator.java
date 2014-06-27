package oocamp;

public enum Operator implements Token {
    plus, minus, multiply, div;

    public static Operator from(char c) {
        switch (c) {
            case '+':
                return plus;
            case '-':
                return minus;
            case '*':
                return multiply;
            case '/':
                return div;
            default:
                return null;
        }
    }
}
