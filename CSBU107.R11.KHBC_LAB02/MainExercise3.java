class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = (hour >= 0 && hour < 24) ? hour : 0;
        this.minute = (minute >= 0 && minute < 60) ? minute : 0;
        this.second = (second >= 0 && second < 60) ? second : 0;
    }

    public void addSeconds(int seconds) {
        int totalSeconds = this.hour * 3600 + this.minute * 60 + this.second + seconds;
        totalSeconds = (totalSeconds % 86400 + 86400) % 86400;

        this.hour = totalSeconds / 3600;
        this.minute = (totalSeconds % 3600) / 60;
        this.second = totalSeconds % 60;
    }

    public void subtractSeconds(int seconds) {
        addSeconds(-seconds);
    }

    public void display() {
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
    }
}

public class MainExercise3 {
    public static void main(String[] args) {
        Time t1 = new Time(23, 59, 50);
        System.out.print("Initial time 1: ");
        t1.display();
        t1.addSeconds(20);
        System.out.print("After adding 20s: ");
        t1.display();

        System.out.println();

        Time t2 = new Time(0, 0, 10);
        System.out.print("Initial time 2: ");
        t2.display();
        t2.subtractSeconds(20);
        System.out.print("After subtracting 20s: ");
        t2.display();
    }
}