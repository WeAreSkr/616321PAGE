<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"></jsp:include>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/hero-slider-style.css">
    <link rel="stylesheet" href="/css/magnific-popup.css">
    <link rel="stylesheet" href="/css/tooplate-style.css">
    <link rel="stylesheet" type="text/css" href="/css/style-1.css">


    <script src="/js/tether.min.js"></script>
    <script src="/js/hero-slider-main.js"></script>
    <script src="/js/jquery.magnific-popup.min.js"></script>

</head>
<body>

<jsp:include page="navigation.jsp"></jsp:include>
<div style="margin-top:-15px">
<ul class="cd-hero-slider" >

    <!-- Page 1 Gallery One -->
    <li class="selected">
        <div class="cd-full-width">
            <div class="container-fluid js-tm-page-content" data-page-no="1" data-page-type="gallery">
                <div class="tm-img-gallery-container">
                    <div class="tm-img-gallery gallery-one">

<c:forEach items="${images}" var = "image"  varStatus="statu">

                            <div class="grid-item">
                                <figure class="effect-bubba">
                                    <img src="/img/imgs/${image.picPath}.jpg" alt="Image" class="img-fluid tm-img">
                                    <figcaption>
                                        <h2 class="tm-figure-title"></h2>
                                        <p class="tm-figure-description">${image.dsc}</p>
                                        <a href="/img/imgs/${image.picPath}">View more</a>
                                    </figcaption>
                                </figure>
                            </div>
</c:forEach>

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
