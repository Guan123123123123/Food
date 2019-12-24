package com.wzs.dao;

import com.wzs.entity.Know;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface KnowDAO extends Mapper<Know> {
    @Select(" <script> "+
            "select *  \n" +
            " from know ko inner join knowtype kt \n" +
            " where kt.knowtypeid=ko.knowtypeid " +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and knowname like concat('%',#{knowname},'%') " +
            " </if> "+
            "</script>")
    List<Know> queryByName(String knowname);

    @Select("select * from knowtype")
    List<Map<String,Object>> findA();
}
