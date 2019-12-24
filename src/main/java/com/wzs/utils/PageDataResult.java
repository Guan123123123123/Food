package com.wzs.utils;

import java.util.List;

/**
 *
 * @类名称：PageDateResult
 * @类描述：封装DTO分页数据（记录数和所有记录）
 */
public class PageDataResult {

    //总记录数量
    private Integer total;
    //当前页数据列表
    private List<?> list;

    private Integer code=200;

    public PageDataResult() {
    }

    public PageDataResult(Integer total,
                          List<?> list) {
        this.total = total;
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "PageDataResult{" +
                "total=" + total +
                ", code=" + code +
                '}';
    }
}
