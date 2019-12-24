package com.wzs.dao;

import com.wzs.entity.TimeLineBlog;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TimeLineBlogMapper extends Mapper<TimeLineBlog> {

    List<TimeLineBlog> getTimeLineBlogList(TimeLineBlog timeLineBlog);

    List<Map<String,String>> getYearList();

    List<TimeLineBlog> getTimeLineListByYear(@Param(value = "year") String year);
}