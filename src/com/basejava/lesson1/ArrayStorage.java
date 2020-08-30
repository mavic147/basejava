package com.basejava.lesson1;

import java.util.Scanner;

public class ArrayStorage {
    Resume[] resumeArr = new Resume[10000];
    Scanner scan = new Scanner(System.in);
    int nextId = 0;

    public void add() {
        if (nextId == resumeArr.length) {
            System.out.println("No more space!");
            return;
        }
        resumeArr[nextId] = new Resume();
        nextId++;
    }

    public void addMany() {
        int vacant = resumeArr.length - nextId;
        System.out.print("How many employees would you like to add? Print: ");
        int employeeAmount = scan.nextInt();
        if (employeeAmount > vacant) {
            System.out.println("Not enough space for all elements. Only " + vacant + " elements are vacant.");
        }
        while (employeeAmount != 0) {
            add();
            employeeAmount--;
        }
    }

    public boolean existsElem(int id) {
        if (id >= nextId || id < 0) {
            System.out.println("No such employee!");
            return false;
        }
        return true;
    }

    public boolean isEmpty() {
        if (nextId == 0) {
            System.out.println("The database is empty by now, probably you should add sb at first.\n");
            return true;
        }
        return false;
    }

    public void get() {
        if (isEmpty()) {
            return;
        }
        System.out.print("Print the id-number of the employee, who you would like to read about: ");
        int id = scan.nextInt();
        if (existsElem(id - 1)) {
            resumeArr[id - 1].show();
        }
    }

    public void getAll() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < nextId; i++) {
            resumeArr[i].show();
        }
    }

    public void delete() {
        System.out.print("Print the number of the employee, whose info you would like to delete: ");
        int id = scan.nextInt();
        if (!existsElem(id - 1)) {
            return;
        }
        resumeArr[id - 1] = null;
        for (int i = id; i < nextId; i++) {
            resumeArr[id - 1] = resumeArr[id];
        }
        nextId--;
        resumeArr[nextId] = null;
    }

    public void size() {
        System.out.println("The size is " + nextId + "/" + resumeArr.length);
        System.out.println();
    }

    public void clear() {
        for (int i = 0; i < nextId; i++) {
            resumeArr[i] = null;
        }
        nextId = 0;
    }

    public void showMenu() {
        System.out.println("1. Show the resume storage");
        System.out.println("2. Show info about a certain employee");
        System.out.println("3. Add employees");
        System.out.println("4. Delete one employee");
        System.out.println("5. Delete all employees");
        System.out.println("6. Show the size of the database");
        System.out.println("0. Exit");
        System.out.println();
    }

    public void startStorage() {
        int choice;
        do {
            showMenu();
            System.out.print("Choose the option: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    getAll();
                    break;
                case 2:
                    get();
                    break;
                case 3:
                    addMany();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    clear();
                    break;
                case 6:
                    size();
                case 0:
                    System.out.println("Thanks for using our database, goodbye!");
                    break;
                default:
                    System.out.println("No such option!");
                    break;
            }
        }
        while (choice != 0);
    }
}
