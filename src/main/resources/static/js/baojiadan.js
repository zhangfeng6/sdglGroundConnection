function qiehuan(dd){
    var a=$(dd).next().next();
    var b=$(a).is(":hidden") ?0:1;
    if(b==0){
        $(dd).attr("src","/images/up.PNG");
    }else{
        $(dd).attr("src","/images/down.PNG");
    }
    $(a).slideToggle();

}
function xianlu1(obj){
    var text=$(obj).html();
    if(text=="自行填写"){
        $(obj).parent().prev().html("<input type='text' class='layui-input'>");
		$(obj).html("选择模板");
    }else{
        var content="<select name='lineArriveName' lay-verify='required'><option>请选择</option>";
        $.ajax({
            url:"/Template/selectTemplate",
            data:{},
            dataType:"json",
            async: false,
            type:"get",
            success:function (data) {
                $.each(data.data,function(i,e){
                    content+="<option value='"+e.templateId+"'>"+e.templateName+"</option>";
                })
                content+="</select>";
            }
        })
        $(obj).parent().prev().html(content);
		$(obj).html("自行填写");
	}



	layui.use(['form', 'layedit', 'laydate','element'], function() {
		var form = layui.form,
			layer = layui.layer,
			layedit = layui.layedit,
			element=layui.element,
			laydate = layui.laydate,
			a;
		element.render( 'test1');
		form.render(); //更新全部
		form.render('select'); //刷新select选择框渲染
	});
}


function muban1(obj){
    var text=$(obj).html();
    if(text=="自行填写"){
        $(obj).parent().prev().html("<input type='text' class='layui-input'>");
        $(obj).html("选择模板");
    }else{
        var content="<select name=\"tourismtemplateName\" lay-filter=\"muban\"><option>请选择</option>";
        $.ajax({
            url:"/Tourismtemplate/selectTourismtemplate",
            data:{},
            dataType:"json",
            async: false,
            type:"get",
            success:function (data) {
                $.each(data.data,function(i,e){
                    content+="<option value='"+e.tourismId+"'>"+e.tourismtemplateName+"</option>";
                })
                content+="</select>";
            }
        })
        $(obj).parent().prev().html(content);
        $(obj).html("自行填写");
    }



    layui.use(['form', 'layedit', 'laydate','element'], function() {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element=layui.element,
            laydate = layui.laydate,
            a;
        element.render( 'test1');
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染
    });
}





function shanchu(aa){
    var a=$(aa).parent();
    $(aa).parent().next().remove();
    a.remove();
}

/*function insertJingdian(onClickjd) {
        $(onClickjd).parent().parent().next().after("<tr id='scenic'>"+
            "<td><label class='layui-form-label'>景点</label></td>"+
            "<td>"+
            "<select name='scenicSpotName' lay-verify='required' lay-filter=\"jingdian\">"+
            "</select>"+
            "</td>"+
            "<td><label class='layui-form-label'>成本价:</label></td>"+
            "<td><input type='text' class='layui-input'></td>"+
            "<td><label class='layui-form-label'>报价:</label></td>"+
            "<td><input type='text' class='layui-input'></td>"+
            "<td style='bottom: 0px;'><label class='layui-form-label' onclick='san(this)'>×</label></td>"+
            "</tr>");
    layui.use(['form', 'layedit', 'laydate','element'], function() {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element=layui.element,
            laydate = layui.laydate,
            a;
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染
    });
    listScenicspotAll();
}*/



