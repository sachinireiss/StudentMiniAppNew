package dao;

import Model.Student;

public interface StudentDaoInterface {
    public boolean insertStudent(Student s);
    public boolean delete(int index);
    public boolean update(int index, String update,int ch,Student s);
    public void showAllStudent();
    public boolean showStudentById(int index); // ✅ Added here
}
