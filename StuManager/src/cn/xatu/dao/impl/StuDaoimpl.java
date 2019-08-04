package cn.xatu.dao.impl;

import cn.xatu.dao.StuDao;
import cn.xatu.domain.Student;
import cn.xatu.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StuDaoimpl implements StuDao {
    Connection conn = null;
   PreparedStatement pstmt = null;
    ResultSet rs = null;
    @Override
    public List <Student> QueryScore(String sno) {
        List<Student> students = new ArrayList <Student>();
        Student student = null;
        try{
            String sql = "SELECT sc.CNO,sc.SNO,sc.Score,c.CN FROM sc,c WHERE sc.SNO =? AND (sc.CNO = c.CNO)";
            Object params[] = {sno};
            rs = DBUtil.executeQuery(sql,params);//创建查询对象
            while (rs.next()){
                String cno = rs.getString("CNO");
                sno = rs.getString("SNO");
                String CN = rs.getString("CN");
                int score = rs.getInt("Score");
                student = new Student(cno,sno,CN,score);
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeAll(conn,pstmt,rs);
        }
    }
}
