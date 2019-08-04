package cn.xatu.dao.impl;
import cn.xatu.dao.IAdminDao;
import cn.xatu.domain.Student;
import cn.xatu.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoimpl implements IAdminDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Override
    public boolean updateStudent(String sno, Student student) {
        String sql = "update s set SN = ?,Sex = ?,Age = ?,Dept = ?,password=? where SNO = ?";
        Object params[] = {student.getName(),student.getSex(),student.getAge(),student.getDept(),student.getPassword(),sno};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean deleteStudent(String sno) {
        String sql = "delete from s where SNO = ?";
        Object params[] = {sno};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "insert into s(SNO,SN,Sex,Age,Dept,password) values (?,?,?,?,?,?)";
        Object params[] = {student.getSno(),student.getName(),student.getSex(),student.getAge(),student.getDept(),student.getPassword()};
        return DBUtil.executeUpdate(sql,params);
    }

    //查询所有学生信息
    @Override
    public List<Student> queryall() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        try {
            //String sql = "SELECT s.SNO,s.SN,s.Sex,s.Age,s.Dept,sc.Score FROM s,sc WHERE s.SNO = sc.SNO";
            String sql = "select * from s";
            rs = DBUtil.executeQuery(sql,null);
            while(rs.next()){//每次循环取一个人
                String number = rs.getString("SNO");
                String name = rs.getString("SN");
                String sex = rs.getString("Sex");
                int age = rs.getInt("Age");
                String dept = rs.getString("Dept");
                String password = rs.getString("password");
                //int score = rs.getInt("Score");
                //student = new Student(number,name,sex,age,dept,score);
                student = new Student(number,name,sex,age,dept,password);
                students.add(student);//查一个保存一个
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.closeAll(conn,pstmt,rs);
        }
    }
    //查询学生成绩
    @Override
    public List <Student> queryScore(String sno) {
        StuDaoimpl stuDaoimpl = new StuDaoimpl();
        return stuDaoimpl.QueryScore(sno);
    }

    //修改学生成绩
    @Override
    public boolean updateScore(String sno, Student student) {
        String sql = "UPDATE sc SET Score=? WHERE SNO=? AND CNO=?";
        Object params[] = {student.getScore(),sno,student.getCno()};
        return DBUtil.executeUpdate(sql,params);
    }

    @Override
    public List<Student> find(String sno) {
        List<Student> students = new ArrayList <>();
        Student student = null;
        try{
        String sql = "select * from s where sno = ?";
            Object params[] = {sno};
        rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){//每次循环取一个人
                String number = rs.getString("SNO");
                String name = rs.getString("SN");
                String sex = rs.getString("Sex");
                int age = rs.getInt("Age");
                String dept = rs.getString("Dept");
                String password = rs.getString("password");
                student = new Student(number,name,sex,age,dept,password);
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
         finally {
            DBUtil.closeAll(conn,pstmt,rs);
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from s";
        return DBUtil.getTotalCount(sql);
    }

    @Override
    public List <Student> findByPages(int start, int pageSize) {
        try{
        String sql = "select * from s limit ?,?";
            Object params[] = {start,pageSize};
            List<Student> students = new ArrayList <>();
            Student student = new Student();
            rs =  DBUtil.executeQuery(sql,params);
            while (rs.next()){//每次循环取一个人
                String number = rs.getString("SNO");
                String name = rs.getString("SN");
                String sex = rs.getString("Sex");
                int age = rs.getInt("Age");
                String dept = rs.getString("Dept");
                String password = rs.getString("password");
                student = new Student(number,name,sex,age,dept,password);
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.closeAll(conn,pstmt,rs);
        }
    }

    @Override
    public Student findScore(String sno,String cno) {
        try{
            Student student = null;
       String sql =  "select sc.CNO,sc.SNO,c.CN,sc.Score FROM c,sc WHERE sc.SNO=? AND c.CNO = ? AND sc.CNO=c.CNO";
        Object params[] = {sno,cno};
        rs = DBUtil.executeQuery(sql,params);
            if(rs.next()){
                rs.getString("CNO");
                String number = rs.getString("SNO");
            String cn = rs.getString("CN");
            int score = rs.getInt("Score");
            student = new Student(cno,sno,cn,score);
            }
        return student;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(conn,pstmt,rs);
        }
    }
}
