package com.collection.DSA_module;

public class ChangeToOppositeCharCase {
    /*
      Given an input A = "AisDVUr", change it to its opposite characterCase as output = "aISdvur";
     */
    public static void main(String[] args){
        String input = "AisDVUr";
        System.out.println(solve(input));



    }

    static String solve(String A){
        // we can use ASCII numbers of every character to change thier case
        /*
               ASCII          ASCII
           A - 65          a - 97
           .               .
           .               .
           .               .
           .               .
           Z - 90          z - 122
           clearly see , if  we take 97-32 = 65 (we can reach to its upper case)
                          if we take 65+32 = 97 (we can reach to its lower case)
         */
        int n = A.length();
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i<n; i++){
            if(A.charAt(i)>='a' && A.charAt(i)<='z'){
                sb.setCharAt(i,(char)(A.charAt(i)-32));
            }else{
                sb.setCharAt(i,(char)(A.charAt(i)+32));
            }
        }
        return sb.toString();

    }
}
