package com.unicom.salesmanagebehind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.salesmanagebehind.model.JSONResult;
import com.unicom.salesmanagebehind.model.ResultPojo;
import com.unicom.salesmanagebehind.model.Saleman;
import com.unicom.salesmanagebehind.service.SalemanService;
import com.unicom.salesmanagebehind.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "saleman")
public class SalemanController {
    @Autowired SalemanService salemanService;

    /**
     * 后台分页、查找获取列表
     * @param page
     * @param limit
     * @param saleId
     * @param saleName
     * @return
     */
    @GetMapping("getList")
//    public JSONResult getList(){
//        List<Saleman> list =salemanService.getList();
//        return new JSONResult().ok(list);
//    }
    public JSONResult selectList(
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "limit",defaultValue = "20") int limit,
            @RequestParam(value = "saleId",defaultValue = "") Integer saleId,
            @RequestParam(value = "saleName",defaultValue = "")String saleName
    ){
        PageHelper.startPage(page,limit);
        List<Saleman> list=salemanService.getList(saleId,saleName);
        PageInfo<Saleman> pageInfo=new PageInfo<>(list);
        return new JSONResult().ok(pageInfo);

    }

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    @DeleteMapping (value = "delete")
    public JSONResult delete(@RequestParam (name = "saleId") int id){
        salemanService.deleteByPrimaryKey(id);
        return new JSONResult().ok("success");
    }


    /**
     * 添加一条数据
     * @param saleman
     * @return
     */
    @PostMapping(value = "insert")
    public  JSONResult insert(@RequestBody Saleman saleman){
        salemanService.insert(saleman);
        return new JSONResult().ok("success");
    }

//    @GetMapping(value = "select")
//    public JSONResult select(@RequestParam(name = "saleId") int id){
//        Saleman saleman=salemanService.selectByPrimaryKey(id);
//        return new JSONResult().ok(saleman);
//    }


    /**
     * 更新一条数据
     * @param saleman
     * @return
     */
    @PutMapping(value = "update")
    public JSONResult update(@RequestBody Saleman saleman){
        salemanService.updateByPrimaryKeySelective(saleman);
        return new JSONResult().ok("success");
    }

    /**
     * 批量删除
     * @param list
     * @return
     */
    @DeleteMapping(value = "batchdel")
    public JSONResult batchDelete(@RequestParam (name = "list")List<Integer> list){
        salemanService.batchDelete(list);
        return new JSONResult().ok("success");
    }






}
