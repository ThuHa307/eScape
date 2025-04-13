package com.example.eScape.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryInfo {
    private int pageNumber;
    private int pageSize;
    private String searchText;
    private String orderBy;
    private String whereClause;
}
