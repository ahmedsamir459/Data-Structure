import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int[] moveValue(int[] array, int value) {
        /*
            Implement your method here
        */
        
       int count = 0; 
        for (int i = 0; i < array.length; i++)
            if (array[i] != value)
                array[count++] = array[i]; 
        while (count < array.length)
            array[count++] = value;
        return array;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);}
        int value =sc.nextInt();
        int[] res = new Solution().moveValue(arr,value);
         System.out.print("[");
          for(int i = 0; i < res.length; ++i) {
            System.out.print(res[i]);
            if(i != res.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}