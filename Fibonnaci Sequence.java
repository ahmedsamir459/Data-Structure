import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int fibonacci(int n) {
    	// Implement your method here.
        if (n==1)return 0;
        int f1=0,f2=1,fib;
        for(int i=2;i<n;i++){
            fib=f1+f2;
            f1=f2;
            f2=fib;
        }
        return f2;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input =new Scanner(System.in);
        int n=input.nextInt();
        n=new Solution().fibonacci(n);
        System.out.println(n);
        
    }
}