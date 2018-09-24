  var preinstallOn = false;
  $(function () {
    $(':input').labelauty();
    // 事件绑定.
    var uls = $('ul.dropdown-menu');
    uls.each(function () {
      var ul = $(this);
      if (ul.attr('id') != 'preinstall') {
        ul.find('li:eq(0)').click(function () {
          var li = $(this);
          li.parents('div.input-group-btn').siblings('input').val(li.text());
        });
        ul.find('li:gt(0)').click(function () {
          var li = $(this);
          var select = li.text();
          var input = li.parents('div.input-group-btn').siblings('input');
          var arr = (input.val() || " ").split(' ');
          if (arr.indexOf('全部') != -1) {
            input.val(select);
          } else {
            if (arr.length == 3) {
              arr.shift();
            }
            if (arr.indexOf(select) == -1) {
              arr.push(select);
              input.val(arr.join(' '));
            }
          }
        });
      } else {
        ul.find('li').click(function () {
          var li = $(this);
          var select = li.text();
          var input = li.parents('div.input-group-btn').siblings('input');
          var otherGroup = li.parents('div.input-group').siblings('div.input-group');
          var otherInputs = otherGroup.find('input');
          if (!preinstallOn) {
            otherGroup.find('button').attr('disabled', '');
            otherInputs.attr('disabled', '');
            preinstallOn = true;
            li.parent().prepend('<li><a href="#">禁用预设</a></li>');
            li.parent().find('li:eq(0)').click(function () {
              preinstallOn = false;
              input.val('禁用预设');
              otherGroup.find('button').removeAttr('disabled');
              otherInputs.removeAttr('disabled');
              li.parent().find('li:eq(0)').remove();
              otherInputs.val('');
            });
          }
          input.val(select);
          switch (select) {
            case '预设一':
              otherInputs.each(function () {
                var thisInput = $(this);
                var thisId = thisInput.attr('id');
                switch (thisId) {
                  case 'direction':
                    thisInput.val('南');
                    break;
                  case 'price':
                    thisInput.val('1000~3000');
                    break;
                  case 'floor':
                    thisInput.val('全部');
                    break;
                  case 'struct':
                    thisInput.val('1室1厅1卫');
                    break;
                  case 'area':
                    thisInput.val('0~40');
                    break;
                  default:
                    break;
                } // switch(thisId)
              });
              break;
            case '预设二':
              otherInputs.each(function () {
                var thisInput = $(this);
                var thisId = thisInput.attr('id');
                switch (thisId) {
                  case 'direction':
                    thisInput.val('东');
                    break;
                  case 'price':
                    thisInput.val('2000~10000');
                    break;
                  case 'floor':
                    thisInput.val('全部');
                    break;
                  case 'struct':
                    thisInput.val('3室2厅2卫');
                    break;
                  case 'area':
                    thisInput.val('全部');
                    break;
                  default:
                    break;
                } // switch(thisId)
              });
              break;
            case '预设三':
              otherInputs.each(function () {
                var thisInput = $(this);
                var thisId = thisInput.attr('id');
                switch (thisId) {
                  case 'direction':
                    thisInput.val('全部');
                    break;
                  case 'price':
                    thisInput.val('0~1000');
                    break;
                  case 'floor':
                    thisInput.val('全部');
                    break;
                  case 'struct':
                    thisInput.val('全部');
                    break;
                  case 'area':
                    thisInput.val('全部');
                    break;
                  default:
                    break;
                } // switch(thisId)
              });
              break;
            case '预设四':
              otherInputs.each(function () {
                var thisInput = $(this);
                var thisId = thisInput.attr('id');
                switch (thisId) {
                  case 'direction':
                    thisInput.val('南');
                    break;
                  case 'price':
                    thisInput.val('全部');
                    break;
                  case 'floor':
                    thisInput.val('全部');
                    break;
                  case 'struct':
                    thisInput.val('全部');
                    break;
                  case 'area':
                    thisInput.val('全部')
                    break;
                  default:
                    break;
                } // switch(thisId)
              });
              break;
            default:
              break;
          } // switch(select)
        });
      } // if-else ul.attr('id') != 'preinstall'
    });
  });
