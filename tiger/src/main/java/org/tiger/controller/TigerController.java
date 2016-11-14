package org.tiger.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.tiger.entity.*;
import org.tiger.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import support.core.Constant;
import support.support.QueryResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Controller
@RequestMapping("/system/tiger")
public class TigerController implements Constant {
    @Resource
    private SchoolInformationService schoolInformationService;
    @Resource
    private NewsService newsService;
    @Resource
    private CourseService courseService;
    @Resource
    AttachmentService attachmentService;
    @Resource
    QQAdvertisementService qqAdvertisement;
    @Resource
    private BranchSchoolService branchSchoolService;

    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Index(ModelAndView mv, HttpServletRequest request) {
        List<SchoolInformation> si = schoolInformationService.doQueryAll();
        request.setAttribute("si",si.get(0));
        List<News> news = newsService.doQueryAll();
        Attachment query=new Attachment();
        query.setType((short)ATT_Carousel);
        QueryResult<Attachment> result=attachmentService.doPaginationQuery(query);
        for(Attachment entity:result.getResultList()){
            if (!StringUtils.isBlank(entity.getBelongToId()) ) {
                mv.addObject(entity.getBelongToId(),entity);
            }

        }
        mv.addObject("news",news);
        mv.setViewName("tiger/index");
        return mv;
    }

    @RequestMapping(value = "/us", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Us(ModelAndView mv) {
        mv.setViewName("tiger/us");
        return mv;
    }
    @RequestMapping(value = "/index-fenxiao", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView FenXiao(ModelAndView mv) {
        mv.setViewName("tiger/index-fenxiao");
        return mv;
    }

    @RequestMapping(value = "/news-battlefield", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView NewsBattlefield(ModelAndView mv) {
        List<News> news = newsService.queryByProerties("ntype","1");
        mv.addObject("battlefield",news);
        mv.setViewName("tiger/news-battlefield");
        return mv;
    }
    @RequestMapping(value = "/getNextNews", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<News> getNextNews(HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        int ntype= Integer.parseInt(request.getParameter("ntype"));
        List<News> news = newsService.getNextNews(id,ntype);
        return news;
    }
    @RequestMapping(value = "/getUpNews", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<News> getUpNews(HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        int ntype= Integer.parseInt(request.getParameter("ntype"));
        List<News> news = newsService.getUpNews(id,ntype);
        return news;
    }
    @RequestMapping(value = "/news_battlefield_id", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public News NewsBattlefieldById(HttpServletRequest request) throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        News news = newsService.getByProerties("nid",id);
        return news;
    }
    @RequestMapping(value = "/news-discount", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView NewsDiscount(ModelAndView mv) {
        List<News> news = newsService.queryByProerties("ntype","3");
        mv.addObject("discount",news);
        mv.setViewName("tiger/news-discount");
        return mv;
    }
    @RequestMapping(value = "/us-course", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView UsCourse(ModelAndView mv) {
        mv.setViewName("tiger/us-course");
        return mv;
    }
    @RequestMapping(value = "/us-envir", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView UsEnvir(ModelAndView mv) {
        mv.setViewName("tiger/us-envir");
        return mv;
    }
    @RequestMapping(value = "/us-advantage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView UsAdvantage(ModelAndView mv) {
        mv.setViewName("tiger/us-advantage");
        return mv;
    }
    @RequestMapping(value = "/you", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView You(ModelAndView mv) {
        mv.setViewName("tiger/you");
        return mv;
    }
    @RequestMapping(value = "/news", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView News(ModelAndView mv){
        List<News> news = newsService.queryByProerties("ntype","2");
        mv.addObject("news",news);
        mv.setViewName("tiger/news");
        return mv;
    }
    @RequestMapping(value = "/videos", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Videos(ModelAndView mv) {
        List<Course> videos=courseService.queryByProerties("ctype",1);
        mv.addObject("videos",videos);
        mv.setViewName("tiger/videos");
        return mv;
    }
    @RequestMapping(value = "/you-text", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView YouText(ModelAndView mv) {
        mv.setViewName("tiger/you-text");
        return mv;
    }
    @RequestMapping(value = "/you-mode", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView YouMode(ModelAndView mv) {
        mv.setViewName("tiger/you-mode");
        return mv;
    }
    @RequestMapping(value = "/videos-huawei", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView VideosHuawei(ModelAndView mv) {
        mv.setViewName("tiger/videos-huawei");
        return mv;
    }
    @RequestMapping(value = "/us-course-con", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView UsCourseCon(ModelAndView mv) {
        mv.setViewName("tiger/us-course-con");
        return mv;
    }

    @RequestMapping(value = "/branch", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView branch(ModelAndView mv) {
        List<BranchSchool> branchSchools=branchSchoolService.doQueryAll();
        mv.addObject("branch",branchSchools);
        mv.setViewName("tiger/us");
        return mv;
    }
    @ModelAttribute
    public ModelAndView advertise(ModelAndView mv) {
        QQAdvertisement qq= qqAdvertisement.doQueryAll().get(0);
        mv.addObject("qqAdvertisement",null==qq?new QQAdvertisement():qq);
        return mv;
    }
}
