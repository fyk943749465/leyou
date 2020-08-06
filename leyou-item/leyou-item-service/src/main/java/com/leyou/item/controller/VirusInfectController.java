package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.VirusInfect;
import com.leyou.item.service.VirusInfectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("virus")
public class VirusInfectController {


    @Autowired
    private VirusInfectService virusInfectService;

    @GetMapping("infect/page")
    public ResponseEntity<PageResult<VirusInfect>> queryVirusPage(
        @RequestParam(value = "key", required = false) String key,
        @RequestParam(value = "saleable", required = false) Boolean saleable,
        @RequestParam(value = "page", defaultValue = "1")Integer page,
        @RequestParam(value = "rows", defaultValue = "10000") Integer rows
    ) {
        PageResult<VirusInfect> result = this.virusInfectService.queryVirusInfectByPage(key, saleable, page, rows);
        if (result == null || CollectionUtils.isEmpty(result.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
