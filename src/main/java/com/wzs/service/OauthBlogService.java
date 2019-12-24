package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.OauthBlogMapper;
import com.wzs.entity.OauthBlog;
import com.wzs.utils.PageDataResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author zhangjiaxun
 * @Description
 * @Date
 **/
@Service
public class OauthBlogService {
    @Resource
    OauthBlogMapper oauthBlogMapper;

    public OauthBlog selectOne(OauthBlog oauthBlog){
        return oauthBlogMapper.selectOne(oauthBlog);
    }

    public int insertSelective(OauthBlog oauthBlog){
        oauthBlog.setId(UUID.randomUUID().toString());
        return oauthBlogMapper.insertSelective(oauthBlog);
    }

    public int updateByPrimaryKeySelective(OauthBlog oauthBlog){
        return oauthBlogMapper.updateByPrimaryKeySelective(oauthBlog);
    }

    /*
     * @author zhangjiaxun
     * @description 最近访客
     */
    public PageDataResult getRecentOauthBlogPageInfo(Integer pageNum,Integer pageSize){
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum,pageSize);
        List<OauthBlog> recentOauthBlogList = oauthBlogMapper.getRecentOauthBlogList();
        PageInfo<OauthBlog> articlePageInfo = new PageInfo<>(recentOauthBlogList);
        pageDataResult.setTotal((int) articlePageInfo.getTotal());
        pageDataResult.setList(recentOauthBlogList);
        return pageDataResult;
    }
}
