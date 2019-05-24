package com.unicom.salesmanagebehind.serviceImpl;

import com.unicom.salesmanagebehind.dao.ProductDao;
import com.unicom.salesmanagebehind.model.Product;
import com.unicom.salesmanagebehind.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @program: saleManage
 * @description: ProductService接口实现
 * @author: Shilongcheng
 * @create: 2019-05-21 17:11
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public int insertItem(Product product){
        return productDao.insertSelective(product);
    }

    @Override
    public List<Product> getList() {
        return productDao.getList();
    }

    @Override
    public void update(Product product) {
        productDao.updateByPrimaryKeySelective(product);
    }

    @Override
    public Product getItemById(int id) {
        return  productDao.selectByPrimaryKey(id);
    }

    @Override
    public String getImgSrcById(int productId) {
        return productDao.getPrdocutImgSrc(productId);
    }


}
