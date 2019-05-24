package com.unicom.salesmanagebehind.serviceImpl;


import com.unicom.salesmanagebehind.dao.PersonalDao;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private PersonalDao personalDao;
    public List<Manager> getList(Integer managerId,String managerName,String loginName,String managerSex,String managerEmail,String managerTel) {
        return personalDao.getList(managerId,managerName,loginName,managerSex,managerEmail,managerTel);
    }

    public int update(Manager manager){
        return personalDao.update(manager);
    }


}

