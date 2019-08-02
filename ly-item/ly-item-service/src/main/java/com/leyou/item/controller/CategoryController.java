package com.leyou.item.controller;

import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * 分类Controller
 *
 * @author: WangJiLin
 * @Date: 2019-07-30 18:15
 */
@RestController
@RequestMapping("category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * @Description: 通过id查询
     * @params: pid
     * @return: list
     * @author: WangJiLin
     * @Date: 2019/7/30
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(
            @RequestParam(value = "pid", defaultValue = "0") Long pid) {
        List<Category> list = this.categoryService.queryListByParent(pid);
        if (list == null || list.size() < 1) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
    /**
     * @Description: 通过品牌id查询商品分类
     * @params: bid
     * @return:
     * @author: WangJiLin
     * @Date: 2019/8/1
     */
     @GetMapping("bid/{bid}")
     public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("bid") Long bid){
         log.info("bid:"+bid);
         List<Category> list = categoryService.queryByBrandId(bid);
         log.info("bid:"+list);
         if (list == null || list.size() < 1){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         return ResponseEntity.ok(list);
     }
}