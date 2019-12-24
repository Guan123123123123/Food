package com.wzs.dao;


import com.wzs.entity.OauthBlog;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OauthBlogMapper extends Mapper<OauthBlog> {

    List<OauthBlog> getRecentOauthBlogList();

}