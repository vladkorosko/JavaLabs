package com.vladkorokso.backendlab1.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopAdmin {
    private Long id;
    private String username;
}
