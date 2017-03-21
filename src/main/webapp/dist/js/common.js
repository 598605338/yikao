function clickToChangeTit(_obj,_tit){
	_obj.each(function(){
		$(this).on("click",function(){
			var $t=$(this);
			_obj.removeClass("cont_aside_header");
			$(".cont_aside div").each(function(i){
				if($(".cont_aside div").eq(i).hasClass("cont_aside_item")){
					
				}else{
					$(this).addClass("hid");
				}
			});
			$t.addClass("cont_aside_header");
			if($t.next().hasClass("hid")){
				$t.next().removeClass("hid");
			}
			_tit.text($t.text());
		});
	});
}
//点击切换类名
function clickClass(_obj,_str){
	_obj.each(function(){
		$(this).on("click",function(){
			_obj.removeClass(_str);
			$(this).addClass(_str)
		});
	});
}
$(document).ready(function(){
	//clickToChangeTit($(".cont_aside_item"),$(".cont_section_header"));
	clickClass($(".page"),"page_chose");
});

//弹出窗口
function popupProOpen(){
	document.getElementById('fade').style.display='block'
	document.getElementById('popupDiv').style.display='block'
}
function popupProClose(){
	document.getElementById('fade').style.display='none'
	document.getElementById('popupDiv').style.display='none'
}


//弹出门店窗口
function popupProOpen1(){
	document.getElementById('fade1').style.display='block'
	document.getElementById('popupDiv1').style.display='block'
}
function popupProClose1(){
	document.getElementById('fade1').style.display='none'
	document.getElementById('popupDiv1').style.display='none'
}

//只能输入两位小数
function clearNoNum(obj){
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字而不是
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3'); //只能输入两个小数
}


$(function(){
	//一级导航
	$(".topNavClick").click(function(){
		window.parent.$('.top_act').trigger("click");
	})
	//二级导航
	$(".leftNavClick").click(function(){
		var tmpHref = window.parent.$('.cont_aside_item.active').find("a").get(0).href;
		window.parent.$('#target').attr("src",tmpHref);
	});
	$(".leftNavClickList").click(function(){
		var tmpHref =window.parent.$('.listt a.word').get(0).href;
		window.parent.$('#target').attr("src",tmpHref);
	});
})


//模糊搜索的中的select，默认第一个颜色是灰色，选中之后是黑色。
$(function(){
	//初始化select颜色
	$('select').each(function(){
		/*console.log($(this))
		console.log($(this).get(0).selectedIndex)*/
		$(this).get(0).selectedIndex == 0 ? $(this).css('color','gray'):$(this).css('color','black');
	})
	//切换的时候变化颜色
	$('select').change(function(){
		$(this).get(0).selectedIndex == 0 ? $(this).css('color','gray'):$(this).css('color','black');
	})
})


//初始化模糊搜索的宽度，实现响应式，自动计算宽度。
$(function(){
	searchWidth();
})
$(window).resize(function(){
	searchWidth();
})

function searchWidth(){
	//按钮的宽度
	var btnWidth = 240;
	//当前一行可以放几个
	var mayNum = (Math.floor(($(".cont_section_head").width()-btnWidth) / $(".row").children(":visible").eq(0).outerWidth(true))) * $(".row").children(":visible").eq(0).outerWidth(true);
	//实际有几个
	var shiji = $(".row").children(":visible").length*$(".row").children(":visible").eq(0).outerWidth(true);
	mayNum < shiji ?　$(".row").css("width",mayNum+"px"):$(".row").css("width",shiji+"px");
}