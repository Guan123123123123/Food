package com.wzs.dao;

import com.wzs.entity.Proces;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProcesDAO extends Mapper<Proces> {
    @Select(" <script> "+
            "select  procesid,procesname  \n" +
            " from  proces \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and procesname like concat('%',#{procesname},'%') " +
            " </if> "+

            "</script>")
    List<Proces>queryByName(String procesname);
}
