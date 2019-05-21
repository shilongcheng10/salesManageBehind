package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.SalemanDao;
import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.SalemanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalemanServiceImpl implements SalemanService {
    @Autowired
    SalemanDao salemanDao;
    public List<Saleman> getAllSaleman(){
        return salemanDao.getAllSaleman();
    }

    public int deleteByPrimaryKey(int saleId){
        return salemanDao.deleteByPrimaryKey(saleId);
    }

}
