package com.collection.DSA_module;

public class AddBinaryString {
    /*
    Problem Description
Given two binary strings A and B. Return their sum (also a binary string).


Problem Constraints
1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings



Input Format
The two argument A and B are binary strings.



Output Format
Return a binary string denoting the sum of A and B



Example Input
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"


Example Output
Output 1:
"111"
Output 2:
"1000"


Example Explanation
For Input 1:
The sum of 100 and 11 is 111.
For Input 2:

The sum of 110 and 10 is 1000.
     */
    public static void main(String[] args){
        String A = "100";
        String B = "11";
        String result = solve(A,B);
        System.out.println(result);

    }
    static String solve(String A, String B){
        int i = A.length()-1;
        int j = B.length()-1;
        int carry = 0;
        int sum = 0;
        StringBuilder sb =  new StringBuilder();
        while(i>=0 || j>=0 || carry == 1){
            sum = carry;
            if(i>=0) sum = sum+A.charAt(i)-'0';
            if(j>=0) sum = sum+B.charAt(j)-'0';
            sb.append((char)(sum%2+'0'));
            carry = sum/2;
            i--;
            j--;
        }
        return sb.reverse().toString();
        // The time complexity of above above approach is O(n) and space complexity is O(n) as we are using StringBuilder


    }
}
