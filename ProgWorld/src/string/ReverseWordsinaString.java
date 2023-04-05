package src.string;

public class ReverseWordsinaString {
    public static String reverseWords(String s) {

        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        int n=s.length();

        //reversing whole string
        reverse(arr,0,n-1);

        //reversing the words
        reversingWords(arr,n);

        //cleaning up the empty spaces
        String res=cleanSpaces(arr,n);

        return res;
    }

    private static void reversingWords(char[] arr,int n){
        int i=0,j=0;

        while(i<n){
            //skipping spaces
            while(i<j || (i<n && arr[i]==' '))
                i++;

            //first j reaches i then increament j till we get next space
            while(j<i || (j<n && arr[j]!=' ')){
                j++;
            }

            //we got the word now reverse it
            reverse(arr,i,j-1); //j-1 because j will be on the space as our prev loop stopped when arr[j]==' '
        }
    }
    private static String cleanSpaces(char[] arr, int n){
        int i=0,j=0;
        //i will traverse our resulting array (which is in-place)
        while(j<n){
            //leading spaces
            while(j<n && arr[j]==' ')
                j++;
            while(j<n && arr[j]!=' '){
                arr[i]=arr[j];
                i++;
                j++;
            }
            //trailing spaces
            while(j<n && arr[j]==' ')
                j++;

            //now we will see if j<n that means j is still on some word which is not the last word
            //so we will add 1 space
            if(j<n){
                arr[i]=' ';
                i++;
            }
        }
        return new String(arr).substring(0,i);
    }
    private static void reverse(char[] arr,int i,int j){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s1="the sky is blue";
        String s2="  hello world  ";
        String s3="a good   example";

        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
        System.out.println(reverseWords(s3));
    }
}
