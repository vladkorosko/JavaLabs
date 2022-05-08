package com.vladkorokso.backendlab1.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopGoods {
    private Long id;
    private String name;
    private Long price;
    private Long count;
}
