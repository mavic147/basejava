package com.basejava.lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStorage {
    Resume[] resumeArr = new Resume[10000];
    Scanner scan = new Scanner(System.in);
    int id;

    public void add() {
        id = 1;
        System.out.print("How many employees would you like to add?: ");
        int employeeAmount = scan.nextInt();
        for (int i = id - 1; i < employeeAmount; i++) {
            Resume resume = new Resume();
            resumeArr[i] = resume;
            id++;
            System.out.println();
        }
    }

    public void get() {
        System.out.print("Print the id-number of the employee, who you would like to read about: ");
        id = scan.nextInt();
        System.out.println(resumeArr[id - 1].getName());
        System.out.println(resumeArr[id - 1].getSurname());
        System.out.println(resumeArr[id - 1].getAge());
        System.out.println(resumeArr[id - 1].getProfession());
        System.out.println(resumeArr[id - 1].getExperience());
        System.out.println();
    }

    public void getAll() {
        System.out.println(Arrays.toString(resumeArr));
        System.out.println();
    }

    public void delete() {
        System.out.print("Print the number of the employee, whose info you would like to delete: ");
        id = scan.nextInt();
        resumeArr[id - 1] = null;
        for (int curInd = id + 1; curInd < resumeArr.length; curInd++) {
            if (resumeArr[id] == null & resumeArr[curInd] != null) {
                resumeArr[id] = resumeArr[curInd];
                id++;
            }
        }
        getAll();
    }

    public void size() {
        int count = 0;
        id = 0;
        while (id < resumeArr.length) {
            if (resumeArr[id] != null) {
                count++;
            }
            id++;
        }
        System.out.println("The amount of employees filled " + count);
        System.out.println();
    }

    public void clear() {
        Arrays.fill(resumeArr, null);
        getAll();
    }
}
