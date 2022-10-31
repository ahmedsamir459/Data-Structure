import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int[][] transpose(int[][] array) {
        /*Implement your method here*/
        if(array.length==0) return array;
        int [][]temp=new int [array.length][array[0].length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                temp[i][j]=array[j][i];}}
        return temp;}
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
        double x=Math.sqrt(arr.length);
        int [][] array=new int [(int)x][(int)x];
        int count=0;
        for (int i=0;i<(int)x;i++){
            for (int j=0;j<(int)x;j++){
                array[i][j]=arr[count++];}}
        array=new Solution().transpose(array);
        System.out.print("[[");
          for(int i = 0; i < (int)x; ++i) {
              for (int j=0;j<(int)x;j++){
            System.out.print(array[i][j]);
            if((i+j) != arr.length - 2 && arr.length!=1 && j!=(int)x-1)
              System.out.print(", ");}
              if (i!=(int)x-1)
              System.out.print("], [");
        }
        System.out.print("]]");
    }
}