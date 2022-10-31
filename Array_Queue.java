import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
interface IArrayBased { }
interface IQueue {
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returnsit.*/
  public Object dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
}

public class ArrayQueue implements IQueue,IArrayBased {
    public static int vol;
    public static int first,last;
    public static int size;
    public static int queue[];
    ArrayQueue(int s){
        first = 0;
        last = -1;
        size=0;
        vol=s;
        queue=new int [vol];}
public void enqueue(Object item){
    if (size==vol){
        System.out.println("Error");
        return;
    }
    if (last==vol-1){
        last =-1;
    }
    queue[++last]=(int)item;
    size++;
    }
public Object dequeue(){
    if (isEmpty()){
        System.out.println("Error");
        return -100000;}
     int temp = queue[first++];
        if(first == vol){
        first = 0;}
        size--;
        return temp;
}
public boolean isEmpty(){
    return(size==0);
}
public int size(){
    return size;
}
public void display(){
      
    System.out.print("[");
        int i=size-1;
        while(i>=0)
        { if(i>0){
            System.out.print(queue[i]+", ");}
         else{System.out.print(queue[i]);}
        
        i--;}
    System.out.print("]");
}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int x,p=0;
        Object q=-100000;
        ArrayQueue queue=new ArrayQueue(500);
        Scanner sc=new Scanner(System.in);
        String sin=sc.nextLine();
        if(sin.equals("[]")){p=1;}
        else{
            String [] s=sin.replaceAll(" ","").replaceAll("\\[","").replaceAll("]","").split(",");
            x=s.length;
            int array[]= new int[s.length]; 
            for(int i=array.length-1;i>=0;i--)
            {
               queue.enqueue(Integer.parseInt(s[i]));
            }
        }
        String key=sc.nextLine();

        if(key.equals("enqueue")){
            Object m;
            m=sc.nextInt();
            queue.enqueue(m);
            queue.display();
        }
        else if(key.equals("dequeue")){
           Object u;
            if(p==0){
            u=queue.dequeue();
            if(u==q){
                System.out.print("Error");
            }
            else{
                int [] arr=new int [queue.size()];
                for (int i =arr.length-1;i>=0;i--){
                    arr[i]=(int)queue.dequeue();}
                System.out.print("[");
                int i =0;
                 while(i<arr.length)
                { if(i<arr.length-1){
                System.out.print(arr[i]+", ");}
                else{System.out.print(arr[i]);}
                 i++;}
                System.out.print("]");
                }
            }
            else{System.out.print("Error");}
        }   
        else if(key.equals("isEmpty")){
            try{
            boolean c=queue.isEmpty();
            if(c==false){
            System.out.print("False");}
            else{System.out.print("True");}
        }
        catch(Exception e){System.out.print("True");}}
        else if(key.equals("size")){
           int r=queue.size();
           System.out.print(r);}
    }
}