package com.wzs.dao;

import com.wzs.entity.Seeme;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SeemeDAO extends Mapper<Seeme> {
    @Select(" <script> "+
            "select seemeid,aid,aid2 \n" +
            " from  seeme \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and aid like concat('%',#{aid},'%') " +
            " </if> "+

            "</script>")
    List<Seeme> queryByName(String aid);
}
