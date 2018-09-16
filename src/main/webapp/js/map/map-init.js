var map;
var tb;  // tb = new Draw(map);
var polygonLayer;
var poiRangeLayer;
var poiLayer;

require(["esri/map", "esri/layers/GraphicsLayer", "dojo/domReady!"],
    function( Map, GraphicsLayer ) {
        map = new Map("map", {
        basemap: "dark-gray-vector",
        center: [120.1551, 30.2741],
        zoom: 13
        });
        polygonLayer = new GraphicsLayer({ id: "query_polygon" });
        poiRangeLayer = new GraphicsLayer({ id: "query_poi" });
        poiLayer = new GraphicsLayer({ id: "poi" });
        map.addLayer(polygonLayer);
        map.addLayer(poiRangeLayer);
        map.addLayer(poiLayer);
});