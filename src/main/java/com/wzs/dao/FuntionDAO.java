package com.wzs.dao;

import com.wzs.entity.Funtion;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FuntionDAO extends Mapper<Funtion> {

    @Select(" <script> "+
            "select * \n" +
            " from funtion where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and funtionname like concat('%',#{funtionname},'%') " +
            " </if> "+
            "</script>")
    List<Funtion> queryByName(String funtionname);
}
