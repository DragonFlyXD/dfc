package com.dragonflyxd.dfcb.components.common.web.response;

import com.dragonflyxd.dfcb.components.common.emuns.ResponseCodeEnum;
import lombok.Data;

import java.util.List;

/**
 * 分页结果 - 响应
 *
 * @author longfei.chen
 * @since 2020.10.24
 **/
@Data
public class PageResultResponse<T> extends ResultResponse<T> {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 总页数
     */
    private int total;
    /**
     * 总记录数
     */
    private int records;
    /**
     * 记录值
     */
    private List<T> rows;

    public PageResultResponse() {
        super();
    }

    public PageResultResponse(String code, String message) {
        super(code, message);
    }

    public PageResultResponse(boolean success, String code, String message) {
        super(success, code, message);
    }

    public PageResultResponse(int page, int total, int records, List<T> rows) {
        super(true, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage());
        this.page = page;
        this.total = total;
        this.records = records;
        this.rows = rows;
    }
}