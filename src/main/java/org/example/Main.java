package org.example;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> FirstCourse = new ArrayList<>();
        List<Student> SecondCourse = new ArrayList<>();
        List<Student> ThirdCourse = new ArrayList<>();
        List<Student> ForthCourse = new ArrayList<>();

        Set<Student> FireStudents;

        //задаем начальные значения

        FirstCourse.add(new Student("Ivan", "Strgo", "IV", "Male", LocalDate.of(2001, 3, 22), "БИСТ-20", 1, 70, 50, 100));
        FirstCourse.add(new Student("Dan", "Dab", "V", "Male", LocalDate.of(2001, 10, 1), "БИВТ-20", 1, 75, 20, 100));
        FirstCourse.add(new Student("Ron", "Strgo", "IV", "Male", LocalDate.of(2000, 8, 12), "БПИ-20", 1, 70, 50, 100));

        SecondCourse.add(new Student("Masha", "Strgo", "IV", "Female", LocalDate.of(2000, 2, 5), "БИСТ-19", 1, 70, 50, 100));
        SecondCourse.add(new Student("Kasha", "Yr", "IV", "Female", LocalDate.of(2000, 1, 21), "БПИ-19", 1, 30, 50, 100));


        ThirdCourse.add(new Student("Fded", "Yr", "IV", "Male", LocalDate.of(1999, 2, 5), "БПИ-18", 1, 30, 50, 100));
        ThirdCourse.add(new Student("VRI", "Yr", "IV", "Male", LocalDate.of(1999, 5, 2), "БИВТ-18", 1, 30, 50, 20));

        ForthCourse.add(new Student("COur", "!23", "IV", "Female", LocalDate.of(1998, 8, 18), "БПИ-17", 1, 30, 50, 100));

        int year = 21;

        Print(FirstCourse, SecondCourse, ThirdCourse, ForthCourse, year);

        FireStudents=AddFireStudents(FirstCourse, SecondCourse, ThirdCourse, ForthCourse);

        for (int i = 0; i < 5; i++) {
            NextYear(FirstCourse, SecondCourse, ThirdCourse, ForthCourse);
            FirstCourse = AddNewStudents(year);
            year++;

            Print(FirstCourse, SecondCourse, ThirdCourse, ForthCourse, year);

            FireStudents.addAll(AddFireStudents(FirstCourse, SecondCourse, ThirdCourse, ForthCourse));
        }


        System.out.println();
        for (int i = 0; i < 100; i++) {
            if(i==50){
                System.out.print("Fire Students");
            }
            System.out.print("==");
        }
        System.out.println();
        System.out.println();

        FireStudents.forEach(System.out::println);

    }

    public static void Print(List<Student> first, List<Student> second, List<Student> third, List<Student> forth, int year) {
        System.out.println("ГОД " + year);
        System.out.println("1 курс");
        first.forEach(System.out::println);
        System.out.println("2 курс");
        second.forEach(System.out::println);
        System.out.println("3 курс");
        third.forEach(System.out::println);
        System.out.println("4 курс");
        forth.forEach(System.out::println);
    }

    // Вариант 10
    public static Set<Student> AddFireStudents(List<Student> first, List<Student> second, List<Student> third, List<Student> forth) {

        Set<Student> FireStudents=new HashSet<>();

        FireStudents.addAll(ForCircleStudents(first));
        FireStudents.addAll(ForCircleStudents(second));
        FireStudents.addAll(ForCircleStudents(third));
        FireStudents.addAll(ForCircleStudents(forth));

        return FireStudents;
    }

    public static List<Student> ForCircleStudents(List<Student> students) {

        List<Student> FireStudents = new ArrayList<>();

        for (Student student : students) {
            LocalDate birthDate = student.getBirthDate();
            boolean isValid = FindFire(birthDate);

            if (isValid) {
                FireStudents.add(student);
            }
        }
        return FireStudents;
    }

    public static boolean FindFire(LocalDate date) {

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();

        if ((month == 3 && day >= 21) || (month == 4 && day <= 20)) {
            return true;
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 21)) {
            return true;
        } else if ((month == 11 && day >= 24) || (month == 12 && day <= 22)) {
            return true;
        } else {
            return false;
        }
    }

    public static void NextYear(List<Student> first, List<Student> second, List<Student> third, List<Student> forth) {

        //4 курс ушел
        forth.clear();

        //3 перешел 2 добавился
        forth.addAll(third);
        forth.forEach(x -> x.setCourse(4));
        third.clear();

        third.addAll(second);
        third.forEach(x -> x.setCourse(3));
        second.clear();

        second.addAll(first);
        second.forEach(x -> x.setCourse(2));
        first.clear();
    }

    public static List<Student> AddNewStudents(int year) {

        String[] names = new String[]{"Masha", "Pavel", "Anna", "Ivan", "Olga", "Elena", "Sergey", "Maria", "Vladimir", "Ekaterina", "Dmitry", "Natalia"};
        String[] lastnames = new String[]{"Smith", "Johnson", "Williams", "Brown", "Davis", "Miller", "Wilson", "Moore"};
        String[] surnames = new String[]{"Ivanovich", "Petrovna", "Sergeevich", "Nikolaevna", "Alexandrovich", "Dmitrievna"};
        String[] genders = new String[]{"Male", "Female",};
        String[] groups = new String[]{"БИСТ-", "БИВТ-", "БПИ-"};
        Random random = new Random();
        int countStud = random.nextInt(1, 4);

        List<Student> firstCourse = new ArrayList<>();

        for (int i = 0; i < countStud; i++) {
            int iName = random.nextInt(0, names.length);
            int iLastname = random.nextInt(0, lastnames.length);
            int iSurname = random.nextInt(0, surnames.length);
            int iGender = random.nextInt(0, genders.length);
            int iGroup = random.nextInt(0, groups.length);
            int month = random.nextInt(1, 13);
            int day = random.nextInt(1, 31);
            int math = random.nextInt(36, 100);
            int russian = random.nextInt(36, 100);
            int it = random.nextInt(36, 100);
            LocalDate birth = LocalDate.of(1981+year, month, day);

            String last = String.valueOf(year);
            String group = groups[iGroup] + last;

            firstCourse.add(new Student(names[iName], lastnames[iLastname], surnames[iSurname], genders[iGender], birth, group, 1, math, russian, it));
        }
        return firstCourse;
    }

}