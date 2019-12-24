package com.wzs.dao;

import com.wzs.entity.Levels;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LevelsDAO extends Mapper<Levels> {
    @Select(" <script> "+
            "select levelsid,levelsname,cooknumber \n" +
            " from  levels \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and levelsname like concat('%',#{levelsname},'%') " +
            " </if> "+

            "</script>")
    List<Levels>queryByName(String levelsname);
}
