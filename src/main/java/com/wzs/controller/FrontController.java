package com.wzs.controller;

import com.wzs.entity.*;
import com.wzs.service.*;
import com.wzs.utils.MD5Code;
import com.wzs.utils.VideoImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("front")
public class FrontController {
    @Resource
    ProcesService procesService;
    @Resource
    TeasteService teasteService;
    @Resource
    HardService hardService;
    @Resource
    CookstyleService cookstyleService;
    @Resource
    HomecookService homecookService;
    @Resource
    SpeacecookService speacecookService;
    @Resource
    CookbookService cookbookService;
    @Resource
    FrontService frontService ;
    @Resource
    MaterialService materialService;  //食材明细
    @Resource
    MvService mvService; //视频
    @Resource
    AccountService accountService;

    String img=""; //记录一下上传的图片名称


    @RequestMapping("/index")
    public String index(){
        return  "front/index";
    }
    @RequestMapping("/head")
    public String head(){
        return  "head";
    }

    @Resource
    TimeLineBlogService  timeLineBlogService;

    @RequestMapping("/timeLine")
    public ModelAndView timeLine(){
        ModelAndView mav = new ModelAndView("front/timeLine");
        //按年分类并
        Map<String, Object> listByYear = timeLineBlogService.getTimeLineListByYear();
        mav.addObject("listByYear",listByYear);
        return mav;
    }




    //菜谱筛选
    @RequestMapping("detailMenuSearch")
    public String detailMenuSearch(Integer cookid,Integer speaceid,Integer procesid,
                                   Integer tasteid,Integer hardid,Integer styleid,Integer homeid,Model model){
      System.out.println("所有值==》"+cookid+"=="+speaceid+"=="+ procesid+"=="+tasteid+"=="+hardid+"=="+styleid+"=="+ homeid);
        List<Map<String, Object>> all8ByAllId = frontService.findAll8ByAllId(cookid, speaceid, procesid, tasteid, hardid, styleid, homeid,0);
        System.out.println(all8ByAllId);
        List<Proces> list1 = procesService.findAll();
        List<Taste>  list2 = teasteService.findAll();
        List<Hard> list3 = hardService.findAll();
        List<Cookstyle> list4 = cookstyleService.findAll();
        List<Homecook> list5 = homecookService.findAll();
        List<Speacecook> list6 = speacecookService.findAll();
        //记录下点了什么类型方便前台样式同时更改
        Map mark1 = new HashMap();
        if (homeid!=0){
            mark1.put("foodsearch5",homeid);
        }if (speaceid!=0){
            mark1.put("foodsearch6",speaceid);
        }if (procesid!=0){
            mark1.put("foodsearch1",procesid);
        }if (tasteid!=0){
            mark1.put("foodsearch2",tasteid);
        }if (hardid!=0){
            mark1.put("foodsearch3",hardid);
        }if (styleid!=0){
            mark1.put("foodsearch4",styleid);
        }
        model.addAttribute("list1",list1);
        model.addAttribute("list2",list2);
        model.addAttribute("list3",list3);
        model.addAttribute("list4",list4);
        model.addAttribute("list5",list5);
        model.addAttribute("list6",list6);
        model.addAttribute("list7",all8ByAllId);
        model.addAttribute("map1",mark1);
        return  "front/gallery";
    }

    //菜谱筛选部分跳转
    @RequestMapping("detailMenuSearchJson")
    @ResponseBody
    public List<Map<String, Object>> detailMenuSearchJson(Integer cookid, Integer speaceid, Integer procesid,
                                                          Integer tasteid, Integer hardid, Integer styleid, Integer homeid){
        return  frontService.findAll8ByAllId(cookid, speaceid, procesid, tasteid, hardid, styleid, homeid,0);
    }


