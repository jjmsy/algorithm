package cn.xatu.dao;

import cn.xatu.domain.Student;

import java.util.List;

public interface StuDao {
    List <Student> QueryScore(String sno);

}
