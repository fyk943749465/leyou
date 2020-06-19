package com.leyou.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResult<T> {

    private Long total;

    private Integer totalPage;

    private List<T> items;

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
