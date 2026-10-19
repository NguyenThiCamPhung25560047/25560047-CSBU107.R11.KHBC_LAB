class Fraction{
    private int numerator;
    private int denominator;
    private int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public void simplify(){
        if(numerator == 0){
            denominator = 1;
            return;
        }

        int common = gcd(numerator, denominator);
        numerator /= common;
        denominator /= common;
        if(denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator){
        if(denominator == 0){
            denominator = 1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction(Fraction other){
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    public Fraction add(Fraction other){
        int num = this.numerator * other.numerator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num,den);
    }

    public Fraction subtract(Fraction other){
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num,den);
    }

    public Fraction multiply(Fraction other){
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new Fraction(num,den);
    }

    public Fraction divide(Fraction other){
        if (other.numerator == 0){
            return new Fraction(this);
        }
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new Fraction(num,den);
    }

    public void display(){
        System.out.println(numerator + "/" + denominator);
    }
}

public class MainExercise2 {
    public static void main(String[] args){
        Fraction f1 = new Fraction(2,4);
        Fraction f2 = new Fraction(3,5);
        System.out.print("Fraction 1: ");
        f1.display();
        System.out.print("Fraction 2: ");
        f2.display();

        System.out.print("Sum: ");
        f1.add(f2).display();

        System.out.print("Difference: ");
        f1.subtract(f2).display();

        System.out.print("Product: ");
        f1.multiply(f2).display();

        System.out.print("Quotient: ");
        f1.divide(f2).display();

        Fraction f3 = new Fraction(f1);
        System.out.print("Copied Fraction: ");
        f3.display();
        System.out.println("Is distinct object: " + (f1 != f3));
    }
}