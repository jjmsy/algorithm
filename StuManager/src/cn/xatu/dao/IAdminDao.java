package cn.xatu.dao;

import cn.xatu.domain.Student;

import java.util.List;

public interface IAdminDao {
    //根据学号修改学生信息
    public boolean updateStudent(String sno,Student student);
    //根据学号删除学生
    public boolean deleteStudent(String sno);
    //添加学生信息
    public boolean addStudent(Student student);
    //查询全部学生
    public List<Student> queryall();
    //根据学号查询学生成绩
    List<Student> queryScore(String sno);
    //根据学号修改学生成绩
    boolean updateScore(String sno, Student student);
    //根据学号查询学生
    List<Student> find(String sno);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询每页的记录
     * @param start
     * @param pageSize
     * @return
     */
    List<Student> findByPages(int start, int pageSize);

    Student findScore(String sno,String cno);
}
