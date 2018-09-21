jQuery(function () {
    $('#find-optimal').click(function () {
        $.ajax({
            url: "findoptimal.action",
            dataType: "json",   //返回格式为json
            async: true,        //请求是否异步，默认为异步，这也是ajax重要特性
            data: {"picked_points": picked_points,
                   "firstk": $("#firstk").val()
            },
            type: "GET",        //请求方式
            traditional: true,
            success: function (result) {
                remJSON = result;
                houseQueryRenderer(result);
                firstPageInit();
                detailsRender();
            },
            error: function () {
                alert("异常！");
            }
        });
    });

});
