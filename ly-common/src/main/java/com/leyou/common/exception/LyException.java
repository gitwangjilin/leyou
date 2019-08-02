package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;

/**
 * Description:
 *
 * @author: WangJiLin
 * @Date: 2019-08-01 9:25
 */
public class LyException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public LyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
    public LyException() {
    }
}