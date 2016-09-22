<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic Layout - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="resources/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="resources/easyui/demo.css">
<script type="text/javascript" src="resources/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<!-- 
	<h2>mLink</h2>
	<div style="margin: 20px 0 10px 0;"></div>
	 -->
	<div class="easyui-tabs" style="width: 100%; height: 850px">
		<div title="基本数据" style="padding: 10px">
			<div class="easyui-layout" style="width: 100%; height: 700px;">
				<div data-options="region:'west',split:true" title="West"
					style="width: 200px;">
					<ul class="easyui-tree" id="tt" data-options="url:'area/get',method:'get',animate:true">
						
					</ul>
				</div>
				<div
					data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
					<table class="easyui-datagrid" id="account_table">
						
					</table>
				</div>
			</div>
		</div>
		<div title="统计分析" style="padding: 10px"></div>
		<div title="Help" data-options="iconCls:'icon-help',closable:true"
			style="padding: 10px">This is the help content.</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#account_table").datagrid({
			width:1400,
			height:800,
			nowrap: true,
			autoRowHeight: false,
			striped: true,
			collapsible:true,
			singleSelect : true,
			url:'accountManage/accountManage_searchAccountManageList',
			sortOrder: 'desc',
			remoteSort: false,
			columns:[[ 
				{field:"xfOrgId",title:"企业号",width:150},
				{field:"loginCode",title:"用户账号",width:150},
				{field:"createTime",title:"账号创建时间",width:150},
				{field:"money",title:"账户余额",width:100},
				{field:"rate",title:"外呼费率（元/分钟）",width:150},
				{field:"rateIn",title:"呼入费率（元/分钟）",width:150},
				{field:"id",title:"审核历史",width:150,
					formatter:function(value,row,index){
						if(value!=''){
							return "<a style='cursor:pointer;color: blue;' onclick='onView(\""+value+"\")'>详情</a>";
						}else{
							return "";
						}
					}		
				}
			]],
			pagination:true,
			rownumbers:true,
			toolbar:[{
				id:'btnedt',
				text:'添加节点',
				iconCls:'icon-edit',
				handler:function(){
					var node = $('#tt').tree('getSelected');
					alert(node.text);
					if (node){
						var nodes = [{
							"id":13,
							"text":"Raspberry"
						},{
							"id":14,
							"text":"Cantaloupe"
						}];
						$('#tt').tree('append', {
							parent:node.target,
							data:nodes
						});
					}
				}
			},'-',{
				id:'btnedt',
				text:'修改节点',
				iconCls:'icon-edit',
				handler:function(){
					editCharge();
				}
			}]
		});
	});
	</script>
</body>
</html>