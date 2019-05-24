package com.unicom.salesmanagebehind.dao;
import java.util.List;
import com.unicom.salesmanagebehind.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDao {
    int deleteByPrimaryKey(int productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(int productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    List<Product> getList();


    String getPrdocutImgSrc(int productId);

}