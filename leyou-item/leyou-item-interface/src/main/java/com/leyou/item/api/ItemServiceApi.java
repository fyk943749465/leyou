package com.leyou.item.api;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ItemServiceApi {

    /***********************brand*******************************************/
    @GetMapping("brand/{id}")
    public Brand queryBrandById(@PathVariable("id")Long id);
    /***********************brand*******************************************/

    /***********************category*******************************************/
    @GetMapping("category/list")
    public List<Category> queryCategoriesById(@RequestParam(value = "pid", defaultValue = "0")Long pid);

    @GetMapping("category")
    public List<String> queryNamesByIds(@RequestParam("ids")List<Long> ids);
    /***********************category*******************************************/

    /***********************Goods*******************************************/
    @GetMapping("spu/detail/{spuId}")
    public SpuDetail querySpuDetailBySupId(@PathVariable("spuId")Long spuId);

    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    );

    @GetMapping("sku/list")
    public List<Sku> querySkusBySpuId(@RequestParam("id")Long spuId);
    /***********************Goods*******************************************/

    /***********************Specification*******************************************/

    @GetMapping("spec/params")
    public List<SpecParam> queryParams(
            @RequestParam(value = "gid", required = false)Long gid,
            @RequestParam(value = "cid", required = false)Long cid,
            @RequestParam(value = "generic", required = false)Boolean generic,
            @RequestParam(value = "searching", required = false)Boolean searching);
    /***********************Specification*******************************************/

    /***********************VirusInfect*********************************************/
    @GetMapping("virus/infect/page")
    public ResponseEntity<PageResult<VirusInfect>> queryVirusPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "10000") Integer rows
    );
    /***********************VirusInfect*********************************************/
}
