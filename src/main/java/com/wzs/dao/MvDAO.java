package com.wzs.dao;

import com.wzs.entity.Mv;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MvDAO extends Mapper<Mv> {
    @Select(" <script> "+
            "select * from  mv \n" +

            " where  1=1  " +

            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and aid like concat('%',#{aid},'%') " +
            " </if> "+

            "</script>")
    List<Mv>  queryByName(String aid);


    //按照最新发布时间取指定条数查询
    @Select(" <script> " +
            "select mvid , mvurl , aid, mvbegintime,mvcontent  \n" +
            "from mv order by mvbegintime desc  \n" +
            "limit #{param1}  "+
            "</script>")
    List<Mv>  findByRow(int mvnum);
}
