package com.neuedu.mapper;

import com.neuedu.entity.Province;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProvinceMapper {

    @Select("select id,code,name,lvl,parent_code from t_area where lvl=#{lvl}")
    List<Province> findByLvl(int lvl);

    @Select("select id,code,name,lvl,parent_code from t_area where parent_code = #{code}")
    List<Province> findByCode(int code);
}
