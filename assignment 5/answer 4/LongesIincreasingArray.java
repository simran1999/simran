/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longesiincreasingarray;
import java.util.Scanner;
public class LongesIincreasingArray {
    public static void main(String[] args) {
        ;
      {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("enter size of array");
        n = s.nextInt();
        int a[] = new int[n];
        
        System.out.println("Enter all the elements:");
        for (int i = 0; i < n; i++) 
        {
            a[i] = s.nextInt();
        }
int max=1,len=1;
int maxindex;
for(int i=1;i<a.length;i++){
    if(a[i]>a[i-1])
        len++;
    else
    {if(max<len){
        max=len;
    }
    len=1;
    }
}
if(max<len)
    max=len;
maxindex=n- max;
for(int i=maxindex;i<max+maxindex;i++){
    System.out.print(a[i]+"");
}
        
    }
    
}
}
