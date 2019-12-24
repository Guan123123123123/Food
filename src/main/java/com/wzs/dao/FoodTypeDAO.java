package com.wzs.dao;

import com.wzs.entity.FoodType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FoodTypeDAO extends Mapper<FoodType> {

    @Select(" <script> "+
            "select * \n" +
            " from foodtype  where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and typename like concat('%',#{typename},'%') " +
            " </if> "+
            "</script>")
    List<FoodType> queryByName(String typename);
}
