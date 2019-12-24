package com.wzs.service;

import com.wzs.dao.FrontDAO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FrontService {
    @Resource
    FrontDAO frontDAO;

    //查询全部
    public List<Map<String,Object>> findAll8(){
        return frontDAO.findAll8();
    }

    //显示八张全部按照id查询
    public List<Map<String,Object>> findAll8ByAllId(Integer cookid,Integer speaceid,Integer procesid,
                                           Integer tasteid,Integer hardid,Integer styleid,Integer homeid,Integer aid){
        return frontDAO.findAll8ByAllId(cookid,speaceid,procesid,tasteid,hardid,styleid,homeid ,aid);
    }
    //显示最新发布五个菜谱
    public List<Map<String,Object>> findLimit5(){
        return frontDAO.findLimit5();
    }


    //显示所有食材单品及疗效，功能
    public List<Map<String,Object>> findfoodAll(){
        return frontDAO.findfoodAll();
    }


}
