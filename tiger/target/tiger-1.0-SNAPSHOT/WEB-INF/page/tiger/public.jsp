<%@ page language="java" contentType="textml; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/common.jsp" %>
<div class="main">
    <div id="middle" >
        <!--US-->
        <div class="middle-1">
            <div class="border"></div>
            <div class="main top-main clear">
                <ul id="us-ul">
                    <li class="bar1-li bar1-li1"><a href="${ctx}/system/tiger/us">关于我们</a></li>
                    <li class="bar1-li bar1-li2"><a href="${ctx}/system/tiger/us-course">我们的课程</a></li>
                    <li class="bar1-li bar1-li3"><a href="${ctx}/system/tiger/us-envir">教学环境</a></li>
                    <li class="bar1-li bar1-li4"><a href="${ctx}/system/tiger/us-advantage">我们的优势</a></li>
                </ul>
                <div class="pic-text clear">
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/us">
                            <img src="${ctx}/static/img/US-about.png" alt=""/>
                            <h2>关于我们</h2>
                            <p>南京太阁IT认证中心成立于2010年12月，是一家思科授权培训机构，是南京航空航天大学官方指定合作伙伴，拥有百万思科实验设备...</p>
                        </a>
                    </div>
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/us-advantage">
                            <img src="${ctx}/static/img/US-good.png" alt=""/>
                            <h2>我们的优势</h2>
                            <p>优越的地理位置，提供免费住宿，学费可分期，就业推荐资源丰富，可在线远程授课</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!--YOU-->
        <div class="middle-1" >
            <div class="border"></div>
            <div class="main top-main clear">
                <ul id="you-ul">
                    <li><a href="${ctx}/system/tiger/you">免费课申请</a></li>
                    <li><a href="${ctx}/system/tiger/you-text">考试须知</a></li>
                    <li><a href="${ctx}/system/tiger/you-mode">上课方式</a></li>
                </ul>
                <div class="pic-text clear">
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/you-text">
                            <img src="${ctx}/static/img/YOU-text.png" alt=""/>
                            <h2>考试须知</h2>
                            <p> 报考时考生需提供考生中英文姓名，E-MAIL地址，中英文联系地址及邮编，联系电话和考试号码，名称及考试语种；非首次考试的考生还应再</p>
                        </a>
                    </div>
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/you-mode">
                            <img src="${ctx}/static/img/YOU-mode.png" alt=""/>
                            <h2>上课方式</h2>
                            <p>本地，远程，集训营班，直通车班，视频班</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!--NEWS-->
        <div class="middle-1">
            <div class="border"></div>
            <div class="main top-main clear">
                <ul id="news-ul">
                    <li><a href="${ctx}/system/tiger/news-battlefield">最新战报</a></li>
                    <li><a href="${ctx}/system/tiger/news">最新开班</a></li>
                    <li><a href="${ctx}/system/tiger/news-discount">最新优惠</a></li>
                </ul>
                <div class="pic-text clear">
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/news">
                            <img src="${ctx}/static/img/NEW-class.png" alt=""/>
                            <h2>最新战报</h2>
                            <p>${battlefield[0].title}</p>
                        </a>
                    </div>
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/news">
                            <img src="${ctx}/static/img/NEW-pic.png" alt=""/>
                            <h2>最新开班</h2>
                            <p>${news[0].title}</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!--VIDEOS-->
        <div class="middle-1">
            <div class="border"></div>
            <div class="main top-main clear">
                <ul id="videos-ul">
                    <li><a href="${ctx}/system/tiger/videos">思科课程试听</a></li>
                    <li><a href="${ctx}/system/tiger/videos-huawei">华为课程试听</a></li>
                </ul>
                <div class="pic-text clear">
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/videos">
                            <img src="${ctx}/static/img/VIDEOS-listion.png" alt=""/>
                            <h2>思科课程试听</h2>
                        </a>
                    </div>
                    <div class="pic-detail">
                        <a href="${ctx}/system/tiger/videos-huawei">
                            <img src="${ctx}/static/img/VIDEOS-student.png" alt=""/>
                            <h2>华为课程试听</h2>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
