package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * 实现
 *
 * @author: WangJiLin
 * @Date: 2019-08-01 10:31
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryListByParent(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }
    /**
     * @Description: 通过品牌id查询商品分类
     * @params: bid
     * @return:
     * @author: WangJiLin
     * @Date: 2019/8/1
     */
    public List<Category> queryByBrandId(Long bid) {
       return categoryMapper.queryByBrandId(bid);
    }
}