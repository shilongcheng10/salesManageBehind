package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.ManagerDao;
import com.unicom.salesmanagebehind.model.Manager;
import com.unicom.salesmanagebehind.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    public Manager isLoginSuccess(Manager manager){
        return managerDao.isLoginSuccess(manager);
    }

    public List<Manager> getList(Integer managerId,String managerName,String loginName,String managerTel) {
        return managerDao.getList(managerId,managerName,loginName,managerTel);
    }

    public int add(Manager manager) {
        return managerDao.addManager(manager);
    }

    public int update(Manager manager){
        return managerDao.update(manager);
    }

    public int delete(Integer id){
        return managerDao.delete(id);
    }

    public int deleteAll(List list){
        return  managerDao.deleteAll(list);
    }

    @Override
    public String getLoginNameByToken(String token) {
        return managerDao.getLoginNameByToken(token);
    }

    @Override
    public void updateTokenById(Manager manager) {
        managerDao.updateByPrimaryKeySelective(manager);
    }

    @Override
    public String getTokenById(int id) {
        return managerDao.getTokenById(id);
    }

    @Override
    public Manager getUserInfoByToken(String token) {
        return managerDao.getUserInfoByToken(token);
    }

    @Override
    public void logout(String token) {
        managerDao.updateTokenByToken(token);
    }

    @Override
    public void updatePasswordByToken(Manager manager) {
        managerDao.updatePasswordByToken(manager);
    }

    @Override
    public String getPasswordByToken(String token) {
        return managerDao.getPasswordByToken(token);
    }
}
