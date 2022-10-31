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

interface IPolynomialSolver {
    /*
    * Set polynomial terms (coefficients & exponents)
    * @param poly: name of the polynomial
    * @param terms: array of [coefficients][exponents]
    */
    void setPolynomial(char poly, int[][] terms);
  
    /*
    * Print the polynomial in ordered human readable representation
    * @param poly: name of the polynomial
    * @return: polynomial in the form like 27x^2+x-1
    */
    String print(char poly);
     /**
    * Clear the polynomial
    * @param poly: name of the polynomial
    */
      void clearPolynomial(char poly);
  
    /**
    * Evaluate the polynomial
    * @param poly: name of the polynomial
    * @param value: the polynomial constant value
    * @return the value of the polynomial
    */
    float evaluatePolynomial(char poly, float value);
  /**
    * Add two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial
    */
    int[][] add(char poly1, char poly2);
  
    /**
    * Subtract two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial*/
    int[][] subtract(char poly1, char poly2);
  
    /**
    * Multiply two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return: the result polynomial
    */
    int[][] multiply(char poly1, char poly2);
  
    
   
}


public class PolynomialSolver implements IPolynomialSolver{
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
         if(index<0||index>size-1){}
        else{ 
        for(int i=0;i<index;i++) {n=n.next;} 
        }  
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
        if(head==null) {return true;}
        else  
            return false;}
    
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
        }}}
    DoubleLinkedList A=new DoubleLinkedList();
    DoubleLinkedList B=new DoubleLinkedList();
    DoubleLinkedList C=new DoubleLinkedList();
    DoubleLinkedList R=new DoubleLinkedList();
    
    public void setPolynomial(char poly, int[][] terms){
        
        String coo =new String();
        switch(poly){
            case 'A': 
                    for(int j=0;j<terms[0].length;j++){
                        coo=coo+String.valueOf(terms[0][j])+",";
                        coo=coo+String.valueOf(terms[1][j]);
                        A.add(coo);
                        coo="";
                      
                        }
                break;
            case 'B': 
                    for(int j=0;j<terms[0].length;j++){
                        coo=coo+String.valueOf(terms[0][j])+",";
                        coo=coo+String.valueOf(terms[1][j]);
                        B.add(coo);
                        coo="";
                        }
                break;
            case 'C': 
                    for(int j=0;j<terms[0].length;j++){
coo=coo+String.valueOf(terms[0][j])+",";
                        coo=coo+String.valueOf(terms[1][j]);
                        C.add(coo);
                        coo="";
                        }
                break;
                case 'R': 
                    for(int j=0;j<terms[0].length;j++){
                       coo=coo+String.valueOf(terms[0][j])+",";
                        coo=coo+String.valueOf(terms[1][j]);
                        R.add(coo);
                        coo="";
                        }
                break;
        }}
  
    public String print(char poly){
        String s=new String();
        String coo =new String();
        switch(poly){
           case 'A':
                if (A.isEmpty()){s="[]";}else{
            for(int j=0;j<A.size();j++){
             
                 coo=String.valueOf(A.get(j));
                                  
                
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                if(x==1&&y!=1){if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s+"x^"+String.valueOf(y);}
                else if(y==0){if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s+String.valueOf(x);}
                else if(x==1&&y==1){if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s+"x";}
                else if(x!=1&&y==1){if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x";}
                else if(x==0){if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s; }
                else{if(j!=0&&j!=A.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x^"+String.valueOf(y);}
                }}
            break;
            
            case 'B':
                if (B.isEmpty()){s="[]";}else{
           for(int j=0;j<B.size();j++){
             
                 coo=String.valueOf(B.get(j));
                                  
                
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                if(x==1&&y!=1){if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s+"x^"+String.valueOf(y);}
                else if(y==0){if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s+String.valueOf(x);}
                else if(x==1&&y==1){if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s+"x";}
                else if(x!=1&&y==1){if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x";}
                else if(x==0){if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s; }
                else{if(j!=0&&j!=B.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x^"+String.valueOf(y);}
                }}
            break;
            
            case 'C':

             if (C.isEmpty()){s="[]";}else{
                 for(int j=0;j<C.size();j++){
             
                 coo=String.valueOf(C.get(j));
                                  
                
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                if(x==1&&y!=1){if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s+"x^"+String.valueOf(y);}
                else if(y==0){if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s+String.valueOf(x);}
                else if(x==1&&y==1){if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s+"x";}
                else if(x!=1&&y==1){if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x";}
                else if(x==0){if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s; }
                else{if(j!=0&&j!=C.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x^"+String.valueOf(y);}
                }}
            break;
            case 'R':
                if (R.isEmpty()){s="[]";}else{
            for(int j=0;j<R.size();j++){
             
                 coo=String.valueOf(R.get(j));
                                  
                
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                if(x==1&&y!=1){if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s+"x^"+String.valueOf(y);}
                else if(y==0){if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s+String.valueOf(x);}
                else if(x==1&&y==1){if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s+"x";}
                else if(x!=1&&y==1){if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x";}
                else if(x==0){if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s; }
                else{if(j!=0&&j!=R.size()&&x>0){s=s+"+";}s=s+String.valueOf(x)+"x^"+String.valueOf(y);}
                }}
            break;}
    return s;}
   public void clearPolynomial(char poly){
       
        switch(poly){
            case 'A':
                if(A.isEmpty())return;
                A.clear();
                break;
            case 'B':
                if(B.isEmpty())return;
                B.clear();
                break;
            case 'C':
                if(C.isEmpty())return;
                C.clear();
                break;
                case 'R':
                if(R.isEmpty())return;
                R.clear();
                break;
        }
        
    }
   public float evaluatePolynomial(char poly, float value){
       float res=0;
       float res1=0.5f;
        String coo =new String();
       
       switch(poly){
            case 'A':
               if (A.isEmpty()){System.out.println("Error");}
               else{
                for(int j=0;j<A.size();j++){
             
                 coo=String.valueOf(A.get(j));      
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                    res+=x*Math.pow((double)value,(double)y);
                    
                }
                   return res;
               }
                    
                break;
            case 'B':
               if (B.isEmpty()){System.out.println("Error");}
               else{
                for(int j=0;j<B.size();j++){
             
                 coo=String.valueOf(B.get(j));      
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                    res+=x*Math.pow((double)value,(double)y);
                    
                }return res;
               }
                  
                break;
            case 'C':
               if (C.isEmpty()){System.out.println("Error");}
               else{
                for(int j=0;j<C.size();j++){
             
                 coo=String.valueOf(C.get(j));      
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                    res+=x*Math.pow((double)value,(double)y);
                    
                }return res;
               }
                break;
            case 'R':
               if (R.isEmpty()){System.out.println("Error");}
               else{
                for(int j=0;j<R.size();j++){
             
                 coo=String.valueOf(R.get(j));      
                String[] str = coo.split(",");; 
                int[] arr = new int[str.length]; 
                for(int i = 0; i < str.length; ++i) 
                 arr[i] = Integer.parseInt(str[i]);
                
                int x=arr[0];
                int y=arr[1];
                    res+=x*Math.pow((double)value,(double)y);
                    
                }return res;
               }
                break;
               
                    
        }
       return res1;
       
   }
    public int[][] add(char poly1, char poly2){
        
        String coo1 =new String();
        String coo2 =new String();
        int [][] res1=new int [2][A.size()];
        
        if (poly1=='A'&& poly2=='B'){
            if (A.isEmpty()||B.isEmpty()){System.out.println("Error");return res1;}else{
            
            if (A.size>B.size){
                
                int [][] res=new int [2][A.size()];     
                                   
                int sizeDiff=A.size()-B.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<A.size();j++){
                 coo1=String.valueOf(B.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(A.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
                     
                  return res;                
                                  
                                  }
             else{
                 int [][] res=new int [2][B.size()];    
                                   
                int sizeDiff=B.size()-A.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(B.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<B.size();j++){
                 coo1=String.valueOf(A.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(B.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
     
                                   
                  return res;}}}
        else if (poly1=='A'&&poly2=='C'){
            if (A.isEmpty()||C.isEmpty()){System.out.println("Error");return res1;}else{
            if (A.size()>C.size()){
                int [][] res=new int [2][A.size()];
                int sizeDiff=A.size()-C.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<A.size();j++){
                 coo1=String.valueOf(C.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(A.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
                     
                  return res;
            
            }
             else{
                 int [][] res=new int [2][C.size()];
                 int sizeDiff=C.size()-A.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(C.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<C.size();j++){
                 coo1=String.valueOf(A.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(C.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
     
                                   
                  return res;
             }
        }}
        else{
            if (C.isEmpty()||B.isEmpty()){System.out.println("Error");return res1;}else{
            if (C.size()>B.size()){
                int [][] res=new int [2][C.size()];
                int sizeDiff=C.size()-B.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(C.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<C.size();j++){
                 coo1=String.valueOf(B.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(C.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
                     
                  return res;
            }
             else{
                 int [][] res=new int [2][B.size()];
                 int sizeDiff=B.size()-C.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(B.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<B.size();j++){
                 coo1=String.valueOf(C.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(B.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xa+xb;
                      res[1][j]=ya;}
     
                                   
                  return res;
             }
        }}
           
    }
   public int[][] subtract(char poly1, char poly2){
       
       
       String coo1 =new String();
        String coo2 =new String();
       
        int [][] res1=new int [2][A.size()];
        
        if (poly1=='A'&& poly2=='B'){
            
            
            if (A.size>B.size){
                
                int [][] res=new int [2][A.size()];     
                                   
                int sizeDiff=A.size()-B.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<A.size();j++){
                 coo1=String.valueOf(B.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(A.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
                     
                  return res;                
                                  
                                  }
             else{
                 int [][] res=new int [2][B.size()];    
                                   
                int sizeDiff=B.size()-A.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(B.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<B.size();j++){
                 coo1=String.valueOf(A.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(B.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
     
                                   
                  return res;}}
        else if (poly1=='A'&&poly2=='C'){
            if (A.size()>C.size()){
                int [][] res=new int [2][A.size()];
                int sizeDiff=A.size()-C.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<A.size();j++){
                 coo1=String.valueOf(C.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(A.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
                     
                  return res;
            
            }
             else{
                 int [][] res=new int [2][C.size()];
                 int sizeDiff=C.size()-A.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(C.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<C.size();j++){
                 coo1=String.valueOf(A.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(C.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
     
                                   
                  return res;
             }
        }
        else{
            if (C.size()>B.size()){
                int [][] res=new int [2][C.size()];
                int sizeDiff=C.size()-B.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(C.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<C.size();j++){
                 coo1=String.valueOf(B.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(C.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
                     
                  return res;
            }
             else{
                 int [][] res=new int [2][B.size()];
                 int sizeDiff=B.size()-C.size();
                for(int k=0;k<sizeDiff;k++){
                    coo2=String.valueOf(B.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                res[0][k]=xa;
                res[1][k]=ya;
                }
                                 
            for (int j=sizeDiff; j<B.size();j++){
                 coo1=String.valueOf(C.get(j-sizeDiff));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                
    
                coo2=String.valueOf(B.get(j));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                
                res[0][j]=xb-xa;
                      res[1][j]=ya;}
     
                                   
                  return res;}}}
   public int[][] multiply(char poly1, char poly2){
       int maxSize;
        String coo1 =new String();
        String coo2 =new String();
       
       int [][] res1=new int [2][A.size()];
       if (poly1=='A'&& poly2=='B'){
            maxSize=(A.size()-1)+(B.size()-1);
           int [][] res=new int [2][maxSize+1]; 
           for (int k=0;k<A.size();k++){
               for (int l=0;l<B.size();l++){
                 coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                coo1=String.valueOf(B.get(l));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                int mult=xa*xb;
                int sum=ya+yb;
                res[0][maxSize-sum]+=mult;
                res[1][maxSize-sum]=sum; 
                   
               }
           }
            return res;}
       if (poly1=='A'&& poly2=='C'){
            maxSize=(A.size()-1)+(C.size()-1);
           int [][] res=new int [2][maxSize+1]; 
           for (int k=0;k<A.size();k++){
               for (int l=0;l<C.size();l++){
                 coo2=String.valueOf(A.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                coo1=String.valueOf(C.get(l));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                int mult=xa*xb;
                int sum=ya+yb;
                res[0][maxSize-sum]+=mult;
                res[1][maxSize-sum]=sum; 
                   
               }
           }
            return res;}
       if (poly1=='C'&& poly2=='B'){
            maxSize=(C.size()-1)+(B.size()-1);
           int [][] res=new int [2][maxSize+1]; 
           for (int k=0;k<C.size();k++){
               for (int l=0;l<B.size();l++){
                 coo2=String.valueOf(C.get(k));      
                String[] str2 = coo2.split(",");; 
                int[] arr2 = new int[str2.length]; 
                for(int i = 0; i < str2.length; ++i) 
                 arr2[i] = Integer.parseInt(str2[i]);
                 int xa=arr2[0];
                int ya=arr2[1];
                coo1=String.valueOf(B.get(l));      
                String[] str1 = coo1.split(",");; 
                int[] arr1 = new int[str1.length]; 
                for(int i = 0; i < str1.length; ++i) 
                 arr1[i] = Integer.parseInt(str1[i]);
                 int xb=arr1[0];
                int yb=arr1[1];
                int mult=xa*xb;
                int sum=ya+yb;
                res[0][maxSize-sum]+=mult;
                res[1][maxSize-sum]=sum; 
                   
               }
           }
            return res;}
             
                                   
                  return res1;}
       
       
       
       
  
    
    
    
    
        
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        PolynomialSolver object=new PolynomialSolver();
        String oper=sc.nextLine();
        char pol,pol1;
        int l=0;
        do{
            if (l!=0){oper=sc.nextLine();}
                l++;
        switch(oper){
            
            case "set":
                pol =sc.nextLine().charAt(0);
                String sin = sc.nextLine().replaceAll("\\[|\\]", ""); 
                String[] s = sin.split(",");; 
                int[] arr = new int[s.length]; 
                if (s.length == 1 && s[0].isEmpty()){ 
                arr = new int[]{};} 
                 else { 
                for(int i = 0; i < s.length; ++i){
                 arr[i] = Integer.parseInt(s[i]);
                 }}
               
                int [][]terms =new int [2][arr.length];
                for(int i=0;i<arr.length;i++){
                terms[0][i]=arr[i];
                terms[1][i]=arr.length-i-1;}
                if (pol!='A'&&pol!='B'&&pol!='C')System.out.println("Error");
                else object.setPolynomial(pol,terms);
            break;
            case "print":
                pol =sc.nextLine().charAt(0);
                if (pol!='A'&&pol!='B'&&pol!='C')System.out.println("Error");
                else System.out.println(object.print(pol));
                break;
                
            case "clear":
                pol=sc.nextLine().charAt(0);
                if (pol!='A'&&pol!='B'&&pol!='C')System.out.println("Error");
                else{
                object.clearPolynomial(pol);
               System.out.print("[]");}
                break;
            case "eval":
                
                pol=sc.nextLine().charAt(0);
                if (pol!='A'&&pol!='B'&&pol!='C'&&pol!='R')System.out.println("Error");
                else
                {float value =sc.nextFloat();
                 if(object.evaluatePolynomial(pol,value)!=0.5f)
                System.out.println((int)object.evaluatePolynomial(pol,value));}
                break;
            case "add":
                pol1=sc.nextLine().charAt(0);
                pol=sc.nextLine().charAt(0);
                if ((pol!='A'&&pol!='B'&&pol!='C')||(pol1!='A'&&pol1!='B'&&pol1!='C'))System.out.println("Error");
                else if (object.add(pol1,pol)==null){break;}
                else{int [][]term =object.add(pol1,pol);
                object.setPolynomial('R',term);
                System.out.println(object.print('R'));}
                
                break;
            case "sub":
                pol1=sc.nextLine().charAt(0);
                pol=sc.nextLine().charAt(0);
                if (pol!='A'&&pol!='B'&&pol!='C'||pol1!='A'&&pol1!='B'&&pol1!='C')System.out.println("Error");
                else{int [][]term =object.subtract(pol1,pol);
                object.setPolynomial('R',term);
                System.out.println(object.print('R'));}
                
                break;
            case "mult":
                pol1=sc.nextLine().charAt(0);
                pol=sc.nextLine().charAt(0);
                if (pol!='A'&&pol!='B'&&pol!='C'||pol1!='A'&&pol1!='B'&&pol1!='C')System.out.println("Error");
                else {int [][]term =object.multiply(pol1,pol);
                object.setPolynomial('R',term);
                System.out.println(object.print('R'));}
                
                break;
                default :
                
                System.out.println("Error");
                
                
                
        }}while(sc.hasNextLine()); 
        
    }
}