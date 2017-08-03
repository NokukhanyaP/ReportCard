package com.example.nokukhanya.reportcard;


/**
 * Created by Nokukhanya on 2017/07/20.
 */

public class Student {


    private int student_ID;
    private String student_name;
    private String student_surname;
    private String student_course;
    private int student_mark1;
    private int student_mark2;
    private int student_mark3;
    private int student_average;

    public Student (int student_ID, String student_name, String student_surname, String student_course, int student_mark1, int student_mark2, int student_mark3, int student_average) {
        this.student_ID = student_ID;
        this.student_name = student_name;
        this.student_surname = student_surname;
        this.student_course = student_course;
        this.student_mark1 = student_mark1;
        this.student_mark2 = student_mark2;
        this.student_mark3 = student_mark3;
        this.student_average = student_average;
    }

    public Student(){

    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_name(){
        return student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudent_course() {
        return student_course;
    }

    public void setStudent_course(String student_course) {
        this.student_course = student_course;
    }

    public int getStudent_mark1() {
        return student_mark1;
    }

    public void setStudent_mark1(int student_mark1) {
        this.student_mark1 = student_mark1;
    }

    public int getStudent_mark2() {
        return student_mark2;
    }

    public void setStudent_mark2(int student_mark2) {
        this.student_mark2 = student_mark2;
    }

    public int getStudent_mark3() {
        return student_mark3;
    }

    public void setStudent_mark3(int student_mark3) {
        this.student_mark3 = student_mark3;
    }

    public int getStudent_average() {
        return student_average;
    }

    public void setStudent_average(int student_average) {
        this.student_average = student_average;
    }
}


