package com.collection.DSA_module;

public class NumberOf1Bits {
    /*
    Problem Description
Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input 1:
11
Input 2:
6


Example Output
Output 1:
3
Output 2:
2


Example Explanation
Explaination 1:
11 is represented as 1011 in binary.
Explaination 2:
6 is represented as 110 in binary.
     */
    public static void main(String[] args){
        int input1 = 11;
        int input2 = 6;
        System.out.println(solve(input1));
    }

    static int solve(int A){                 //76543210
        // for 11 binary reperesentation is -> 00001011
        // right shift ->  >>
         // for 11 >> 0 -> 0 0 0 0 1 0 1 1
         //  for 11 >> 1 ->0 0 0 0 0 1 0 1
        //              &  0 0 0 0 0 0 0 1
        //        -----------------------------
        //                 0 0 0 0 0 0 0 1
        // clearly see 3 bits are set bits
        // set bits are 1 and unset bits are 0
        int noOfsetBits = 0;
        for(int i = 1; i<=32;i++){
            if(checkBit(A,i)){
                noOfsetBits++;
            }
        }
        return noOfsetBits;
        // time complexity of this approach is O(32)-> O(1) and space complexity is O(1);

    }

    static boolean checkBit(int n, int i){
        if(((n>>i)&1) == 1){
            return true;
        }
        return false;
    }
}