function insertJingdian(onClickjd) {
    var a = $(onClickjd);
    var A=$("[name=scenic]");
    /*if(A.length==5){
        alert("最多可选择五个景点！");
        return;
    }*/
    var index=parseInt(A.length)+1;
    var content = $("#jingdian").html();
    //var content=$("select[name=scenicSpotName]").html();
    $(onClickjd).parent().parent().parent().find("[name=wucai]").before("<tr id=\"scenic1\" name=\"scenic\" class=\"scenic\">\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">景点</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"jingdian\">\n" +
        "\t\t\t\t\t\t\t\t\t<select id=\"jingdian\" name=\"scenicSpotName\" lay-verify=\"required\" lay-filter=\"jingdian\">"+content+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价:</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"jdcostPrice\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价:</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"jdoffer\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t</tr>");
    layui.use(['form', 'layedit', 'laydate','element'], function() {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element=layui.element,
            laydate = layui.laydate,
            a;
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染
    });
}






/*function appss(onClickjd) {
    var A=$("[name=zong]");
    if(A.length==5){
        alert("最多可选择五天行程！");
        return;
    }
    var B=$("[name=scenic]");
    var index1=parseInt(B.length)+1;
    var index=parseInt(A.length)+1;
    var content=$("#zong1").html();
    $(onClickjd).parent().after("<div id='zong"+index+"' lay-filter='test1'>"+content+"</div>");
    var a = "#zong"+index;
    $(a).find("[name=scenic]").attr("id","#scenic"+index1);
    layui.use(['form', 'layedit', 'laydate','element'], function() {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element=layui.element,
            laydate = layui.laydate,
            a;
        element.render( 'test1');
        form.render(); //更新全部
        form.render('select','skt'); //刷新select选择框渲染
    });
}*/







	function  san(dang){
      $(dang).parent().parent().remove();
	}
			function addss1() {
                var laydate;

                var A=$("[name=zong]");
                var xianlu = $("#xianlu").html();
                var jiudian = $("#jiudian").html();
                var jingdian = $("#jingdian").html();
                var wucan = $("#wucan").html();
                var wancan = $("#wancan").html();
                var index=parseInt(A.length)+1;
				var a = "<div id='zong"+index+"' name=\"zong\" lay-filter=\"test1\">\n" +
                    "\t\t\t<div style='margin-bottom: 30px;width: 800px'>\n" +
                    "\t\t\t\t<input type=\"image\" src=\"/images/up.PNG\" style=\"height: 30px;width: 35px;\" id=\"toggle\" onclick='qiehuan(this)' />\n" +
                    "\t\t\t\t<input type=\"image\" id=\"sc\" src=\"/images/del.PNG\" onclick='shanchu(this)' style=\"display:inline-block;float: right;height: 30px;width: 35px;\" />\n" +
                    "\t\t\t\t<div id=\"content\">\n" +
                    "\t\t\t\t\t<form class=\"layui-form layui-form-pane\" action=\"\">\n" +
                    "\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">线路</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class='xzxianlu'>\n" +
                    "\t\t\t\t\t\t\t\t\t<select name=\"lineArriveName\" lay-verify=\"required\" lay-search lay-filter=\"xianlu\">"+xianlu+"</select>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t<td colspan=\"2\">&nbsp;<button type=\"button\" class='layui-btn layui-btn-normal layui-btn-radius' style='height: 30px;width: 100px;' onclick=\"xianlu1(this)\">自行填写</button></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">日期</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"date\" id=\"date2\" lay-verify=\"date\" placeholder=\"yyyy-MM-dd\" autocomplete=\"off\" class=\"layui-input\" lay-key=\"4\">\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">酒店</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"jiudian\">\n" +
                    "\t\t\t\t\t\t\t\t\t<select class=\"hotelName\" name=\"hotelName\" lay-verify=\"required\" lay-filter=\"jiudian\">"+jiudian+"</select>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><input name=\"jcostPrice\" type=\"text\" class=\"layui-input\"></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><input name=\"joffer\" type=\"text\" class=\"layui-input\"></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<!--点击新增景点-->\n" +
                    "\t\t\t\t\t\t\t<tr id=\"onClickjd\">\n" +
                    "\t\t\t\t\t\t\t\t<td colspan=\"2\" class='tian'><button id=\"tian\" class=\"layui-btn\" type=\"button\" style=\"font-size: 12px\" onclick=\"insertJingdian(this)\">添加景点+</button></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<!--点击新增结束-->\n" +
                    "\t\t\t\t\t\t\t<tr id=\"scenic1\" name=\"scenic\" class=\"scenic\" >\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">景点</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"jingdian\">\n" +
                    "\t\t\t\t\t\t\t\t\t<select name=\"scenicSpotName\" lay-verify=\"required\" lay-filter=\"jingdian\">"+jingdian+"</select>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价:</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><input name=\"jdcostPrice\" type=\"text\" class=\"layui-input\"></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价:</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><input name=\"jdoffer\" type=\"text\" class=\"layui-input\"></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<tr name=\"wucai\">\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">午餐</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"wuc\">\n" +
                    "\t\t\t\t\t\t\t\t\t<select name=\"typeName\" lay-verify=\"required\" lay-filter=\"wucan\">"+wucan+"</select>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label  class=\"layui-form-label\">成本价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"wucb\"><input type=\"text\" class=\"layui-input\" name=\"cb\"></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"wubj\"><input type=\"text\" class=\"layui-input\" name=\"bj\"></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">晚餐</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class='wanc'>\n" +
                    "\t\t\t\t\t\t\t\t\t<select name=\"typeName\" lay-verify=\"required\" lay-filter=\"wancan\">"+wancan+"</select>\n" +
                    "\t\t\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"wancb\"><input type=\"text\" class=\"layui-input\" name=\"cb\"></td>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td class=\"wanbj\"><input type=\"text\" class=\"layui-input\" name=\"bj\"></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t\t<tr>\n" +
                    "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">行程</label></td>\n" +
                    "\t\t\t\t\t\t\t\t<td colspan=\"5\"> <textarea  name=\"trip\" placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea></td>\n" +
                    "\t\t\t\t\t\t\t</tr>\n" +
                    "\t\t\t\t\t\t</table>\n" +
                    "\t\t\t\t\t</form>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<!---中结束-->\n" +
                    "\t\t</div>";
				$("#add").before(a);
                /*selectTourismtemplate();
                selectofferline();
                selectHotel();
                listScenicspotAll();
                selectMealType();
                selectTravel();*/
                /*var b = $("#add");
				b.remove();*/
				/*var f = "<button class='layui-btn layui-btn-normal layui-btn-radius' onclick='addss()' id='add'>十</button>";
				$("#zong").append(f);*/
                layui.use(['form', 'layedit', 'laydate','element'], function() {
                    var form = layui.form,
                        laydate = layui.laydate,
                        element=layui.element;
                    laydate.render({
                        elem: '[name=date]'
                        ,type: 'datetime'
                    });
                });
				layui.form.render('select');
			}

function gouwudiyes(obj){

    $(obj).parent().next().html("<select><option>请选择购物地</option></select>");
}

function gouwudino(obj){
    $(obj).parent().next().html("");
}
function addjd(obj){
    var jd=$(obj).prev().val();
    var textar= $(obj).next().html();
    $(obj).next().html(textar+jd+",");
}
function deljd(obj){
    $(obj).prev().text("");
}




function addss2() {
    var laydate;
    var A=$("[name=zong]");
    var xianlu = $("#xianlu").html();
    var jiudian = $("#jiudian").html();
    var jingdian = $("#jingdian").html();
    var wucan = $("#wucan").html();
    var wancan = $("#wancan").html();
    var index=parseInt(A.length)+1;
    var a = "<div id='zong"+index+"' name=\"zong\" lay-filter=\"test1\">\n" +
        "\t\t\t<div style='margin-bottom: 30px;width: 800px'>\n" +
        "\t\t\t\t<input type=\"image\" src=\"/images/up.PNG\" style=\"height: 30px;width: 35px;\" id=\"toggle\" onclick='qiehuan(this)' />\n" +
        "\t\t\t\t<input type=\"image\" id=\"sc\" src=\"/images/del.PNG\" onclick='shanchu(this)' style=\"display:inline-block;float: right;height: 30px;width: 35px;\" />\n" +
        "\t\t\t\t<div id=\"content\">\n" +
        "\t\t\t\t\t<form class=\"layui-form layui-form-pane\" action=\"\">\n" +
        "\t\t\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
        "\t\t\t\t\t\t\t<tr>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">线路</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class='xzxianlu'>\n" +
        "\t\t\t\t\t\t\t\t\t<select name=\"lineArriveName\" lay-verify=\"required\" lay-search lay-filter=\"xianlu\">"+xianlu+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td colspan=\"2\">&nbsp;<button type=\"button\" class='layui-btn layui-btn-normal layui-btn-radius' style='height: 30px;width: 100px;' onclick=\"xianlu1(this)\">自行填写</button></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<tr>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">日期</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td>\n" +
        "\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"date\" id=\"date2\" lay-verify=\"date\" placeholder=\"yyyy-MM-dd\" autocomplete=\"off\" class=\"layui-input\" lay-key=\"4\">\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\n" +
        "\t\t\t\t\t\t\t<tr>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">酒店</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"jiudian\">\n" +
        "\t\t\t\t\t\t\t\t\t<select class=\"hotelName\" name=\"hotelName\" lay-verify=\"required\" lay-filter=\"jiudian\">"+jiudian+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"jcostPrice\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"joffer\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<!--点击新增景点-->\n" +
        "\t\t\t\t\t\t\t<tr id=\"onClickjd\">\n" +
        "\t\t\t\t\t\t\t\t<td colspan=\"2\" class='tian'><button id=\"tian\" class=\"layui-btn\" type=\"button\" style=\"font-size: 12px\" onclick=\"insertJingdian(this)\">添加景点+</button></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<!--点击新增结束-->\n" +
        "\t\t\t\t\t\t\t<tr id=\"scenic1\" name=\"scenic\" class=\"scenic\" >\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">景点</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"jingdian\">\n" +
        "\t\t\t\t\t\t\t\t\t<select name=\"scenicSpotName\" lay-verify=\"required\" lay-filter=\"jingdian\">"+jingdian+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价:</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"jdcostPrice\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价:</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td><input name=\"jdoffer\" type=\"text\" class=\"layui-input\"></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<tr name=\"wucai\">\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">午餐</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"wuc\">\n" +
        "\t\t\t\t\t\t\t\t\t<select name=\"typeName\" lay-verify=\"required\" lay-filter=\"wucan\">"+wucan+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td><label  class=\"layui-form-label\">成本价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"wucb\"><input type=\"text\" class=\"layui-input\" name=\"cb\"></td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"wubj\"><input type=\"text\" class=\"layui-input\" name=\"bj\"></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<tr>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">晚餐</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class='wanc'>\n" +
        "\t\t\t\t\t\t\t\t\t<select name=\"typeName\" lay-verify=\"required\" lay-filter=\"wancan\">"+wancan+"</select>\n" +
        "\t\t\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">成本价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"wancb\"><input type=\"text\" class=\"layui-input\" name=\"cb\"></td>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">报价</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td class=\"wanbj\"><input type=\"text\" class=\"layui-input\" name=\"bj\"></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t\t<tr>\n" +
        "\t\t\t\t\t\t\t\t<td><label class=\"layui-form-label\">行程</label></td>\n" +
        "\t\t\t\t\t\t\t\t<td colspan=\"5\"> <textarea  name=\"trip\" placeholder=\"请输入内容\" class=\"layui-textarea\"></textarea></td>\n" +
        "\t\t\t\t\t\t\t</tr>\n" +
        "\t\t\t\t\t\t</table>\n" +
        "\t\t\t\t\t</form>\n" +
        "\t\t\t\t</div>\n" +
        "\t\t\t</div>\n" +
        "\t\t\t<!---中结束-->\n" +
        "\t\t</div>";
    $("#add").before(a);
    /*selectTourismtemplate();
    selectofferline();
    selectHotel();
    listScenicspotAll();
    selectMealType();
    selectTravel();*/
    /*layui.use(['form', 'layedit', 'laydate','element'], function() {
            var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element=layui.element,
            laydate = layui.laydate,
            a;
            element.render( 'test1');
            form.render(); //更新全部
            form.render('select'); //刷新select选择框渲染
    });*/
    layui.use(['form', 'layedit', 'laydate','element'], function() {
        var form = layui.form,
            laydate = layui.laydate,
            element=layui.element;
        laydate.render({
            elem: '[name=date]'
            ,type: 'datetime'
        });
    });
    /*var b = $("#add");
    b.remove();*/
    /*var f = "<button class='layui-btn layui-btn-normal layui-btn-radius' onclick='addss()' id='add'>十</button>";
    $("#zong").append(f);*/
    //layui.form.render('select');
}