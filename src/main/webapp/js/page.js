var remJSON = null;
var pageNum;
var detailsRender;

require( [
    "esri/map",
    "esri/symbols/SimpleMarkerSymbol",
    "esri/geometry/Point",
    "esri/toolbars/draw",
    "esri/layers/GraphicsLayer", "esri/graphic",
    "esri/Color",
    "esri/InfoTemplate",
    "dojo/dom", "dojo/on", "dojo/domReady!"
], function(Map,
            SimpleMarkerSymbol,
            Point, Draw,
            GraphicsLayer, Graphic,
            Color, InfoTemplate,
            dom, on
) {
    //高亮
    function detailRender() {
        var markerSymbol = new SimpleMarkerSymbol();
        markerSymbol.setColor(new Color("#58faff"));
        markerSymbol.setSize(12);
        detailLayer.clear();
        for (var i = 8*pageNum-8; i < 8*pageNum && i < Object.keys(remJSON).length; i++){
            var content = "价格: " + remJSON[i].price + "<br>房屋结构: " + remJSON[i].structure;
            content += "<br>面积(平方米): " + remJSON[i].area;
            var infoTemplate = new InfoTemplate(remJSON[i].commname, content);
            var graphic = new Graphic(new Point(remJSON[i].lon, remJSON[i].lat), markerSymbol);
            graphic.setInfoTemplate(infoTemplate);
            detailLayer.add(graphic);
        }
    }

    detailsRender = detailRender;
});

function pageInit() {
    var scoleID, headingID, detailID, radarID, commentID;
    for (var i = 0; i < 8; i++){
        scoleID = "scole" + i;
        headingID = "heading" + i;
        detailID = "detail" + i;
        radarID = "radar" + i;
        commentID = "comment" + i;
        scole = document.getElementById(scoleID);
        scole.innerHTML = "";
        heading = document.getElementById(headingID);
        heading.innerHTML = "";
        detail = document.getElementById(detailID);
        detail.innerHTML = "";
        radar = document.getElementById(radarID);
        //var myChart = echarts.init(radar);
        //myChart.clear();
        comment = document.getElementById(commentID);
        comment.innerHTML = "";
    }
    if(remJSON.length == 0)
        return;
    $('.house-slot').css('display', 'block');
    $('.house-slot').each(function(){
        var thisSlot = $(this);
        thisSlot.find('.comment').removeClass('comment-toggle');
        thisSlot.find('.radar').removeClass('radar-toggle');
    });
    if(Math.ceil(remJSON.length/8) == pageNum){
        console.log('last page...');
        $('.house-slot').css('display', 'none');
        for(var i = 1; i <= remJSON.length%8; i++){
            $('.house-slots').find('.house-slot:nth-child(' + i + ')').css('display', 'block');
        }
    }
}

function firstPageInit() {
    var hint1 = document.getElementById('no-solution-hint');
    if (Object.keys(remJSON).length <= 0) {
        hint1.innerHTML = "无相应推荐，请重新设定条件。";
    } else {
        hint1.innerHTML = "总计推荐结果" + Object.keys(remJSON).length + "条。";
    }
    firstPage();
}

function firstPage() {
    if (remJSON == null) return;
    pageNum = 1;
    var hint2 = document.getElementById('page-hint');
    hint2.innerHTML = "第1页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
    var scoleID, headingID, detailID, radarID, commentID;
    pageInit();
    for (var i = 0; i < 8 && i < Object.keys(remJSON).length; i++) {
        scoleID = "scole" + i;
        headingID = "heading" + i;
        detailID = "detail" + i;
        radarID = "radar" + i;
        commentID = "comment" + i;
        scole = document.getElementById(scoleID);
        scole.innerHTML = remJSON[i].totalscole;
        heading = document.getElementById(headingID);
        heading.innerHTML = remJSON[i].commname;
        detail = document.getElementById(detailID);
        radar = document.getElementById(radarID);
        //radarGen(radar, remJSON[i]);
        comment = document.getElementById(commentID);
        //comment.innerHTML = "评论数据待补充。";
        var content = "价格：" + remJSON[i].price + "元/月，";
        content += "面积：" + remJSON[i].area + "平方米，";
        content += "住房结构：" + remJSON[i].structure;
        content += "，装潢程度: " + remJSON[i].decoration;
        content += "，房屋朝向: " + remJSON[i].direction;
        content += "，楼层高度: " + remJSON[i].hpart + ".";
        detail.innerHTML = content;
    }
    detailsRender();
}

