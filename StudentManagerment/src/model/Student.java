/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class Student {

//    public enum CourseName {
//        first {
//            @Override
//            public String toString() {
//                return "Java";
//            }
//        },
//        second {
//            @Override
//            public String toString() {
//                return ".Net";
//            }
//        },
//        third {
//            @Override
//            public String toString() {
//                return "C/C++";
//            }
//        }
//
//    }
    private String id;
    private String name;
    private String semeter;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, String semeter, String courseName) {
        this.id = id;
        this.name = name;
        this.semeter = semeter;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemeter() {
        return semeter;
    }

    public void setSemeter(String semeter) {
        this.semeter = semeter;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + semeter + " | " + courseName;
    }

}
