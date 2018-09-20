var tb, legend;
var attributeQueryRenderer;
var remJSON;
var pageNum;
require( [
        "esri/map",
        "esri/symbols/SimpleMarkerSymbol",
        "esri/geometry/Point",
        "esri/toolbars/draw",
        "esri/layers/GraphicsLayer", "esri/graphic",
        "esri/Color", 
        "esri/InfoTemplate",
        "esri/layers/FeatureLayer",
        "esri/layers/RasterLayer",
        "esri/layers/ArcGISDynamicMapServiceLayer",
        "dojo/dom", "dojo/on", "dojo/domReady!"
      ], function(Map,
        SimpleMarkerSymbol,
        Point, Draw,
        GraphicsLayer, Graphic,
        Color, InfoTemplate,
        FeatureLayer, RasterLayer,
        ArcGISDynamicMapServiceLayer,
        dom, on
      ) {
          /*map = new Map("map", {  
            basemap: "osm",
            center: [120.1551, 30.2741],
            zoom: 11
          });*/

          function detailRender() {
              var markerSymbol = new SimpleMarkerSymbol();
              markerSymbol.setColor(new Color("#58faff"));
              markerSymbol.setSize(12);
              //map.graphics.clear();
              //houseRecoLayer.clear();
              detailLayer.clear();
              for (var i = 8*pageNum-8; i < 8*pageNum; i++){
                  var content = "Price: " + remJSON[i].price + "<br>Structure: " + remJSON[i].structure;
                  content += "<br>Area(m^2): " + remJSON[i].area;
                  var infoTemplate = new InfoTemplate(remJSON[i].commname, content);
                  var graphic = new Graphic(new Point(remJSON[i].longitude, remJSON[i].latitude), markerSymbol);
                  graphic.setInfoTemplate(infoTemplate);
                  detailLayer.add(graphic);
              }
          }

          detailsRender = detailRender;

          function houseRecommendRender(json) {
              var markerSymbol1 = new SimpleMarkerSymbol();
              markerSymbol1.setColor(new Color("#00FF00"));
              markerSymbol1.setSize(10);

              var markerSymbol2 = new SimpleMarkerSymbol();
              markerSymbol2.setColor(new Color("#00CD66"));
              markerSymbol2.setSize(10);

              var markerSymbol3 = new SimpleMarkerSymbol();
              markerSymbol3.setColor(new Color("#FFFF00"));
              markerSymbol3.setSize(10);

              var markerSymbol4 = new SimpleMarkerSymbol();
              markerSymbol4.setColor(new Color("#FFD700"));
              markerSymbol4.setSize(10);

              var markerSymbol5 = new SimpleMarkerSymbol();
              markerSymbol5.setColor(new Color("#FF7F24"));
              markerSymbol5.setSize(10);

              var markerSymbol6 = new SimpleMarkerSymbol();
              markerSymbol6.setColor(new Color("#FF0000"));
              markerSymbol6.setSize(10);
              
              map.graphics.clear();
              houseRecoLayer.clear();
              for (i in json) {
                  var content = "Price: " + json[i].price + "<br>Structure: " + json[i].structure;
                  content += "<br>Area(m^2): " + json[i].area;
                  var infoTemplate = new InfoTemplate(json[i].commname, content);
                  if (json[i].price < 1000) {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol1);
                  } else if (json[i].price < 2000) {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol2);
                  } else if (json[i].price < 3000) {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol3);
                  } else if (json[i].price < 4000) {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol4);
                  } else if (json[i].price < 5000) {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol5);
                  } else {
                    var graphic = new Graphic(new Point(json[i].longitude, json[i].latitude), markerSymbol6);
                  }
                  graphic.setInfoTemplate(infoTemplate);
                  houseRecoLayer.add(graphic);
              }
          }
          houseRecommendRenderer = houseRecommendRender;
});

$(document).ready(function () {
    $(':radio').click(function () {
        var option = document.getElementById('gexing');
        if (option.checked == true) {
            $('.brick.small').attr('style', 'pointer-events: auto');
            $('.youxian').show();
        } else {
            $('.brick.small').attr('style', 'pointer-events: none');
            $('.youxian').hide();
        }
    })
});

