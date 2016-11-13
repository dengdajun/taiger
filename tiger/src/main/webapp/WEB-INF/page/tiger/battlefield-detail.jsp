<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
        <script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
        <script src="${ctx}/static/js/Index.js"></script>
        <title>NEWS-discount</title>
    </head>
    <body>
        <!--顶部-->
        <!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"></iframe>-->

        <!--顶部-->
        <jsp:include page="top.jsp"/>
        <!--中间-->
        <jsp:include page="public.jsp"/>
        <!---->
        <img src="${ctx}/static/img/NEW-bg.png" alt="" width="100%" class="img"/>
        <div class="main places">当前位置：首页>新闻资讯>最新战报</div>
        <!--内容-->
        <div class="content">
            <div class="main clear">
                <div class="nav-bar">
                    <ul class="bar1">
                        <li class="title-li">NEWS
                            <i class="icon-reorder"></i>
                        </li>
                        <li class="bar1-li active">
                            <a href="${ctx}/system/tiger/news-battlefield">最新战报
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                        <li class="bar1-li">
                            <a href="${ctx}/system/tiger/news">最新开班
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                        <li class="bar1-li">
                            <a href="${ctx}/system/tiger/news-discount">最新优惠
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="bar2">
                        <li class="active bar2-bg1">
                            <a href="tencent://message/?uin=125439857">在线咨询</a>
                        </li>
                        <li class="bar2-bg2">
                            <a href="${ctx}/system/tiger/you">免费课申请</a>
                        </li>
                        <li class="bar2-bg3">
                            <a href="${ctx}/system/tiger/videos">视频试听</a>
                        </li>
                    </ul>
                </div>
                <!--右边部分 -->
                <div class="right-con">
                    <!--最新开班-->
                    <div id="article3" class="new-class">
                        <h2 style="margin-bottom: 0">最新战报</h2>
                            <div class="curriculum news-curriculum">
                                <h4><i class="icon-circle"></i>${news.title}</h4>
                                <time><fmt:formatDate value="${news.date}" pattern="yyyy-MM-dd"/></time>
                                <div class="clear">
                                    <p>
                                        <b class="clear">${news.content}</b>
                                    </p>
                                    <img src="${ctx}/static/img/NEWS-bat.png" alt=""/>
                                </div>
                            </div>
                        <iframe src="page.jsp" frameborder="0" scrolling="no" width="700px" height="40px;"
                                style="margin-top: 20px"></iframe>
                    </div>
                    <!--最新战报详情页-->
                    <div id="article6" class="clear">
                        <h2>最新战报</h2>
                             <div class="curriculum news-curriculum">
                                 <h4><i class="icon-circle"></i>${news.title}</h4>
                                 <time><fmt:formatDate value="${news.date}" pattern="yyyy-MM-dd"/></time>
                                 <div class="clear">
                                     <p>
                                         <b class="clear">${news.content}</b>
                                     </p>
                                     <img src="${ctx}/static/img/NEWS-bat.png" alt=""/>
                                 </div>
                             </div>
                        <!--上下篇-->
                        <div class="move-page">
                            <p>
                                <i class="icon-caret-up"></i>
                                上一篇：无
                            </p>
                            <p>
                                <i class=" icon-caret-down"></i>
                                下一篇：太阁开学季9-10月开班计划
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--广告-->
        <jsp:include page="QQ-advertise.jsp"/>
        <!--底部-->
        <jsp:include page="footer.jsp"/>
    </body>
</html>