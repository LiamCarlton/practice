package com.example.projecttower;

import java.util.ArrayList;

public class Student extends Person
{
    private double gpa;
    private double creditsTaking;
    private String major;

    private ArrayList<String> coursesTook = new ArrayList<String>();
    private ArrayList<Double> coursesTookgpa = new ArrayList<Double>();

    private ArrayList<String> coursesNeeded = new ArrayList<String>();
    private ArrayList<String> coursesTaking = new ArrayList<String>();

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addcoursesTook(ArrayList<String> courses, ArrayList<Double> gpa){
        for(int i = 0; i<courses.size(); i++){
            coursesTook.add(courses.get(i));
            coursesTookgpa.add(gpa.get(i));
        }
        ;
    }

    public ArrayList<String> getCoursesTook() {
        return coursesTook;
    }

    public void setCoursesTook(ArrayList<String> coursesTook) {
        this.coursesTook = coursesTook;
    }

    public ArrayList<String> getCoursesTaking() {
        return coursesTaking;
    }

    public void setCoursesTaking(ArrayList<String> coursesTaking) {
        this.coursesTaking = coursesTaking;
    }

    public void addcoursesTaking(String course){

        coursesTaking.add(course);
    }

    public double getGPA(){
        gpa = 0;
        for(int i=0;i>coursesTookgpa.size(); i++){
            gpa += coursesTookgpa.get(i);
        }
        gpa = gpa/coursesTookgpa.size();
        return gpa;

    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<String> getCoursesNeeded() {
        return coursesNeeded;
    }

    public void setCoursesNeeded(ArrayList<String> coursesNeeded) {
        this.coursesNeeded = coursesNeeded;
    }

}