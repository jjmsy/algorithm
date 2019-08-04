package cn.xatu.service.impl;

import cn.xatu.dao.IAdminDao;
import cn.xatu.dao.impl.AdminDaoimpl;
import cn.xatu.domain.LimitPage;
import cn.xatu.domain.Student;
import cn.xatu.service.IAdminService;

import java.util.List;

public class AdimnServiceimpl implements IAdminService {
    private IAdminDao dao = new AdminDaoimpl();
    //修改学生信息
    @Override
    public boolean updateStudent(String sno, Student student) {
        return dao.updateStudent(sno, student);
    }
    //根据学号删除学生
    @Override
    public boolean deleteStudent(String sno) {
        return dao.deleteStudent(sno);
    }

    @Override
    public boolean addStudent(Student student) {
        return dao.addStudent(student);
    }
    //查询全部学生
    @Override
    public List<Student> queryall() {
        return dao.queryall();
    }
    //查询学生成绩
    @Override
    public List <Student> queryScore(String sno) {
        return dao.queryScore(sno);
    }
    //更新学生成绩
    @Override
    public boolean updateScore(String sno, Student student)
    {
        return dao.updateScore(sno,student);
    }
    //根据学号查询成绩
    @Override
    public List<Student> find(String sno) {
        return dao.find(sno);
    }

    /**
     * 分页查询
     * @param _currentPage
     * @param _pageSize
     * @return
     */
    @Override
    public LimitPage<Student> findStuByPage(String _currentPage, String _pageSize) {
        int currentPage = Integer.parseInt(_currentPage);
            if(currentPage <= 0){
                currentPage = 1;
            }
        int pageSize = Integer.parseInt(_pageSize);

        //1.创建一个空的LimitPage对象
        LimitPage<Student> ls = new LimitPage <Student>();
        //2.设置参数
        ls.setCurrentPage(currentPage);
        ls.setPageSize(pageSize);
        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        //4.调用dao查询List集合
        //计算开始时的索引

        int start = (currentPage -1) * pageSize;
        List<Student> list = dao.findByPages(start,pageSize);
        ls.setList(list);
        //5.计算总页码
        int totalPage = totalCount % pageSize==0 ? totalCount / pageSize : totalCount / pageSize + 1;
        ls.setTotalPage(totalPage);
        return ls;
    }

    @Override
    public Student findScore(String sno,String cno) {
        return dao.findScore(sno,cno);
    }
}
