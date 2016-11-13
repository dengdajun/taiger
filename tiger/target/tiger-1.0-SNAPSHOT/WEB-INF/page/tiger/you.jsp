<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
    <script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
    <script src="${ctx}/static/js/Index.js"></script>
    <title>YOU</title>

</head>
<body>

<!--顶部-->
<!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"></iframe>-->

<!--顶部-->
<jsp:include page="top.jsp"/>
<!--中间-->
<jsp:include page="public.jsp"/>

<!---->
<img src="${ctx}/static/img/YOU-bg.png" alt="" width="100%" class="img"/>
<div class="main places">当前位置：首页>YOU><span id="text-html">免费课申请</span></div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1">
                <li class="title-li">YOU <i class="icon-reorder"></i></li>
                <li class="active bar1-li you-bar1-li1"><a href="${ctx}/system/tiger/you">免费课申请   <i class="icon-angle-right"></i></a></li>
                <li class="bar1-li you-bar1-li2"><a href="${ctx}/system/tiger/you-text">考试须知  <i class="icon-angle-right"></i></a>  </li>
                <li class="bar1-li you-bar1-li3"><a href="${ctx}/system/tiger/you-mode">上课方式  <i class="icon-angle-right"></i></a>  </li>
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

            <!--免费课申请-->
            <div class="article9" style="display: block">
                <h2>免费课申请</h2>
                <form action="">
                    <div><span>姓名：</span> <input type="text" /> </div>
                    <div><span>电话：</span> <input type="text" /></div>
                    <div><span>QQ：</span> <input type="text" /></div>
                    <div><span>咨询课程：</span> <input type="text" /></div>
                    <div><span>专业：</span> <input type="text" /></div>
                    <div><span style="float: left">备注：</span> <textarea></textarea></div>
                    <div style="text-align: left" class="clear">
                        <span style="float: left">验证码：</span>
                        <input type="text" class="verification" style="float: left"/>
                        <span class="var-img" style="cursor: pointer"><img src="${ctx}/static/img/cisco.png" alt=""/></span>
                    </div>
                    <div>
                        <span></span>
                        <input type="submit" value="提交" class="btn submit"/>
                        <input type="submit" value="重置" class="btn reset"/>
                    </div>
                </form>
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