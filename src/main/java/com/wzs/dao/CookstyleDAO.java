package com.wzs.dao;

import com.wzs.entity.Cookstyle;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CookstyleDAO extends Mapper<Cookstyle> {
    @Select(" <script> "+
            "select styleid,stylename,styleflag \n" +
            "            from cookstyle where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and stylename like concat('%',#{stylename},'%') " +
            " </if> "+
            "</script>")
    List<Cookstyle> queryByName(String Stylename);

    //查询外国菜 的菜系前5个 cookstyle
    @Select(" <script> "+
            " select styleid,stylename,styleflag  \n" +
            " from cookstyle where styleflag = 2 limit 5 "+
            "</script>")
    List<Cookstyle> queryBylimit5();
}
