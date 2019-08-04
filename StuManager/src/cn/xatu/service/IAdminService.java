package cn.xatu.service;

import cn.xatu.domain.LimitPage;
import cn.xatu.domain.Student;

import java.util.List;

public interface IAdminService {
    //根据学号修改学生信息
    public boolean updateStudent(String sno,Student student);
    //根据学号删除学生
    public boolean deleteStudent(String sno);
    //添加学生信息
    public boolean addStudent(Student student);
    //查询全部学生
    public List<Student> queryall();
    //查询学生成绩
    public List <Student> queryScore(String sno);
    //根据学号修改学生成绩
    boolean updateScore(String sno, Student student);
    //根据学号查询学生
    List<Student> find(String sno);
    //分页查询
   LimitPage<Student> findStuByPage(String currentPage, String pageSize);

   Student findScore(String sno,String cno);
}
