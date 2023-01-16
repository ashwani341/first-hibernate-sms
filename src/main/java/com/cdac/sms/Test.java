package com.cdac.sms;

import com.cdac.pojos.Student;
import java.util.List;

public class Test {
  
  public static void main(String[] args) {
    
    DBOperations dbops = new DBOperations();

//    Student std = new Student();
//    std.setName("Ketan");
//    std.setCourse("PGDAC");
//    dbops.insertStudent(std);


//    dbops.deleteStudent(3);

    dbops.updateStudent(3, "Chetan", "DBDA");


    List<Student> list = dbops.getStudents();
    for (Student stdnt : list) {
      System.out.println("-------------------------------------------------");
      System.out.println("Roll no : " + stdnt.getRollNo());
      System.out.println("Name : " + stdnt.getName());
      System.out.println("Course : " + stdnt.getCourse());
    }
    
  }
}
