<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-09-22
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<link  rel="stylesheet" href="/css/welcome.css">--%>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <!-- load stylesheets -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <!-- Bootstrap style -->
    <link rel="stylesheet" href="/css/hero-slider-style.css">
    <!-- Hero slider style (https://codyhouse.co/gem/hero-slider/) -->
    <link rel="stylesheet" href="/css/magnific-popup.css">
    <!-- Magnific popup style (http://dimsemenov.com/plugins/magnific-popup/) -->
    <link rel="stylesheet" href="/css/tooplate-style.css">
    <link rel="stylesheet" type="text/css" href="/css/style-1.css">
    <script src="/js/jquery.waypoints.min.js"></script>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/tree.js"></script>
    <script src="/js/tether.min.js"></script> <!-- Tether for Bootstrap (http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h) -->
    <script src="/js/hero-slider-main.js"></script>          <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
    <script src="/js/jquery.magnific-popup.min.js"></script> <!-- Magnific popup (http://dimsemenov.com/plugins/magnific-popup/) -->
    <style>
        .dropdown {
            display: inline-block;
        }
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }
        .dropdown-content a:hover {background-color: #f1f1f1}


    </style>
</head>
<body>
<nav class="navbar navbar-default " role="navigation">
    <div class="container-fluid">
        <!--header section -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/tree">616321</a>
        </div>
        <!-- menu section -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/tree">班级志</a></li>
                <li><a href="/photo">班级相册</a></li>
                <li><a href="#">同学录</a></li>
                <li class="dropdown">
                    <c:if test="${user!=null}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img style="width: 20px;height: 20px; border-radius: 50px; overflow: hidden;"  src="img/head/${user.headImg}">${user.name}
                            <b class="caret" ></b>
                        </a>
                        <ul class="dropdown-menu" style="width:100px;">
                            <li><a href="/page?stunmb=${user.stuNmb}">我的主页</a></li>
                            <li><a href="/page">编辑主页</a></li>
                            <li><a href="/authority/0/addevent">添加班级志</a></li>
                            <li><a href="#"> 上传相片至班级照片</a> </li>
                            <c:if test="${user.authority == 1}">
                                <li class="divider"></li>
                                <li><a href="/authority/1/pass">审核班级志(班长特有哦)</a></li>
                            </c:if>
                            <li class="divider"></li>
                            <li><a href="/logout">退出登录</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${user==null}">
                        <a href="javascript:showDialog()" class="current">登录</a>
                    </c:if>
                </li>
            </ul>
        </div>

    </div>
</nav>
<div class="ui-mask" id="mask" onselectstart="return false"></div>
<div class="ui-dialog" id="dialogMove" onselectstart='return false;'>
    <div class="ui-dialog-title" id="dialogDrag"  onselectstart="return false;" >
        登录通行证
        <a class="ui-dialog-closebutton" href="javascript:hideDialog();"></a>
    </div>
    <form class="ui-dialog-content" action="/login" method="post">
        <div class="ui-dialog-l40 ui-dialog-pt15">
            <input class="ui-dialog-input ui-dialog-input-username" type="text" placeholder="学号" name="stuNmb"/>
        </div>
        <br>
        <div class="ui-dialog-l40 ui-dialog-pt15">
            <input class="ui-dialog-input ui-dialog-input-password" type="password" placeholder="密码" name="pwd"/>
        </div>
        <br>
        <div>
            <input type="submit" class="ui-dialog-submit" value="登录">
        </div>
        <div class="ui-dialog-l40">
            <a href="/register">立即注册</a>
            <a href="#">忘记密码</a>
        </div>
    </form>
</div>
<div style="margin-top:-15px">
<ul class="cd-hero-slider" >

    <!-- Page 1 Gallery One -->
    <li class="selected">
        <div class="cd-full-width">
            <div class="container-fluid js-tm-page-content" data-page-no="1" data-page-type="gallery">
                <div class="tm-img-gallery-container">
                    <div class="tm-img-gallery gallery-one">
                        <%--<!-- Gallery One pop up connected with JS code below -->--%>
                        <%--<div class="tm-img-gallery-info-container">--%>
                            <%--<h2 class="tm-text-title tm-gallery-title tm-white"><span class="tm-white">Multi Color Image Gallery</span></h2>--%>
                            <%--<p class="tm-text">This responsive HTML template includes three gallery pages. Multi color is designed by Tooplate. You may use this layout for your website.--%>
                            <%--</p>--%>
                        <%--</div>--%>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-01-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>One</span></h2>
                                    <p class="tm-figure-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    <a href="/image/tm-img-01.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-02-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Two</span></h2>
                                    <p class="tm-figure-description">Maecenas purus sem, lobortis id odio in sapien.</p>
                                    <a href="/image/tm-img-02.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-03-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Three</span></h2>
                                    <p class="tm-figure-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    <a href="/image/tm-img-03.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-04-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Four</span></h2>
                                    <p class="tm-figure-description">Maecenas purus sem, lobortis id odio in sapien.</p>
                                    <a href="/image/tm-img-04.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-05-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Five</span></h2>
                                    <p class="tm-figure-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    <a href="/image/tm-img-05.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-06-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Six</span></h2>
                                    <p class="tm-figure-description">Maecenas purus sem, lobortis id odio in sapien.</p>
                                    <a href="/image/tm-img-06.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-07-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Seven</span></h2>
                                    <p class="tm-figure-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    <a href="/image/tm-img-07.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-08-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Eight</span></h2>
                                    <p class="tm-figure-description">Maecenas purus sem, lobortis id odio in sapien.</p>
                                    <a href="/image/tm-img-08.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-09-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Nine</span></h2>
                                    <p class="tm-figure-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    <a href="/image/tm-img-09.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>
                        <div class="grid-item">
                            <figure class="effect-bubba">
                                <img src="/image/tm-img-10-tn.jpg" alt="Image" class="img-fluid tm-img">
                                <figcaption>
                                    <h2 class="tm-figure-title">Image <span>Ten</span></h2>
                                    <p class="tm-figure-description">Maecenas purus sem, lobortis id odio in sapien.</p>
                                    <a href="/image/tm-img-10.jpg">View more</a>
                                </figcaption>
                            </figure>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </li>

</ul>
</div>


<script>

    function adjustHeightOfPage(pageNo) {

        var offset = 80;
        var pageContentHeight = 0;

        var pageType = $('div[data-page-no="' + pageNo + '"]').data("page-type");

        if( pageType != undefined && pageType == "gallery") {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .tm-img-gallery-container").height();
        }
        else {
            pageContentHeight = $(".cd-hero-slider li:nth-of-type(" + pageNo + ") .js-tm-page-content").height() + 20;
        }

        if($(window).width() >= 992) { offset = 120; }
        else if($(window).width() < 480) { offset = 40; }

        // Get the page height
        var totalPageHeight = $('.cd-slider-nav').height()
            + pageContentHeight + offset
            + $('.tm-footer').height();

        // Adjust layout based on page height and window height
        if(totalPageHeight > $(window).height())
        {
            $('.cd-hero-slider').addClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", totalPageHeight + "px");
        }
        else
        {
            $('.cd-hero-slider').removeClass('small-screen');
            $('.cd-hero-slider li:nth-of-type(' + pageNo + ')').css("min-height", "100%");
        }
    }

    /*
        Everything is loaded including images.
    */
    $(window).load(function(){

        adjustHeightOfPage(1); // Adjust page height

        /* Gallery One pop up
        -----------------------------------------*/
        $('.gallery-one').magnificPopup({
            delegate: 'a', // child items selector, by clicking on it popup will open
            type: 'image',
            gallery:{enabled:true}
        });

        /* Gallery Two pop up
        -----------------------------------------*/
        $('.gallery-two').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery:{enabled:true}
        });

        /* Gallery Three pop up
        -----------------------------------------*/
        $('.gallery-three').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery:{enabled:true}
        });

        /* Collapse menu after click
        -----------------------------------------*/
        $('#tmNavbar a').click(function(){
            $('#tmNavbar').collapse('hide');

            adjustHeightOfPage($(this).data("no")); // Adjust page height
        });

        /* Browser resized
        -----------------------------------------*/
        $( window ).resize(function() {
            var currentPageNo = $(".cd-hero-slider li.selected .js-tm-page-content").data("page-no");

            // wait 3 seconds
            setTimeout(function() {
                adjustHeightOfPage( currentPageNo );
            }, 1000);

        });

        // Remove preloader (https://ihatetomatoes.net/create-custom-preloading-screen/)
        $('body').addClass('loaded');

    });



</script>
</body>
</html>
