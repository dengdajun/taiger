<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <!--<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">-->

        <link rel="stylesheet" href="${ctx}/static/css/index.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/slide.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
        <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>


        <title>南京太阁首页</title>

    </head>
    <body onload="load()">

        <!--顶部-->
        <!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"></iframe>-->


        <!--顶部-->
         <jsp:include page="top.jsp"/>
        <!--中间-->
        <jsp:include page="public.jsp"/>
        <!--banner  轮播-->

        <div id="solid" style="height: auto" class="img">
            <!--<div class="solid0"></div><div class="solid1"></div><div class="solid2"></div>-->
            <ul>
                <li>
                    <a href="javascript:;">
                        <img src="${ctx}/${banner1.filePath}"/>
                    </a>
                </li>
                <li>
                    <a href="javascript:;">
                        <img src="${ctx}/${banner2.filePath}"/>
                    </a>
                </li>
                <a href="${ctx}/system/tiger/you">
                    <li>
                        <img src="${ctx}/${banner3.filePath}"/>
                    </li>
                </a>
                <!--<li><a href="you.jsp"><img src="static/img/banner3.png" /></a></li>-->
            </ul>
            <div id="btt">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>

        <!--轮播下面的消息-->
        <div class="notice">

            <ul class="line main">
                <span>最新战报:</span>
                <c:forEach items="${news}" var="n">
                    <c:if test="${n.ntype=='battlefield'}">
                        <li style="margin-top: 0px; ">
                            <a href="javascript:;">${n.title}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>

        </div>
        <!--内容-->
        <article>
            <div class="main clear">
                <p class="text">Let’s &nbsp get &nbsp into  &nbsp the &nbsp Tiger-lab  &nbsp live &nbsp online……</p>
                <div></div>
                <aside class="aside1 aside">
                    <img src="${ctx}/static/img/ask-how.png" alt=""/>
                    <p>想听更多您可点击
                        <a href="${ctx}/system/tiger/videos">Videos</a>
                    </p>
                </aside>
                <aside class="aside2">

                    <video autoplay="true" controls="controls" loop="true">
                        <source src="${ctx}/${home_video.filePath}" type="video/mp4"/>
                        <source src="${ctx}/${home_video.filePath}" type="video/ogg"/>
                    </video>

                    <!--<video src="http://v.qq.com/cover/b/bzfkv5se8qaqel2.html?vid=n0020yrnly7" controls="controls"></video>-->
                </aside>
                <aside class="aside3">
                    <h2>闫辉简介</h2>
                    <p>
                        闫辉老师同时拥有路由，交换，运营商，数据中心四个方向的CCIE证书，以及华为HCIE。曾参加江苏省政府园区网核心层改造。江苏省交通银行园区改造，苏宁环球，上海虹桥机场以及苏大，东大，南师大等校园的无线网络部署。重要的是教学经验丰富，学生遍布全国以及各个国家的华人，在业界有很高的口碑，是国内著名技术论坛上最有人气的讲师之一，曾被大众评为口碑排行第一
                    </p>
                </aside>
                <aside class="aside4 aside">
                    <img src="${ctx}/static/img/ask-free.png" alt=""/>
                    <p>您可点击
                        <a href="${ctx}/system/tiger/you">免费课申请</a>
                    </p>
                </aside>
                <aside class="aside5 aside">
                    <img src="${ctx}/static/img/ask-money.png" alt=""/>
                </aside>
                <aside class="aside6">
                    <img src="${ctx}/static/img/screenshot.png" alt=""/>
                </aside>
                <aside class="aside7" id="container">
                    <!--地图-->
                </aside>
                    <aside class="aside8">
                        <p>
                            <img src="${ctx}/static/img/ask-other.png" alt=""/>
                        </p>
                        <p><span>南京校区地址</span>：南京栖霞区仙林大学城甘家东边108号金港科技园3号楼107（进园区大门左转第一幢飞马旅新立方即为3号楼）。图中ABCD处
                        </p>
                        <!--<p>图中ABCD处</p>-->
                        <p>仙林地区公交323可到达金港科技园门口，途径地铁2号线外地学员南京站高铁下车或者是南京站下车后坐地铁公交即可到达</p>
                        <p> 3号线（大行宫） --2号线（学则路）--323路（金港科技园）<br/>
                            1号线（新街口） --2号线（学则路）--323路（金港科技园）</p>
                        <div id="contact" class="clear">
                            <img src="http://www.xcwljy.cn/images/pixel.gif " alt="" class="contact contact1"/>
                            <span>025-85315447</span>
                            <img src="http://www.xcwljy.cn/images/pixel.gif " alt="" class="contact contact2"/>
                            <span class="qq">77958630</span>
                        </div>
                    </aside>
            </div>
        </article>
        <!--广告-->
        <jsp:include page="QQ-advertise.jsp"/>
        <!--底部-->
        <jsp:include page="footer.jsp"/>


        <script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
        <script src="${ctx}/static/js/slide.js"></script>
        <script src="${ctx}/static/js/myslideup.js"></script>
        <script src="${ctx}/static/js/Index.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script>
        <script src="${ctx}/static/js/map.js"></script>
        <script type="text/javascript">
            $(function(){
            $(".line").slideUp();
            })
        </script>

    </body>
</html>