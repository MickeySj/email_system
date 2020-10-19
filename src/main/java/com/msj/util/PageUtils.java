package com.msj.util;


/**
 * @author sj
 * @version 1.0
 * @date 2020/9/24 8:57
 * @desc 分页工具类
 */

public class PageUtils {

    private Integer current;
    private Integer pageSize;
    private Integer recordTotal;
    private Integer pageTotal;

    public PageUtils() {
        this.current = 1;
        this.pageSize = 5;
    }

    public PageUtils(Integer current, Integer pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal) {
        this.recordTotal = recordTotal;
        pageTotal = 1;
        if (recordTotal != 0) {
            int pageTotal = recordTotal % pageSize == 0 ? (recordTotal / pageSize) : ((recordTotal / pageSize) + 1);
            this.setPageTotal(pageTotal);
        }
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    private void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "current=" + current +
                ", pageSize=" + pageSize +
                ", recordTotal=" + recordTotal +
                ", pageTotal=" + pageTotal +
                '}';
    }
}
