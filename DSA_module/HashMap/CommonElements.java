package com.collection.DSA_module.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElements {
    /*
     Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.

     */
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 3, 1, 2};
        System.out.println(solve(A,B));
    }

    static ArrayList<Integer> solve(int[] A, int[] B){
        /*
            using hashMap we can simply store the frequency of the all elements from A
            and then check if elements exist in array B
         */
        int n = A.length;
        int m = B.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            int key = A[i];
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key)+1);
            }else{
                hm.put(key,1);
            }
        }
        for(int i = 0; i<m; i++){
            int key = B[i];
            if(hm.containsKey(key) && hm.get(key)>0){
                result.add(key);
                hm.put(key, hm.get(key)-1);
            }
        }
        return result;

        /*
          time complexity of this approach is O(n)
          space complexity is O(n)
         */
    }

}
