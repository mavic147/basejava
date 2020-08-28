package com.basejava.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStorage {
    Resume[] resumeArr = new Resume[10000];
    Scanner scan = new Scanner(System.in);
    int id;

    public void add() {
        System.out.print("How many employees would you like to add?: ");
        int employeeAmount = scan.nextInt();
        for (id = 1; id <= employeeAmount; id++) {
            Resume resume = new Resume();
            resumeArr[id] = resume;
        }
    }

    public void get() {
        System.out.print("Print the id-number of the employee, who you would like to read about: ");
        id = scan.nextInt();
        System.out.println(resumeArr[id].getName());
        System.out.println(resumeArr[id].getSurname());
        System.out.println(resumeArr[id].getAge());
        System.out.println(resumeArr[id].getProfession());
        System.out.println(resumeArr[id].getExperience());
    }

    public void getAll() {
        System.out.println(Arrays.toString(resumeArr));
    }

    public void delete() {
        System.out.print("Print the number of the employee, whose info you would like to delete: ");
        id = scan.nextInt();
        resumeArr[id] = null;
        for (int curInd = id + 1; curInd < resumeArr.length; curInd++) {
            if (resumeArr[id] == null & resumeArr[curInd] != null) {
                resumeArr[id] = resumeArr[curInd];
                id++;
            }
        }
        getAll();
    }

    public int size() {
        int count = 0;
        id = 1;
        while (id < resumeArr.length) {
            if (resumeArr[id] != null) {
                count++;
            }
        }
        return count;
    }

    public void clear() {
        Arrays.fill(resumeArr, null);
    }
}
