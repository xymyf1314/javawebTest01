package com.neuedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private Integer id;
    private String code;
    private String name;
    private Integer lvl;
    private String parent_code;
}
