<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="${ctx}/static/css/puplic.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/All-in.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/font-awesome.css"/>
    <link rel="stylesheet" href="${ctx}/static/css/pages.css"/>
    <script src="${ctx}/static/js/jquery-2.2.1.min.js"></script>
    <script src="${ctx}/static/js/Index.js"></script>
    <script src="${ctx}/static/js/page.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
           $("#Pagination").pagination("10");
        });
    </script>
    <title>NEWS</title>
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
<div class="main places">当前位置：首页>新闻资讯>最新开班</div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <div class="nav-bar">
            <ul class="bar1">
                <li class="title-li">NEWS <i class="icon-reorder"></i></li>
                <li class="bar1-li"><a href="${ctx}/system/tiger/news-battlefield">最新战报 <i class="icon-angle-right"></i></a> </li>
                <li class="bar1-li active"><a href="${ctx}/system/tiger/news">最新开班  <i class="icon-angle-right"></i></a>  </li>
                <li class="bar1-li"><a href="${ctx}/system/tiger/news-discount">最新优惠  <i class="icon-angle-right"></i></a>  </li>
            </ul>
            <ul class="bar2">
                <li class="active bar2-bg1"><a href="tencent://message/?uin=125439857">在线咨询</a></li>
                <li class="bar2-bg2"><a href="${ctx}/system/tiger/you">免费课申请</a></li>
                <li class="bar2-bg3"><a href="${ctx}/system/tiger/videos">视频试听</a></li>
            </ul>
        </div>
        <!--右边部分 -->
        <div class="right-con">
            <!--最新开班-->
            <div id="article3" class="new-class">
                <h2 style="margin-bottom: 0">最新开班</h2>
                <c:forEach items="${news}" var="n">
                    <div class="curriculum news-curriculum">
                        <h4><i class="icon-circle"></i>${n.title}</h4>
                        <time><fmt:formatDate value="${n.date}" pattern="yyyy-MM-dd" /></time>
                        <div class="clear">
                            <p>
                                <c:forEach items="${n.openClass}" var="oc">
                                    <b class="clear">${oc.content} <time>${oc.time}</time></b>
                                </c:forEach>
                                 <span class="all">...查看全文 <b style="display:none;">${n.nid}</b><strong style="display:none;">${n.ntype}</strong></span>
                            </p>
                            <img src="${ctx}/static/img/class.png" alt=""/>
                        </div>
                    </div>
                </c:forEach>
                <div class="pages clear" style="margin-top:30px;">
                    <div class="page">
                        <div id="Pagination"></div>
                        <div class="searchPage">
                            <span class="page-sum">共<strong class="allPage">${news%5==0?news/5:news/5+1}</strong>页</span>
                            <span class="page-go">去第<input type="text" />页</span>
                            <a href="javascript:;" class="page-btn">确定</a>
                        </div>
                    </div>
                </div>
            </div>
            <!--最新开班详情页-->
            <div id="article6" class="clear">
                <h2 >最新开班</h2>
                <div class="title">
                    <h4 id="title"></h4>
                    <p>发布时间：<time id="time"></time>浏览次数：58</p>
                </div>
                <img src="${ctx}/static/img/class-pic.png" alt="" class="class-pic" style="width: 100%;height: 280px"/>
                <div class="title-bar clear">
                </div>
                <!--上下篇-->
                <div class="move-page">
                    <p id="upnews" class="all"></p>
                    <p id="nextnews" class="all"></p>
                </div>
            </div>
        </div>
    </div>
</div>
    <script>
        $(function(){
        $(".all").on("click", function(){
        var nid = $(this).find("b").html();
        var ntype = $(this).find("strong").html();
        $.ajax({
        url:"${ctx}/system/tiger/news_battlefield_id?id=" + nid,
        dataType:"json",
        type:"post",
        scriptCharset: 'utf-8',
        success:function(data){
        $("#title").html(data.title);
        $("#time").html(data.date);
        var openClass=data['openClass'];
        var content="";
        for (i in openClass) {
          content=content+"<p>"+openClass[i].content+"<time>"+openClass[i].time+"</time></p>"
        }
        $(".title-bar").html(content);
        }
        });

        $.ajax({
        url:"${ctx}/system/tiger/getNextNews?id=" + nid +"&ntype="+ntype,
        dataType:"json",
        type:"post",
        scriptCharset: 'utf-8',
        success:function(data){
        if(data == ""){
        $("#nextnews").html("<i class='icon-caret-down'></i> 下一篇：没有下一篇了");
        }else{
        $("#nextnews").html("<i class='icon-caret-down'></i> 下一篇："+data[0].title+"<b style='display:none;'>"+data[0].nid+"</b><strong style='display:none;'>"+data[0].ntype+"</strong>");
        }
        }
        });
        $.ajax({
        url:"${ctx}/system/tiger/getUpNews?id=" + nid +"&ntype="+ntype,
        dataType:"json",
        type:"post",
        scriptCharset: 'utf-8',
        success:function(data){
        if(data == ""){
        $("#upnews").html("<i class='icon-caret-down'></i> 上一篇：没有上一篇了");
        }else{
        $("#upnews").html("<i class='icon-caret-down'></i> 上一篇："+data[0].title+"<b style='display:none;'>"+data[0].nid+"</b><strong style='display:none;'>"+data[0].ntype+"</strong>");
        }
        }
        });
        });
        })
    </script>
<!--广告-->
<jsp:include page="QQ-advertise.jsp"/>
<!--底部-->
<jsp:include page="footer.jsp"/>
</body>
</html>