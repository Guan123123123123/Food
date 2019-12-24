package com.wzs.dao;

import com.wzs.entity.Food;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FoodDAO extends Mapper<Food> {
    @Select(" <script> "+
            "select * from food \n" +

            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and foodname like concat('%',#{foodname},'%') " +
            " </if> "+

            "</script>")
    List<Food>queryByName(String foodname);
}
