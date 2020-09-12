package com.basejava.interviewQuestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Math;

public class interviewQuestionsRandom {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\German\\Desktop\\interview_questions.txt"));
        String str;

        ArrayList<String> list = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }

        String[] interviewQuestions = list.toArray(new String[0]);
        int numberQuestions = (int) (Math.random() * (interviewQuestions.length - 1) + 1);
        System.out.println(interviewQuestions[numberQuestions]);
        reader.close();
    }
}
