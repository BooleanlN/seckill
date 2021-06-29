package cn.whu.utils;

import java.util.List;

/**
 * @author snow
 * @className PagedGridResult
 * @date 2021/6/28
 **/
public class PagedGridResult {
    private Integer page; // 当前页数
    private long total; // 总页数
    private long records; // 记录条数
    //无边界通配符
    private List<?> rows; // 每行显示内容

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
