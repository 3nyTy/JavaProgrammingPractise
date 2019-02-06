package amazomn;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        if (s == null)
            return null;

        char[] arr = s.toCharArray();
        int n = arr.length;

        reverse(arr, 0, n - 1);
        
        int start = 0;
        int end = arr.length-1;
        
        for (int i = 0; i < n;i++) {
            if(arr[i] == ' ') {
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
       return reverse(arr, start, end).toString();

    }

    /*private String cleanSpaces(char[] arr, int n) {
        // TODO Auto-generated method stub
        return null;
    }

    private void reverseWords(char[] arr, int n) {
        int i = 0;
        int j = 0;

        while (i < n) {
            while (i < j || i < n && arr[i] == ' ')
                i++; // skip spaces
            while (j > i || j < n && arr[j] != ' ')
                j++; // skip non-spaces
            reverse(arr, i, j - 1);
        }
    }*/

    private char[] reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

}
