<%@page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>DDOS保护</title>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath()%>/">
<link href="resources/web/style/common.css" rel="stylesheet"
	type="text/css">
<link href="resources/web/style/othercss.css" rel="stylesheet"
	type="text/css">
<script language="javascript" src="resources/web/js/jquery-1.8.3.min.js"></script>
<script language="javascript" src="resources/web/js/header.js"></script>
<script language="javascript" src="resources/web/js/pagejs.js"></script>
</head>

<body>
	<div class="pageheader">
		<div class="header">
			<div class="headermain pagewidth">
				<div class="logo">
					<img src="resources/web/images/logo.png">
				</div>
				<div class="meun">
					<ul>
						<li><a href="#"><span>首页</span></a></li>
						<li><a href="#"><span>主机托管/租用</span></a>
							<ol>
								<li><a href="#">主机托管</a></li>
								<li><a href="#">主机租用</a></li>
								<li><a href="#">云主机</a></li>
								<li><a href="#">带宽租用</a></li>
								<li><a href="#">防DDoS攻击</a></li>
							</ol></li>
						<li><a href="#"><span>SDN专线</span></a></li>
						<li><a href="#"><span>关于我们</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="wholeworldbanner">
			<div class="pagewidth pic_p">
				<img src="resources/web/images/dospic.jpg">
				<div class="intrpage jf">
					<h3>DDoS保护</h3>
					<p>智能防护，全面保障</p>
					<p>当互联网服务器在遭受大流量的DDoS攻击出现服务不可用或崩溃的情况下，企业通
						过我们的DDoS防护业务，可以将攻击流量牵引到DDoS防护系统，通过检测和清洗 功能将流量净化，并回注到服务器。</p>
				</div>
			</div>
		</div>
	</div>
	<div class="rowblock">
		<div class="pagewidth">
			<div class="renthostdiv">
				<div class="renthostblock">
					<h5>DELL、华为、超微等国内外知名设备厂商</h5>
					<img src="resources/web/images/dospic01.jpg">
				</div>
				<div class="renthostblock">
					<h5>稳定、优质的硬件设备</h5>
					<img src="resources/web/images/dospic02.jpg">
				</div>
				<div class="renthostblock">
					<h5>按需定制，解决烦恼</h5>
					<img src="resources/web/images/dospic03.jpg">
				</div>
			</div>


		</div>
	</div>

	<div class="rowblock graybg">
		<div class="pagewidth">
			<h4>产品功能</h4>
			<div class="dfunctionlist">
				<div class="dfunctionlistblock">
					<div class="dfunctionicon dficon01"></div>
					<h5>SSD硬盘选择</h5>
				</div>
				<div class="crentserviceblock">
					<div class="dfunctionicon dficon02"></div>
					<h5>负载均衡</h5>
				</div>

				<div class="crentserviceblock">
					<div class="dfunctionicon dficon03"></div>
					<h5>防火墙</h5>
				</div>

				<div class="crentserviceblock">
					<div class="dfunctionicon dficon04"></div>
					<h5>BGP多线接入</h5>
				</div>

				<div class="crentserviceblock">
					<div class="dfunctionicon dficon05"></div>
					<h5>海内外资源</h5>
				</div>

				<div class="crentserviceblock">
					<div class="dfunctionicon dficon06"></div>
					<h5>全面安全防护</h5>
				</div>

			</div>
		</div>
	</div>

	<div class="rowblock">
		<div class="pagewidth">
			<h4>想要了解更多关于防DDoS攻击业务的信息，请联系我们。</h4>
			<div class="contactlist">
				<div class="contactblock contacticon01">咨询热线：4001053626</div>
				<div class="contactblock contacticon02">咨询邮箱：sales@mlink.cn</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="pagewidth">
			<div class="footer_b">
				<em>友情链接：</em><a herf="#">移数通</a>
			</div>
			<div class="footer_b">
				<em>备案号：</em>京ICP备10054122号-6
			</div>
			<div class="footer_b">
				<em>客服热线：</em>4001053626
			</div>
			<div class="footer_b">
				<em>咨询邮箱：</em>sales@mlink.cn
			</div>
			<div class="footer_b rightfloat">
				<em>官网二维码：</em><img src="resources/web/images/web_qr.jpg">
			</div>
		</div>
	</div>
</body>
</html>
