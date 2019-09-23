package com.neuedu.service.serviceimpl;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.Province;
import com.neuedu.mapper.ProvinceMapper;
import com.neuedu.service.IProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements IProvinceService {
    private ProvinceMapper mapper;

    public ProvinceServiceImpl(ProvinceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JSONArray findByLvl(int lvl) {
        JSONArray jsonArray = new JSONArray();
        List<Province> byLvl = mapper.findByLvl(lvl);
        jsonArray.addAll(byLvl);
        return jsonArray;
    }

    @Override
    public JSONArray findByCode(int code) {
        JSONArray jsonArray = new JSONArray();
        List<Province> byCode = mapper.findByCode(code);
        jsonArray.addAll(byCode);
        return jsonArray;
    }
}
