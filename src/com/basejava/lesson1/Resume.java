package com.basejava.lesson1;

import java.util.Scanner;

public class Resume {
    private String name;
    private String surname;
    private int age;
    private String profession;
    private char experience;
    Scanner scan = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public char getExperience() {
        return experience;
    }

    public Resume() {
        System.out.print("Print the name: ");
        this.name = scan.next();
        System.out.print("Print the surname: ");
        this.surname = scan.next();
        System.out.print("Print the age: ");
        this.age = scan.nextInt();
        scan.nextLine();
        System.out.print("Print the profession: ");
        this.profession = scan.nextLine();
        System.out.print("Print Y if the person has experience, and N if not: ");
        this.experience = scan.next().charAt(0);
    }
}
