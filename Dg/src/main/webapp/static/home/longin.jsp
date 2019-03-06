<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/12 0012
  Time: 下午 4:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head lang="en">
  <meta charset="UTF-8">
  <title>登录</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />

  <link rel="stylesheet" href="../AmazeUI-2.4.2/assets/css/amazeui.css" />
  <link href="../css/dlstyle.css" rel="stylesheet" type="text/css">
  <script src="../js/jquery.js"></script>
  <script src="../AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
  <script src="../AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
  <script src="../js/jquery-3.1.0.min.js"></script>

</head>

<body>

<div class="login-boxtitle">
  <a href="home.jsp"><img alt="logo" src="../images/logobig.png" /></a>
</div>

<div class="login-banner">
  <div class="login-main">
    <div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
    <div class="login-box">

      <h3 class="title">登录商城</h3>

      <div class="clear"></div>

      <div class="login-form">
        <form action="http://localhost:8080/Dg/shiro/longins" method="post" id="formlogin">
          <div class="user-name">
            <label for="user"><i class="am-icon-user"></i></label>
            <input type="text" name="uname" id="user" value="" placeholder="邮箱/用户名">
          </div>
          <div class="user-pass">
            <label for="password"><i class="am-icon-lock"></i></label>
            <input type="password" name="psword" id="password" value="" placeholder="请输入密码">
          </div>
        </form>
      </div>


      <div class="am-cf">
        <input id="submitId" type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
      </div>
      <div class="partner">
        <h3>合作账号</h3>
        <div class="am-btn-group">
          <li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
          <li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
          <li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
        </div>
      </div>

    </div>
  </div>
</div>


<div class="footer ">
  <div class="footer-hd ">
    <p>
      <a href="# ">恒望科技</a>
      <b>|</b>
      <a href="# ">商城首页</a>
      <b>|</b>
      <a href="# ">支付宝</a>
      <b>|</b>
      <a href="# ">物流</a>
    </p>
  </div>
  <div class="footer-bd ">
    <p>
      <a href="# ">关于恒望</a>
      <a href="# ">合作伙伴</a>
      <a href="# ">联系我们</a>
      <a href="# ">网站地图</a>
      <em>© 2015-2025 Hengwang.com 版权所有. 更多模板 <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></em>
    </p>
  </div>
</div>
<script>
  $("#submitId").click(function () {
      $("#formlogin").submit()
  })

</script>
</body>
</html>

