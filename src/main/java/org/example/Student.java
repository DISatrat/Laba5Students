package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Student {

    private String name;
    private String lastName;
    private String surname;
    private String gender;
    private LocalDate birthDate;
    private String group;
    private int course;
    private int math;
    private int russian;
    private int it;


    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getRussian() {
        return russian;
    }

    public void setRussian(int russian) {
        this.russian = russian;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Student(String name, String lastName, String surname, String gender, LocalDate birthDate, String group, int course, int math, int russian, int it) {
        this.name = name;
        this.lastName = lastName;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.group = group;
        this.course = course;
        this.math = math;
        this.russian = russian;
        this.it = it;
    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", Math=" + math +
                ", russian=" + russian +
                ", it=" + it +
                '}';
    }
}
