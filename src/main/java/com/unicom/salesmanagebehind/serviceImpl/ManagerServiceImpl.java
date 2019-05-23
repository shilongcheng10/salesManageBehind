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

    public List<Manager> getList() {
        return managerDao.getList();
    }

    @Override
    public int add(Manager manager) {
        return 0;
    }

    public int add() {
        return 0;
    }
}