    //单个菜谱明细
    @RequestMapping("blog-single")
    public ModelAndView gallery_single(Integer cookid, Integer speaceid, Integer procesid,
                                       Integer tasteid, Integer hardid, Integer styleid, Integer homeid, Model model){
        ModelAndView modelAndView = new ModelAndView("front/blog-single");
        List<Map<String, Object>> all8ByAllId = frontService.findAll8ByAllId(cookid, speaceid, procesid, tasteid, hardid, styleid, homeid,0);
        modelAndView.addObject("cookbookMap",all8ByAllId);
        //查询当前发表此菜谱的用户对应的其他菜谱
        List<Map<String, Object>> cp = frontService.findAll8ByAllId(cookid, speaceid, procesid, tasteid, hardid, styleid, homeid,0);
        modelAndView.addObject("cplist",cp);
        //通过id查询该菜谱食材明细
        List<Material> materials = materialService.findBycookid(cookid);
        modelAndView.addObject("materials",materials);
        return modelAndView;
    }


    //前台登录 加密
    @RequestMapping("login")
    public String login(String aname, String apassword, Model model, HttpSession session){
        System.out.println("进来了====="+aname+"=="+apassword);
        apassword = new MD5Code().getMD5ofStr(apassword);
        //查询出当前登录人
        Map<String, Object>  users = accountService.findUser(aname,apassword);
        System.out.println("查询出当前登录人========>"+users);
        //session记录当前登录人
        session.setAttribute("u",users);
         if (users!=null){
            //判断当前状态是否被禁用 0可用
            if (0!=(int)users.get("accountstate")){
                System.out.println("您的账户已被封了喲");
                session.setAttribute("mmsg","您的账户已被封了喲");
                return "redirect:/skipPage/login";
            }
            else {
                System.out.println("登录成功");
                session.removeAttribute("mmsg");
                return "redirect:/front/indexFood";
            }
        }else{
            //用户不存在
             System.out.println("登录失败了哟，您的账户或密码不正确");
             session.setAttribute("mmsg","登录失败了哟，您的账户或密码不正确");
             return "redirect:/skipPage/login";
        }

    }

        //注册页面
    @RequestMapping("regist")
    public String  regist(String aname, String apassword,String aphone,HttpSession session){
            System.out.println(aname+"======"+apassword+"==="+this.img);
            String newImg = "/img/"+this.img;
            //查询注册用户是否存在
            List<Account> unique = accountService.findUnique(aname, aphone);
            if (unique.isEmpty()){
                //添加新用户
                Account account = new Account(null,aname ,new MD5Code().getMD5ofStr(apassword), newImg, aphone, 0, null, null, null, null, null, null, null);
                int num = accountService.add(account);
                return "redirect:/skipPage/login";
            }else{
                session.setAttribute("mmsg","请重新注册");
                return "redirect:/skipPage/regist";
            }

    }

    //注册添加传图片
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
        this.img=s;
        Integer code=0;
        return code;
    }



    //挑选指定 热门视频
    @RequestMapping("about")
    public String  about(int newid,Model model){
        if (newid==1){
            model.addAttribute("list", mvService.findByRow(10));//查最新发布的10行
        }
        else {
            model.addAttribute("list", mvService.findAll());//查全部
        }
        return "/front/about";
    }

    //视频跳单个页面
    @RequestMapping("gallery-single")
    public String  gallery_single(int mvid,Model model){
      
        model.addAttribute("list",mvService.findOne(mvid));//查单个
        model.addAttribute("list5", frontService.findLimit5());//查最新发布5个菜谱
        return "/front/gallery-single";
    }

    //初始化首页面
    @RequestMapping("indexFood")
    public String indexFood(Model model,HttpSession session,@RequestParam(name = "flag",defaultValue = "0") int flag){
        Object u = session.getAttribute("u");
        if (u!=null){
            session.setAttribute("flagSwitch","成功");
        }
        if (flag==1){
            session.removeAttribute("flagSwitch");
            session.removeAttribute("u");
        }
        System.out.println("此时session值"+session.getAttribute("flagSwitch"));
        model.addAttribute("list5", frontService.findLimit5());//查最新发布5个菜谱
        model.addAttribute("mvlist", mvService.findByRow(3));//查最新发布3个视频
        return "front/indexFood";
    }

    //食品百科显示
    @RequestMapping("services")
    public String services(Model model){
        //显示所有食材单品及疗效，功能
        List<Map<String, Object>> all = frontService.findfoodAll();
        System.out.println("结果==》"+all);
        model.addAttribute("list",all);
        return "front/services";
    }

}
