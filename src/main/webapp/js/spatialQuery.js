var envelope = [];
var selectedHouse = [];


require([
        "esri/map", "esri/toolbars/draw",
        "esri/symbols/SimpleLineSymbol", "esri/symbols/SimpleFillSymbol", "esri/geometry/Circle",
        "esri/graphic", "esri/Color",
        "dojo/dom", "dojo/on", "dojo/domReady!"
    ], function(
        Map, Draw,
        SimpleLineSymbol, SimpleFillSymbol, Circle,
        Graphic, Color,
        dom, on
    ) {
        // fill symbol used for extent, polygon and freehand polygon, use a picture fill symbol
        // the images folder contains additional fill images, other options: sand.png, swamp.png or stiple.png
        /*var fillSymbol = new PictureFillSymbol(
            "images/mangrove.png",
            new SimpleLineSymbol( SimpleLineSymbol.STYLE_SOLID, new Color('#000'), 1 ), 42, 42 );*/

        var fillSymbol = new SimpleFillSymbol( SimpleFillSymbol.STYLE_SOLID,
                                                new SimpleLineSymbol(SimpleLineSymbol.STYLE_DASHDOT,
                                                new Color([255,0,0]), 2), new Color([255,255,0,0.1]) );

        map.on("load", initToolbar);
        map.on("load", graphic_click);

        function initToolbar(){
            tb = new Draw(map);
            tb.on("draw-end", polygonQueryRender);
        }

        function polygonQueryRender(evt) {
            tb.deactivate();
            map.enableMapNavigation();
            var symbol = fillSymbol;
            var geo = evt.geometry;
            map.graphics.clear();
            polygonLayer.clear();
            polygonLayer.add(new Graphic(geo, symbol));
            envelope = [];
            envelope.push(geo.xmin, geo.ymin, geo.xmax, geo.ymax);
        }

        //图形点击事件
        function graphic_click(){
            map.graphics.on("click", function (evt) {
                selectedHouse = [];
                selectedHouse.push(evt.graphic.geometry.x, evt.graphic.geometry.y);

                var symbol = new SimpleFillSymbol().setColor(null).outline.setColor("blue");
                var circle = new Circle({
                    center: evt.graphic.geometry,
                    geodesic: true,
                    radius: 500
                });
                var graphic = new Graphic(circle, symbol);
                poiRangeLayer.clear();
                poiRangeLayer.add(graphic);
            });
        }

});

jQuery(function () {

    $('#polyq').click(function () {
        $.ajax({
            url:"polygon.action",
            dataType:"json",   //返回格式为json
            async:true,        //请求是否异步，默认为异步，这也是ajax重要特性
            data:{ "coordinates": envelope },
            type:"GET",        //请求方式
            traditional: true,
            success : function(result){
                attributeQueryRenderer(result);
            },
            error : function() {
                alert("异常！");
            }
        });
    });


    $('#poiq').click(function () {
        var selectedTag = [];

        $("div.poi-tag").find('li').each(function () {
            if( $(this).children().is(":checked") ) {
                selectedTag.push($(this).index());
            }
        });

        $.ajax({
            url: "poi.action",
            dataType: "json",
            async: true,
            data: {
                "tag_list": selectedTag,
                "pHouse": selectedHouse
            },
            type: "GET",
            traditional: true,
            success : function(result){
                //TODO 请求成功时处理
                poiQueryRenderer(result);
            },
            error : function() {
                alert("异常！");
            }
        });
    });

});