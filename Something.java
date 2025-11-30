// My Best leetcode problem which i took 3 days to solve hahaha

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    
    public static int[] mergeArray(int[] ar1 , int m , int[] ar2,int n){
        int p1 = m-1,p2 = n-1;
        int i = m+n-1;
        while(i!=0){
           if(p2>=0){ 
            if(ar1[p1]<ar2[p2]){
                ar1[i] = ar2[p2];
                p2--;
            }else{
                ar1[i] = ar1[p1];
                p1--;
            }
        }else{
            return ar1;
        }
            i--;
        }
        return ar1;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of m: ");
        int m = sc.nextInt();
        System.out.println("enter the value of n: ");
        int n = sc.nextInt();

        int[] ar1 = new int[m+n];
        int[] ar2 = new int[n];
        System.out.println("Enter the Elements in Array1: ");
        for(int i = 0;i<m;i++){
            ar1[i] = sc.nextInt();
        }
        System.out.println("Enter the Elements in Array2: ");
        for(int i = 0;i<n;i++){
            ar2[i] = sc.nextInt();
        }
        ar1 = mergeArray(ar1, m, ar2, n);
        System.out.println("Output Array is given Below");
        System.out.println(Arrays.toString(ar1));
        sc.close();
    }
}
