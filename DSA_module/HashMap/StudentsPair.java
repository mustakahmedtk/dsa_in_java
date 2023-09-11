package com.collection.DSA_module.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StudentsPair {
    /*
      You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a collection of (student ID number, course name) pairs and returns, for every pair of students, a collection of all courses they share.


Sample Input:

enrollments1 = [
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
  ["58", "Software Design"],
]


output ->


find_pairs(enrollments1) =>
{
  "58,17": ["Software Design", "Linear Algebra"]
  "58,94": ["Economics"]
  "58,25": ["Economics"]
  "94,25": ["Economics"]
  "17,94": []
  "17,25": []
}

     */

public static void main(String[] args) {
    String[][] enrollments1 = {
            {"58", "Linear Algebra"},
            {"94", "Art History"},
            {"94", "Operating Systems"},
            {"17", "Software Design"},
            {"58", "Mechanics"},
            {"58", "Economics"},
            {"17", "Linear Algebra"},
            {"17", "Political Science"},
            {"94", "Economics"},
            {"25", "Economics"},
            {"58", "Software Design"}
    };

    String[][] enrollments2 = {
            {"0", "Advanced Mechanics"},
            {"0", "Art History"},
            {"1", "Course 1"},
            {"1", "Course 2"},
            {"2", "Computer Architecture"},
            {"3", "Course 1"},
            {"3", "Course 2"},
            {"4", "Algorithms"}
    };


      /*
        58 -> {"Linear Algebra", "Mechanics", "Economics", "Software Design"}
        94 -> {"Art History", "Operating Systems", "Economics"}

        17 -> {"Software Design", "Linear Algebra", "Political Science"}
        25 -> {"Economics"}

        58 94   58 17  58 17  58 25  94 17 94 25


        58,94 -> {}












        */
    HashMap<String , ArrayList<String>> result = matchPair(enrollments2);
    System.out.println(result);
}

    private static HashMap<String , ArrayList<String>> matchPair(String[][] enrollments1){
        int n = enrollments1.length;
        HashMap<String, HashSet<String>> pairs = new HashMap<String, HashSet<String>>();
        HashMap<String , ArrayList<String>> result = new HashMap<String , ArrayList<String>>();
        for(int i = 0; i<n; i++){
            String stdId = enrollments1[i][0];
            String stdCourse = enrollments1[i][1];
            if(pairs.containsKey(stdId)){
                pairs.get(stdId).add(stdCourse);
            }else{
                HashSet<String> hs = new HashSet<String>();
                hs.add(stdCourse);
                pairs.put(stdId, hs);
            }
        }

        String[] keys = new String[pairs.size()];
        int length = 0;
        for(String entry:pairs.keySet()){
                keys[length++] = entry;
        }

        for(int i = 0; i<keys.length-1; i++){
            HashSet<String> courses = pairs.get(keys[i]);
            String key = keys[i];
            for(int j = i+1; j<keys.length; j++){
                ArrayList<String> arr = new ArrayList<String>();
                HashSet<String> courses1 = pairs.get(keys[j]);
                key +=","+keys[j];
                for(String course:courses){
                    if(courses1.contains(course)){
                        arr.add(course);
                    }

                }
                result.put(key, arr);
                key = keys[i];
            }
        }
        return result;



    }

}
