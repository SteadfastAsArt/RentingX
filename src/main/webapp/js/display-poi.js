$(function () {
    $('.view').click(function(e){
        if(!clickHouse){
            return;
        }
        var xx = e.originalEvent.x || e.originalEvent.layerX || 0;
        var yy = e.originalEvent.y || e.originalEvent.layerY || 0;
        var poiPanel = $('.display-poi');
        poiPanel.css('left', xx+75);
        poiPanel.css('top', yy+45);
        poiPanel.css('display', 'block');
        clickHouse = false;
    });
    $('#close-display-poi').click(function(){
        var thisButton = $(this);
        console.log(thisButton.parents('div.panel'));
        thisButton.parents('div.panel').css('display', 'none');
    });
    $('button.btn-display-poi').each(function () {
        $(this).click(function () {
            var before = $('button.btn-primary.btn-display-poi');
            var after = $(this);
            before.removeClass('btn-primary');
            before.addClass('btn-default');
            after.removeClass('btn-default');
            after.addClass('btn-primary');

            $.ajax({
                url: "poi.action",
                dataType: "json",
                async: true,
                data: {
                    "tag_list": after.text(),
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
});