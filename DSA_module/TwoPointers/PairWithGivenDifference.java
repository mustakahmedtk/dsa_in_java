package com.collection.DSA_module.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PairWithGivenDifference {
    /*
      Problem Description
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.



Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105



Input Format
First argument is an one-dimensional integer array A of size N.

Second argument is an integer B.



Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.



Example Input
Input 1:

 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:

 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:

 A = [1, 1, 1, 2, 2]
 B = 0


Example Output
Output 1:

 2
Output 2:

 5
Output 3:

 2


Example Explanation
Explanation 1:

 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
Explanation 2:

 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
Explanation 3:

 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
     */


    public static void main(String[] args) {
        int[] input1 = {1, 5, 3, 4, 2};
        int targetDiff1 = 3;
        int[] input2 = {8, 12, 16, 4, 0, 20};
        int targetDiff2 = 4;
        int[] input3 = {1, 1, 1, 2, 2};
        int targetDiff3 = 0;

        System.out.println(solve(input2, targetDiff2));
    }



    static int solve(int[] input, int target){
        /*
           brute force -->
             iterate over all the pairs and store the pairs in hashset for removing duplicate pairs
         */
        int n = input.length;
        /*
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int diff = Math.abs(input[i]-input[j]);
                if(diff == target){
                    hs.add(input[i]+""+input[j]);
                }
            }
        }
        return hs.size();

         */

        /*
           the brute force approach takes O(N^2) time complexity
           and O(n^2) space complexity since we are using string of Hashset;


           lets think of a better approach

           since we need to find the difference
           x - y = diff
           x = diff+y
           now if for every x if we can find the diff+x we found out our pair
           -> store the frequency of all the elements
           -> now remove all the duplicates from array
           -> check if for an element element+diff exist or not in hashMap and if it exist increment pair
           -> for special case where target = 0, we need to check if the frequency of the element is > 1 or not
         */
        int pairs = 0;
        /*
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // find out frequency
        for(int i = 0; i<n; i++) {
            if (hm.containsKey(input[i])) {
                hm.put(input[i], hm.get(input[i]) + 1);
            } else {
                hm.put(input[i], 1);
            }
        }
        // remove duplicates from the array
        n = removeDuplicateFromArray(input, hm);

        // iterate over the array and find the difference
        for(int i = 0; i<n; i++){
            if(target == 0){
                if(hm.get(input[i])>1) {
                    pairs++;
                }
            }
            else{
                if(hm.containsKey(input[i]+target) && hm.get(input[i]+target)>=1){
                    pairs++;
                }
            }
        }
        return pairs;

         */

        /*
           the overall time complexity of this approach is O(n);
           and space complexity is O(n);
            lets think  of doing without space

            we can use Two pointer technique , where we will start with two pointers

            p1 and p2 and keep traversing for finding diff == target
            if diff> target p1 moves
            and diff < target p2 moves;
            sort the array
           p1p2
            1    2   3   4    5
            1-1 = 0<target p2 moves

            p1   p2
            1    2   3   4    5
            1-2= 1>target p2 moves

             p1     p2
            1    2   3   4    5
            1-3= 2>target p2 moves


            p1          p2
            1    2   3   4    5
            1-4= 3 == target p2 moves   pairs counted to +1

                 p1           p2
            1    2   3   4    5
            1-5= 4 > target p1 moves
            2-5 = 3 == target p2  pairs counted to +1  and p2 reached to end
            hence we found out 2 pairs;

         */
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(input);
        while(p2<n){
            int diff = Math.abs(input[p1]-input[p2]);
            if(diff>target){
                p1++;

            }
            else if(diff<target || p1 == p2){
                p2++;
            }
            else if(diff == target){
                pairs++;
                int y = input[p2];
                while(p2<n && input[p2] == y){
                    p2++;
                }
            }

        }

        return pairs;
        // the overall time complexity of this aproach is O(nlogn) since we sorted
        // space complexity is O(1)
    }

   static int removeDuplicateFromArray(int[] A, HashMap<Integer, Integer> hm){
        int j = 0;
        for(int key: hm.keySet()){
            A[j++] = key;
        }
        return j;
    }



}
