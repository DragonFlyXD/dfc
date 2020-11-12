package com.dragonflyxd.dfcb.components.context.response;

import java.util.List;

/**
 * 分页结果 - 响应
 *
 * @author longfei.chen
 * @since 2020.10.24
 **/
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

    private PageResultResponse(boolean success, String code, String message, T data, int page, int total, int records, List<T> rows) {
        super(success, code, message, data);

        this.page = page;
        this.total = total;
        this.records = records;
        this.rows = rows;
    }

    public static Builder init() {
        return new Builder();
    }

    public static class Builder extends ResultResponse.Builder {
        private static int page;
        private static int total;
        private static int records;

        public Builder page(int page) {
            Builder.page = page;

            return this;
        }

        public Builder total(int total) {
            Builder.total = total;

            return this;
        }

        public Builder records(int records) {
            Builder.total = records;

            return this;
        }

        @Override
        public <T> PageResultResponse<T> build() {
            return new PageResultResponse<>(success, code, message, null, page, total, records, null);
        }

        public <T> PageResultResponse<T> build(List<T> data) {
            return new PageResultResponse<>(success, code, message, null, page, total, records, data);
        }
    }
}