function getElementTop(element){
    var actualTop = element.offsetTop;
    var current = element.offsetParent;
    while (current !== null){
        actualTop += current.offsetTop;
        current = current.offsetParent;
    }
    return actualTop;
}

//var houseScole = new Array();
var locationScole = new Array();
var serviceScole = new Array();

$(document).ready(function () {
    $('.youxian').hide();
})

function getOrder(eleID, group) {
    var order = 1;
    var hei = getElementTop(document.getElementById(eleID));
    /*
    houseScole[0] = getElementTop(document.getElementById('priceScole'));
    houseScole[1] = getElementTop(document.getElementById('decorationScole'));
    houseScole[2] = getElementTop(document.getElementById('heightScole'));
    houseScole[3] = getElementTop(document.getElementById('directionScole'));
    */
    locationScole[0] = getElementTop(document.getElementById('transportScole'));
    locationScole[1] = getElementTop(document.getElementById('serviceScole'));
    locationScole[2] = getElementTop(document.getElementById('environmentScole'));
    serviceScole[0] = getElementTop(document.getElementById('educationScole'));
    serviceScole[1] = getElementTop(document.getElementById('treatmentScole'));
    serviceScole[2] = getElementTop(document.getElementById('shopScole'));
    serviceScole[3] = getElementTop(document.getElementById('lifeScole'));
    serviceScole[4] = getElementTop(document.getElementById('entertainmentScole'));
    serviceScole[5] = getElementTop(document.getElementById('financeScole'));
    if (group == 1) {
        for (var i = 0; i < houseScole.length; i++) {
            if (hei > houseScole[i]) {
                order++;
            }
        }
    } else if (group == 2) {
        for (var i = 0; i < locationScole.length; i++) {
            if (hei > locationScole[i]) {
                order++;
            }
        }
    } else {
        for (var i = 0; i < serviceScole.length; i++) {
            if (hei > serviceScole[i]) {
                order++;
            }
        }
    }
    return order;
}

$(document).ready(function () {
    $("#testButton").click(function () {
        alert("123");
    })
})

