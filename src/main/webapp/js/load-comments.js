jQuery(function () {
    $('.house-slot').click(function () {
        var thisSlot = $(this);
        $.ajax({
            url: "comments.action",
            dataType: "json",   //返回格式为json
            async: true,        //请求是否异步，默认为异步，这也是ajax重要特性
            data: { "community_name": thisSlot.find('.list-group-item-heading').text() },
            type: "GET",        //请求方式
            traditional: true,
            success: function (result) {
                commentDiv = thisSlot.find('.comment');
                commentDiv.empty();
                for(var i = 0; i < result.length; i++){
                    commentDiv.append("<p class='question-name'>" + "<span class='label label-primary'>问</span>" + " " + result[i].ques+ "</p>");
                    commentDiv.append("<p class='question-answer'>" + "<span class='label label-success'>答</span>" + " " + result[i].ans + "</p>");
                }
                if(result.length == 0){
                    commentDiv.append("<p>" + "未找到小区有关的评论数据." + "</p>")
                }
            },
            error: function () {
                alert("评论查询异常！");
            }
        });
    });

});
