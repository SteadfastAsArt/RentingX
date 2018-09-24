var extsClosed = true;
var qcogClosed = true;
var starClosed = true;
var tb;

jQuery(function () {
  console.log('hello, welcome to use rental screening and evaluation platform(HangZhou, China)');

  /* 扩展功能模块响应 */
  $('#btn-exts').click(function () {
    console.log('btn-exts clicked...');
    if (!qcogClosed) {
      $('#btn-qcog').click();
    }
    if (!starClosed) {
      $('#btn-star').click();
    }
    extsClosed = !extsClosed;
    $('div.exts').toggleClass('exts-toggle');
    if (extsClosed) {
      $('#btn-exts').removeClass('btn-danger');
      $('#btn-exts').addClass('btn-default');
      $('#btn-exts span').removeClass('glyphicon-remove');
      $('#btn-exts span').addClass('glyphicon-th-large');
      $('#btn-exts').attr('title', '扩展功能');
    } else {
      $('#btn-exts').removeClass('btn-default');
      $('#btn-exts').addClass('btn-danger');
      $('#btn-exts span').removeClass('glyphicon-th-large');
      $('#btn-exts span').addClass('glyphicon-remove');
      $('#btn-exts').attr('title', '关闭扩展功能');
    }
  });

  /* 快速设置模块响应 */
  $('#btn-qcog').click(function () {
    console.log('btn-qcog clicked...');
    if (!extsClosed) {
      $('#btn-exts').click();
    }
    if (!starClosed) {
      $('#btn-star').click();
    }
    qcogClosed = !qcogClosed;
    $('div.qcog').toggleClass('qcog-toggle');
    if (qcogClosed) {
      $('#btn-qcog').removeClass('btn-danger');
      $('#btn-qcog').addClass('btn-default');
      $('#btn-qcog span').removeClass('glyphicon-remove');
      $('#btn-qcog span').addClass('glyphicon-cog');
      $('#btn-qcog').attr('title', '快速设置');
    } else {
      $('#btn-qcog').removeClass('btn-default');
      $('#btn-qcog').addClass('btn-danger');
      $('#btn-qcog span').removeClass('glyphicon-cog');
      $('#btn-qcog span').addClass('glyphicon-remove');
      $('#btn-qcog').attr('title', '关闭快速设置');
    }
  });
  $('#btn-qcog-cancel').click(function () {
    $('#btn-qcog').click();
  });

  $('#btn-star').click(function () {
    console.log('btn-star clicked...');
    if (!extsClosed) {
      $('#btn-exts').click();
    }
    if (!qcogClosed) {
      $('#btn-qcog').click();
    }
    starClosed = !starClosed;
    $('div.star').toggleClass('star-toggle');
    if (starClosed) {
      $('#btn-star').removeClass('btn-danger');
      $('#btn-star').addClass('btn-default');
      $('#btn-star span').removeClass('glyphicon-remove');
      $('#btn-star span').addClass('glyphicon-star');
      $('#btn-star').attr('title', '关闭系统推荐');
    } else {
      $('#btn-star').removeClass('btn-default');
      $('#btn-star').addClass('btn-danger');
      $('#btn-star span').removeClass('glyphicon-star');
      $('#btn-star span').addClass('glyphicon-remove');
      $('#btn-star').attr('title', '系统推荐');
    }
  });

  //绘制多边形
  $("#drawpoly").click(function () {
    map.disableMapNavigation();
    tb.activate("extent");
  });

  //清除图像
  $("#graphic-clear").click(function () {
    map.graphics.clear();
    polygonLayer.clear();
    poiRangeLayer.clear();
    optimalLayer.clear();
    detailLayer.clear();
    houseRecoLayer.clear();
    poiLayer.clear();
    houseBasic.clear();

    $('#commname').val("");
    $('#legend-price').hide(100);
    if(!starClosed)
        $('#btn-star').click();

  });

  //绘制多点
  $("#pick").click(function () {
      //map.disableMapNavigation();
      tb.activate("multipoint");
  });

});
