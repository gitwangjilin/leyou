package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * 分类Service
 *
 * @author: WangJiLin
 * @Date: 2019-07-30 18:16
 */

public interface CategoryService {


     List<Category> queryListByParent(Long pid);

    /**
     * @Description: 通过品牌id查询商品分类
     * @params: bid
     * @return:
     * @author: WangJiLin
     * @Date: 2019/8/1
     */
     List<Category> queryByBrandId(Long bid);

}