package com.leyou.common.pojo;

import com.leyou.common.enums.ExceptionEnum;

/**
 * Description:
 *
 * @author: WangJiLin
 * @Date: 2019-08-01 9:20
 */
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult (ExceptionEnum em){
        this.status=em.getCode();
        this.message=em.getMsg();
        this.timestamp=System.currentTimeMillis();
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}