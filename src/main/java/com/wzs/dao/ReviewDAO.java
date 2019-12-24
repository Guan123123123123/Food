package com.wzs.dao;

import com.wzs.entity.Review;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ReviewDAO extends Mapper<Review> {
    @Select(" <script> "+
            "select * \n" +
            " from review  where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and content like concat('%',#{content},'%') " +
            " </if> "+
            "</script>")
    List<Review> queryByName(String content);
}
