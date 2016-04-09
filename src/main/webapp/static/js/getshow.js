
/**
 * Created by Administrator on 2016/4/6 0006.
 * 每个面获取书籍信息展示
 */
jQuery(document).ready(function ($) {

    $.ajax({
        type: "post", //请求方式
        async: false, //同步和异步的参数
        dataType: "json",
        url: "getShow", //发送请求地址
        // data: params,
        success: function (map) {
            var hotbooks="";
            var newbooks="";
            var booktypes="";
            $.each(map.hotbooks, function (index, Book) {
                hotbooks+='<div class="new_prod_box"><a href="getBookDetails?id='+Book.id+'">'+Book.name+
                '</a><div class="new_prod_bg"><span class="new_icon"><img src="images/promo_icon.gif"/></span>' +
                '<a href="getBookDetails?id='+Book.id+'"><img src="/bookstore'+Book.img+'" class="image thumb"' +
                ' border="0"/></a> </div></div>';
            });
            $.each(map.newbooks, function (index, Book) {
                newbooks+='<div class="new_prod_box"><a href="getBookDetails?id='+Book.id+'">'+Book.name+
                '</a><div class="new_prod_bg"><span class="new_icon"><img src="images/new_icon.gif"/></span>' +
                '<a href="getBookDetails?id='+Book.id+'"><img src="/bookstore'+Book.img+'" class="image thumb"' +
                ' border="0"/></a> </div></div>';
            });
            $.each(map.booktypes, function (index, BookType) {
                booktypes+='<li><a href="getTypeBooks?id='+BookType.id+'">'+BookType.name+'</a></li>';
            });

           //展示数据
            $("#booktypeshow").html(booktypes);
            $("#bookhotshow").html(hotbooks);
            $("#booktnewshow").html(newbooks);
        }
    });

});