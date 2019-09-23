package com.neuedu.service;


import com.alibaba.fastjson.JSONArray;


public interface IProvinceService {

    JSONArray findByLvl(int id);

    JSONArray findByCode(int code);

}
