package com.wzs.dao;

import com.wzs.entity.Account;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AccountDAO extends Mapper<Account> {
    @Select(" <script> "+
            "select * \n" +
            " from account where 1=1 \n" +
            " <if test=\" _parameter != null and _parameter !=''\">" +
            "   and aname like concat('%',#{aname},'%') " +
            " </if> "+
            "</script>")
    List<Account> queryByName(String aname);

    //做登录逻辑
    Map<String,Object> queryById(String aname, String apassword);

    //查询所有
    @Select(" <script> "+
            "select a.aid  as  aid,a.aname  as  aname,a.apassword  as  apassword,a.aimg  as  aimg, \n" +
            "a.aphone  as  aphone,a.accountstate  as  accountstate,a.accountdian  as  accountdian,\n" +
            "a.fensi  as  fensi, a.atime as  atime,a.beginTime  as beginTime,\n" +
            "a.endTime  as  endTime,b.levelsid  as levelsid, b.levelsname   as  levelsname,\n" +
            "b.cooknumber as  cooknumber,c.vipid  as  vipid,c.vipname   as  vipname, \n" +
            "c.vipdian  as  vipdian  from  account a \n" +
            "join levels  b  on a.levelsid = b.levelsid \n" +
            "join vip  c on  a.vipid = c.vipid   where aname= #{param1} and apassword=#{param2}  "+
            " </script>")
    Map<String,Object> findUser(String aname, String apassword);



    //查询电话号 与 用户名是否是唯一标识
    @Select(" <script> "+
            "select * from account  " +
            "<trim prefix='WHERE' prefixOverrides='AND|OR'>" +
            " <if test=\" param1 != null and param1 !=''\">" +
            "   OR  aname = #{param1}   " +
            " </if> "+
            " <if test=\" param2 != null and param2 !=''\">" +
            "  OR   aphone = #{param2}   " +
            " </if> " +
            "</trim>"+
            " </script>")
    List<Account> findUnique(String aname, String aphone);
}
