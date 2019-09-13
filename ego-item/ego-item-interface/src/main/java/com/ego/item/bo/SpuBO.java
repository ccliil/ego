package com.ego.item.bo;

import com.ego.item.pojo.Sku;
import com.ego.item.pojo.Spu;
import com.ego.item.pojo.SpuDetail;
import lombok.Data;

import java.util.List;


@Data
public class SpuBO extends Spu {
    private String categoryName;
    private String brandName;

    private List<Sku> skus;
    private SpuDetail spuDetail;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public SpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }
}
