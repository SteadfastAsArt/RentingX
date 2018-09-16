var poiQueryRenderer;
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

        for (i in json) {
            var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol);
            var content = "<br>Address: " + json[i].address;
            content += "<br>Tel: " + json[i].tel;
            var infoTemplate = new InfoTemplate(json[i].name, content);
            graphic.setInfoTemplate(infoTemplate);
            poiLayer.add(graphic);
        }
    }
    poiQueryRenderer = poiQueryRender;
});