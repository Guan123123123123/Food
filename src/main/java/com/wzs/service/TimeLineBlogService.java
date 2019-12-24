package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.TimeLineBlogMapper;
import com.wzs.entity.TimeLineBlog;
import com.wzs.utils.PageDataResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangjiaxun
 * @Description
 * @Date
 **/
@Service
public class TimeLineBlogService {
    @Resource
    TimeLineBlogMapper timeLineBlogMapper;

    public TimeLineBlog selectOne(TimeLineBlog timeLineBlog){
        return timeLineBlogMapper.selectOne(timeLineBlog);
    }

    public PageDataResult getTimeLineBlogPageInfo(Integer pageNum, Integer pageSize, TimeLineBlog timeLineBlog){
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<TimeLineBlog> timeLineList = timeLineBlogMapper.getTimeLineBlogList(timeLineBlog);
        PageInfo<TimeLineBlog> articlePageInfo = new PageInfo<>(timeLineList);
        pageDataResult.setTotal((int) articlePageInfo.getTotal());
        pageDataResult.setList(timeLineList);
        return pageDataResult;
    }

    public int insertSelective(TimeLineBlog timeLineBlog){
       /* User user = (User) SecurityUtils.getSubject().getPrincipal();
        timeLineBlog.setId(UUID.randomUUID().toString());
        timeLineBlog.setCreateBy(user.getId().toString());
        timeLineBlog.setCreateDate(new Date());
        timeLineBlog.setUpdateBy(user.getId().toString());
        timeLineBlog.setUpdateDate(new Date());*/
        return timeLineBlogMapper.insertSelective(timeLineBlog);
    }

    public int updateByPrimaryKeySelective(TimeLineBlog timeLineBlog){
       /* User user = (User) SecurityUtils.getSubject().getPrincipal();
        timeLineBlog.setUpdateBy(user.getId().toString());
        timeLineBlog.setUpdateDate(new Date());*/
        return timeLineBlogMapper.updateByPrimaryKeySelective(timeLineBlog);
    }

    public Map<String,Object> getTimeLineListByYear(){
        HashMap<String, Object> resultMap = new HashMap<>();
        //1、查询所有年的集合
        List<Map<String, String>> yearList = timeLineBlogMapper.getYearList();

        //2、遍历并按年封装数据
        if (yearList.size() > 0){
            for (Map<String, String> theYear : yearList) {
                String year = theYear.get("year");
                List<TimeLineBlog> listByYear = timeLineBlogMapper.getTimeLineListByYear(year);
                resultMap.put(year,listByYear);
            }
        }

        return resultMap;
    }
}
