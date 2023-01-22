package com.collection.DSA_module;

public class spiralOrderMatrix {
    /*given a matrix
    int[][] arr = {   {1,2,3,4,5,6,7,8},
                        {9,10,11,12,13,14,15,16},
                        {17,18,19,20,21,22,23,24}
                      };
       print in spiral order;
     */
    public static void main(String[] args){
        int[][] arr = {   {1,2,3,4,5,6,7,8},
                        {9,10,11,12,13,14,15,16},
                        {17,18,19,20,21,22,23,24}
                      };
        printSpiral(arr);


    }

    static void printSpiral(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int rmin = 0,rmax = n-1;
        int cmin = 0, cmax = m-1;
        int count = 0;
        boolean inbound = count<n*m;
        while(inbound){
          // top boundry
          for(int col = cmin; (col<=cmax) && inbound;col++){
              System.out.println(arr[rmin][col]+" ");
              count++;
          }
          rmin++;
          // rightBoundry
            for(int row = rmin; (row<=rmax) && inbound;row++){
                System.out.println(arr[row][cmax] +" ");
                count++;
            }
            cmax--;
            // bottomBoundry
            for(int col = cmax; (col>=cmin) && inbound;col--){
                System.out.println(arr[rmax][col]+ " ");
                count++;
            }
            rmax--;
            // left boundry
            for(int row = rmax; (row>=rmin) && inbound;row--){
                System.out.println(arr[row][cmin] + " ");
                count++;
            }
            cmin++;
        }

    }
}
