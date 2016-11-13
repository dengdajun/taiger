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
<jsp:include page="top.jsp"/>
<!--中间-->
<jsp:include page="public.jsp"/>
<!---->
<img src="${ctx}/static/img/YOU-bg.png" alt="" width="100%" class="img"/>
<div class="main places">当前位置：首页>YOU><span id="text-html">上课方式</span></div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1">
                <li class="title-li">YOU <i class="icon-reorder"></i></li>
                <li class="bar1-li you-bar1-li1"><a href="${ctx}/system/tiger/you">免费课申请   <i class="icon-angle-right"></i></a></li>
                <li class="bar1-li you-bar1-li2"><a href="${ctx}/system/tiger/you-text">考试须知  <i class="icon-angle-right"></i></a>  </li>
                <li class="active bar1-li you-bar1-li3"><a href="${ctx}/system/tiger/you-mode">上课方式  <i class="icon-angle-right"></i></a>  </li>
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

            <!--上课方式-->
            <div class="article10" style="display: block">
                <h2>上课方式</h2>
                <p><span>本地</span>---您可以来本地上课，本地的外地的都可以，反正可以免费住宿，上课效果也好</p>
                <p><span>远程</span>---如果上班族受时间和地点的限制，您可以通过YY3660频道和腾讯课堂远程收听我们的课程</p>
                <p><span>集训营班</span>：如果已经有CCNA，CCNP或者RHCA和RHCP的扎实基础，可以直接参加CCIE或者RHCE的最后阶段的集训学习和练习，适合有工作经验，需要短期内取得证书的上班族</p>
                <p><span>直通车班</span>：系统的从最初小白阶段开始学习，一步一步踏踏实实晋升到最高级。</p>
                <p>视频班：适合自学能力很强，自我约束管理能力很强的学员，无需老师的辅导也能成功的大神们</p>
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