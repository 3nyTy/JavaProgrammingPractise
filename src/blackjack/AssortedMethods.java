package blackjack;

import java.util.Random;

public class AssortedMethods {
    public static int randomIntInRange(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