$(document).ready(function () {
    $("#sub").click(function () {
        var op1 = document.getElementById("notuijian");
        var op2 = document.getElementById("moren");
        var defau;
        if (op1.checked) {
            defau = 1;
        } else if (op2.checked) {
            defau = 2;
        } else {
            defau = 3;
        }
        $.ajax({
            url:"showReco.action",
            dataType:"json",
            async:true,
            data:{
                /*area: $("#area").prop('selectedIndex'),
                structure: $("#structure").prop('selectedIndex'),
                direction: $("#direction").prop('selectedIndex'),
                height: $("#height").val(),
                price: $("#price").prop('selectedIndex'),*/
                direction: $("#direction").val(),
                price: $("#price").val(),
                height: $("#floor").val(),
                structure: $("#struct").val(),
                area: $("#area").val(),
                defau: defau,
                /*priceOrder: getOrder("priceScole", 1),
                decorationOrder: getOrder("decorationScole", 1),
                heightOrder: getOrder("heightScole", 1),
                directionOrder: getOrder("directionScole", 1),*/
                transportOrder: getOrder("transportScole", 2),
                serviceOrder: getOrder("serviceScole", 2),
                environmentOrder: getOrder("environmentScole", 2),
                educationOrder: getOrder("educationScole", 3),
                treatmentOrder: getOrder("treatmentScole", 3),
                shopOrder: getOrder("shopScole", 3),
                lifeOrder: getOrder("lifeScole", 3),
                entertainmentOrder: getOrder("entertainmentScole", 3),
                financeOrder: getOrder("financeScole", 3)
            },
            type:"GET",
            success: function (result) {
                remJSON = result;
                houseRecommendRenderer(result);
                houseDetail(result);
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

function houseDetail(json) {
    var hint1 = document.getElementById('no-solution-hint');
    var hint2 = document.getElementById('page-hint');
    if (Object.keys(json).length <= 0) {
        hint1.innerHTML = "无相应推荐，请重新设定条件。";
    } else {
        hint1.innerHTML = "总计推荐结果" + Object.keys(json).length + "条。";
    }
    hint2.innerHTML = "第1页 共" + Math.ceil(Object.keys(json).length/8) + "页";
    var scoleID, headingID, detailID, radarID, commentID;
    pageNum = 1;
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
        radar.innerHTML = "";
        comment = document.getElementById(commentID);
        comment.innerHTML = "";
    }
    for (var i = 0; i < 8 && i < Object.keys(json).length; i++) {
        scoleID = "scole" + i;
        headingID = "heading" + i;
        detailID = "detail" + i;
        radarID = "radar" + i;
        commentID = "comment" + i;
        scole = document.getElementById(scoleID);
        scole.innerHTML = json[i].totalscole;
        heading = document.getElementById(headingID);
        heading.innerHTML = json[i].commname;
        detail = document.getElementById(detailID);
        radar = document.getElementById(radarID);
        radar.innerHTML = "雷达图待补充。";
        comment = document.getElementById(commentID);
        comment.innerHTML = "评论数据待补充。";
        var content = "价格：" + json[i].price + "元/月，";
        content += "住房结构：" + json[i].structure;
        content += "，装潢程度: " + json[i].decoration;
        content += "，房屋朝向: " + json[i].direction;
        content += "，楼层高度: " + json[i].hpart + ".";
        detail.innerHTML = content;
    }
}

$(document).ready(function () {
    $("#first-page").click(function firstPage() {
        pageNum = 1;
        var hint2 = document.getElementById('page-hint');
        hint2.innerHTML = "第1页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
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
            radar.innerHTML = "";
            comment = document.getElementById(commentID);
            comment.innerHTML = "";
        }
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
            radar.innerHTML = "雷达图待补充。";
            comment = document.getElementById(commentID);
            comment.innerHTML = "评论数据待补充。";
            var content = "价格：" + remJSON[i].price + "元/月，";
            content += "住房结构：" + remJSON[i].structure;
            content += "，装潢程度: " + remJSON[i].decoration;
            content += "，房屋朝向: " + remJSON[i].direction;
            content += "，楼层高度: " + remJSON[i].hpart + ".";
            detail.innerHTML = content;
        }
        detailsRender();
    })
})

$(document).ready(function () {
    $("#previous-page").click(function () {
        if (pageNum == 1){
            alert("警告：已经是第一页了。");
        }
        else {
            pageNum--;
            var hint2 = document.getElementById('page-hint');
            hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
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
                radar.innerHTML = "";
                comment = document.getElementById(commentID);
                comment.innerHTML = "";
            }
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
                radar.innerHTML = "雷达图待补充。";
                comment = document.getElementById(commentID);
                comment.innerHTML = "评论数据待补充。";
                var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
                content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
                content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
                content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
                content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
                detail.innerHTML = content;
            }
            detailsRender();
        }
    })
})

$(document).ready(function () {
    $("#next-page").click(function () {
        if (pageNum == Math.ceil(Object.keys(remJSON).length/8)){
            alert("警告：已经是最后一页了。");
        }
        else {
            pageNum++;
            var hint2 = document.getElementById('page-hint');
            hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
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
                radar.innerHTML = "";
                comment = document.getElementById(commentID);
                comment.innerHTML = "";
            }
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
                radar.innerHTML = "雷达图待补充。";
                comment = document.getElementById(commentID);
                comment.innerHTML = "评论数据待补充。";
                var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
                content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
                content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
                content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
                content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
                detail.innerHTML = content;
            }
            detailsRender();
        }
    })
})

$(document).ready(function () {
    $("#last-page").click(function () {
        pageNum = Math.ceil(Object.keys(remJSON).length/8);
        var hint2 = document.getElementById('page-hint');
        hint2.innerHTML = "第" + pageNum + "页 共" + Math.ceil(Object.keys(remJSON).length/8) + "页";
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
            radar.innerHTML = "";
            comment = document.getElementById(commentID);
            comment.innerHTML = "";
        }
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
            radar.innerHTML = "雷达图待补充。";
            comment = document.getElementById(commentID);
            comment.innerHTML = "评论数据待补充。";
            var content = "价格：" + remJSON[8*pageNum+i-8].price + "元/月，";
            content += "住房结构：" + remJSON[8*pageNum+i-8].structure;
            content += "，装潢程度: " + remJSON[8*pageNum+i-8].decoration;
            content += "，房屋朝向: " + remJSON[8*pageNum+i-8].direction;
            content += "，楼层高度: " + remJSON[8*pageNum+i-8].hpart + ".";
            detail.innerHTML = content;
        }
        detailsRender();
    })
})