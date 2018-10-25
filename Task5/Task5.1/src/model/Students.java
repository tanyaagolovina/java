package model;

import model.entity.Student;

import java.util.ArrayList;

public class Students {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
