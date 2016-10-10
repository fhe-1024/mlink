$(function(){
$(".meun li").hover(function(){
	$(this).css('background-color', '#142D55');
	},function(){$(this).css('background-color', '');})
 
$(".meun li").has("ol").find("span").addClass("moremeun");
	
	
	
	$('.meun li').mouseover(function(){
		if(!$(".meun li").find("ol").is(":animated")){$(this).find("ol").slideDown();}
		});
	$('.meun li').mouseout(function(){
		if(!$(".meun li").find("ol").is(":animated")){$(this).find("ol").slideUp();}
		});
		
	})