function radarGen(eid, items) {
    var dom = document.getElementById(eid);
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {
            data: []
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '交通', max: 100},
                { name: '教育', max: 100},
                { name: '医疗', max: 100},
                { name: '购物', max: 100},
                { name: '环境', max: 100},
                { name: '生活', max: 100},
                { name: '娱乐', max: 100},
                { name: '金融', max: 100}
            ]
        },
        series: [{
            name: '',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [items.transportscole, items.educationscole, items.treatmentscole, items.shopscole,
                        items.environmentscole, items.lifescole, items.entertainmentscole, items.financescole],
                    name : items.commname
                }
            ]
        }]
    };;
    if (option && typeof option === "object") {
        myChart.clear();
        myChart.setOption(option, true);
    }
}

jQuery(function () {
    $('div.list-group a').click(function () {
        var thisA = $(this);
        thisA.find('div.radar').toggleClass('radar-toggle');
        thisA.find('div.comment').toggleClass('comment-toggle');
        var eid = thisA.find('div.radar').attr('id');
        for (var i = 0; i < 8; i++) {
            var radarID1 = "radar" + i;
            if (eid == radarID1 && (8*pageNum+i-8) < remJSON.length) {
                //console.log(eid);
                radarGen(eid, remJSON[8*pageNum+i-8]);
                break;
            }
        }
    });
});
