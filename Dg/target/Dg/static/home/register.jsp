<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head lang="en">
	<meta charset="UTF-8">
	<title>注册</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" href="../../static/AmazeUI-2.4.2/assets/css/amazeui.min.css" />
	<link href="../../static/css/dlstyle.css" rel="stylesheet" type="text/css">
	<script src="../../static/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="../../static/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
	<script src="../../static/js/jquery-3.1.0.min.js"></script>


</head>

<body>

<div class="login-boxtitle">
	<a href="home/demo.html"><img alt="" src="../images/logobig.png" /></a>
</div>

<div class="res-banner">
	<div class="res-main">
		<div class="login-banner-bg"><span></span><img src="../images/big.jpg" /></div>
		<div class="login-box">

			<div class="am-tabs" id="doc-my-tabs">
				<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
					<li class="am-active"><a href="">邮箱注册</a></li>
					<li><a href="">用户注册</a></li>
				</ul>

				<div class="am-tabs-bd">
					<div class="am-tab-panel am-active">
						<form method="post" action="http://localhost:8080/Dg/shiro/Register" id="Submit">

							<div class="user-email">
								<label for="email"><i class="am-icon-envelope-o"></i></label>
								<input type="text" name="email" id="email" placeholder="请输入邮箱账号" />
							</div>
							<div class="verification">
								<label for="code"><i class="am-icon-code-fork"></i></label>
								<input type="tel" name="" id="code" placeholder="请输入验证码" />
								<a class="btn" href="javascript:void(0);" id="sendEmailCode">
									<span id="dyMobileButton">获取</span></a>
							</div>
							<div class="user-pass">
								<label for="password"><i class="am-icon-lock"></i></label>
								<input type="password" name="password" id="password" placeholder="设置密码">
							</div>
							<div class="user-pass">
								<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								<input type="password" name="" id="passwordRepeat" placeholder="确认密码">
							</div>

						</form>

						<div class="login-links">
							<label for="reader-me">
								<input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
							</label>
						</div>
						<div class="am-cf">
							<input type="submit" id="EmailSubmit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
						</div>

					</div>

					<div class="am-tab-panel">
						<form method="post">
							<div class="user-phone">
								<label for="Uname"><i class="am-icon-user am-icon-md"  style="font-size: 10px"></i></label>
								<input type="Uname" name="" id="Uname" placeholder="请输入用户名称">
							</div>

							<div class="user-pass">
								<label for="password"><i class="am-icon-lock"></i></label>
								<input type="password" name="" id="password1" placeholder="设置密码">
							</div>
							<div class="user-pass">
								<label for="passwordRepeat"><i class="am-icon-lock"></i></label>
								<input type="password" name="" id="passwordRepeat1" placeholder="确认密码">
							</div>
						</form>
						<div class="login-links">
							<label for="reader-me">
								<input id="reader-me1" type="checkbox"> 点击表示您同意商城《服务协议》
							</label>
						</div>
						<div class="am-cf">
							<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
						</div>

						<hr>
					</div>

					<script>
                        $(function() {
                            $('#doc-my-tabs').tabs();
                        })
					</script>

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

		var emailCode;

		var resultData;

		var Datas;//邮箱号

        var regEmail = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;

		var values = 0;//values值代表是否可执行，0执行，1不执行
        var url = "http://localhost:8080/Dg/shiro/Email";

		var passwordRepeats;

        var password;

        //发送邮箱验证码
		$("#sendEmailCode").click(function () {
            if(values == 0) {
                Datas = $("#email").val();

                /*$.post(url,JSON.stringify({"email":"m15730748898@163.com"}),function (data) {
                  resultData = data.Em.toString();
                    alert(resultData);
                })*/
                $.ajax({
                    url: url,
                    data: JSON.stringify({"email": Datas}),
                    dataType: "json",
                    contentType: "application/json;charset=UTF-8",
                    type: "POST",
                    success: function (result) {




                        resultData = result.Em;


                    }
                })
            }
            else{
                alert("请输入正确邮箱");
			}


        })
		//检查邮箱格式
        $("#email").change(function () {
            Datas = $("#email").val();
            if(!regEmail.test(Datas)){
                values = 1;
                alert("格式错误");
			}
			else{
                values = 0;
			}

        })
		//执行登录
		$("#EmailSubmit").click(function () {
		    if(values == 0){
            emailCode = $("#code").val();

			alert(resultData == emailCode);
		    if(resultData == emailCode){

		        alert("恭喜您注册本网站，您的用户名默认为邮箱前五个字符"+$("#email").val().substring(0,5)+"请您尽快到用户中心去完善个人信息");
                $("#Submit").submit();

            }
            else{
                alert("请用邮箱进行验证");
            }

		    }

        })
        $("#passwordRepeat").mouseout(function () {
			password = $("#password").val();
            passwordRepeats = $("#passwordRepeat").val();
            if(password != passwordRepeats){
                values = 1;

			}
			else {
                values = 0;

			}

        })
	</script>
</div>
</body>

</html>