package microsoft;

public class OTS1 {
public static void main(String[] args) throws Exception {
    int target[] = new int[] {2,7,8,0,0,0};
    int arr[] = new int[] {1, 4,6};
    int op[] = mergeTwoArrays(target, arr, 3);
    for(int i : op) {
        System.out.println(i);
    }
}

private static int[] mergeTwoArrays(int[] target, int[] arr, int validValues) throws Exception {
    if (validValues + arr.length > target.length) throw new Exception();
    
    int i = validValues - 1;
    int j = arr.length- 1;
    int mergePtr = target.length - 1;
    
    while(i >=0 && j >=0) {
        if(target[i] > arr[j]) {
            target[mergePtr] = target[i];
            i--;
        } else {
            target[mergePtr] = arr[j];
            j--;
        }
        mergePtr--;
        
    }
    
   while(j >= 0) {
        target[mergePtr] = arr[j];
        j--;
        mergePtr--;
    }
            
    return target;
}
}
