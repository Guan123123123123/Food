package com.wzs.dao;

import com.wzs.entity.Vip;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface VipDAO extends Mapper<Vip> {
    @Select(" <script> "+
            "select vipid,vipname,vipdian  \n" +
            " from  vip \n" +
            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and vipname like concat('%',#{vipname},'%') " +
            " </if> "+

            "</script>")
List<Vip> queryByName(String vipname);
}
