<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传</title>
<link href="<%=path%>/js/inputFile/inputfile.css" type="text/css" rel="Stylesheet" />
<script src="<%=basePath %>dist/js/jquery-1.11.2.js"></script>
<script src="<%=basePath %>js/inputFile/jquery.easyDrag.js.js"></script>
<style type="text/css">
.imgbox, .imgbox1 {
	float: left;
	margin-right: 20px;
	margin-top: 20px;
	position: relative;
	width: 182px;
	height: 142px;
	border: 1px solid red;
	overflow: hidden;
}

.imgbox1 {
	border: 1px solid blue;
}

.imgnum {
	left: 0px;
	top: 0px;
	margin: 0px;
	padding: 0px;
}

.imgnum input, .imgnum1 input {
	position: absolute;
	width: 182px;
	height: 142px;
	opacity: 0;
}

.imgnum img, .imgnum1 img {
	width: 100%;
	height: 100%;
}

.close, .close1 {
	color: red;
	position: absolute;
	left: 170px;
	top: 0px;
	display: none;
}
</style>
</head>
<body>
	<div id="img">
		<div class="imgbox">
			<div class="imgnum">
				<input type="file" class="filepath" /> <span class="close">X</span>
				<img src="btn.png" class="img1" /> <img src="" class="img2" />
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
    $(function() {
        $(".filepath").on("change",function() {
            var srcs = getObjectURL(this.files[0]);   //获取路径
            $(this).nextAll(".img1").hide();   //this指的是input
            $(this).nextAll(".img2").show();  //fireBUg查看第二次换图片不起做用
            $(this).nextAll('.close').show();   //this指的是input
            $(this).nextAll(".img2").attr("src",srcs);    //this指的是input
			$(this).val('');    //必须制空
            $(".close").on("click",function() {
                $(this).hide();     //this指的是span
                $(this).nextAll(".img2").hide();
                $(this).nextAll(".img1").show();
            })
        })
    })

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file)
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file)
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file)
        }
        return url
    };

    $(function() {
        $("#img").on("change",".filepath1",function() {
            //alert($('.imgbox1').length);
            var srcs = getObjectURL(this.files[0]);   //获取路径
            //this指的是input
            /* $(this).nextAll(".img22").attr("src",srcs);    //this指的是input
             $(this).nextAll(".img22").show();  //fireBUg查看第二次换图片不起做用*/
            var htmlImg='<div class="imgbox1">'+
                    '<div class="imgnum1">'+
                    '<input type="file" class="filepath1" />'+
                    '<span class="close1">X</span>'+
                    '<img src="btn.png" class="img11" />'+
                    '<img src="'+srcs+'" class="img22" />'+
                    '</div>'+
                    '</div>';

            $(this).parent().parent().before(htmlImg);
			$(this).val('');    //必须制空
            $(this).parent().parent().prev().find(".img11").hide();   //this指的是input
            $(this).parent().parent().prev().find('.close1').show();

            $(".close1").on("click",function() {
                $(this).hide();     //this指的是span
                $(this).nextAll(".img22").hide();
                $(this).nextAll(".img11").show();
                if($('.imgbox1').length>1){
                    $(this).parent().parent().remove();
                }

            })
        })
    })

</script>
</html>