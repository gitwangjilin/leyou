package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.service.BrandService;
import com.leyou.pojo.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * 品牌管理
 *
 * @author: WangJiLin
 * @Date: 2019-07-31 9:00
 */
@RestController
@RequestMapping("brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * @Description: 查询所有并且分页
     * @params: key
     * @return: result
     * @author: WangJiLin
     * @Date: 2019/7/31
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> result = this.brandService.queryBrandByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * @Description: 新增品牌
     * @params: brand
     * @return:
     * @author: WangJiLin
     * @Date: 2019/7/31
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("categories") List<Long> categories) {
        log.info(categories+"cids---------------------------------------"+brand);
        this.brandService.saveBrand(brand, categories);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * @Description: 修改品牌
     * @params: brand
     * @return:
     * @author: WangJiLin
     * @Date: 2019/8/1
     */
    @PutMapping
    public ResponseEntity<Void> updateBrand(Brand brand,@RequestParam("categories") List<Long> categories){
    //    this.brandService.updateBrand(brand,categories);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
