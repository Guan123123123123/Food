package com.wzs.dao;

import com.wzs.entity.Cookbook;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CookbookDAO extends Mapper<Cookbook> {
    @Select(" <script> "+
            "select * \n" +
            " from cookbook where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and cookname like concat('%',#{cookname},'%') " +
            " </if> "+
            "</script>")
    List<Cookbook> queryByName(String cookname);
}
