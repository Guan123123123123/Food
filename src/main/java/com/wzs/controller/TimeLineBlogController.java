package com.wzs.controller;


import com.wzs.dao.TimeLineBlogMapper;
import com.wzs.entity.TimeLineBlog;
import com.wzs.service.TimeLineBlogService;
import com.wzs.utils.PageDataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Author zhangjiaxun
 * @Description
 * @Date
 **/
@Controller
@RequestMapping("/timeLineBlog")
public class TimeLineBlogController {
    @Resource
    TimeLineBlogService timeLineBlogService;

    @Resource
    TimeLineBlogMapper timeLineBlogMapper;

    @RequestMapping("/timeLineListPage")
    public ModelAndView sortArticleListPage(){//时间线列表页面
        ModelAndView mav = new ModelAndView("system/timeLineListPage");
        return mav;
    }

    @RequestMapping("/getTimeLinePageInfo")
    @ResponseBody
    public PageDataResult getArticlePageInfo(@Param(value = "page") Integer page,
                                             @Param(value = "limit") Integer limit,
                                             TimeLineBlog timeLineBlog){//获取分类列表数据
        PageDataResult articleBlogPageInfo = timeLineBlogService.getTimeLineBlogPageInfo(page, limit, timeLineBlog);
        return articleBlogPageInfo;
    }

    @RequestMapping("/editTimeLine")
    @ResponseBody
    public TimeLineBlog editTimeLine(TimeLineBlog timeLineBlog){//编辑时间线
        TimeLineBlog timeLine = timeLineBlogService.selectOne(timeLineBlog);
        return timeLine;
    }

    @RequestMapping("/saveInfo")
    @ResponseBody
    public String saveInfo(TimeLineBlog timeLineBlog){
        String code = "200";

        String Id = timeLineBlog.getId();
        if (""==timeLineBlog.getId() || null==timeLineBlog.getId()){
            timeLineBlogService.insertSelective(timeLineBlog);
        }else {
            timeLineBlogService.updateByPrimaryKeySelective(timeLineBlog);
        }

        return code;
    }
}
