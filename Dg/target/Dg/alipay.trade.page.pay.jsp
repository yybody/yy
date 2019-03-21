<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>付款</title>
</head>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.alipay.api.*"%>
<%@ page import="com.alipay.api.request.*"%>
<%
	//获得初始化的AlipayClient
	AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016092400588998", "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDQcm+EvOIhp6qng+/E578/WvMkeARHTiHrrXVUpNAy+Mr5xqcHDbABs2HQwUyooDxm/yp5VSwCCDgNpSL9ejhA4oD79DGNUvh7+LOvnNiFcolexQLe9MQ0XOeYDPIk9MOwFFC9A7iEtYjoUcbZMN6PlhNGBfLiasHdCk1mXIGpMdc2b59kPXZ9bmdLcL9IIFG0LEJXa4niieAx+vuxEVFzkRmIlgETwjkIssLYljOllCLs/LIAsjcNsVJskXtyeOwZOBayfAzgXGcXosFUSFavfbsoxQAhMoSrm06HXcOwFZBiM364OdmqdRhAA6DwE+w67CI5rgAv0tPcywKvo2FLAgMBAAECggEBAIoBme/qFlVt6sCpy480WBycHKqig0Kqai7dUvdNf0KgEdK5QVCcMVGO8E4EDLsAC72tZvOZ/l8CDgqKsNXdm2zqCbfGfyAwNK/vgxfb4kbIBEcobLQsndKFSBgVSiRJoV3stV/PHNVQU2ps6hhWEKREGlKcEajyQZQVBBWnXXkkgkidvjhHg/QoDRj00DLeA2k8Yjbz4ZgDW3XWnA7XUwYH29AF/wLSLBkZR2qH+K5M1Irdva0No/VZ8UgY+mlw455djByJAG+XlrpsbYDNcLilK6w60MOwN1tvNj26zyKvI22+7ylfBELibqMwbs1uC7x47QM2Yb7wrrsy0Qgu3oECgYEA8VuOcibJqmeKRVtOlKU4zJG+1yBk867dcpqAO5JNUqONy3zhBaHICKQZYb0usbWawyuEBkeXNV8aJNgvuPJSQ7Ud38EWhQ+eG38fpwctfiwB25i6DKW5vZonIxS0HHjqkTIYfVlP6QtvSzfqu0YKafHR5Vuxti8G1kPTd/uNvuECgYEA3RfBYflSKnyxO2JzsonN+7p7mwhDDup/FX99YemfTF2bbkitrwkjuC3o94u4S3GQaJJ1bC/7dZZLhlm2Aiirlv2Q0y+HUeLYJaio0NncZzjEZ94Sr54oaevhHuAZ4KARY+g30MPTc43WfGSaQpPuSpYzEWIsEr94QpSsqG72AasCgYEAm7cAHfGcZk5KzRhtiEVYcdMOFukVeIo24PuBA+4N6OUQVFqLKwEHd1u37HELsSeDY6utkAecLJjg2yiHEYF1Ra2SSovepZY/4WmQ2EgvN5nY0P6l+gbp4MOVwHJZCY2ReH+jgSuf/LCd6x92V8CGc3fKfXk9HFcWyCIWSvCGsMECgYEAoybmk9ASbDv75aCvVC8RDBP/Jtaf9Z/iDBE6i0iFPytMicOkN6h87WsjoZk/dJznPePmNuHppEo2jXwiLdGpXhDcEJvgNfM6IgAmI4jBdoKTnTppe6Mwm4lvZQNm1TYJ3zn8Blib74fZoY3zr/HORMg2Azv43hThP/DKwLixXWUCgYAEhntTMG8hMNdaAjSVaB3KIOy0w81LCTChP9CdLTxtPCGOZAUWaishYyIxovFsBopW/ks4XLJPHSjCVtf7MkWA2GdbDU9yrPG7ByjIc7qKPhCsfANl/roXzQ2oNiHNjPP7wlFTzWb6sjEyJbyXkdDD3Lsf3W+oBXi9VvNkXdBeMA==", "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq05BnCgqxI7eSmPTxLL/SW6P943+T6kTWXVXgBw8AViDOSffp/3Nyed/QxBe3ARDHkIaW5VpcPckLPo3TIKYTDvQtKFXzF3iyDDJLzs8Epxu+XJCb9Vt2xesSQ1oivA6mAPHCAb9zJ9QT0ibIKO3RnDWfS3IZSfTOMrcrFTaEXTEhpauFEB46osg/KyLTzv95+BnTdBk7qIaCKZiSEoJntLZmQI6Oq2MkJe8Vs2YqMy4+UpyJKaDN5VOItwCpy1JL5QhAZOnRhQrq3MTubA9bIiZhIEX4Q2DoPc0mN1u1aQ4ZAUN64krRDukB8Ufaozaf5xqh609hOVXZdc1BV7KrwIDAQAB", "RSA2");
	//设置请求参数
	AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	alipayRequest.setReturnUrl("");
	alipayRequest.setNotifyUrl("");
	
	//商户订单号，商户网站订单系统中唯一订单号，必填
	String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
	//付款金额，必填
	String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
	//订单名称，必填
	String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
	//商品描述，可空
	String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"),"UTF-8");
	
	alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
			+ "\"total_amount\":\""+ total_amount +"\"," 
			+ "\"subject\":\""+ subject +"\"," 
			+ "\"body\":\""+ body +"\"," 
			+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	
	//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
	//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
	//		+ "\"total_amount\":\""+ total_amount +"\"," 
	//		+ "\"subject\":\""+ subject +"\"," 
	//		+ "\"body\":\""+ body +"\"," 
	//		+ "\"timeout_express\":\"10m\"," 
	//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
	//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
	
	//请求
	String result = alipayClient.pageExecute(alipayRequest).getBody();
	
	//输出
	out.println(result);
%>
<body>
</body>
</html>