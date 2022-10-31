import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public double average(int[] array) {
        double sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
        }
        if (sum ==0) return 0;
        return sum/array.length;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String sin = input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        double x= new Solution().average(arr);
        System.out.println(x);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}