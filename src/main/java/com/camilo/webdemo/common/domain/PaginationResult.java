package com.camilo.webdemo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResult<T> {
    private List<T> content;
    private int page;
    private int totalPage;
    private int size;
    private long totalElement;

}
