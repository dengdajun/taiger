<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<!--底部-->
<footer>
    <div class="main clear">
        <div class="img"><img src="${ctx}/static/img/footer-login.png" alt=""/></div>
        <div class="address">
            <p><span>电话：</span><span>${si.mobile}</span><span>${si.tel}</span></p>
            <p><span>QQ: </span><span>${si.QQ}</span>QQ群：<span>${si.QQgroup}</span> </p>
            <p><span>地址：</span><b class="address-text">${si.routedetails}</b></p>
        </div>
        <div class="about">
            <p>关于我们：</p>
            <ul class="clear">
                <li>
                    <p class="f-img"><img src="${ctx}/static/img/qq.png" alt="" class="f-img1"/></p>
                    <p>QQ群</p>
                </li>
                <li>
                    <p class="f-img"><img src="${ctx}/static/img/wechat.png" alt="" class="f-img2"/></p>
                    <p>微信</p>
                </li>
                <li>
                    <p class="f-img"><img src="${ctx}/static/img/weibo.png" alt="" class="f-img3"/></p>
                    <p>微博</p>
                </li>
                <li>
                    <p class="f-img"><img src="${ctx}/static/img/collection.png" alt="" class="f-img4"/></p>
                    <p>收藏网站</p>
                </li>
            </ul>
        </div>
    </div>
</footer>
