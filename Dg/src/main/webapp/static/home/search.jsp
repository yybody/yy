<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>搜索页面</title>

    <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css"/>
    <link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css"/>

    <link href="../basic/css/demo.css" rel="stylesheet" type="text/css"/>

    <link href="../css/seastyle.css" rel="stylesheet" type="text/css"/>

    <%--<script type="text/javascript" src="../basic/js/jquery-1.7.min.js"></script>--%>
    <%--<script type="text/javascript" src="../js/script.js"></script>--%>
    <script src="../js/jquery-3.1.0.min.js"></script>

</head>

<body>


<!--悬浮搜索框-->

<div class="nav white">
    <div class="logo"><img src="../images/logo.png"/></div>
    <div class="logoBig">
        <li><img src="../images/logobig.png"/></li>
    </div>

    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>
        <form>
            <input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
            <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
        </form>
    </div>
</div>

<div class="clear"></div>
<b class="line"></b>
<div class="search">
    <div class="search-list">
        <div class="nav-table">
            <div class="long-title"><span class="all-goods">全部分类</span></div>
            <div class="nav-cont">
                <ul>
                    <li class="index"><a href="#">首页</a></li>
                </ul>
                <div class="nav-extra">
                    <i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>附近商家
                    <i class="am-icon-angle-right" style="padding-left: 10px;"></i>
                </div>
            </div>
        </div>
        <div class="am-g am-g-fixed">
            <div class="am-u-sm-12 am-u-md-12"><!-- 加不起事件 -->
                <div class="theme-popover">
                    <div class="searchAbout">
                        <span class="font-pale">相关搜索：</span>
                        <a title="坚果"
                           href="${pageContext.request.contextPath}/menu2/gid?goodid=${(pageInfo.list)[0].gid}">坚果</a>
                        <a title="瓜子" href="#">瓜子</a>
                        <a title="鸡腿" href="#">豆干</a>

                    </div>
                    <ul class="select">
                        <p class="title font-normal">
                            <span class="fl">${m2Name}</span>
                            <span class="total fl">搜索到<strong class="num">${pageInfo.total}</strong>件相关商品</span>
                        </p>

                        <li class="select-list">
                            <dl id="select1">
                                <dt class="am-badge am-round">品牌</dt>

                                <div class="dd-conent">
                                    <dd class="select-all selected"><a
                                            href="${pageContext.request.contextPath}/menu2/gid?goodid=${(pageInfo.list)[0].gid}">全部</a>
                                    </dd>
                                    <c:forEach items="${pageInfo.list}" var="good">
                                        <dd>
                                            <a href="${pageContext.request.contextPath}/menu2/gid?goodid=${(pageInfo.list)[0].gid}">
                                                <p class="p1">${good.brand}</p></a></dd>
                                    </c:forEach>

                                </div>

                            </dl>
                        </li>

                        <li class="select-list">
                            <dl id="select3">
                                <dt class="am-badge am-round">选购热点</dt>
                                <div class="dd-conent">
                                    <dd class="select-all selected"><a href="#">全部</a></dd>
                                    <dd><a href="#">手剥松子</a></dd>
                                    <dd><a href="#">薄壳松子</a></dd>
                                    <dd><a href="#">进口零食</a></dd>
                                    <dd><a href="#">有机零食</a></dd>
                                </div>
                            </dl>
                        </li>

                    </ul>
                    <div class="clear"></div>
                </div>
                <div class="search-content">
                    <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
                        <c:forEach items="${pageInfo.list}" var="good">
                            <li>
                                <div class="i-pic limit">
                                    <img src="${good.gpic}"/>
                                    <p class="px">${good.gname}</p>
                                    <p class="price fl">
                                        <b>¥</b>
                                        <strong>${good.gprice}</strong>
                                    </p>
                                    <p class="number fl">
                                        销量<span>1110</span>
                                    </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!--分页 -->
            <ul class="am-pagination am-pagination-right">


                <li class="am-disabled">

                    <a href="${pageContext.request.contextPath}/menu2/good?m2id=${(pageInfo.list)[0].m2id}&pn=1">第一页</a>

                </li>


                <!--所有的页码-->
                <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                    <c:if test="${pageInfo.pageNum==page_num}">
                        <li class="am-active"><a
                                href="${pageContext.request.contextPath}/menu2/good?m2id=${(pageInfo.list)[0].m2id}&pn=${page_num}">${page_num}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum!=page_num}">
                        <li>
                            <a href="${pageContext.request.contextPath}/menu2/good?m2id=${(pageInfo.list)[0].m2id}&pn=${page_num}">${page_num}</a>
                        </li>
                    </c:if>


                </c:forEach>


                <li>

                    <a href="${pageContext.request.contextPath}/menu2/good?m2id=${(pageInfo.list)[0].m2id}&pn=${pageInfo.pages}">末页</a>

                </li>


                </li>
            </ul>
        </div>
    </div>

