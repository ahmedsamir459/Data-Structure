import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] sumEvenOdd(int[] array) {
    	/*Implement your method here */
        int sumE=0,sumO=0;
        for (int i=0;i<array.length;i++){
            if (array[i]%2==0) sumE+=array[i];
            else sumO+=array[i];}
        int []arr={sumE,sumO};
        return arr;}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);}
        int[] res = new Solution().sumEvenOdd(arr);
         System.out.print("[");
          for(int i = 0; i < res.length; ++i) {
            System.out.print(res[i]);
            if(i != res.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
    }
}