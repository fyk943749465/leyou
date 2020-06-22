package com.leyou.item.bo;

import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpuBo extends Spu {

    private String cname;

    private String bname;

    private SpuDetail spuDetail;

    private List<Sku> skus;
}
