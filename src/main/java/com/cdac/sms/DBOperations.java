package com.cdac.sms;

import com.cdac.pojos.Student;
import com.cdac.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBOperations {

  SessionFactory sf;
  Session session;
  Transaction trn;

  public List<Student> getStudents() {
    List<Student> studentsList = null;
    // first get the session factory to open a connection with the database
    sf = HibernateUtil.getSessionFactory();
    // open a connection with the database
    session = sf.openSession();
    // perform the query with the database with the help of hql(hibernate query language.
    studentsList = session.createQuery("from Student", Student.class).list();
    // after performing all the operations with the database finally close the session.
    if (session != null) {
      session.close();
    }

    return studentsList;
  }

  public void insertStudent(Student std) {
    sf = HibernateUtil.getSessionFactory();
    session = sf.openSession();
    // begin a transaction : using transaction is the safe for the database
    trn = session.beginTransaction();
    session.save(std);
    // commit the changes
    trn.commit();

    if (session != null) {
      session.close();
    }
  }

  public void deleteStudent(int rollno) {
    sf = HibernateUtil.getSessionFactory();
    session = sf.openSession();

    // first get the student with the roll no
    Student std = session.get(Student.class, rollno);
    // then delete it and commit the result
    trn = session.beginTransaction();
    session.delete(std);
    trn.commit();

    if (session != null) {
      session.close();
    }
  }

  public void updateStudent(int rollno, String name, String course) {
    sf = HibernateUtil.getSessionFactory();
    session = sf.openSession();
    
    Student std = session.get(Student.class, rollno);
    std.setName(name);
    std.setCourse(course);
    
    trn = session.beginTransaction();
    session.update(std);
    trn.commit();

    if (session != null) {
      session.close();
    }
  }

}
