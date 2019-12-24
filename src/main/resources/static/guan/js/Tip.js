$(function () {
    $('.tip-container').click(function () {
        var tipcon = '<div class="tip-input">' +
            '<input type="text" class="house-tip" placeholder="请输入内容">' +
            '<span class="del"></span>' +
            '</div>';
        $('.tip').append(tipcon);



        // 鍒犻櫎琛ㄥ崟
        $('.del').click(function () {
            $(this).parent().remove();
        });
    });

});