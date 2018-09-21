var tb, legend;
var attributeQueryRenderer;

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
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol1);
                  } else if (json[i].price < 2000) {
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol2);
                  } else if (json[i].price < 3000) {
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol3);
                  } else if (json[i].price < 4000) {
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol4);
                  } else if (json[i].price < 5000) {
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol5);
                  } else {
                    var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol6);
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
    $("#sub").click(function () {
        var op1 = document.getElementById("notuijian");
        var defau;
        if (op1.checked) {
            defau = 1;
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
                firstPageInit();
                detailsRender();
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

