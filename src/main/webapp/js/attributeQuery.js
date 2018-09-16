var attributeQueryRenderer;
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

	  function attributeQueryRender(json) {
		  var markerSymbol = new SimpleMarkerSymbol();
		  markerSymbol.setColor(new Color("#00FFFF"));
		  markerSymbol.setSize(10);

		  if (map.graphics.graphics.length != 1) {
              map.graphics.clear();
		  }

		  for (i in json) {
			  var graphic = new Graphic(new Point(json[i].lon, json[i].lat), markerSymbol);
			  var content = "Price: " + json[i].price + "<br>Structure: " + json[i].structure;
			  content += "<br>Area(m^2): " + json[i].area;
			  var infoTemplate = new InfoTemplate(json[i].commname, content);
			  graphic.setInfoTemplate(infoTemplate);
			  map.graphics.add(graphic);
		  }
	  }
	  attributeQueryRenderer = attributeQueryRender;
});


$(document).ready(function(){
	$("#sub").click(function ( ) {
		$.ajax({
		    url:"showHouse.action",
		    dataType:"json",   //返回格式为json
		    async:true,        //请求是否异步，默认为异步，这也是ajax重要特性
		    data:{ commname: "",
		    	priceIdx: 3,
		    	areaIdx: 3,
		    	structure: "",
		    	floor: "",
		    	direction: ""},
		    type:"GET",        //请求方式
		    beforeSend:function(){
		        //请求前的处理
		    },
		    complete:function(){
		        //请求完成的处理
		    },
		    success : function(result){
		    	//TODO 请求成功时处理
		    	attributeQueryRenderer(result);
		    	},
	    	error : function() {
		          alert("异常！");      
		     }
		});
	});
});