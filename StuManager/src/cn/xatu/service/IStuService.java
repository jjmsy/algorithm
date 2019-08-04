package cn.xatu.service;

import cn.xatu.domain.Student;

import java.util.List;

public interface IStuService {
    List <Student> QueryScore(String sno);
}
