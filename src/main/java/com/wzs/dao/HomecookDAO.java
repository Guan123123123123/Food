package com.wzs.dao;

import com.wzs.entity.Homecook;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HomecookDAO extends Mapper<Homecook> {
    @Select(" <script> "+
            "select * \n" +
            " from homecook where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and homename like concat('%',#{homename},'%') " +
            " </if> "+
            "</script>")
    List<Homecook> queryByName(String homename);
}
