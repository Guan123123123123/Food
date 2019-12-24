package com.wzs.controller;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.wzs.entity.*;
import com.wzs.service.*;
import com.wzs.utils.PageData;
import com.wzs.utils.VideoImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("food")
public class FoodController {

    @Resource
    AccountService  accountService;
    @Resource
    OauthBlogService oauthBlogService;

    @RequestMapping("/qqLoginCallBack")
    public String qqLoginCallBack(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {//qq登录回调
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = null;
            String openID = null;
            long tokenExpireIn = 0L;
            System.out.println("111111111111111");
            System.out.println("accessTokenObj = " + accessTokenObj);
            System.out.println("====================");
            if (accessTokenObj.getAccessToken().equals("")) {//进到这里了
                System.out.println("没有获取到响应参数");//我们的网站被CSRF攻击了或者用户取消了授权,做一些数据统计工作
            } else {
                accessToken = accessTokenObj.getAccessToken();
                System.out.println("====================");
                System.out.println("tokenExpireIn = " + tokenExpireIn);
                tokenExpireIn = accessTokenObj.getExpireIn();
                System.out.println("tokenExpireIn = " + tokenExpireIn);
                System.out.println("====================");
                OpenID openIDObj =  new OpenID(accessToken);// 利用获取到的accessToken 去获取当前用的openid
                openID = openIDObj.getUserOpenID();
                System.out.println("openID = " + openID);
                System.out.println("====================");
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);// 利用获取到的accessToken 去获取当前用户的openid
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();

                if (userInfoBean.getRet() == 0) {
                    String nickName = userInfoBean.getNickname();
                    String gender = userInfoBean.getGender();
                    String avatarURL100 = userInfoBean.getAvatar().getAvatarURL100();

                    OauthBlog oauthBlog = new OauthBlog();

                    oauthBlog.setOauthId(openID);
                    OauthBlog isExist = oauthBlogService.selectOne(oauthBlog);
                    System.out.println("what is  it!");
                    System.out.println("isExist = " + isExist);
                    if (isExist == null){
                        oauthBlog.setOauthType("qq");
                        oauthBlog.setOauthAccessToken(accessToken);
                        oauthBlog.setOauthExpires(String.valueOf(tokenExpireIn));
                        oauthBlog.setOauthNickname(nickName);
                        oauthBlog.setOauthGender(gender);
                        oauthBlog.setOauthAvatar(avatarURL100);

                        /*
                         * QQ头一次登录给与帐号和密码，并存入session
                         *
                         */

                        Account account1 =new Account();
                        account1.setAccountdian(0);
                        account1.setAccountstate(0);
                        account1.setFensi(0);
                        account1.setVipid(0);
                        account1.setLevelsid(0);
                        account1.setAimg(avatarURL100);
                        //打卡时间和会员时间默认为空
                        //account1.setAtime();
                        //account1.setBeginTime();
                        //account1.setEndTime();

                        account1.setAname(nickName);
                        account1.setApassword("123");
                        int i=accountService.add(account1);
                        System.out.println("i = " + i);
                        Map<String, Object> account = accountService.queryById(nickName, "123");
                        session.setAttribute("account",account);
                        oauthBlog.setAid((Integer) account.get("aid"));
                        System.out.println("account = " + account);
                        System.out.println("oauthBlog = " + oauthBlog);
                        oauthBlogService.insertSelective(oauthBlog);
                        session.setAttribute("oauth",oauthBlog);
                    }else {
                        isExist.setOauthAccessToken(accessToken);
                        isExist.setOauthExpires(String.valueOf(tokenExpireIn));
                        isExist.setOauthNickname(nickName);
                        isExist.setOauthGender(gender);
                        isExist.setOauthAvatar(avatarURL100);
                        oauthBlogService.updateByPrimaryKeySelective(isExist);
                        /*
                         * 不是头一次登录直接将信息存入session
                         * */

                        Map<String, Object> account = accountService.queryById(nickName, "123");
                        session.setAttribute("account",account);
                        session.setAttribute("oauth",isExist);
                    }


                } else {
                    System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }

            }
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        ///*
        //     account.setStatus(0);
        //        System.out.println("account = " + account);
        //        int i=accountService.add(account);
        // */
        //回调 到注册页面进行绑定

        return  "success";
        //return "redirect:/blog/article";
        //return "/account/add";
        //return "redirect:"+session.getAttribute("beforLoginUrl")+"";
        //System.out.println("6666666666666666");
        //return "font/main";
    }
    @Resource
    FoodService foodService;
    @Resource
    FoodTypeService foodTypeService;
    @Resource
    FuntionService funtionService;

    //反回查询页面
    @RequestMapping("showfood")
    public String show(){
        return "back/Food/FoodShow";
    }
    //添加
    @RequestMapping("add1")
    public String add(Model model){
        List<FoodType> foodType =foodTypeService.findAll();
        model.addAttribute("foodType",foodType);
        List<Funtion> funtion = funtionService.findAll();
        model.addAttribute("funtion",funtion);

        return "back/Food/FoodAdd";
    }

    String img="";

    @RequestMapping("/upload")
    @ResponseBody
    public Integer fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, Model model){
        System.out.println(" = =========图片上传进来了=====" );
        //上传成功会收到文件名
        String s = VideoImgUtil.helper_V_I(file, req,1);
        if (s.equals("0")){
            System.out.println("上传失败");
        }
        System.out.println("文件名====》"+s);
        //赋值
        img=s;
        Integer code=0;
        return code;
    }
    //添加页面
    @RequestMapping("foodAdd")
    @ResponseBody
    public int LevelsAdd(Food food){
        System.out.println("food = 添加");
        System.out.println("levels--------------->"+food);
        String  url="/img/"+img;
        food.setFoodimg(url);
        int add=foodService.add(food);
        return add;
    }
    //修改查询
    @RequestMapping("Update")
    public String update1(int fid, Model model){
        System.out.println("============================+--");
        System.out.println("foodid="+fid);
        Food food=foodService.findOne(fid);
        System.out.println("one==>" +food);
        model.addAttribute("food",food);
        return "back/Food/FoodUpdate";
    }

    @RequestMapping("foodUpdate")
    @ResponseBody
    public int levelsUpdate(Food food) {
        System.out.println("levels = " + food);
        int upt = foodService.upd(food);
        return upt;
    }
    @RequestMapping("show")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Food> byPage = foodService.findByPage(page, limit, name);


        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }


    @RequestMapping("del")
    @ResponseBody
    public int del(int fid) {
        int del = foodService.del(fid);
        return del;
    }
}
