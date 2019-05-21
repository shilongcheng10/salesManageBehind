package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.Saleman;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface SalemanDao {
    //获取全部销售人员数据
//    @Select("select * from saleman")
//    @Results({
//            @Result(column = "newstypeid",
//                    property = "newsType",
//                    one = @One(select = "com.unicom.news.dao.NewsTypeDao.getNewsTypeById",
//                            fetchType = FetchType.EAGER)
//            )
//    })
    List<Saleman> getAllSaleman();

    int deleteByPrimaryKey(int saleId);
    int insert(Saleman record);

    int insertSelective(Saleman record);

    Saleman selectByPrimaryKey(int saleId);

    int updateByPrimaryKeySelective(Saleman record);

    int updateByPrimaryKey(Saleman record);
}