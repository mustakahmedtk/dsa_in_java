package com.collection.DSA_module;



class TrieNode{
     TrieNode[] children;
     int wordCount;
     boolean isEndOfWord;
    TrieNode(){
        children = new TrieNode[26];
        wordCount = 0;
        isEndOfWord = false;
    }
}

class Runner2{
    public static void main(String args[]){
        Tries tr = new Tries();
        //TrieNode root = new TrieNode();
        String[] words = {"cat", "catian", "bel"};
        for(int i = 0; i<words.length;i++){
            tr.addWord(words[i]);
        }
        System.out.println(tr.findPrefix("catian"));
        System.out.println(tr.search("bel"));
    }
}

public class Tries {
    TrieNode root;
    Tries(){
        root = new TrieNode();
    }
     void addWord(String A){
        TrieNode temp = root;
        for(int i = 0; i<A.length(); i++){
            int index = A.charAt(i)-'a';
            if(temp.children[index] == null){
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
            temp.wordCount++;
         }
        temp.isEndOfWord = true;
    }

    String findPrefix(String word) {
        TrieNode temp = root;
        String prefix = "";
        for(int i = 0; i<word.length(); i++){
            int idx = word.charAt(i)-'a';
            prefix = prefix + word.charAt(i);
            if(temp.children[idx].wordCount == 1) {
                break;
            }
            temp = temp.children[idx];
        }
        return prefix;
    }

     Boolean search(String key){
        TrieNode temp = root;
        for(int i = 0; i<key.length();i++){
           int index = key.charAt(i)-'a';
            if(temp.children[index] ==null){
                return false;
            }
            temp  = temp.children[index];
        }
        return temp.isEndOfWord;
     }

}
