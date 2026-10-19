import java.util.Random;

class Dice{
    private int value;
    private Random random;

    public Dice(){
        this.value = 1;
        this.random = new Random();
    }

    public int roll(){
        this.value = random.nextInt(6) + 1;
        return this.value;
    }

    public int getValue(){
        return value;
    }
}

public class MainExercise5{
    public static void main(String[] args){
        Dice dice = new Dice();
        int rolls = 100000;
        int[] counts = new int[7];

        for(int i=0; i<rolls; i++){
            int result = dice.roll();
            counts[result]++;
        }

        System.out.println("Dice Roll Results (" + rolls + "times):");
        for(int face = 1; face <= 6; face++){
            double probability = (double) counts[face] / rolls;
            System.out.printf("Face %d: %d times | Probability: %.4f\n", face, counts[face], probability);
        }
    }
}