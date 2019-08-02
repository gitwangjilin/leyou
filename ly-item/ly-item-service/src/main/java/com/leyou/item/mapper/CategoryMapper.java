package com.leyou.item.mapper;

import com.leyou.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Description:
 * Category数据访问层
 *
 * @author: WangJiLin
 * @Date: 2019-07-30 18:17
 */
public interface CategoryMapper extends Mapper<Category> {

    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}