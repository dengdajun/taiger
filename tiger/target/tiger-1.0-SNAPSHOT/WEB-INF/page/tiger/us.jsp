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
        <title>US</title>
    </head>
    <body>
        <!--顶部-->
        <jsp:include page="top.jsp"/>
        <!--中间-->
        <jsp:include page="public.jsp"/>
        <!---->
        <!--<div class="pag" style="position: relative;z-index: 998">                &lt;!&ndash;包裹开始&ndash;&gt;-->
        <img src="${ctx}/static/img/about-bg.png" alt="" width="100%" class="img"/>
        <div class="main places">当前位置：首页>US>
            <span id="text-html">关于我们</span>
        </div>
        <!--内容-->
        <div class="content">
            <div class="main clear">
                <div class="nav-bar">
                    <ul class="bar1" id="bar1">
                        <li class="title-li">US
                            <i class="icon-reorder"></i>
                        </li>
                        <li class="active bar1-li bar1-li1">
                            <a href="${ctx}/system/tiger/us">关于我们
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                        <li class="bar1-li bar1-li2">
                            <a href="${ctx}/system/tiger/us-course">我们的课程
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                        <li class="bar1-li bar1-li3">
                            <a href="${ctx}/system/tiger/us-envir">教学环境
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                        <li class="bar1-li bar1-li4">
                            <a href="${ctx}/system/tiger/us-advantage">我们的优势
                                <i class="icon-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="bar2">
                        <li class="active bar2-bg1">
                            <a href="tencent://message/?uin=125439857">在线咨询</a>
                        </li>
                        <li style="padding-left: 0" class="bar2-bg2">
                            <a href="${ctx}/system/tiger/you">免费课申请</a>
                        </li>
                        <li style="padding-left: 0" class="bar2-bg3">
                            <a href="${ctx}/system/tiger/videos">视频试听</a>
                        </li>
                    </ul>
                </div>
                <!--右边部分 -->
                <div class="right-con">
                    <!--关于我们-->
                    <div id="article1">
                        <h2>关于我们</h2>
                        <div class="clear">
                            <div class="text-p">
                                    <p>南京太阁IT认证中心成立于2010年12月，是一家思科授权培训机构,是南京航空航天大学官方指定合作伙伴，拥有百万思科实验设备，常年致力于网络领域高端IT培训，主打华为和Cisco（思科）职业生涯认证体系培训，公司位于南京栖霞区仙林大学城地区，目前线下主要为仙林大学城南京高大学，南京邮电大学，南京高师范大学等9大高校提供IT培训，通过高质量的精品小班教学，致力于学员的学习效率与考试通过率，保证学员在学习技术知识的同时达成学有所用，学有所感。线上在腾讯课堂，鸿鹄论坛上也都有直播上课。公司创始人闫辉老师同时拥有路由，交换，运营商，数据中心四个方向的CCIE证书，以及华为HCIE。曾参加江苏省政府园区网核心层改造，江苏省交通银行园区改造，苏宁环球，上海虹桥机场以及苏大，东大，南师大等校园的无线网络部署。重要的教学经验丰富，以及培训出了上千名优秀的网络人才，学生遍布全国以及各个国家的华人，在业界有很高的口碑，是国内著名技术论坛上最有人气的讲师之一，曾被大众评为口碑排行第一名。
                                     </p><p>
                                        我们时间不算很长，但一直尽心尽力做着一件事，就是为学员好好上课，好好辅导学员通过考试，所以无论是上课口碑还是通过率都在江苏地区遥遥领先，往后更会坚持做好，做精这一件事，欢迎更多的小伙伴加入我们，一起努力吧！
                                    </p>
                            </div>

                            <img src="${ctx}/static/img/pic-three.png" alt=""/>
                        </div>
                    </div>

                    <!---->
                </div>
            </div>
        </div>


        <!--</div>      &lt;!&ndash;包裹结尾&ndash;&gt;-->
        <!--广告-->
        <jsp:include page="QQ-advertise.jsp"/>
        <!--底部-->
        <jsp:include page="footer.jsp"/>
    </body>
</html>