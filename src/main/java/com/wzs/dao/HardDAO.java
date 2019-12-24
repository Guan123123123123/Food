package com.wzs.dao;

import com.wzs.entity.Hard;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HardDAO extends Mapper<Hard> {
    @Select(" <script> "+
            "select * \n" +
            " from hard where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and hardname like concat('%',#{hardname},'%') " +
            " </if> "+
            "</script>")
    List<Hard> queryByName(String hardname);
}
