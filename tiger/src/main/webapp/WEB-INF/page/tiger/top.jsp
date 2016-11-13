<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<div class="top">
    <div style="" class="main top-main clear">
        <div class="top-right clear">
            <a href="${ctx}/system/tiger/index">返回首页</a>
            <select onchange="window.location=this.value">
                <option value="${ctx}/system/tiger/index">分校区</option>
                <option value="${ctx}/system/tiger/index-fenxiao">扬州校区</option>
            </select>
        </div>
    </div>
</div>
<!--导航-->
<nav>
    <div class="main clear">
        <img src="${ctx}/static/img/logo.png" alt="" id="logo"/>
        <ul class="clear" id="nav">
            <li class="active">
                <a href="${ctx}/system/tiger/us">Us</a>
            </li>
            <li>
                <a href="${ctx}/system/tiger/you">You</a>
            </li>
            <li>
                <a href="${ctx}/system/tiger/news">News</a>
            </li>
            <li>
                <a href="${ctx}/system/tiger/videos">Videos</a>
            </li>
        </ul>
    </div>
</nav>
