package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Saleman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface SalemanDao {
    //获取列表
    List<Saleman> getList(
            @Param("saleId") Integer id,
            @Param("saleName") String saleName
    );
    //删除一条记录
    int deleteByPrimaryKey(int saleId);

    //获取数据
    @Select("SELECT a.*," +
            "(select count(*) from sales b where b.salemanId=a.saleId) as saleProductNum," +
            "(select sum(d.productFee) from sales b,product d where b.productId=d.productId GROUP BY salemanId HAVING b.salemanId=a.saleId) as saleTotalPrice" +
            "FROM saleman a")
    List<Saleman> getLists();

    //新增一条记录
    int insert(Saleman saleman);

    //更新一条记录
    int updateByPrimaryKeySelective(Saleman record);

    //批量删除

    int batchDelete(List<Integer> list);

//    int insertSelective(Saleman record);


//    Saleman selectByPrimaryKey(int saleId);



//    int updateByPrimaryKey(Saleman record);
}