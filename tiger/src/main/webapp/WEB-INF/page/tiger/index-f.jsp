<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/index.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/sl.css"/>
    <script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
    <script src="${ctx}/static/js/Index.js"></script>
    <title>F</title>
</head>
<body>
<!--顶部-->
<!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"></iframe>-->

<!--顶部-->
    <jsp:include page="top.jsp"/>
<!--中间-->
<jsp:include page="public.jsp"/>
    <!--banner-->
<div id="banner" style="position: relative;border: 2px solid red;height: 600px">
    <div id="solid"  class="img">
        <div class="solid0"></div><div class="solid1"></div><div class="solid2"></div>
        <ul style="border: 2px solid purple;height: 600px">
            <li>
                <a href="javascript:;">
                    <img src="${ctx}/static/img/banner.png" />
                </a>
            </li>
            <li><a href="javascript:;">
                <img src="${ctx}/static/img/banner2.png" /></a>
            </li>
            <li>
                <a href="${ctx}/system/tiger/you"><img src="${ctx}/static/img/banner3.png" /></a>
            </li>
        </ul>
        <div id="btt">
            <span></span> <span></span> <span></span>  <span></span>
        </div>
    </div>
</div>


<!--内容-->
<div class="content">

</div>
<!--广告-->
<jsp:include page="QQ-advertise.jsp"/>
<!--底部-->
<jsp:include page="footer.jsp" />
</body>
</html>