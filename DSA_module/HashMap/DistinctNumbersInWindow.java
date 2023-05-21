package com.collection.DSA_module.HashMap;

import java.util.*;

public class DistinctNumbersInWindow {
    /*
        Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
     */
    public static void main(String[] args) {
        int[] input  = {1, 2, 1, 3, 4, 3};
        int B = 3;
        System.out.print(solve(input,B));
    }

    static ArrayList<Integer> solve(int[] A, int B){
        /*
          brute force
          simply iterate over the loops twice one to -> n and another to B and set everything to hashSet
          and simply store the size of hashSet and clear hashSet on every complete B iteration
         */
        int n = A.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        /*
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i<n-B+1; i++){
            for(int j = i; j<B+i;j++){
                hs.add(A[j]);
            }
            result.add(hs.size());
            hs.clear();
        }
        return result;

         */

        /*
          the brute force solution takes O(n*B) time complexity
          and O(B) space complexity
          Optimized approach using HashMap
          let take the input

           A = [1, 2, 1, 3, 4, 3]
           B = 3

          1     2    1    3    4    3

          -> store B elements and their frequency to hashMap
           HashMap
           ========
           1 -> 2
           2 -> 1

           -> now iterate over the array from B+1 to n
            -> on every iteration take the lastKey =  A[i-B] from hashMap and reduce its frequency by 1
               if frequency becomes zero delete the key from hashMap
               and Add the A[i] element and its frequency

               -> lastly store the size of the hashMap to result

         */
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<B;i++){
            int key = A[i];
            if(hm.containsKey(key)){
                hm.put(key,hm.get(key)+1);
            }else{
                hm.put(key,1);
            }
        }
        result.add(hm.size());
        for(int i = B;i<n;i++){
            int lastKey = A[i-B];
            if(hm.get(lastKey)>0){
                hm.put(lastKey,hm.get(lastKey)-1);
            }
            if(hm.get(lastKey) == 0){
                hm.remove(lastKey);
            }
            int currentKey = A[i];
            if(hm.containsKey(currentKey)){
                hm.put(currentKey,hm.get(currentKey)+1);
            }else{
                hm.put(currentKey,1);
            }
            result.add(hm.size());
        }
        return result;

        // the overall time complexity of this approach is O(n)
        // the space complexity is O(n);


    }
}
