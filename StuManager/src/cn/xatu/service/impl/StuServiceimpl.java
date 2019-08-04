package cn.xatu.service.impl;

import cn.xatu.dao.StuDao;
import cn.xatu.dao.impl.StuDaoimpl;
import cn.xatu.domain.Student;
import cn.xatu.service.IStuService;

import java.util.List;

public class StuServiceimpl implements IStuService {
    StuDao stuDao = new StuDaoimpl();
    @Override
    public List <Student> QueryScore(String sno) {
        return stuDao.QueryScore(sno);
    }
}
