window.onload=function(){
	$("#title").focus()
}
$("input").blur(function(){
	$(".validate_faqadd").css("color","#BD362F")
	if($(this).is("#title")){				//faq标题判断
		var na = /^\S{2,44}$/
		if($("#title").val()!=""){
			if(!(na.test($("#title").val()))){
				$(".spa1").text("请输入2-44个字符");
				$(this).css("border","1px solid #BD362F")
				return false;
			}else if(na){
				$(".spa1").text("");
				return true;
			}
		}else{
			$(".spa1").text("");
		}
	}
	if($(this).is("#keywords")){            //关键词判断
		var kw= /^\S{2,30}$/
		if($("#userkwone").val()!=""){
		if(!(kw.test($("#keywords").val()))){
			$(".spa3").text("请输入2-30个字符");
			$(this).css("border","1px solid #BD362F")
			return false;
		}else if(kw){
			$(".spa3").text("");
			return true;
		}
		}else{
			$(".spa3").text("");
		}
	}
})

$("textarea").blur(function(){
	$(".validate_faqadd").css("color","#BD362F")
	if($(this).is("#description")){				//简介的判断
		var dp = /^\S{2,100}$/
		if($("#description").val()!=""){
			if(!(dp.test($("#description").val()))){
				$(".spa5").text("请输入2-100个字符");
				$(this).css("border","1px solid #BD362F")
				return false;
			}else if(dp){
				$(".spa5").text("");
				return true;
			}
		}else{
			$(".spa5").text("");
		}
	}
	if($(this).is("#risk_prompt")){				//风险的判断
		var rp = /^\S{0,100}$/
		if($("#risk_prompt").val()!=""){
			if(!(rp.test($("#risk_prompt").val()))){
				$(".spa6").text("请输入至多100个字符");
				$(this).css("border","1px solid #BD362F")
				return false;
			}else if(rp){
				$(".spa6").text("");
				return true;
			}
		}else{
			$(".spa6").text("");
		}
	}
})

$("input").focus(function(){
	if($(this).is("#title")){
		$(".spa1").text("不超过44个字符").css("color","#aaa")
		$(this).css("border","1px solid #aaa")
	}
	if($(this).is("#keywords")){
		$(".spa3").text("输入关键词用逗号隔开").css("color","#aaa")
		$(this).css("border","1px solid #aaa")
	}
})

$("textarea").focus(function(){
	if($(this).is("#description")){
		$(".spa5").text("不超过100个字符").css("color","#aaa")
		$(this).css("border","1px solid #aaa")
	}
	if($(this).is("#risk_prompt")){
		$(".spa6").text("不超过100个字符").css("color","#aaa")
		$(this).css("border","1px solid #aaa")
	}
})