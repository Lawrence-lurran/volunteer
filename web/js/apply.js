/**
 * Created by liuyang on 2016/10/25.
 */

$("#cu-interview-date").hide();
$("#cu-medical-history").hide();
var project_id_GET = getQueryString("project_id");

$(function(){
    // var serialized = $("#apply-form").serialize();
    // alert(serialized)
    // console.log(serialized)
    // var is_apply_interview = $("#is_apply_interview");
    // var is_medical_history = $("#is_medical_history");

    // //验证登录状态
    // $.ajax({
    //     url: "/theACP/controller/check.login.php",
    //     success: function (data) {
    //         var result = JSON.parse(data);
    //         if (result.status != CORRECT) {
    //             // 显示错误信息
    //             $("#cu-apply-notification").html(
    //                 "error code: " + result.status + '<br>' + errorcode2errorinfo(result.status) +
    //                 ", 正在跳转至登录页面..."
    //             );
    //             setTimeout(function () {
    //                 location.href = "/theACP/login.html";
    //             }, 1200);
    //         } else {
    //             $("#cu-apply-notification").hide();
    //         }
    //     }
    // });



    //提交报名表单
    $("#apply-form").submit(function () {
        // Prevent default posting of form - put here to work in case of errors

        // setup some local variables
        var $form = $(this);
        // Let's select and cache all the fields
        // var $inputs = $form.find("input, select, button, textarea");
        // $inputs.prop("disabled", true);
        var serializedData = $form.serialize();
        alert(serializedData)
        console.log(serializedData)

        console.log(1)


        // if ($("#name").val() == "") {
        //     showErrorInfo("姓名没有填写，请检查", "不能为空", $("#cu-name-fb"), $inputs);
        //     return false;
        // }
        // if ($("#name").val().length > 20) {
        //     showErrorInfo("姓名太长了", "俄罗斯人的名字也没有这么长吧!", $("#cu-name-fb"), $inputs);
        // }
        // if ($("#phone_number").val() == "") {
        //     showErrorInfo("电话号码没有填写，请检查", "不能为空", $("#cu-phone-number-fb"), $inputs);
        //     return false;
        // }
        // if ($("#email").val() == "") {
        //     showErrorInfo("邮箱没有填写，请检查", "不能为空", $("#cu-email-fb"), $inputs);
        //     return false;
        // }
        // if ($("#wechat").val() == "") {
        //     showErrorInfo("微信号没有填写，请检查", "不能为空", $("#cu-wechat-fb"), $inputs);
        //     return false;
        // }
        // if ($("#id_card_number").val() == "") {
        //     showErrorInfo("身份证号没有填写，请检查", "不能为空", $("#cu-id-card-number-fb"), $inputs);
        //     return false;
        // }
        // if ($("#province").val() == "") {
        //     showErrorInfo("现居省份没有填写，请检查", "不能为空", $("#cu-province-fb"), $inputs);
        //     return false;
        // }
        // if ($("#post_address").val() == "") {
        //     showErrorInfo("邮寄地址没有填写，请检查", "不能为空", $("#cu-post-address-fb"), $inputs);
        //     return false;
        // }



        $.ajax({
            url: "applyServlet",
            type: "post",
            data: "action=submit&"+serializedData,
            dataType:"json",
            success: function (data) {
                var result = JSON.parse(data);
                if (result.status != CORRECT) {
                    // 显示错误信息
                    $("#cu-submit-fb").attr("class", "cu-error-fb").html(
                        "<span class='glyphicon glyphicon-remove'></span>&nbsp;" +
                        "error code: " + result.status + "&nbsp;&nbsp;" + errorcode2errorinfo(result.status)
                    ).show();
                } else {
                    $("#cu-submit-fb").attr("class", "cu-success-fb").html(
                        "<span class='glyphicon glyphicon-ok'></span>&nbsp;报名成功..."
                    ).show();
                    setTimeout(function () {
                        location.href = "/theACP/user.html";
                    }, 1200);
                }

                setTimeout(function () {
                    $("#cu-submit-fb").fadeOut(800);
                }, 2000);
            },
        });
    });

    // 点击提交时判断input的合法性
    // function showErrorInfo(info1, info2, fb, inputs) {
    //     $("#cu-submit-fb").attr("class", "cu-error-fb").html(
    //         "<span class='glyphicon glyphicon-remove'></span>&nbsp;" + info1
    //     ).show();
    //     fb.attr("class", "cu-error-fb").html(
    //         "<span class='glyphicon glyphicon-remove'></span>&nbsp;" + info2
    //     ).fadeIn(800);
    //     inputs.prop("disabled", false);
    // }


    //失去焦点时判断 input 的合法性
    $("#name").blur(function () {
        checkEmpty($(this), $("#cu-name-fb"));
    });

    $("#phone_number").blur(function () {
        checkEmpty($(this), $("#cu-phone-number-fb"));
    });
    $("#email").blur(function () {
        checkEmpty($(this), $("#cu-email-fb"));
    });
    $("#wechat").blur(function () {
        checkEmpty($(this), $("#cu-wechat-fb"));
    });
    $("#id_card_number").blur(function () {
        checkEmpty($(this), $("#cu-id-card-number-fb"));
    });

    $("#province").blur(function () {
        checkEmpty($(this), $("#cu-province-fb"));
    });
    $("#post_address").blur(function () {
        checkEmpty($(this), $("#cu-post-address-fb"));
    });

    //验证表单是否为空，如果是空的话显示错误信息
    function checkEmpty(tar, fb) {
        if (tar.val() == "") {
            tar.parent("div").removeClass("has-success").addClass("has-error");
            fb.attr("class", "cu-error-fb").html(
                "<span class='glyphicon glyphicon-remove'></span>&nbsp;不能为空"
            ).fadeIn(800);
        } else {
            tar.parent("div").removeClass("has-error").addClass("has-success");
            fb.attr("class", "cu-success-fb").html("").fadeIn(800);
        }
    }

    //下载报名表
    $("#cu-apply-download-btn").click(function () {
        window.location.href = 'http://localhost:8080/volunteer/open-resource/项目报名表.doc';
    });
    //退出登录
    // $("#cu-logout").click(function () {
    //     $.ajax({
    //         url: "/theACP/controller/logout.con.php",
    //         success: function (data) {
    //             if (data == CORRECT) {
    //                 location.href = "/login.html";
    //             }
    //         }
    //     })
    // });
});
