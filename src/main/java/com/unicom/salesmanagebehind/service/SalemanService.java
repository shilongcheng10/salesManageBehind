package com.unicom.salesmanagebehind.service;

import com.unicom.salesmanagebehind.model.Saleman;

import java.util.List;

public interface SalemanService {

    /**
     * 获取列表+查询
     * @param id
     * @param saleName
     * @return
     */

    List<Saleman> getList(Integer id,String saleName);

    /**
     * 根据saleId删除一条记录
     * @param saleId
     * @return
     */
    int deleteByPrimaryKey(int saleId);

    /**
     * 添加一条记录
     * @param saleman
     * @return
     */
    int insert(Saleman saleman);

//    Saleman selectByPrimaryKey(int saleId);

    /**
     * 更新一条记录
     * @param saleman
     * @return
     */

    int updateByPrimaryKeySelective(Saleman saleman);

    /**
     * 批量删除
     * @param list
     * @return
     */

    int batchDelete(List<Integer> list);

}

