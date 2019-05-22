package com.unicom.salesmanagebehind.service;
import java.util.List;
import com.unicom.salesmanagebehind.model.Product;

/**
 * @program: saleManage
 * @description: 套餐表service接口
 * @author: Shilongcheng
 * @create: 2019-05-21 17:09
 **/
public interface ProductService {
    public int insertItem(Product product);
    public List<Product> getList();
}
