/**
 * Created by Administrator on 2016/4/6 0006.
 * 管理员添加验证
 */
jQuery(document).ready(function ($) {
    $(".tooltips").tooltip();//启动提示
    //提交验证
    function Judge() {
        var name = $("#name").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var tel = $("#tel").val();
        var email = $("#email").val();
        var el = /[~#^$@%&!*.,。，()<>:;'"{}【】  ]/gi;
        if (name == "" || name.length > 10|| name.length < 3 || el.test(name)) {
            alert("名称格式不正确！");
            return false;
        }
        if (password != password2 || password.length > 16 || password2.length > 16 || password.length < 6 || password2.length < 6) {
            alert("两次密码不一致或者长度小于6位大于16位！");
            return false;
        }
        if (tel.length!=11) {
            alert("不是11位手机号");
            return false;
        }
        el=/[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
        if (email == "" ||!el.test(email)) {
            alert("Email格式不正确！");
            return false;
        }
        return true;
    };


//表单提交
    $('#sub').click(function () {
        if (Judge()) {
            return true;
        } else {
            return false;
        }

    });

});