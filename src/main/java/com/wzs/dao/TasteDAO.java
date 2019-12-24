package com.wzs.dao;

import com.wzs.entity.Taste;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TasteDAO extends Mapper<Taste> {
    @Select(" <script> "+
            "select tasteid,tastename  \n" +
            " from  taste \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and tastename like concat('%',#{tastename},'%') " +
            " </if> "+

            "</script>")
    List<Taste> queryByName(String tastename);
}
