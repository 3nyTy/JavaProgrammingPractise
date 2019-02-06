package amazomn;

public class FindMissingNumInArrays {
public static void main(String[] args) {
    int[] arr1 = new int[] {1, 2, 3, 5, 6,7};
    int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7};
    System.out.println("Missinggggg");
    System.out.println(findMissingNum(arr1, arr2));
}

//XOR is fast as it does bitwise operationand is better than
//formula approach n * (n + 1)/2
/**
 * XOR other example is finding even occurences of element in an array. Ideally we can use Map and find it but by using XOR:
 * For example, let’s say we’re given the following array: [2, 1, 3, 1]. First we get all the unique elements [1, 2, 3]. 
 * Then we construct a new array from the original array and the unique elements by appending them 
 * together [2, 1, 3, 1, 1, 2, 3]. We XOR all the elements in this new array. 
 * The result is 2^1^3^1^1^2^3 = 1. Because the numbers 2 and 3 occur in the new array even number of times (2 times), 
 * so they’ll be XORed with themselves odd times (1 time), which results in 0. 
 * The number 1 occurs odd number of times (3 times), so it’ll be XORed with itself even times (2 times), and the 
 * result is the number 1 itself. Which is the even occurring element in the original array
 * 
 * 0 ^ 0 = 0
 * 1 ^ 0 = 1
 * 0 ^ 1 = 1
 * 1 ^ 1 = 0
 * 
 * **********************************************************
 * Find Next Higher Number With Same Digits
 * 
 * the given number is 12543 and the resulting next higher number should be 13245. We scan the digits of the given number 
 * starting from the tenths digit (which is 4 in our case) going towards left. At each iteration we check the right digit 
 * of the current digit we’re at, and if the value of right is greater than current we stop, otherwise we continue to left. 
 * So we start with current digit 4, right digit is 3, and 4>=3 so we continue. Now current digit is 5, right digit is 4, 
 * and 5>= 4, continue. Now current is 2, right is 5, but it’s not 2>=5, so we stop. The digit 2 is our pivot digit. 
 * From the digits to the right of 2, we find the smallest digit higher than 2, which is 3. This part is important, 
 * we should find the smallest higher digit for the resulting number to be precisely the next higher than original number. 
 * We swap this digit and the pivot digit, so the number becomes 13542. Pivot digit is now 3. We sort all the digits to 
 * the right of the pivot digit in increasing order, resulting in 13245.
 * **************************************************************
 * Find Next Palindrome Number
 * 
 * Let’s say the given number is 250, we first take the mirror image around its center, resulting in 252. 252 is greater 
 * than 250 so this is the first palindrome greater than the given number, we’re done. Now let’s say the number is 123, 
 * now mirroring the number results in 121, which is less than the original number. So we increment it’s middle digit, 
 * resulting in 131. This is again the first smallest palindrome larger than the number. But what if the middle digit 
 * is 9 and mirroring the number results in a smaller value? Then simply incrementing the middle digit would not work.
 *  The solution is we first round up the number and then apply the procedure to it. For example if the number is 397, 
 *  mirroring results in 393 which is less. So we round it up to 400 and solve the problem as if we got 400 in the first 
 *  place. We take the mirror image, which is 404 and this is the result.
 *  
 *  Now let’s analyze the case where the given number has even number of digits. Let’s say the given number is ABCD,
 *   similar to the odd case the smallest possible palindrome we can obtain from this number is ABBA (and yes their 
 *   songs are awesome :). Again we did the mirror image around its center from left to right. But since the number 
 *   has even number of digits the center now lies between 2nd (C, tenth digit) and 3rd (B, hundredth) digits (counting 
 *   from right starting at 1). So let’s define the center digit as the middle two digits, 2nd and 3rd in our case. The 
 *   strategy to find the next palindrome is same. First we mirror the number and check whether it’s greater than the given 
 *   one. If it is then we return that number, if not we increment the middle two digits by 1, which means adding 110 in 
 *   this case. 
 * 
 * 
 * ***/
private static int findMissingNum(int[] arr1, int[] arr2) {
    //int result = 0;
    int sum2 =arr2[0];
    int length1 = arr1.length; int length2 = arr2.length;   
    int sum1 = arr1[0];
    for (int i = 1; i < length1 ; i++) {
        sum1 = sum1 ^  arr1[i] ;
    }
    for (int i = 1 ; i< length2; i++) {
        sum2 = sum2 ^ arr2[i];
    }
    return sum1 ^ sum2;
}
}
