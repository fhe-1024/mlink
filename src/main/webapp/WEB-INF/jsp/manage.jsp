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
	
<script type="text/javascript" src="resources/manage/mlink_basic.js"></script>	
<script type="text/javascript" src="resources/manage/mlink_facility.js"></script>	
</head>
<body>


	<div id="tabs" class="easyui-tabs" style="width: 100%; min-height:100%;margin:0px;">
		<div title="基本数据" style="padding: 10px">
			<div class="easyui-layout" style="width: 100%; height: 800px;">
				<div data-options="region:'west',split:true" title="mlink-大洲-国家-城市-节点"
					style="width: 200px;">
					<ul class="easyui-tree" id="tt"  >
					</ul>
				</div>
				<div
					data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
					<table class="easyui-datagrid" id="node_table">
					</table>
				</div>
			</div>
		</div>
		<div title="机房详情" style="padding: 10px" >
			<div class="easyui-layout" style="width: 100%; height: 800px;">
				<div data-options="region:'west',split:true" title="mlink-大洲-国家"
					style="width: 200px;">
					<ul class="easyui-tree" id="facility"  >
					</ul>
				</div>
				<div
					data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
					<table class="easyui-datagrid" id="facility_table">
					</table>
				</div>
			</div>
		</div>
		<div title="节点信息" style="padding: 10px" >
			<div class="easyui-layout" style="width: 100%; height: 800px;">
				<div data-options="region:'west',split:true" title="mlink-大洲-国家-城市-节点"
					style="width: 200px;">
					<ul class="easyui-tree" id="single"  >
					</ul>
				</div>
				<div
					data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
					<table class="easyui-datagrid" id="single_table">
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div id="window" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save'" style="width:500px;padding:10px;">
		 <form id="levelform">
		 	<input type="hidden" name="levelid" value="">
		 	<input type="hidden" name="levelname" value="">
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="名称：" name="level_name" labelPosition="top" style="width:100%;height:52px">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="排序：" name="sort" labelPosition="top" style="width:100%;height:52px">
        </div>
       
        <div>
            <a onclick="basic.addLevel();" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">Submit</a>
        </div>
        </form>
	</div>
	
	<div id="facilitywindow" class="easyui-window" title="Basic Window" data-options="iconCls:'icon-save'" style="width:500px;padding:10px;">
		 <form id="facilityform">
		 	<input type="hidden" name="facility_countryid" value=""/>
		 	 <div style="margin-bottom:20px">
                <select class="easyui-combobox" name="facility_type" label="类型:" labelPosition="top" style="width:100%;height: 52px;">
                	<option value="0">机房-托管规格-机柜功率-机柜价格</option>
                	<option value="1">(机房)-托管规格-机柜功率-机柜价格</option>
                	<option value="2">(机房-托管规格)-机柜功率-机柜价格</option>
                	<option value="3">(机房-托管规格)-(机柜功率-机柜价格)</option>
            	</select>
            </div>
             <div style="margin-bottom:20px">
	            <input class="easyui-textbox" label="排序：" name="facility_sort" labelPosition="top" style="width:100%;height:52px">
	        </div>
	        <div style="margin-bottom:20px">
	            <input class="easyui-textbox" label="机房：" name="facility_name" labelPosition="top" style="width:100%;height:52px">
	        </div>
	        <div style="margin-bottom:20px">
	            <input class="easyui-textbox"  label="托管规格：" name="facility_standard" labelPosition="top" style="width:100%;height:80px" data-options="label:'Message:',multiline:true">
	        </div>
	        <div style="margin-bottom:20px">
	            <input class="easyui-textbox"  label="机柜功率：" name="facility_power" labelPosition="top" style="width:100%;height:80px" data-options="label:'Message:',multiline:true">
	        </div>
	        <div style="margin-bottom:20px">
	            <input class="easyui-textbox"  label="机柜价格：" name="facility_price" labelPosition="top" style="width:100%;height:80px" data-options="label:'Message:',multiline:true">
	        </div>
	       
	        <div>
	            <a onclick="facility.addFacility();" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">Submit</a>
	        </div>
        </form>
	</div>
	
	
	<script type="text/javascript">
	
	 $(function(){
		 basic.init();
		 $("#window").window("close");
		 $("#facilitywindow").window("close");
		 $('#tabs').tabs({
			    border:false,
			    onSelect:function(title,index){
			    	if(index=='0'){
			    		basic.init();
			    	}else if(index=='1'){
			    		facility.init();
			    	}
			    }
			});
     });
	 
	 var single = function() {
			return {
				init : function() {
					console.log(document.body.clientHeight);
					$("#single_table").datagrid({
						width:document.body.clientWidth-300,
						height:750,
						nowrap: true,
						autoRowHeight: false,
						striped: true,
						collapsible:true,
						singleSelect : true,
						url:'single/getNodeList',
						sortOrder: 'desc',
						remoteSort: false,
						columns:[[ 
							{field:"name",title:"名称",width:'20%'},
							{field:"sort",title:"排序",width:'20%'},
							{field:"description",title:"描述",width:'60%'}
						]],
						pagination:true,
						rownumbers:true,
						toolbar:[{
							id:'btnedt',
							text:'添加节点',
							iconCls:'icon-edit',
							handler:function(){
								var node = $('#tt').tree('getSelected');
								if (node){
										console.log(node.text+":"+node.id+":"+node.level);
										if("node"!=node.level){
											$("#window").window("open");
											$("input[name='levelid']").val(node.id);
											$("input[name='levelname']").val(node.level);
										}else{
											$.messager.show({
								                title:'警告',
								                msg:':)',
								                showType:'show'
								            });
										}
								}
							}
						}]
					});
					
					$("#single").tree({
						url:"tree/getTreeMenu",
						method:"get",
						animate:"true",
						lines:true,
			            onClick:function(node){  
			                console.log(node.id+":"+node.level);
			                $("#node_table").datagrid("reload",{"level":node.level,"id":node.id});
			            }  
			        });  
				},
	
				addLevel:function(){
					$.ajax({
						url : 'tree/saveLevel',
						data : $('#levelform').serialize(),
						dataType : 'json',
						async : false,
						type : 'post',
						success : function(json) {
							if(json.result){
								var node = $('#tt').tree('getSelected');
								if(node){
									$.messager.show({
						                title:'小提示',
						                msg:'添加成功',
						                showType:'show'
						            });
									//重新加载表格
									$("#node_table").datagrid("reload",{"level":node.level,"id":node.id});
									//树形菜单加上
									console.log(json.id);
									var nodes=[{
										"id":json.id,
										"text":$("input[name='level_name']").val(),
										"level":json.level
									}];
									$('#tt').tree('append', {
										parent:node.target,
										data:nodes
									});
									//关闭窗口
									$("#window").window("close");
								}
							}else{
								$.messager.show({
					                title:'小提示',
					                msg:'添加失败',
					                showType:'show'
					            });
							}
						}
					});
			}
		};
	}();
	

	</script>
</body>
</html>