</div>

<!--引导 -->
<div class="navCir">
    <li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
    <li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
    <li><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>
    <li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>
</div>

<!--菜单 -->
<div class=tip>
    <div id="sidebar">
        <div id="wrap">
            <div id="prof" class="item">
                <a href="#">
                    <span class="setting"></span>
                </a>
                <div class="ibar_login_box status_login">
                    <div class="avatar_box">
                        <p class="avatar_imgbox"><img src="../images/no-img_mid_.jpg"/></p>
                        <ul class="user_info">
                            <li>用户名：sl1903</li>
                            <li>级&nbsp;别：普通会员</li>
                        </ul>
                    </div>
                    <div class="login_btnbox">
                        <a href="#" class="login_order">我的订单</a>
                        <a href="#" class="login_favorite">我的收藏</a>
                    </div>
                    <i class="icon_arrow_white"></i>
                </div>

            </div>
            <div id="shopCart" class="item">
                <a href="#">
                    <span class="message"></span>
                </a>
                <p>
                    购物车
                </p>
                <p class="cart_num">0</p>
            </div>
            <div id="asset" class="item">
                <a href="#">
                    <span class="view"></span>
                </a>
                <div class="mp_tooltip">
                    我的资产
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>

            <div id="foot" class="item">
                <a href="#">
                    <span class="zuji"></span>
                </a>
                <div class="mp_tooltip">
                    我的足迹
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>

            <div id="brand" class="item">
                <a href="#">
                    <span class="wdsc"><img src="../images/wdsc.png"/></span>
                </a>
                <div class="mp_tooltip">
                    我的收藏
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>

            <div id="broadcast" class="item">
                <a href="#">
                    <span class="chongzhi"><img src="../images/chongzhi.png"/></span>
                </a>
                <div class="mp_tooltip">
                    我要充值
                    <i class="icon_arrow_right_black"></i>
                </div>
            </div>

            <div class="quick_toggle">
                <li class="qtitem">
                    <a href="#"><span class="kfzx"></span></a>
                    <div class="mp_tooltip">客服中心<i class="icon_arrow_right_black"></i></div>
                </li>
                <!--二维码 -->
                <li class="qtitem">
                    <a href="#none"><span class="mpbtn_qrcode"></span></a>
                    <div class="mp_qrcode" style="display:none;"><img src="../images/weixin_code_145.png"/><i
                            class="icon_arrow_white"></i></div>
                </li>
                <li class="qtitem">
                    <a href="#top" class="return_top"><span class="top"></span></a>
                </li>
            </div>

            <!--回到顶部 -->
            <div id="quick_links_pop" class="quick_links_pop hide"></div>

        </div>

    </div>
    <div id="prof-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            我
        </div>
    </div>
    <div id="shopCart-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            购物车
        </div>
    </div>
    <div id="asset-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            资产
        </div>

        <div class="ia-head-list">
            <a href="#" target="_blank" class="pl">
                <div class="num">0</div>
                <div class="text">优惠券</div>
            </a>
            <a href="#" target="_blank" class="pl">
                <div class="num">0</div>
                <div class="text">红包</div>
            </a>
            <a href="#" target="_blank" class="pl money">
                <div class="num">￥0</div>
                <div class="text">余额</div>
            </a>
        </div>

    </div>
    <div id="foot-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            足迹
        </div>
    </div>
    <div id="brand-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            收藏
        </div>
    </div>
    <div id="broadcast-content" class="nav-content">
        <div class="nav-con-close">
            <i class="am-icon-angle-right am-icon-fw"></i>
        </div>
        <div>
            充值
        </div>
    </div>

</div>


<div class="theme-popover-mask"></div>
<script>


    $(function () {
        console.log("ready...")
        /*$(".boxes li").on("click", function (evt) {
            alert("hello")
            window.location.href = "${pageContext.request.contextPath}/menu2/gid?goodid=${(pageInfo.list)[0].gid}";
            return false;
        })*/
        console.log($(".boxes li"));
        $(".am-u-md-12").on("click", function () {
            alert('hello')
        })
    })

</script>
</body>

</html>