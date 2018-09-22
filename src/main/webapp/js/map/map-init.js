var map;
var tb;  // tb = new Draw(map);
var polygonLayer;
var poiRangeLayer;
var poiLayer;
var optimalLayer;

var detailLayer;
var houseRecoLayer;

var houseBasic;

require(["esri/map", "esri/layers/GraphicsLayer", "esri/layers/FeatureLayer", "esri/layers/ArcGISDynamicMapServiceLayer", "dojo/dom", "dojo/on", "dojo/domReady!"],
    function( Map, GraphicsLayer, FeatureLayer, ArcGISDynamicMapServiceLayer, dom, on ) {
        map = new Map("map", {
        basemap: "dark-gray-vector",
        //basemap: "osm",
        center: [120.1551, 30.2741],
        zoom: 13
        });
        polygonLayer = new GraphicsLayer({ id: "query_polygon" });
        poiRangeLayer = new GraphicsLayer({ id: "query_poi" });
        poiLayer = new GraphicsLayer({ id: "poi" });
        optimalLayer = new GraphicsLayer({ id: "optimal" });
        houseRecoLayer = new GraphicsLayer({ id: "houseRecoLayer" });
        detailLayer = new GraphicsLayer({ id: "detailLayer" });
        houseBasic = new GraphicsLayer({ id: "houseBasic" });

        map.addLayer(polygonLayer);
        map.addLayer(poiRangeLayer);
        map.addLayer(poiLayer);
        map.addLayer(optimalLayer);
        map.addLayer(houseRecoLayer);
        map.addLayer(houseBasic);
        map.addLayer(detailLayer);



        serverURL = "http://localhost:6080/arcgis/rest/services/BaseMap/MapServer/";
        var featureLayer = new FeatureLayer(serverURL+"1");
        map.addLayer(featureLayer);

        locationURL = "http://222.205.60.249:6080/arcgis/rest/services/LocationMap/MapServer/";
        var layer1 = new ArcGISDynamicMapServiceLayer(locationURL);
        layer1.opacity = 0.5;
        map.addLayer(layer1);
        map.getLayer("layer2").hide();

        priceperURL = "http://222.205.60.249:6080/arcgis/rest/services/PricePerMap/MapServer/";
        var layer2 = new ArcGISDynamicMapServiceLayer(priceperURL);
        layer2.opacity = 0.5;
        map.addLayer(layer2);
        map.getLayer("layer3").hide();

        transportURL = "http://222.205.60.249:6080/arcgis/rest/services/TransportMap/MapServer/";
        var layer3 = new ArcGISDynamicMapServiceLayer(transportURL);
        layer3.opacity = 0.5;
        map.addLayer(layer3);
        map.getLayer("layer4").hide();

        environmentURL = "http://222.205.60.249:6080/arcgis/rest/services/EnvironmentMap/MapServer/";
        var layer4 = new ArcGISDynamicMapServiceLayer(environmentURL);
        layer4.opacity = 0.5;
        map.addLayer(layer4);
        map.getLayer("layer5").hide();

        educationURL = "http://222.205.60.249:6080/arcgis/rest/services/EducationMap/MapServer/";
        var layer5 = new ArcGISDynamicMapServiceLayer(educationURL);
        layer5.opacity = 0.5;
        map.addLayer(layer5);
        map.getLayer("layer6").hide();

        entertainmentURL = "http://222.205.60.249:6080/arcgis/rest/services/EntertainmentMap/MapServer/";
        var layer6 = new ArcGISDynamicMapServiceLayer(entertainmentURL);
        layer6.opacity = 0.5;
        map.addLayer(layer6);
        map.getLayer("layer7").hide();

        shopURL = "http://222.205.60.249:6080/arcgis/rest/services/ShopMap/MapServer/";
        var layer7 = new ArcGISDynamicMapServiceLayer(shopURL);
        layer7.opacity = 0.5;
        map.addLayer(layer7);
        map.getLayer("layer8").hide();

        financeURL = "http://222.205.60.249:6080/arcgis/rest/services/FinanceMap/MapServer/";
        var layer8 = new ArcGISDynamicMapServiceLayer(financeURL);
        layer8.opacity = 0.5;
        map.addLayer(layer8);
        map.getLayer("layer9").hide();

        lifeURL = "http://222.205.60.249:6080/arcgis/rest/services/LifeMap/MapServer/";
        var layer9 = new ArcGISDynamicMapServiceLayer(lifeURL);
        layer9.opacity = 0.5;
        map.addLayer(layer9);
        map.getLayer("layer10").hide();

        //console.log(map.layerIds);

        $("#location").click(function () {
            var sobu = document.getElementById('location');
            if (sobu.checked) {
                map.getLayer("layer2").show();
            } else {
                map.getLayer("layer2").hide();
            }
        });

        $("#priceper").click(function () {
            var sobu = document.getElementById('priceper');
            if (sobu.checked) {
                map.getLayer("layer3").show();
            } else {
                map.getLayer("layer3").hide();
            }
        });


        $("#transport").click(function () {
            var sobu = document.getElementById('transport');
            if (sobu.checked) {
                map.getLayer("layer4").show();
            } else {
                map.getLayer("layer4").hide();
            }
        });

        $("#environment").click(function () {
            var sobu = document.getElementById('environment');
            if (sobu.checked) {
                map.getLayer("layer5").show();
            } else {
                map.getLayer("layer5").hide();
            }
        });

        $("#education").click(function () {
            var sobu = document.getElementById('education');
            if (sobu.checked) {
                map.getLayer("layer6").show();
            } else {
                map.getLayer("layer6").hide();
            }
        });

        $("#entertainment").click(function () {
            var sobu = document.getElementById('entertainment');
            if (sobu.checked) {
                map.getLayer("layer7").show();
            } else {
                map.getLayer("layer7").hide();
            }
        });

        $("#shop").click(function () {
            var sobu = document.getElementById('shop');
            if (sobu.checked) {
                map.getLayer("layer8").show();
            } else {
                map.getLayer("layer8").hide();
            }
        });

        $("#finance").click(function () {
            var sobu = document.getElementById('finance');
            if (sobu.checked) {
                map.getLayer("layer9").show();
            } else {
                map.getLayer("layer9").hide();
            }
        });

        $("#life").click(function () {
            var sobu = document.getElementById('life');
            if (sobu.checked) {
                map.getLayer("layer10").show();
            } else {
                map.getLayer("layer10").hide();
            }
        });

});