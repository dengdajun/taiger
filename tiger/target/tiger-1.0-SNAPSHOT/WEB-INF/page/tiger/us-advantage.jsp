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
    <title>US</title>
</head>
<body>
<!--顶部-->
<!--<iframe src="top.jsp"  frameborder="0" scrolling="no" width="100%" height="40px"  class="top"></iframe>-->

<!--顶部-->
<jsp:include page="top.jsp"/>
<!--中间-->
<jsp:include page="public.jsp"/>
<!---->
<!--<div class="pag" style="position: relative;z-index: 998">                &lt;!&ndash;包裹开始&ndash;&gt;-->
<img src="${ctx}/static/img/about-bg.png" alt="" width="100%" class="img" />
<div class="main places">当前位置：首页>US><span id="text-html">我们的优势</span></div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1" id="bar1">
                <li class="title-li">US
                    <i class="icon-reorder"></i>
                </li>
                <li class=" bar1-li bar1-li1">
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
                <li class="active bar1-li bar1-li4">
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
            <!--我们的优势-->
            <div id="article5" style="display: block">
                <h2>我们的优势</h2>
                <h3>优越的地理位置</h3>
                <p>公司位于仙林大学城，比邻南京九大高校，坐落于仙林金港科技园内，公交车可直达各大高校和2号线地铁站，南京邮电大学以及南京师范大学学员骑车十分钟即可到达。是仙林大学城内唯一思科华为培训机构，极大的节省了学员们上课路途所的宝贵时间</p>
                <h3>提供免费住宿</h3>
                <p>外地学员（包括国内好多特意回国来学习的学员）可以提供免费住宿，南京日益高涨的房价和租房价全国闻名，我们尽自己最大能力给学员提供学习便利。（水电费制付，基本可以忽略。但也要提一下，我们不喜欢藏着掖着）</p>
                <h3>学费可分期</h3>
                <p>学员可通过分期乐分期付款，先学习后付款，减轻资金压力，尤其是部分辞职来学习的学员。</p>
                <p>就业推荐资源丰富</p>
                <p>我们的学员遍布各大公司，就业资源丰富，来学习的学员自然就拥有了众多的同行的人脉资源，就业机会也多了起来。</p>
                <h3>可现在远程授课</h3>
                <p>我们的学员遍布全球各地，任何学员只要有网就可通过YY和腾讯课堂同步远程授课，百万机架也可供学员24小时远程操作实验。只要有想要进取得心，一切困难都能克服，我们能做的就是把困难尽量渺小化，优势就是这么明显。</p>
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