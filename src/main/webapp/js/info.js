jQuery(function () {
  $('div.list-group a').click(function () {
    var thisA = $(this);
    thisA.find('div.radar').toggleClass('radar-toggle');
    thisA.find('div.comment').toggleClass('comment-toggle');
  });
});
