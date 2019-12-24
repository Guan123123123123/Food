package com.wzs.dao;

import com.wzs.entity.Knowtype;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface KnowtypeDAO extends Mapper<Knowtype> {
    @Select(" <script> "+
            "select * \n" +
            " from knowtype where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and knowtypename like concat('%',#{knowtypename},'%') " +
            " </if> "+
            "</script>")
    List<Knowtype> queryByName(String knowtypename);
}
