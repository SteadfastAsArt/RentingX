var locationScole = [];
var serviceScole = [];


function getElementTop(element){
    var actualTop = element.offsetTop;
    var current = element.offsetParent;
    while (current !== null){
        actualTop += current.offsetTop;
        current = current.offsetParent;
    }
    return actualTop;
}


function getOrder(eleID, group) {
    var order = 1;
    var hei = getElementTop(document.getElementById(eleID));

    locationScole[0] = getElementTop(document.getElementById('transportScole'));
    locationScole[1] = getElementTop(document.getElementById('serviceScole'));
    locationScole[2] = getElementTop(document.getElementById('environmentScole'));
    serviceScole[0] = getElementTop(document.getElementById('educationScole'));
    serviceScole[1] = getElementTop(document.getElementById('treatmentScole'));
    serviceScole[2] = getElementTop(document.getElementById('shopScole'));
    serviceScole[3] = getElementTop(document.getElementById('lifeScole'));
    serviceScole[4] = getElementTop(document.getElementById('entertainmentScole'));
    serviceScole[5] = getElementTop(document.getElementById('financeScole'));

    if (group == 1) {
        for (var i = 0; i < houseScole.length; i++) {
            if (hei > houseScole[i]) {
                order++;
            }
        }
    } else if (group == 2) {
        for (var i = 0; i < locationScole.length; i++) {
            if (hei > locationScole[i]) {
                order++;
            }
        }
    } else {
        for (var i = 0; i < serviceScole.length; i++) {
            if (hei > serviceScole[i]) {
                order++;
            }
        }
    }
    return order;
}


$(document).ready(function () {
    $('.youxian').hide();

    $(':radio').click(function () {
        var option = document.getElementById('gexing');
        if (option.checked == true) {
            $('.brick.small').attr('style', 'pointer-events: auto');
            $('.youxian').show();
        } else {
            $('.brick.small').attr('style', 'pointer-events: none');
            $('.youxian').hide();
        }
    });

    $("#sub, #findByName").click(function () {
        var op1 = document.getElementById("notuijian");
        var defau;
        if (op1.checked) {
            defau = 1;
        } else {
            defau = 3;
        }
        $.ajax({
            url:"showReco.action",
            dataType:"json",
            async:true,
            data:{
                houseName: $("#commname").val(),
                direction: $("#direction").val(),
                price: $("#price").val(),
                height: $("#floor").val(),
                structure: $("#struct").val(),
                area: $("#area").val(),
                defau: defau,
                transportOrder: getOrder("transportScole", 2),
                serviceOrder: getOrder("serviceScole", 2),
                environmentOrder: getOrder("environmentScole", 2),
                educationOrder: getOrder("educationScole", 3),
                treatmentOrder: getOrder("treatmentScole", 3),
                shopOrder: getOrder("shopScole", 3),
                lifeOrder: getOrder("lifeScole", 3),
                entertainmentOrder: getOrder("entertainmentScole", 3),
                financeOrder: getOrder("financeScole", 3)
            },
            type:"GET",
            success: function (result) {
                remJSON = result;
                houseRecommendRenderer(result);
                firstPageInit();
                detailsRender();
                if(starClosed)
                    $('#btn-star').click();
                $('#legend-price').show("slow");
            },
            error: function () {
                alert("Error!");
            }
        });
    });
});

