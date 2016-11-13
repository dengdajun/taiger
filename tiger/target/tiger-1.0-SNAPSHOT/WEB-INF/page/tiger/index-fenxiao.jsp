<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
    <title>扬州校区</title>
</head>
<body>


<!--顶部-->
<!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"></iframe>-->


<!--顶部-->
    <jsp:include page="top.jsp"/>

<!---->
<img src="${ctx}/static/img/about-bg.png" alt="" width="100%"/>
<div class="main places">当前位置：首页>分校区><span id="text-html">扬州校区</span></div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1">
                <li class="title-li">分校区 <i class="icon-reorder"></i></li>
            </ul>
            <ul class="bar2">
                <li class="active bar2-bg1"><a href="tencent://message/?uin=125439857">在线咨询</a></li>
                <li class="bar2-bg2"><a href="${ctx}/system/tiger/you">免费课申请</a></li>
                <li class="bar2-bg3"><a href="${ctx}/system/tiger/videos">视频试听</a></li>
            </ul>
        </div>
        <!--右边部分 -->
        <div class="right-con">
            <!--我们的课程-->
            <div class="article3" style="display: block">
                <h2 style="margin-bottom: 0">分校区</h2>
                <div class="curriculum">
                    <h4><i class="icon-circle"></i>扬州校区</h4>
                    <time>2016-08-20</time>
                    <div class="clear">
                        <p>思科认证是由网络领域著名的厂商--Cisco公司推出的。想要获得思科认证，首先要参加由思科推荐并授权的培训中心所开设的培训课程。完成学业后再到由全球考试机构VUE授权的考试中心参加由思科指定的科目的认证考试。通过指定的系列科目考试后，学员就可以获得相应分支系列等级的资格认证。<span class="detailed-introduction">...查看全文</span>
                        </p>
                        <img src="${ctx}/static/img/cisco.png" alt=""/>
                    </div>
                </div>
                <div class="curriculum">
                    <h4><i class="icon-circle"></i>南京校区</h4>
                    <time>2016-08-20</time>
                    <div class="clear">
                        <p> 华为认证是华为技术有限公司（简称“华为”）凭借多年信息通信技术人才培养经验，以及对行业发展的理解，基于ICT产业链人才个人职业发展生命周期，以层次化的职业技术认证为指引，搭载华为“云 管  端”融合技术，推出的覆盖IP,CT以及ICT融合技术领域的认证体系。<span class="detailed-introduction">...查看全文</span>
                        </p>
                        <img src="${ctx}/static/img/huawei.png" alt=""/>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<!--广告-->
<jsp:include page="QQ-advertise.jsp"/>
<!--底部-->
<jsp:include page="footer.jsp"/>

<script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
<script src="${ctx}/static/js/Index.js"></script>
</body>
</html>