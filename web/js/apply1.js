/**
 * Created by liuyang on 2016/10/25.
 */

$(function(){
    $("#apply-form").submit(function () {

        $.ajax({
            url: "applyServlet",
            type: "post",
            data: "action=submit&"+serialized,
            dataType:"json",
            success: function (data) {

            },
        });

    })

})
