var envelope = [];
var selectedHouse = [];
var range_draw_end_query;
var pickPlace_draw_end_query;
var picked_points = [];
var clickHouse = false;   //Display-POI panel

jQuery(function () {

    function drawend1() {
        $.ajax({
            url: "polygon.action",
            dataType: "json",   //返回格式为json
            async: true,        //请求是否异步，默认为异步，这也是ajax重要特性
            data: {"coordinates": envelope},
            type: "GET",        //请求方式
            traditional: true,
            success: function (result) {
                remJSON = result;
                houseQueryRenderer(result);
                firstPageInit();
                detailsRender();
                if(starClosed)
                    $('#btn-star').click();
            },
            error: function () {
                alert("异常！");
            }
        });
    }

    range_draw_end_query = drawend1;

    function drawend2() {
        $.ajax({
            url: "findoptimal.action",
            dataType: "json",   //返回格式为json
            async: true,        //请求是否异步，默认为异步，这也是ajax重要特性
            data: { "picked_points": picked_points },
            type: "GET",        //请求方式
            traditional: true,
            success: function (result) {
                remJSON = result;
                houseQueryRenderer(result);
                firstPageInit();
                detailsRender();
                if(starClosed)
                    $('#btn-star').click();
            },
            error: function () {
                alert("异常！");
            }
        });
    }

    pickPlace_draw_end_query = drawend2;

});


require([
        "esri/toolbars/draw",
        "esri/symbols/SimpleMarkerSymbol","esri/symbols/SimpleLineSymbol", "esri/symbols/SimpleFillSymbol", "esri/geometry/Circle",
        "esri/graphic", "esri/Color",
        "dojo/dom", "dojo/on", "dojo/domReady!"
    ], function(
        Draw,
        SimpleMarkerSymbol, SimpleLineSymbol, SimpleFillSymbol, Circle,
        Graphic, Color,
        dom, on
    ) {
        // Range Query polygon symbol
        var fillSymbol = new SimpleFillSymbol( SimpleFillSymbol.STYLE_SOLID,
                                                new SimpleLineSymbol(SimpleLineSymbol.STYLE_DASHDOT,
                                                new Color([255,0,0]), 2), new Color([255,255,0,0.05]) );

        //Pick-places symbol
        var markerSymbol = new SimpleMarkerSymbol();
        markerSymbol.setPath(svglocate1);
        markerSymbol.setColor(new Color("#ff1100"));
        markerSymbol.setSize(30);
        markerSymbol.setOutline(null);

        map.on("load", initToolbar);
        map.on("load", graphic_click);

        function initToolbar(){
            tb = new Draw(map);
            tb.on("draw-end", drawingRender);
        }

        function drawingRender(evt) {
            tb.deactivate();
            map.enableMapNavigation();

            var geo = evt.geometry;
            var symbol;

            //multipointsQueryRender
            if ( evt.geometry.type === "multipoint" ) {
                //evt.geometry.points[i][0/1] i-th point x/y
                symbol = markerSymbol;
                optimalLayer.clear();
                optimalLayer.add(new Graphic(geo, symbol));
                picked_points = [];
                for(i in evt.geometry.points) {
                    picked_points.push ( evt.geometry.points[i][0], evt.geometry.points[i][1] );
                }
                console.log(picked_points);
                pickPlace_draw_end_query();
            }
            //extentQueryRender
            else {
                symbol = fillSymbol;
                polygonLayer.clear();
                poiRangeLayer.clear();
                poiLayer.clear();
                polygonLayer.add(new Graphic(geo, symbol));
                envelope = [];
                envelope.push(geo.xmin, geo.ymin, geo.xmax, geo.ymax);
                range_draw_end_query();
            }
        }


        //图形点击事件
        function graphic_click(){
            houseBasic.on("click", function (evt) {
                clickHouse = true;
                selectedHouse = [];
                selectedHouse.push(evt.graphic.geometry.x, evt.graphic.geometry.y);
                var symbolFill = new SimpleFillSymbol().setColor(null);
                symbolFill.setOutline(new SimpleLineSymbol(SimpleLineSymbol.STYLE_DASH, new Color("AAAAAA"), 3));
                var circle = new Circle({
                    center: evt.graphic.geometry,
                    geodesic: true,
                    radius: 500
                });
                var graphic = new Graphic(circle, symbolFill);
                poiLayer.clear();
                poiRangeLayer.clear();
                poiRangeLayer.add(graphic);
            });

            detailLayer.on("click", function (evt) {
                clickHouse = true;
                selectedHouse = [];
                selectedHouse.push(evt.graphic.geometry.x, evt.graphic.geometry.y);
                var symbolFill = new SimpleFillSymbol().setColor(null);
                symbolFill.setOutline(new SimpleLineSymbol(SimpleLineSymbol.STYLE_DASH, new Color("AAAAAA"), 3));
                var circle = new Circle({
                    center: evt.graphic.geometry,
                    geodesic: true,
                    radius: 500
                });
                var graphic = new Graphic(circle, symbolFill);
                poiLayer.clear();
                poiRangeLayer.clear();
                poiRangeLayer.add(graphic);
            });
        }

});