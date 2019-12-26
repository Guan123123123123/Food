package com.wzs.dao;


import com.wzs.entity.Cookbook;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface FrontDAO extends Mapper<Cookbook> {
    //显示全部菜谱
    @Select("<script>" +
            "select \n" +
            "a1.cookid cookid,a1.cookname cookname,a1.cooknumber cooknumber,\n" +
            "a1.readlytime readlytime,a1.worktime worktime,a1.cookcontent cookcontent,\n" +
            "a1.cookstate cookstate,a1.viplevel viplevel,a1.cookimg cookimg,\n" +
            "a2.speaceid speaceid,a2.speacename speacename,a3.procesid procesid,a3.procesname procesname,\n" +
            "a4.tasteid tasteid,a4.tastename tastename,a5.hardid hardid,a5.hardname hardname,\n" +
            "a6.styleid styleid,a6.stylename stylename,a6.styleflag styleflag,\n" +
            "a7.homeid homeid,a7.homename homename,a8.aid aid,a8.aname aname,\n" +
            "a8.apassword apassword,a8.aimg aimg,a8.accountstate accountstate,\n" +
            "a8.accountdian accountdian,a8.vipid vipid,a8.levelsid levelsid,\n" +
            "a8.fensi fensi,a8.atime atime,a8.beginTime beginTime,a8.endTime endTime\n" +
            "from \n" +
            "cookbook a1 left join \n" +
            "speacecook a2 on a1.speaceid = a2.speaceid left join \n" +
            "proces a3 on a1.procesid = a3.procesid left join \n" +
            "taste a4 on a1.tasteid = a4.tasteid left join \n" +
            "hard a5 on  a1.hardid = a5.hardid left join \n" +
            "cookstyle a6 on a1.styleid = a6.styleid left join \n" +
            "homecook a7 on a1.homeid=a7.homeid left join \n" +
            "account a8 on  a1.aid = a8.aid \n" +
            "where a1.cookstate=0 "+
            "</script>"
            )
             List<Map<String,Object>> findAll8();

    //显示全部按照id查询
    @Select("<script>" +
            "select \n" +
            "a1.cookid cookid,a1.cookname cookname,a1.cooknumber cooknumber,\n" +
            "a1.readlytime readlytime,a1.worktime worktime,a1.cookcontent cookcontent,\n" +
            "a1.cookstate cookstate,a1.viplevel viplevel,a1.cookimg cookimg,\n" +
            "a2.speaceid speaceid,a2.speacename speacename,a3.procesid procesid,a3.procesname procesname,\n" +
            "a4.tasteid tasteid,a4.tastename tastename,a5.hardid hardid,a5.hardname hardname,\n" +
            "a6.styleid styleid,a6.stylename stylename,a6.styleflag styleflag,\n" +
            "a7.homeid homeid,a7.homename homename,a8.aid aid,a8.aname aname,\n" +
            "a8.apassword apassword,a8.aimg aimg,a8.accountstate accountstate,\n" +
            "a8.accountdian accountdian,a8.vipid vipid,a8.levelsid levelsid,\n" +
            "a8.fensi fensi,a8.atime atime,a8.beginTime beginTime,a8.endTime endTime\n" +
            "from \n" +
            "cookbook a1 left join \n" +
            "speacecook a2 on a1.speaceid = a2.speaceid left join \n" +
            "proces a3 on a1.procesid = a3.procesid left join \n" +
            "taste a4 on a1.tasteid = a4.tasteid left join \n" +
            "hard a5 on  a1.hardid = a5.hardid left join \n" +
            "cookstyle a6 on a1.styleid = a6.styleid left join \n" +
            "homecook a7 on a1.homeid=a7.homeid left join \n" +
            "account a8 on  a1.aid = a8.aid \n" +
            "where a1.cookstate=0 \n" +
            " <if test=\" param1 != null and param1 !=0\">" +
            "  and a1.cookid=#{param1}   " +
            " </if> "+
            " <if test=\" param2 != null and param2 !=0\">" +
            "  and a2.speaceid=#{param2}   " +
            " </if> "+
            " <if test=\" param3 != null and param3 !=0\">" +
            "  and a3.procesid=#{param3}   " +
            " </if> "+
            " <if test=\" param4 != null and param4 !=0\">" +
            "  and a4.tasteid=#{param4}   " +
            " </if> "+
            " <if test=\" param5 != null and param5 !=0\">" +
            "  and a5.hardid=#{param5}   " +
            " </if> "+
            " <if test=\" param6 != null and param6 !=0\">" +
            "  and a6.styleid=#{param6}   " +
            " </if> "+
            " <if test=\" param7 != null and param7 !=0\">" +
            "  and a7.homeid=#{param7}   " +
            " </if> "+
            " <if test=\" param8 != null and param8 !=0\">" +
            "  and a8.aid=#{param8}   " +
            " </if> "+
            " </script>")
            List<Map<String,Object>> findAll8ByAllId(Integer cookid, Integer speaceid, Integer procesid,
                                                     Integer tasteid, Integer hardid, Integer styleid, Integer homeid,Integer aid);


    //显示最新发布五个菜谱
    @Select("<script>" +
            "select \n" +
            "a1.cookid cookid,a1.cookname cookname,a1.cooknumber cooknumber,\n" +
            "a1.readlytime readlytime,a1.worktime worktime,a1.cookcontent cookcontent,\n" +
            "a1.cookstate cookstate,a1.viplevel viplevel,a1.cookimg cookimg,\n" +
            "a2.speaceid speaceid,a2.speacename speacename,a3.procesid procesid,a3.procesname procesname,\n" +
            "a4.tasteid tasteid,a4.tastename tastename,a5.hardid hardid,a5.hardname hardname,\n" +
            "a6.styleid styleid,a6.stylename stylename,a6.styleflag styleflag,\n" +
            "a7.homeid homeid,a7.homename homename,a8.aid aid,a8.aname aname,\n" +
            "a8.apassword apassword,a8.aimg aimg,a8.accountstate accountstate,\n" +
            "a8.accountdian accountdian,a8.vipid vipid,a8.levelsid levelsid,\n" +
            "a8.fensi fensi,a8.atime atime,a8.beginTime beginTime,a8.endTime endTime\n" +
            "from \n" +
            "cookbook a1 left join \n" +
            "speacecook a2 on a1.speaceid = a2.speaceid left join \n" +
            "proces a3 on a1.procesid = a3.procesid left join \n" +
            "taste a4 on a1.tasteid = a4.tasteid left join \n" +
            "hard a5 on  a1.hardid = a5.hardid left join \n" +
            "cookstyle a6 on a1.styleid = a6.styleid left join \n" +
            "homecook a7 on a1.homeid=a7.homeid left join \n" +
            "account a8 on  a1.aid = a8.aid \n " +
            "where a1.cookstate=0  " +
            " order by readlytime desc    " +
            "  limit 5  "+
            "</script>  "
    )
    List<Map<String,Object>> findLimit5();

    //显示所有食材单品及疗效，功能
    @Select("<script>" +
            "select a.fid as fid,a.foodname as foodname,\n" +
            "a.foodnametwo as foodnametwo,a.advice as advice,\n" +
            "a.okpeople as okpeople,a.onpeople as onpeople,\n" +
            "a.foodimg as foodimg,b.typeid as typeid,\n" +
            "b.typename as typename,c.funtionid as funtionid,\n" +
            "c.funtionname as funtionname from food as a left join \n" +
            "foodtype as b on a.typeid = b.typeid left join\n" +
            "funtion as c on a.funtionid = c.funtionid" +
            "</script>  "
    )
    List<Map<String,Object>> findfoodAll();

    //查询出指定食材对应的菜谱
    @Select("<script>" +
            "select  \n" +
            "a1.cookid cookid,a1.cookname cookname,a1.cooknumber cooknumber, \n" +
            "a1.readlytime readlytime,a1.worktime worktime,a1.cookcontent cookcontent, \n" +
            "a1.cookstate cookstate,a1.viplevel viplevel,a1.cookimg cookimg, \n" +
            "a2.speaceid speaceid,a2.speacename speacename,a3.procesid procesid,a3.procesname procesname, \n" +
            "a4.tasteid tasteid,a4.tastename tastename,a5.hardid hardid,a5.hardname hardname, \n" +
            "a6.styleid styleid,a6.stylename stylename,a6.styleflag styleflag, \n" +
            "a7.homeid homeid,a7.homename homename,a8.aid aid,a8.aname aname, \n" +
            "a8.apassword apassword,a8.aimg aimg,a8.accountstate accountstate, \n" +
            "a8.accountdian accountdian,a8.vipid vipid,a8.levelsid levelsid, \n" +
            "a8.fensi fensi,a8.atime atime,a8.beginTime beginTime,a8.endTime endTime \n" +
            "from  \n" +
            "cookbook a1 left join  \n" +
            "speacecook a2 on a1.speaceid = a2.speaceid left join  \n" +
            "proces a3 on a1.procesid = a3.procesid left join  \n" +
            "taste a4 on a1.tasteid = a4.tasteid left join  \n" +
            "hard a5 on  a1.hardid = a5.hardid left join  \n" +
            "cookstyle a6 on a1.styleid = a6.styleid left join  \n" +
            "homecook a7 on a1.homeid=a7.homeid left join  \n" +
            "account a8 on  a1.aid = a8.aid  \n" +
            "where a1.cookstate=0 \n" +
            "and a1.cookid in(\n" +
            "select cookbook.cookid from cookbook left join material\n" +
            " on cookbook.cookid= material.cookid \n" +
            "where material.materialname=#{param1} group by cookbook.cookid \n" +
            ")\n" +
            "</script>")
    List<Map<String,Object>> findfoodAllByMaterialname(String name);


    @Select("  select id,titile,contents,fkid from repaly where fkid=#{param1} ")
    List<Map<String,Object>>  findReplayById(int fkid);

}
