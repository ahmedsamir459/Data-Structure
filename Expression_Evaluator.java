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

interface IExpressionEvaluator {
  
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression infix expression
* @return postfix expression
*/
  
public String infixToPostfix(String expression);
  
  
/**
* Evaluate a postfix numeric expression, with a single space separator
* @param expression postfix expression
* @return the expression evaluated value
*/
  
public int evaluate(String expression);

}

public class Evaluator implements IExpressionEvaluator {
    
    public static String []var=new String [3];
    
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
    }
    
    public  boolean areBracketsBalanced(String expr){
        
        MyStack stack=new MyStack();
  
        
        int i=0;
        while (i<expr.length())
        {
            
            char x = expr.charAt(i);
            if ((x != '(' && x != '[' && x != '{')&&(x != ')' && x != ']' && x != '}')) 
            {
                
                i++;
                continue;
            } 
  
            if (x == '(' || x == '[' || x == '{') 
            {
                
                stack.push(x);
                i++;
                continue;
            }
  
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = (char)stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
  
            case '}':
                check = (char)stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
  
            case ']':
                check = (char)stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
            i++;
        }
        return (stack.isEmpty());
    }
    
    static int Prec(char ch){
        switch (ch)
        {
        case '+':
        case '-':
            return 1;
    
        case '*':
        case '/':
            return 2;
    
        case '^':
            return 3;
        }
        return -1;
    }
    
    static boolean isOperator(char ch){
      if(ch == '+' || ch == '-' || ch == '*' || ch == '/'||ch=='^')
      return true;
      
      return false;
  }
    
    public String infixToPostfix(String expression){
        String result = new String("");
        int counter=0;      
        int j=0;
        if (expression.charAt(0)=='*'||expression.charAt(0)=='/'||expression.charAt(0)=='^'){
                        return "Error";}
        while(j<expression.length()){
            
            if(j==expression.length()) return "Error";
            char v = expression.charAt(j);
            if(isOperator(v)){break;};
            j++;
        }
        MyStack stack = new MyStack();
        
        int i=0;
        while (i< expression.length())
        {
            boolean flag=true;
            boolean found=true;
            char c = expression.charAt(i);
        
            if (Character.isLetterOrDigit(c))
                result += c;
    
            else if (c == '(')
                stack.push(c);

            else if (c == ')')
            {   
                if (isOperator(expression.charAt(i-1)))return "Error";
                
                while (!stack.isEmpty() && (char)stack.peek() != '(')
                    {result += (char)stack.pop();}
                
                    stack.pop();
            }
            
            else 
            {
              
                
                  if (i==0&&c=='+'){
                      flag=false;
                  }                     
                  if (c=='-'&&expression.charAt(i+1)=='-'){
                        if (i==0){
                            flag=false;
                            i++;}
                        
                        else if (expression.charAt(i-1)=='-'||expression.charAt(i-1)=='+'){
                            flag=false;
                            if(i!=0){
                                stack.push('+');
                                i++;}
                            else i++;}
                        else if (expression.charAt(i-1)=='/'||expression.charAt(i-1)=='*'||expression.charAt(i-1)=='^'){
                            flag=false;
                            i++;}
                        else{
                            flag=false;
                            if(i!=0){
                                found=false;
                                i++;}
                            else i++;
                        }
                  }
                if(c=='+'){
                    if(expression.charAt(i+1)=='-'){
                        flag=false;
                        stack.push('-');
                        i++;
                    }
                    if(expression.charAt(i+1)=='+'){
                        flag=false;
                        if(i!=0){
                            found=false;
                                
                                i++;}
                            else i++;
                        
                    }
                }
                if(c=='-'){
                    if(expression.charAt(i+1)=='+'){
                        flag=false;
                        stack.push('-');
                        i++;
                    }
                    
                }
                
                
                
                if (isOperator(c)&&(expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/'||expression.charAt(i+1)=='^')){
                      return "Error";
                  }
               
                
                
                
              
                  
                while (!stack.isEmpty() && Prec(c)<= Prec((char)stack.peek())&&(flag==found)){
                    
                    result +=(char) stack.pop();
                
                
                }
                    if(!found ){
                        
                        
                        if(expression.charAt(i)=='-')
                        stack.push('+');
                        else 
                        stack.push(expression.charAt(i));
                        
                    
                    
                    }
                    if (flag)stack.push(c);}
            i++;
        }
        while (!stack.isEmpty()){result += (char)stack.pop();}
        return result;
        
    }
    
    public int evaluate(String expression){
    
        MyStack stack=new MyStack();
        
        for(int i=0;i<expression.length();i++)
        {
            char c=expression.charAt(i);
            
            if(c=='a')
            stack.push(Integer.parseInt(var[0]));
            if(c=='b')
            stack.push(Integer.parseInt(var[1]));
            if(c=='c')
            stack.push(Integer.parseInt(var[2]));
            
            if(isOperator(c))
            
            {
                
                int val2;
                int val1 = (int)stack.pop();
                if (stack.isEmpty()!=true)
                     val2 = (int)stack.pop();
                else  val2=0;
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
                        
                    case '^':
                    
                    stack.push((int)Math.pow(val2,val1));
                    break;
                        
              }
            }
           
        
    }
    return (int)stack.pop();}
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        
       try{ Scanner sc = new Scanner(System.in); 
        String exp = sc.nextLine();
        var[0] = sc.nextLine().replaceAll("a=","");
        var[1] = sc.nextLine().replaceAll("b=","");
        var[2] = sc.nextLine().replaceAll("c=","");
        Evaluator obj=new Evaluator();
        if (!obj.areBracketsBalanced(exp))
            System.out.println("Error");
        else {
            System.out.println(obj.infixToPostfix(exp));
            if (obj.infixToPostfix(exp)!="Error")
            System.out.println(obj.evaluate(obj.infixToPostfix(exp)));}}
           catch(Exception e){
               System.out.println("Error");}
           
        }
        
        
        
        
    }
