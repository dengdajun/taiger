<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<div class="advertise">
    <div class="title">太阁IT认证 <span class="img close"><img src="${ctx}/static/img/close.png" alt="" /></span></div>
    <div class="con clear">
        <img src="${ctx}/static/img/QQ-ad.png" alt=""/>
        <div class="text">
            <h2>${qqAdvertisement.talk}</h2>
            <p>${qqAdvertisement.message}</p>
            <span>工作时间：${qqAdvertisement.time}</span>
        </div>
    </div>
    <div class="bottom clear">
        <span class="close">下次再说</span>
        <span> <a href="tencent://message/?uin=125439857" id="bay_window">QQ交谈</a></span>
    </div>
</div>
