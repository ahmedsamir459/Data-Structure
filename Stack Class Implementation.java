import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface ILinkedList {
/*
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/*
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/*
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/*
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/*
* Removes all of the elements from this list.
*/
public void clear();
/*
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/*
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/*
* @return the number of elements in this list.
*/
public int size();
/*
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/*
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack implements IStack {
    
    public class SingleLinkedList implements ILinkedList { 
    public class node{ 
    Object value; 
    node next; 
    public node(Object value,node newnode ) { 
        this.next=newnode; 
        this.value=value; }} 
 
    node head; 
    node tail; 
    int size; 
    public SingleLinkedList () { 
        head=null; 
        tail=null; 
        size=0;} 
     
public void add(int index, Object element) { 
        node n =new node(element,null); 
        node n1; 
        node n2; 
        n1=head; 
          boolean flg=false;
        if(index<0||index>size){ System.out.println("Error");flg=true; } 
        else if(index==0){
            n.next = head;
            head = n;
            if (size == 0) {tail = n;}
            size++;
        }
        else if(index==size){
      if (size == 0) {
        head = tail = n;
      } else {
        tail.next = n;
        tail = n;
      }

      size++;
        }
        else{
        for(int i=0;i<index-1;i++) { n1=n1.next; } 
            n.next=n1.next; 
            n1.next=n; 
            size++;
        }} 
    public void add(Object element) { 
        node n=new node(element,null); 
        if (size==0) { 
            head=n; 
            tail=n;
            tail.next=null;
            size++; 
        }else{ 
        n.next=null; 
        tail.next=n; 
        tail=n; 
            size++; 
        } 
        
    } 
    public Object get(int index) { 
        node n;
        n=head; 
         if(index<0||index>size-1){ 
             return null;
        }
        else{ 
        for(int i=0;i<index;i++) { 
            n=n.next; 
             
        } 
         }  
    return  n.value; 
          
    } 
    public void set(int index, Object element) { 
        if(index<0||index>size-1){ 
            System.out.println("Error"); 
            return; 
        } 
         
        node n=new node(element,null); 
       
        if(index==0){ 
            n.next=head.next; 
            head=n; 
             
        }else if(index==1){ 
        node n1; 
        node n2; 
        n1=head; 
        n2=n1.next; 
        n.next=n2.next; 
        head.next=n;     
        }else{ 
        node n1; 
        node n2; 
        n1=head; 
        for(int i=0;i<index-1;i++) { 
            n1=n1.next; 
             
        } 
        n2=n1.next; 
        n1.next=n; 
        if (n2.next==null) { 
            n.next=null; 
        } 
        else { 
        n.next=n2.next; 
            } 
        } 
       
        } 
     
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
             
            return (head==null); 
} 
    public void remove(int index) { 
        if(index<0||index>size-1||size==0){
            System.out.println("Error");
            return;
        }else if(index==0){
                head=head.next;
            
            
        }
        
        else{ 
            
        node n1; 
        node n2; 
        n1=head; 
        for(int i=0;i<index-1;i++) { 
            n1=n1.next; 
        } 
        n2=n1.next; 
        n1.next=n2.next;
            size--;
        }
           
        
    } 
    public int size() { 
        return size; 
    } 
    public ILinkedList sublist(int fromIndex, int toIndex) { 
        node n; 
        n=head; 
        SingleLinkedList ls= new SingleLinkedList(); 
        if(fromIndex<0||toIndex<0||fromIndex>size-1||toIndex>size-1|| fromIndex>toIndex){ 
            System.out.println("Error"); 
        }else{ 
        for(int i=0;i<fromIndex;i++) { 
            n=n.next; 
        } 
        for(int j=0;j<toIndex-fromIndex;j++) { 
             
            ls.add(n.value); 
            n=n.next; 
        } 
        ls.add(n.value); 
        } 
        return ls; 
    } 
     
    public boolean contains(Object o) { 
        node n; 
        n=head; 
        if(n==null){
            return false;
        }else{
        while(n!=null) { 
            if((int)n.value==(int)o) {
                return true; 
            }else { 
                n=n.next; 
            }}
        return false; 
    } }
    }
    SingleLinkedList obj= new SingleLinkedList(); 
    public Object pop(){
        Object popped=null;
        if (obj.head!=null){
            popped = obj.head.value;
            obj.head= obj.head.next;
           obj.size--;
        }
        return popped;    
        
    }
    public Object peek(){
          if (obj.head == null) {
              return null;
          }
        else {
            return obj.head.value;
        }
    }
    public void push(Object element){
        obj.add(0,element);
    }
    public boolean isEmpty(){
        if(obj.size()==0)return true;
        else return false;
    }
    public int size(){
        return obj.size();
    }

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
             arr[i] = Integer.parseInt(s[i]); 
        }
        MyStack stack=new MyStack();
        
       for(int i=0;i<arr.length;i++) { 
           stack.push(arr[arr.length-i-1]);
       } 
      
      String word=sc.nextLine(); 
      switch(word){
          case "pop":
              if(stack.pop()==null){
                  System.out.println("Error");
              }
              else{
              System.out.print("["); 
              while(stack.peek()!=null) { 
                 System.out.print(stack.pop()); 
                 if(stack.peek()!=null) { 
                 System.out.print(", ");}}
              System.out.print("]");}
              break;
        case "peek":
            if(stack.peek()==null){System.out.println("Error");}
            else{System.out.println(stack.peek());}
            break;
        case "push":
            int value =sc.nextInt();
            stack.push(value);
            System.out.print("["); 
              while(stack.peek()!=null) { 
                 System.out.print(stack.pop()); 
                 if(stack.peek()!=null) { 
                 System.out.print(", ");}}
              System.out.print("]");
              break;
        case "isEmpty":
              if (stack.isEmpty())
                  System.out.println("True");
              else 
                  System.out.println("False");
            break;
        case "size":
            System.out.println(stack.size());
            break;}    
    }
}
    
    
    