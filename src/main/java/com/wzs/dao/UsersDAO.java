package com.wzs.dao;

import com.wzs.entity.Users;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UsersDAO extends Mapper<Users> {
    @Select(" <script> "+
            "select * \n" +
            " from users  where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and uname like concat('%',#{uname},'%') " +
            " </if> "+
            "</script>")
    List<Users> queryByName(String uname);

    Map<String,Object> query(String uname, String upassword);

}
