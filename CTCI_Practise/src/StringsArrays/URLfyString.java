package StringsArrays;

public class URLfyString {
    public static void main(String[] args) {
        String str = new String("Mr John Smith    ");
        System.out.println(urlifyString(str, 13));
    }

    private static String urlifyString(String str, int trueLength) {
        char[] arr = str.toCharArray();
        int spaceCount = 0;
        for (int i = 0 ;i < trueLength; i++) {
            if(arr[i] == ' ') spaceCount++;
        }
        if(trueLength < str.length()) arr[trueLength] = '\0';
        
        int index = trueLength + spaceCount * 2;
        System.out.println(index);
        
        for(int  i = trueLength - 1; i >= 0; i--) {
            if(arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index = index - 3;
                
            } else {
                arr[index - 1] = arr[i];
                index--;
            }
            
        }
        
        
        return new String(arr);
        
    }

}
