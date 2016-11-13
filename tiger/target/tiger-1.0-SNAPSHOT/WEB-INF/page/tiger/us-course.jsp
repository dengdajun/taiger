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
<div class="main places">当前位置：首页>US><span id="text-html">我们的课程</span></div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1" id="bar1">
                <li class="title-li">US
                    <i class="icon-reorder"></i>
                </li>
                <li class="bar1-li bar1-li1">
                    <a href="${ctx}/system/tiger/us">关于我们
                        <i class="icon-angle-right"></i>
                    </a>
                </li>
                <li class="active bar1-li bar1-li2">
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
            <!--我们的课程-->
            <div class="article3" style="display: block">
                <h2 style="margin-bottom: 0">我们的课程</h2>
                <div class="curriculum">
                    <h4><i class="icon-circle"></i>思科课程</h4>
                    <time>2016-08-20</time>
                    <div class="clear">
                        <p>思科认证是由网络领域著名的厂商--Cisco公司推出的。想要获得思科认证，首先要参加由思科推荐并授权的培训中心所开设的培训课程。完成学业后再到由全球考试机构VUE授权的考试中心参加由思科指定的科目的认证考试。通过指定的系列科目考试后，学员就可以获得相应分支系列等级的资格认证。<span class="detailed-introduction">...查看全文</span>
                        </p>
                        <img src="${ctx}/static/img/cisco.png" alt=""/>
                    </div>
                </div>
                <div class="curriculum">
                    <h4><i class="icon-circle"></i>华为课程</h4>
                    <time>2016-08-20</time>
                    <div class="clear">
                        <p> 华为认证是华为技术有限公司（简称“华为”）凭借多年信息通信技术人才培养经验，以及对行业发展的理解，基于ICT产业链人才个人职业发展生命周期，以层次化的职业技术认证为指引，搭载华为“云 管  端”融合技术，推出的覆盖IP,CT以及ICT融合技术领域的认证体系。<span class="detailed-introduction">...查看全文</span>
                        </p>
                        <img src="${ctx}/static/img/huawei.png" alt=""/>
                    </div>
                </div>
            </div>

            <!--我们的课程详细-->
            <div id="article4">
                <h2 >我们的课程</h2>
                <div class="title">
                    <h4>思科课程</h4>
                    <p>发布时间：<time>2016-08-31</time>浏览次数：58</p>
                </div>
                <p>CCNP全称是：Cisco Certified Network Professional——思科认证网络高级工程师。CCNP专页人员表示通过认证的人员具有丰富的网络知识。获得CCNP认证的专业人员可以为具有100到500多个节点的大型企业网络安装，配置和运行LAN，WAN和拨号访问业务。获得CCNP认证资格的资深网络工程师拥有丰富的知识和技能，能够管理构成网络核心的路由器和交换机，以及将语言，无线和安全集成到网络中的边缘应用。CCNP认证呃有效期为三年。如需重新认证，必须在认证到期前通过同等级别考试中的任何一项，或通过现有的CCIE笔试，即可延续认证有效三年。</p>
                <p>CCNP全称是：Cisco Certified Network Professional——思科认证网络高级工程师。CCNP专页人员表示通过认证的人员具有丰富的网络知识。获得CCNP认证的专业人员可以为具有100到500多个节点的大型企业网络安装，配置和运行LAN，WAN和拨号访问业务。获得CCNP认证资格的资深网络工程师拥有丰富的知识和技能，能够管理构成网络核心的路由器和交换机，以及将语言，无线和安全集成到网络中的边缘应用。CCNP认证呃有效期为三年。如需重新认证，必须在认证到期前通过同等级别考试中的任何一项，或通过现有的CCIE笔试，即可延续认证有效三年。</p>
                <p>CCNP全称是：Cisco Certified Network Professional——思科认证网络高级工程师。CCNP专页人员表示通过认证的人员具有丰富的网络知识。获得CCNP认证的专业人员可以为具有100到500多个节点的大型企业网络安装，配置和运行LAN，WAN和拨号访问业务。获得CCNP认证资格的资深网络工程师拥有丰富的知识和技能，能够管理构成网络核心的路由器和交换机，以及将语言，无线和安全集成到网络中的边缘应用。CCNP认证呃有效期为三年。如需重新认证，必须在认证到期前通过同等级别考试中的任何一项，或通过现有的CCIE笔试，即可延续认证有效三年。</p>
                <iframe src="page.jsp" frameborder="0" scrolling="no" width="700px" height="40px;" style="margin-top: 20px"></iframe>
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