/**
 * Created by huangxueping on 2016/10/19.
 */
$(function(){
	alert("aa");
    var index=window.location.href.split('/').length-1;
    var href=window.location.href.split('/')[index].substr(0,4);
    $(".header .nav li a[href^='"+href+"']").addClass("on");


    var li_width=$(".header .nav li a.on").outerWidth();//li或者a的宽度
    var li_left=$(".header .nav li a.on").position().left;
    $(".header  .line").css({width:li_width,left:li_left});//线的宽度，距离左边的距离



//鼠标事件
    $(".nav li a").hover(function(){
        var li_width=$(this).outerWidth();
        var li_left=$(this).position().left;
        $(".nav .line").stop().animate({width:li_width,left:li_left},{duration:1500,easing:"easeOutElastic"})

//移入

    },function(){

        $(".nav .line").stop().animate({width:li_width,left:li_left},{duration:1500,easing:"easeOutElastic"})
//移除
    });
    
    
  

});