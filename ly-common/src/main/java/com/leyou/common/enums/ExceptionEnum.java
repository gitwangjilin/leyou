package com.leyou.common.enums;

import lombok.Getter;

/**
 * Description:
 * 枚举返回状态
 *
 * @author: WangJiLin
 * @Date: 2019-08-01 9:22
 */
@Getter
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400, "价格不能为空！"),
    CAREGORY_NOT_FOND(404,"商品分类没查到！"),
    BRAND_SAVE_ERROR(500,"新增品牌失败！"),
    UPLOAD_FILE_ERROR(500,"文件上传失败！"),
    INVALID_FILE_TYPE(400,"无效文件类型！")
    ;
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    ExceptionEnum() {
    }
}
