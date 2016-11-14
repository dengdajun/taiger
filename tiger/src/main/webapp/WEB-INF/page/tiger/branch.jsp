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
<div class="main places">当前位置：首页>校区</div>
<!--内容-->
<div class="content">
    <div class="main clear">
        <!--右边部分 -->
        <div class="right-con">
            <div id="article3" class="new-class">
                <h2 style="margin-bottom: 0">校区</h2>
                <c:forEach items="${branchSchools}" var="n">
                    <div class="curriculum news-curriculum">
                        <h4><i class="icon-circle"></i>${n.name}</h4>
                        <time><fmt:formatDate value="${n.updateTime}" pattern="yyyy-MM-dd" /></time>
                        <div class="clear">
                            <p>
                                 <b class="clear">${n.content} </b>
                            </p>
                        </div>
                    </div>
                </c:forEach>
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