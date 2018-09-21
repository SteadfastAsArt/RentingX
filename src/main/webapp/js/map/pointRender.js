var poiQueryRenderer;
var houseQueryRenderer;
require( [
    "esri/symbols/SimpleMarkerSymbol",
    "esri/geometry/Point", "esri/toolbars/draw",
    "esri/layers/GraphicsLayer", "esri/graphic",
    "esri/Color", "esri/InfoTemplate",
    "dojo/dom", "dojo/on", "dojo/domReady!"
], function(
    SimpleMarkerSymbol,
    Point, Draw,
    GraphicsLayer, Graphic,
    Color, InfoTemplate, dom, on
) {
    function poiQueryRender(json) {
        var markerSymbol = new SimpleMarkerSymbol();
        markerSymbol.setColor(new Color("#9955FF"));
        markerSymbol.setSize(5);

        poiLayer.clear();

        for (i in json) {
            var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol);
            var content = "地址: " + json[i].address;
            content += "<br>联系电话: " + json[i].tel;
            var infoTemplate = new InfoTemplate(json[i].name, content);
            graphic.setInfoTemplate(infoTemplate);
            poiLayer.add(graphic);
        }
    }
    poiQueryRenderer = poiQueryRender;

    function houseQueryRender(json) {
        var markerSymbol = new SimpleMarkerSymbol();
        markerSymbol.setColor(new Color("#FF33FF"));
        markerSymbol.setSize(10);

        houseBasic.clear();

        for (i in json) {
            var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol);
            var content = "面积(平方米): " + json[i].area;
            content += "<br>价格: " + json[i].price;
            content += "<br>房屋结构: " + json[i].structure;

            var infoTemplate = new InfoTemplate(json[i].commname, content);
            graphic.setInfoTemplate(infoTemplate);
            //map.graphics.add(graphic);
            houseBasic.add(graphic)
        }
    }
    houseQueryRenderer = houseQueryRender;

});