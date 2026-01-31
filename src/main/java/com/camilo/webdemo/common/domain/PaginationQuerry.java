package com.camilo.webdemo.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationQuerry {
    private int page;
    private int size;
    private String sortBy;
    private String direction;
}
