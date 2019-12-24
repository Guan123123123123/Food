package com.wzs.dao;

import com.wzs.entity.Speacecook;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Controller;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpeacecookDAO extends Mapper<Speacecook> {
    @Select(" <script> "+
            "select speaceid,speacename \n" +
            " from  speacecook \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and speacename like concat('%',#{speacename},'%') " +
            " </if> "+

            "</script>")
    List<Speacecook>queryByName(String speacename);
}
