package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.VirusInfectMapper;
import com.leyou.item.pojo.VirusInfect;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class VirusInfectService {


    @Autowired
    private VirusInfectMapper virusInfectMapper;

    public PageResult<VirusInfect> queryVirusInfectByPage(String key, Boolean saleable, Integer page, Integer rows) {

        Example example = new Example(VirusInfect.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("title", "%" + key + "%");
        }

        if (saleable != null) {
            criteria.andEqualTo("saleable", saleable);
        }

        PageHelper.startPage(page, rows);

        List<VirusInfect> virusInfects = this.virusInfectMapper.selectByExample(example);

        return new PageResult<>((long)virusInfects.size(), virusInfects);

    }
}