$(document).ready(function () {
    $("#previous-page").click(function () {
        if (remJSON == null) return;
        if (pageNum == 1){
            alert("警告：已经是第一页了。");
        }
        else {
            pageNum--;
            var hint2 = document.getElementById('page-hint');
            hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
            var scoleID, headingID, detailID, radarID, commentID;
            pageInit();
            for (var i = 0; i < 8 && (8*pageNum+i-8) < Object.keys(remJSON).length; i++) {
                scoleID = "scole" + i;
                headingID = "heading" + i;
                detailID = "detail" + i;
                radarID = "radar" + i;
                commentID = "comment" + i;
                scole = document.getElementById(scoleID);
                scole.innerHTML = remJSON[8*pageNum+i-8].totalscole;
                heading = document.getElementById(headingID);
                heading.innerHTML = remJSON[8*pageNum+i-8].commname;
                detail = document.getElementById(detailID);
                radar = document.getElementById(radarID);
                //radarGen(radar, remJSON[8*pageNum+i-8]);
                comment = document.getElementById(commentID);
                //comment.innerHTML = "评论数据待补充。";
                var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
                content += "面积：" + remJSON[8*pageNum+i-8].area + "平方米，";
                content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
                content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
                content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
                content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
                detail.innerHTML = content;
            }
            detailsRender();
        }
    })
});

$(document).ready(function () {
    $("#next-page").click(function () {
        if (remJSON == null) return;
        if (pageNum == Math.ceil(Object.keys(remJSON).length/8)){
            alert("警告：已经是最后一页了。");
        }
        else {
            pageNum++;
            var hint2 = document.getElementById('page-hint');
            hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
            var scoleID, headingID, detailID, radarID, commentID;
            pageInit();
            for (var i = 0; i < 8 && (8*pageNum+i-8) < Object.keys(remJSON).length; i++) {
                scoleID = "scole" + i;
                headingID = "heading" + i;
                detailID = "detail" + i;
                radarID = "radar" + i;
                commentID = "comment" + i;
                scole = document.getElementById(scoleID);
                scole.innerHTML = remJSON[8*pageNum+i-8].totalscole;
                heading = document.getElementById(headingID);
                heading.innerHTML = remJSON[8*pageNum+i-8].commname;
                detail = document.getElementById(detailID);
                radar = document.getElementById(radarID);
                //radarGen(radar, remJSON[8*pageNum+i-8]);
                comment = document.getElementById(commentID);
                //comment.innerHTML = "评论数据待补充。";
                var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
                content += "面积：" + remJSON[8*pageNum+i-8].area + "平方米，";
                content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
                content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
                content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
                content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
                detail.innerHTML = content;
            }
            detailsRender();
        }
    })
});

$(document).ready(function () {
    $("#last-page").click(function () {
        if (remJSON == null) return;
        pageNum = Math.ceil(Object.keys(remJSON).length/8);
        var hint2 = document.getElementById('page-hint');
        hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
        var scoleID, headingID, detailID, radarID, commentID;
        pageInit();
        for (var i = 0; i < 8 && (8*pageNum+i-8) < Object.keys(remJSON).length; i++) {
            scoleID = "scole" + i;
            headingID = "heading" + i;
            detailID = "detail" + i;
            radarID = "radar" + i;
            commentID = "comment" + i;
            scole = document.getElementById(scoleID);
            scole.innerHTML = remJSON[8*pageNum+i-8].totalscole;
            heading = document.getElementById(headingID);
            heading.innerHTML = remJSON[8*pageNum+i-8].commname;
            detail = document.getElementById(detailID);
            radar = document.getElementById(radarID);
            //radarGen(radar, remJSON[8*pageNum+i-8]);
            comment = document.getElementById(commentID);
            //comment.innerHTML = "评论数据待补充。";
            var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
            content += "面积：" + remJSON[8*pageNum+i-8].area + "平方米，";
            content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
            content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
            content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
            content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
            detail.innerHTML = content;
        }
        detailsRender();
    })
});