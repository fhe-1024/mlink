<%@page language="java" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title><%=request.getAttribute("countryname") %>机房</title>
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
				<img src="resources/web/images/abroadpic02.jpg">
				<div class="intrpage jf">
					<h3>
						<em><%=request.getAttribute("countryname") %></em> 机房托管服务
					</h3>
					<p>20+顶级数据中心，800Gbps</p>
				</div>
			</div>
		</div>
	</div>
	<div class="rowblock">
		<div class="pagewidth">
			<h4><%=request.getAttribute("countryname") %>机房信息</h4>

			<div class="sel_jfdiv">
				<div class="sel_jf_row" id="machine">
					<a href="#" class="moresel"><span>香港01</span>
						<div class="localdiv">
							<div class="localblock">香港01</div>
							<div class="localblock">香港02</div>
						</div></a><a class="active" href="#">北京</a> <a href="#">成都</a><a href="#">重庆</a>
					<a href="#">佛山</a><a href="#">广州</a><a href="#">济南</a> <a href="#">
						南京</a> <a href="#"> 上海</a> <a href="#"> 沈阳</a> <a href="#">石家庄</a> <a
						href="#"> 天津</a> <a href="#"> 温州</a> <a href="#"> 武汉</a> <a
						href="#"> 无锡</a> <a href="#">西安</a> <a href="#"> 珠海</a>
					<div class="clearfloat"></div>
				</div>
				
				<div class="sel_jf_row" style="display: none;">
					<a href="#" class="moresel"><span>香港01</span>
						<div class="localdiv">
							<div class="localblock">香港01</div>
							<div class="localblock">香港02</div>
						</div></a> <a href="#">台湾</a>
				</div>
				<div class="clearfloat"></div>
				
			</div>
			<div class="jf_info">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col"><span class="tableicon t_icon01"></span>总面积</th>
						<th scope="col"><span class="tableicon t_icon02"></span>服务等级协议(SLA)
						</th>
						<th scope="col"><span class="tableicon t_icon03"></span>电力和冷却</th>
						<th scope="col"><span class="tableicon t_icon04"></span>等级资质</th>
					</tr>
					<tr id="singleentity">
						<td>39,390平方米</td>
						<td>100% 正常运作时间<br> 99.9999+% 的历史正常运行时间
						</td>
						<td>电力：N，N+1， 2N UPSs，PDUs和RPPs；N+1<br>
							冷却：N+1，冷却机，CRAHs和 冷水泵
						</td>
						<td>SSAE 16 SOC-1 Type II<br> PCI DSS<br>
							基础设施/物理安全标准符合HIPAA规定<br></td>
					</tr>
				</table>

			</div>
		</div>
	</div>
	<div class="rowblock graybg">
		<div class="pagewidth">
			<h4><%=request.getAttribute("countryname") %>机房托管价格详情</h4>
			<div class="detailstable">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" id="mlink">
					<tr>
						<th scope="col">机房</th>
						<th scope="col">托管规格</th>
						<th scope="col">机柜功率</th>
						<th scope="col">机柜价格(元/月)</th>
					</tr>
					<tr>
						<td rowspan="2">洛杉矶机房</td>
						<td>整柜</td>
						<td>20A/208V</td>
						<td>9050</td>
					</tr>
					<tr>
						<td>整柜</td>
						<td>30A/208V</td>
						<td>12400</td>
					</tr>
					<tr>
						<td>达拉斯机房</td>
						<td>整柜</td>
						<td>30A/120V</td>
						<td>12400</td>
					</tr>
					<tr>
						<td>华盛顿机房</td>
						<td>整柜</td>
						<td>20A/208V</td>
						<td>10050</td>
					</tr>
					<tr>
						<td colspan="2" rowspan="4">国际独享带宽价格（元/Mbps/月）</td>
						<td>&lt;100M</td>
						<td>30</td>
					</tr>
					<tr>
						<td>100M-999M</td>
						<td>27</td>
					</tr>
					<tr>
						<td>1000M-1999M</td>
						<td>24</td>
					</tr>
					<tr>
						<td>&gt;2000M</td>
						<td>17</td>
					</tr>
					<tr>
						<td colspan="2">一次性上架费（元/柜）</td>
						<td colspan="2">10050</td>
					</tr>
				</table>
				<div class="tablemark">以上所有报价均为税前价格，在此基础上需加收6%的增值税。</div>

			</div>
		</div>
	</div>
	<div class="pagebanner">
		<img src="resources/web/images/pagebanner.jpg">
	</div>
	<div class="rowblock">
		<div class="pagewidth">
			<h4>想要了解更多地区的机房价格托管信息，请联系我们。</h4>
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
	<script type="text/javascript">
			
	 var machine = function() {
		return {
			inittable : function() {
				 $.ajax({
						url : 'machine/getFacilityList',
						data : {"countryid":"<%=request.getAttribute("countryid")%>"},
						dataType : 'json',
						async : false,
						type : 'get',
						success : function(json) {
							console.log(json.result);
							if(json.result){
								console.log(json.data);
								var facility="";
								
								facility+="<tr>";
									facility+="<th scope='col'>机房</th>";
									facility+="<th scope='col'>托管规格</th>";
									facility+="<th scope='col'>机柜功率</th>";
									facility+="<th scope='col'>机柜价格(元/月)</th>";
									facility+="</tr>";
								
								$.each(json.data,function(i, obj) {
									console.log(obj.type);
									var length=obj.size;
									if("0"===obj.type){
										$.each(obj.data,function(i,obj){
											console.log(obj.power)
											var option="<tr><td>"+obj.name+"</td><td>"+obj.standard+"</td><td>"+obj.power+"</td><td>"+obj.price+"</td></tr>";
											facility+=option;
										});
									}else if("1"===obj.type){
										$.each(obj.data,function(i,obj){
											console.log(obj.power)
											var option="";
											if(i==0){
												option="<tr><td rowspan="+length+">"+obj.name+"</td><td>"+obj.standard+"</td><td>"+obj.power+"</td><td>"+obj.price+"</td></tr>";
											}else{
												option="<tr><td>"+obj.standard+"</td><td>"+obj.power+"</td><td>"+obj.price+"</td></tr>";
											}
											facility+=option;
										});
									}else if("2"===obj.type){
										$.each(obj.data,function(i,obj){
											console.log(obj.power)
											var option="";
											if(i==0){
												option="<tr><td colspan='2' rowspan="+length+">"+obj.name+"</td><td>"+obj.power+"</td><td>"+obj.price+"</td></tr>";
											}else{
												option="<tr><td>"+obj.power+"</td><td>"+obj.price+"</td></tr>";
											}
											facility+=option;
										});
									}else if("3"===obj.type){
										$.each(obj.data,function(i,obj){
											console.log(obj.power)
											var option="<tr><td colspan='2'>"+obj.name+"</td><td colspan='2'>"+obj.power+"</td></tr>";
											facility+=option;
										});
									}
								});
								
								$("#mlink").html(facility);
							}
						}
					});
			},
			initmachine:function(){
				 $.ajax({
						url : 'machine/getNodeList',
						data : {"countryid":"<%=request.getAttribute("countryid")%>"},
						dataType : 'json',
						async : false,
						type : 'get',
						success : function(json) {
							console.log(json);
							if(json.result){
								var machinehtml="";
								$.each(json.ret,function(i, obj) {
									console.log(obj.name);
									if(obj.size==1){
										$.each(obj.node,function(j, obj) {
											console.log(obj.name);
											machinehtml+="<a href='#' id='"+obj.id+"'>"+obj.name+"</a>";
										}); 
									}else if(obj.size>1){
										$.each(obj.node,function(j, obj) {
											console.log(obj.name);
											if(j==0){
												machinehtml+="<a href='#' class='moresel' id='"+obj.id+"'><span>"+obj.name+"</span>";
												machinehtml+="<div class='localdiv'>";
											}
											machinehtml+="<div class='localblock' id='"+obj.id+"'>"+obj.name+"</div>";
										}); 
										machinehtml+="</div></a>";
									}
								});
								machinehtml+="<div class='clearfloat'></div>"
								$("#machine").html(machinehtml);
							}
						}
				 });	
			},
			initsingle:function(nodeid){
				 $.ajax({
						url : 'machine/getSingleEntity',
						data : {"nodeid":nodeid},
						dataType : 'json',
						async : false,
						type : 'get',
						success : function(json) {
							console.log(json);
							if(json.result){
								$("#singleentity").html("<td>"+json.single.area+"</td><td>"+json.single.protocol+"</td><td>"+json.single.electricity+"</td><td>"+json.single.authentication+"</td>");
							}else{
								$("#singleentity").html("");
							}
						}
				 });	
			}
				 
			};
		}();	
	
	</script>
</body>
</html>
