/* In the Name of GOD */
var map;
/* the Graphic Drawing Tool */
var tb; // tb = new Draw(map);

/* LAYER-Lists: */

// 0.HouseResults layer
/*
 * Attribute-reco has its own layer due to its potential
 * large output, so we need to classify them using color,
 * classification fields will be 'price'
 */
var houseRecoLayer;
/*each query EXCEPT reco*/
var houseBasic;
/*each page High-light*/
var detailLayer;


// 1.Spatial Query Layer
/*1.1 Region Extent*/
var polygonLayer;
/*1.2 Circle*/
var poiRangeLayer;
/*1.3 POI Layer*/
var poiLayer;
/*1.4 Pick places Layer*/
var optimalLayer;


require(["esri/map", "esri/dijit/Scalebar", "esri/geometry/Extent", "esri/layers/GraphicsLayer", "esri/layers/FeatureLayer", 'esri/layers/ArcGISTiledMapServiceLayer',
        "esri/layers/ArcGISDynamicMapServiceLayer", "dojo/dom", "dojo/on", "dojo/domReady!"],
    function( Map, Scalebar, Extent, GraphicsLayer, FeatureLayer, ArcGISTiledMapServiceLayer, ArcGISDynamicMapServiceLayer, dom, on ) {
        map = new Map("map", {
        //basemap: "dark-gray-vector",
            //basemap: "osm",
        center: [120.1751, 30.2541],
        zoom: 14
            //extent: new Extent({xmin:-20098296,ymin:-2804413,xmax:5920428,ymax:15813776,spatialReference:{wkid:54032}
        });

        var BaseMapURL = "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer";
        var layer0 = new ArcGISTiledMapServiceLayer(BaseMapURL);
        map.addLayer(layer0);
        var scalebar = new Scalebar({
            map: map,
            scalebarStyle: "ruler",
            // "english": default, "dual", "metric"
            scalebarUnit: "metric"
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

        /*
        locationURL = "http://222.205.72.136:6080/arcgis/rest/services/LocationMap/MapServer/";
        var layer1 = new ArcGISDynamicMapServiceLayer(locationURL);
        layer1.opacity = 0.5;
        map.addLayer(layer1);
        map.getLayer("layer2").hide();

        priceperURL = "http://222.205.72.136:6080/arcgis/rest/services/PricePerMap/MapServer/";
        var layer2 = new ArcGISDynamicMapServiceLayer(priceperURL);
        layer2.opacity = 0.5;
        map.addLayer(layer2);
        map.getLayer("layer3").hide();

        transportURL = "http://222.205.72.136:6080/arcgis/rest/services/TransportMap/MapServer/";
        var layer3 = new ArcGISDynamicMapServiceLayer(transportURL);
        layer3.opacity = 0.5;
        map.addLayer(layer3);
        map.getLayer("layer4").hide();

        environmentURL = "http://222.205.72.136:6080/arcgis/rest/services/EnvironmentMap/MapServer/";
        var layer4 = new ArcGISDynamicMapServiceLayer(environmentURL);
        layer4.opacity = 0.5;
        map.addLayer(layer4);
        map.getLayer("layer5").hide();

        educationURL = "http://222.205.72.136:6080/arcgis/rest/services/EducationMap/MapServer/";
        var layer5 = new ArcGISDynamicMapServiceLayer(educationURL);
        layer5.opacity = 0.5;
        map.addLayer(layer5);
        map.getLayer("layer6").hide();

        entertainmentURL = "http://222.205.72.136:6080/arcgis/rest/services/EntertainmentMap/MapServer/";
        var layer6 = new ArcGISDynamicMapServiceLayer(entertainmentURL);
        layer6.opacity = 0.5;
        map.addLayer(layer6);
        map.getLayer("layer7").hide();

        shopURL = "http://222.205.72.136:6080/arcgis/rest/services/ShopMap/MapServer/";
        var layer7 = new ArcGISDynamicMapServiceLayer(shopURL);
        layer7.opacity = 0.5;
        map.addLayer(layer7);
        map.getLayer("layer8").hide();

        financeURL = "http://222.205.72.136:6080/arcgis/rest/services/FinanceMap/MapServer/";
        var layer8 = new ArcGISDynamicMapServiceLayer(financeURL);
        layer8.opacity = 0.5;
        map.addLayer(layer8);
        map.getLayer("layer9").hide();

        lifeURL = "http://222.205.72.136:6080/arcgis/rest/services/LifeMap/MapServer/";
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
        }); */

});