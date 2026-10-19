class Calculator {
    public int add(int a, int b) {
        return a+b;
    }

    public double add(double a, double b) {
        return a+b;
    }

    public int add(int a, int b, int c) {
        return a+b+c;
    }

    public int max(int a, int b) {
        return (a>b) ? a:b;
    }

    public double max(double a, double b) {
        return (a>b) ? a:b;
    }
}

public class MainExercise6 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("add(int, int): " + calc.add(5,10));
        System.out.println("add(double, double): " + calc.add(2.5,3.7));
        System.out.println("add(int, int, int): " + calc.add(1,2,3));
        System.out.println("max(int, int): " + calc.max(8,12));
        System.out.println("max(double, double): " + calc.max(4.5,2.3));
    }
}