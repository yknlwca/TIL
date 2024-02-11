package boj;

import java.util.Scanner;

class Student {
    String name;
    int day, month, year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int compareAge(Student other) {
        if (this.year != other.year) {
            return this.year - other.year;
        } else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }
}

public class Boj5635 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // 개행문자 처리

        Student older = null;
        Student younger = null;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int day = Integer.parseInt(input[1]);
            int month = Integer.parseInt(input[2]);
            int year = Integer.parseInt(input[3]);

            Student current = new Student(name, day, month, year);
            if (older == null || current.compareAge(older) < 0) {
                older = current;
            }
            if (younger == null || current.compareAge(younger) > 0) {
                younger = current;
            }
        }

        System.out.println(younger.name);
        System.out.println(older.name);

        scanner.close();
    }
}
