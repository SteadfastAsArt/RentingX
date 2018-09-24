var poiQueryRenderer;
var houseQueryRenderer;
var houseRecommendRenderer;

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
        markerSymbol.setPath(svgPath);
        //markerSymbol.setColor(new Color("#00343F"));
        markerSymbol.setColor(new Color("#77FF00"));
        markerSymbol.setSize(16);

        houseBasic.clear();

        for (i in json) {
            var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol);
            var content = "面积(平方米): " + json[i].area;
            content += "<br>价格: " + json[i].price;
            content += "<br>房屋结构: " + json[i].structure;
            var infoTemplate = new InfoTemplate(json[i].commname, content);

            graphic.setInfoTemplate(infoTemplate);
            houseBasic.add(graphic)
        }
    }
    houseQueryRenderer = houseQueryRender;

    function houseRecommendRender(json) {

        houseRecoLayer.clear();

        for (i in json) {
            var content = "价格: " + json[i].price + "<br>房屋结构: " + json[i].structure;
            content += "<br>面积(平方米): " + json[i].area;
            var infoTemplate = new InfoTemplate(json[i].commname, content);

            var pMarkerSymbol = new SimpleMarkerSymbol();
            pMarkerSymbol.setSize(16);
            pMarkerSymbol.setPath(svgPath);

            if (json[i].price < 2000) {
                pMarkerSymbol.setColor(new Color("#426fff"));
                var graphic = new Graphic(new Point(json[i].lon, json[i].lat), pMarkerSymbol);
            } else if (json[i].price < 3000) {
                pMarkerSymbol.setColor(new Color("#908eff"));
                var graphic = new Graphic(new Point(json[i].lon, json[i].lat), pMarkerSymbol);
            } else if (json[i].price < 4000) {
                pMarkerSymbol.setColor(new Color("#ffb3c3"));
                var graphic = new Graphic(new Point(json[i].lon, json[i].lat), pMarkerSymbol);
            } else if (json[i].price < 5000) {
                pMarkerSymbol.setColor(new Color("#ff6167"));
                var graphic = new Graphic(new Point(json[i].lon, json[i].lat), pMarkerSymbol);
            } else {
                pMarkerSymbol.setColor(new Color("#ff0000"));
                var graphic = new Graphic(new Point(json[i].lon, json[i].lat), pMarkerSymbol);
            }

            graphic.setInfoTemplate(infoTemplate);
            houseRecoLayer.add(graphic);
        }
    }
    houseRecommendRenderer = houseRecommendRender;

});