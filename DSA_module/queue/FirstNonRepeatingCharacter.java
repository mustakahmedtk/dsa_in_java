package com.collection.DSA_module.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    /*
       Problem Description
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string B after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation
Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
     */

    public static void main(String[] args) {

        String input = "abadbc";
        System.out.println(solve(input));

    }

    static String solve(String A){
        /*
           using Queue
           -> store all the chars and their frequency as 0
           -> also create a StringBuilder
           -> for every stream of char , store it in queue , update the frequency
           -> keep removing an element from queue until its peek element's frequency>1
           -> if queue is not empty , append the front element in SB
           -> if queue is empty , append # in SB
         */
        int n = A.length();
        Queue<Character> q = new LinkedList<Character>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            hm.put(A.charAt(i),0);
        }
        for(int i = 0; i<n; i++){
            char ch = A.charAt(i);
            q.add(ch);
            hm.put(ch, hm.get(ch)+1);
            while(!q.isEmpty() && hm.get(q.peek())>1){
                q.remove();
            }
            if(!q.isEmpty()){
                sb.append(q.peek());
            }else{
                sb.append('#');
            }
        }
        return sb.toString();

        /*
           T.C --> O(n)
           S.C --> O(n)
         */
    }
}
