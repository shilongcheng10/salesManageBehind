package com.unicom.salesmanagebehind.dao;

import com.unicom.salesmanagebehind.model.MonthSale;
import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.model.Sales;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MonthSalesDao {
    //获取各月套餐销售总额和销售总量
    @Select("select saleMonth,sum(aa) saleVolume,sum(salecout) saleCount from (SELECT (m.productFee*salecounts.salecout) as aa,salecounts.salecout,salecounts.saleMonth,m.* from product m,\n" +
            "\n" +
            "(SELECT DATE_FORMAT(date,\"%Y-%m-01\") as saleMonth,a.productId,count(*) as salecout from sales a,product b\n" +
            "where a.productId=b.productId\n" +
            "group by saleMonth,a.productId) as salecounts\n" +
            "\n" +
            "where m.productId=salecounts.productId\n" +
            "ORDER BY salecounts.saleMonth,aa) abc GROUP BY abc.saleMonth\n")
    List<MonthSale> getSales();
}
