package StringsArrays;

/**
 * Approach is count the characters, for palindrome it should be wither all characters even or 2 single odd.
 * Use hash map and keep a count variable, check count <= 1
 * Improvise using bit vector
 */
public class PermutaionPalindrom {
    public static void main(String[] args) {
        String test = "tact coa";
        System.out.println(isPermuationOfPalindrome(test));
    }

    private static boolean isPermuationOfPalindrome(String test) {
        int bitVector = createBitVector(test);

        return checkAtmostOneBit(bitVector);
    }

    private static boolean checkAtmostOneBit(int bitVector) {
        // TODO Auto-generated method stub
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int createBitVector(String test) {
        int bitVector = 0;
        for (char c : test.toCharArray()) {
            int num = c - 'a';
            bitVector = toggleBitVector(bitVector, num);
        }
        return 0;
    }

    private static int toggleBitVector(int bitVector, int index) {
        System.out.println("Entering: " + bitVector);
        if (index < 0)
            return bitVector;
        int mask = 1 << index;
        System.out.println("Mask is: " + mask);
        
        if ((bitVector & mask) == 0) {
            bitVector = bitVector | mask;
        } else {
            bitVector = bitVector & ~mask;
        }
        System.out.println("Exiting: " + bitVector);
        return bitVector;
    }
}
