import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.*;

interface IPlayersFinder {
    /**
     * Search for players locations at the given photo
     * @param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * @param team
     *     Identifier of the team
     * @param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * @return
     *     Array of players locations of the given team
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}


public class PlayersFinder implements IPlayersFinder{
	/*
       Implement your class here
    */
    public static int count=0;
    public int searching(int [][] photo, int x,int y, int team ,int [] coord){
        if(x<0||y<0||x==photo.length||y==photo[0].length||photo[x][y]==0) return 0;
        photo[x][y]=0;
        if (coord[0]>x) coord[0]=x;
        else if (coord[1]<x) coord[1]=x;
        if (coord[2]>y)coord[2]=y;
        else if (coord[3]<y)coord[3]=y;
        return 1+ searching(photo,x-1,y,team,coord) + searching(photo,x+1,y,team,coord) + searching(photo,x,y-1,team,coord ) + searching(photo,x,y+1,team,coord);}
    
    public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
        
        Point [] centers=new Point[50000];
        int [] coord=new int [4];
        int size,x,y;
        
        int [][] photo1=new int[photo.length][photo[0].length()];
        for (int i=0;i<photo1.length;i++){
            for(int j=0;j<photo1[0].length;j++){
                 if(Character.getNumericValue(photo[i].charAt(j))==team){
                     photo1[i][j]=team;}
                 else photo1[i][j]=0;}}
        for (int i=0;i<photo1.length;i++){
            for(int j=0;j<photo1[0].length;j++){
                 if(photo1[i][j]==team){
                     coord[1]=0;coord[3]=0;
                     coord[0]=photo1.length;coord[2]=photo1[0].length;
                     size=searching(photo1,i,j,team,coord);
                     
                     if (size*4>=threshold){
                         if (size==1){
                            x=coord[0]*2+1;
                            y=coord[2]*2+1;
                            centers[count]=new Point(y,x);
                            count++;}
                         else{
                            x=coord[0]+coord[1]+1;
                            y=coord[2]+coord[3]+1;
                            centers[count]=new Point(y,x);
                            count++;}}
                }}}return centers;}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         String sin = sc.nextLine();
         String[] s = sin.split(", ");
         int[] arr = new int[s.length];
         for(int i = 0; i < s.length; i++)  arr[i] = Integer.parseInt(s[i]);
         String [] photo=new String[arr[0]];
         for(int i=0; i<arr[0];i++){photo[i]=sc.nextLine();}
         int team= sc.nextInt();
         int lim=sc.nextInt();
         Point [] centers=new PlayersFinder().findPlayers(photo,team,lim);
         int pointcount=0;
         for(Point p : centers){if(p!=null){pointcount++;}}
         Point [] centers1=new Point[pointcount];
         for(int i=0;i<pointcount;i++){centers1[i]=centers[i];}
         Arrays.sort(centers1, Comparator.comparing(Point::getX).thenComparing(Point::getY));
         int comma=0;
        if (pointcount==0){
            System.out.print("[]");
        }
        else{
         System.out.print("[");
        
         for(Point p : centers1){
         if(p!=null){
              if(comma!=0)
              System.out.print(", ");
              System.out.print("("+p.x+", "+p.y+")");
              comma=1;}}
         System.out.print("]");}}
         
        
        /* Implement main method to parse the input from stdin and print output to stdout */
    }