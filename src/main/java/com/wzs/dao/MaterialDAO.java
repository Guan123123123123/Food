package com.wzs.dao;

import com.wzs.entity.Material;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MaterialDAO extends Mapper<Material> {
    @Select(" <script> "+
            "select * \n" +
            " from material  where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and materialname like concat('%',#{materialname},'%') " +
            " </if> "+
            "</script>")
    List<Material> queryByName(String materialname);


    //按照菜谱id查询所有配料
    @Select(" <script> "+
            "select * from material where cookid=#{param1}"+
            "</script>")
    List<Material> findBycookid(int cookid);
}
