package com.vladkorokso.backendlab1.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopClient {
    private Long id;
    private String username;
    private Long amount;
}
