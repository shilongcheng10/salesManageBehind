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
    public  Manager getManagerInfo(String token){
        return personalDao.getManagerInfoByToken(token);
    }
//    public String update(Manager manager){
//        return personalDao.update(manager);
//    }
public  void updateManagerInfo(Manager manager){
        personalDao.updateManagerInfoByToken(manager);
}



}

