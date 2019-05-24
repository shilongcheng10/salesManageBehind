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
    /**
     * 获取列表+查询
     * @param id
     * @param saleName
     * @return
     */

    public List<Saleman> getList(Integer id,String saleName){
        return salemanDao.getList(id,saleName);
    }

    /**
     * 根据saleId删除一条记录
     * @param saleId
     * @return
     */
    public int deleteByPrimaryKey(int saleId){
        return salemanDao.deleteByPrimaryKey(saleId);
    }

    /**
     * 添加一条记录
     * @param saleman
     * @return
     */

    public int insert(Saleman saleman){
        return salemanDao.insert(saleman);
    }

//    public Saleman selectByPrimaryKey(int saleId){
//        return salemanDao.selectByPrimaryKey(saleId);
//    }

    /**
     * 更新一条记录
     * @param saleman
     * @return
     */
    public int updateByPrimaryKeySelective(Saleman saleman){
        return salemanDao.updateByPrimaryKeySelective(saleman);
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int batchDelete(List<Integer> list){
        return salemanDao.batchDelete(list);

    }





}
