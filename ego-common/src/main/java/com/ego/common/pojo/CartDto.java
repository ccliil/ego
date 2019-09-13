package com.ego.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long skuId;  //商品skuId

    private Integer num;  //购买数量

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
    public Long getSkuId() {
        return skuId;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}
