package com.leyou.item.mapper;

import com.leyou.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Description:
 * 品牌数据访问层
 *
 * @author: WangJiLin
 * @Date: 2019-07-31 8:55
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * @Description: 新增商品分类和品牌中间表数据
     * @params: cid 商品分类id
     * @params: bid 品牌id
     * @return:
     * @author: WangJiLin
     * @Date: 2019/7/31
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    void deleteByBrandIdInCategoryBrand(Long bid);

    List<Brand> queryBrandByCategoryId(Long cid);
}