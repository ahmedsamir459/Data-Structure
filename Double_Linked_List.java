import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class DoubleLinkedList implements ILinkedList {
    node head; 
    node tail; 
    int size; 
    public DoubleLinkedList () { 
        head=null; 
        tail=null; 
        size=0;} 
     
	/* Implement your linked list class here*/
    public class node{ 
    Object value; 
    node next; 
    node prev;
    public node(Object value,node newnode ,node prev) { 
        this.next=newnode;
        this.prev=prev;
        this.value=value; }}
    
    public void add(Object element){ 
        node n=new node(element,null,null); 
        if (size==0) { 
            head=n; 
            tail=n;
            size++; 
        }else{ 
        n.next=null; 
        tail.next=n;
        n.prev=tail;
        tail=n; 
            size++; 
        }}
    public void add(int index, Object element) { 
        node n =new node(element,null,null); 
        node n1; 
        node n2; 
        n1=head; 
        boolean flg=false;
        if(index<0||index>size){ System.out.println("Error");flg=true;} 
        else if(index==0){
            head.prev=n;
            n.next = head;
            head = n;
            if (size == 0) {head= tail = n;}
            size++;}
        else if(index==size){
            if (size == 0) {head = tail = n;}
            else {
                n.prev=tail;
                tail.next = n;
                tail = n;}
                size++;}
        else{
        for(int i=0;i<index-1;i++) { n1=n1.next; }
            n.prev=n1;
            n.next=n1.next; 
            n1.next=n; 
            size++;}
        if(!flg){
            node s=head;        
            System.out.print("["); 
            while(s!=null) { 
                System.out.print(s.value); 
                if(s.next!=null) { System.out.print(", "); } 
            s=s.next; } 
            System.out.print("]"); }}
    
    public Object get(int index) { 
        node n=head; 
         if(index<0||index>size-1){System.out.println("Error");}
        else{ 
        for(int i=0;i<index;i++) {n=n.next;} 
            System.out.println(n.value);}  
    return  n.value;}
    
    public void set(int index, Object element) { 
        node n=new node(element,null,null); 
        if(index<0||index>size-1){ 
            System.out.println("Error"); 
            return;} 
        if(index==0){ 
            n.next=head.next; 
            head=n;}
        else if(index==1){ 
            node n1;
            n1=head.next;
            n.prev=head;
            n.next=n1.next; 
            head.next=n;}
        else{ 
            node n1; 
            node n2; 
            n1=head; 
            for(int i=0;i<index-1;i++) {n1=n1.next;} 
            
            n2=n1.next; 
            n1.next=n; 
            
            if (n2.next==null){n.prev=n1;n.next=null;} 
            else{
                n.prev=n1;
                n.next=n2.next;}
        } 
        node s=head;        
        System.out.print("["); 
        while(s!=null) { 
        System.out.print(s.value); 
        if(s.next!=null) {System.out.print(", ");} 
        s=s.next;} 
        System.out.print("]"); }
    
    public void clear(){ 
        head=null; 
        tail=null; 
        size=0; 
    } 
    public boolean isEmpty(){ 
        if(head==null) 
        System.out.println("True"); 
        else 
        System.out.println("False"); 
             
            return (head==null);}
    
    public void remove(int index) { 
        if(index<0||index>size-1||size==0){
            System.out.println("Error");
            return;}
        else if(index==0){
            head=head.next;
            head.prev=null;
        }
        else{    
        node n1; 
        node n2; 
        n1=head; 
        for(int i=0;i<index-1;i++) {n1=n1.next;} 
        
        n2=n1.next;
        n1.next=n2.next;
        n2.prev=n1;
            size--;}
        
    node s=head;        
    System.out.print("["); 
    while(s!=null) { 
    System.out.print(s.value); 
    if(s.next!=null) {System.out.print(", ");} 
    s=s.next;} 
    System.out.print("]");} 
    
    public int size() { 
        return size; 
    } 
    public ILinkedList sublist(int fromIndex, int toIndex) { 
        node n; 
        n=head; 
        DoubleLinkedList ls= new DoubleLinkedList(); 
        if(fromIndex<0||toIndex<0||fromIndex>size-1||toIndex>size-1|| fromIndex>toIndex){ 
            System.out.println("Error"); }
        else{ 
        for(int i=0;i<fromIndex;i++) {n=n.next;} 
        for(int j=0;j<toIndex-fromIndex;j++){ 
            ls.add(n.value); 
            n=n.next;} 
        ls.add(n.value);
            
        node s=ls.head;        
        System.out.print("["); 
        while(s!=null) { 
        System.out.print(s.value); 
        if(s.next!=null) {System.out.print(", ");} 
        s=s.next;} 
        System.out.print("]");} 
        return ls; }
    
    public boolean contains(Object o) { 
        node n; 
        n=head; 
        if(n==null){
              System.out.println("Error");
                return false;}
        else{
        while(n!=null) { 
            if((int)n.value==(int)o) { 
             System.out.println("True"); 
                return true; 
            }
            else { n=n.next; }}
            
        System.out.println("False"); 
        return false;
        }}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in); 
        String sin = sc.nextLine().replaceAll("\\[|\\]", ""); 
        String[] s = sin.split(", ");; 
        int[] arr = new int[s.length]; 
        if (s.length == 1 && s[0].isEmpty()) 
            arr = new int[]{}; 
        else { 
            for(int i = 0; i < s.length; ++i) 
             arr[i] = Integer.parseInt(s[i]);} 
    DoubleLinkedList obj= new DoubleLinkedList(); 
       for(int i=0;i<arr.length;i++) { 
           obj.add(arr[i]);} 
        String word=sc.nextLine(); 
        int n; 
        int h; 
        switch(word) { 
        case "add": n=sc.nextInt();obj.add(n);node l=obj.head;        
                    System.out.print("["); 
                    while(l!=null) { 
                    System.out.print(l.value); 
                    if(l.next!=null) {System.out.print(", ");} 
                    l=l.next;} 
                    System.out.print("]"); break; 
        case "addToIndex": n=sc.nextInt();h=sc.nextInt();obj.add(n,h);break;  
        case "get": n=sc.nextInt();obj.get(n);break; 
        case "set": n=sc.nextInt();h=sc.nextInt() ;obj.set(n,h);break; 
        case "clear": obj.clear();System.out.println("[]");break; 
        case "isEmpty":obj.isEmpty();break; 
        case "remove": n=sc.nextInt();obj.remove(n);break; 
        case "size":System.out.println(obj.size());break; 
        case "sublist": n=sc.nextInt();h=sc.nextInt();obj.sublist(n, h);break; 
        case "contains": n=sc.nextInt();obj.contains(n);break;  
         
        }
        
    }
}