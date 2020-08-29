package com.basejava.lesson1;

import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.Math.pow;

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

    public void get() {
        System.out.print("Print the id-number of the employee, who you would like to read about: ");
        int id = scan.nextInt();
        if (existsElem(id - 1)) {
            resumeArr[id - 1].show();
        }
    }

    public void getAll() {
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
        System.out.println("Размер " + nextId + "/" + resumeArr.length);
        System.out.println();
    }

    public void clear() {
        for (int i = 0; i < nextId; i++) {
            resumeArr[i] = null;
        }
        nextId = 0;
    }

    public void showMenu() {
        System.out.println("1. Показать базу резюме");
        System.out.println("2. Показать базу по id");
        System.out.println("3. Добавить резюме");
        System.out.println("4. Удалить по индексу");
        System.out.println("5. Удалить ВСЕ (абсолютно все)");
        System.out.println("6. Сколько места занято");
        System.out.println("0. Выход");
        System.out.println();
    }

    public void startStorage() {
        while (true) {
            showMenu();
            System.out.print("Введите номер: ");
            int answer = scan.nextInt();
            if (answer == 0) {
                break;
            }
            switch (answer) {
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
                    break;
                default:
                    System.out.println("Некорректный пункт меню");
            }
        }
    }
}
