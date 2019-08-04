package cn.xatu.util;

import java.sql.*;
import java.util.List;

//通用的数据库帮助类，可以简化Dao层的代码量
public class DBUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "mly9121021";
    public static Connection conn =null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    /**
     * 查询总数
     * @param sql 从外界获取sql语句 select count(*) form student
     */
    public static int getTotalCount(String sql){
        int count = -1;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);//获取总数据量
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return count;
    }
    /**
     *通用的数据库增，删，改操作方法
     * @param sql 从外界传来的sql语句
     * @param params sql传来的"?"值通过该数组接收
     * @return
     */
    public static boolean executeUpdate(String sql,Object params[]){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            //setxxx（）方法的个数和sql语句中的"?"个数一致，而"?"个数与params数组的个数一致
            if(params != null){
                for(int i = 0; i < params.length ; i++){
                    pstmt.setObject(i+1,params[i]);//第一个值为？的个数，第二个值为？的值
                }
            }
            int count = pstmt.executeUpdate();
            if(count > 0){
                return true;
            }else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            closeAll(null,pstmt,rs);
        }
    }

    public static <T> T updateScore(String sql, Object params[]){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            //setxxx（）方法的个数和sql语句中的"?"个数一致，而"?"个数与params数组的个数一致
            if(params != null){
                for(int i = 0; i < params.length ; i++){
                    pstmt.setObject(i+1,params[i]);//第一个值为？的个数，第二个值为？的值
                }
            }
            int count = pstmt.executeUpdate();
            if(count > 0){
               return (T) params;
            }else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            closeAll(null,pstmt,rs);
        }
    }

    /**
     *通用的数据库查询操作方法
     * @param sql 从外界传来的sql语句
     * @param params sql传来的"?"值通过该数组接收
     * @return
     */
    public static <T> T executeQuery(String sql,Object params[]){
        T instance = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = conn.prepareStatement(sql);
            if(params != null){
                for(int i = 0; i < params.length ; i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            rs = pstmt.executeQuery();
            return (T) rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null)  conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
