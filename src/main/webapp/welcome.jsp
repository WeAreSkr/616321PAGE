<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>welcome</title>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<style>
@import url('https://fonts.googleapis.com/css?family=Nunito:300,400,700');

/* _variables.css */

/* _mixins.css */

/* _global.css */
* {
  box-sizing: border-box;
}

body {
	font-family: 'Nunito', sans-serif;
	
}

img {
  max-width: 100%;
  height: auto;
}

/* _site-header.css */
.site-header {
  text-align: center;
  padding: 40px 0;

}
.site-header__title {
  font-size: 36px;
  color: #fff;
}

/* _wrapper.css */
.wrapper {
  padding-left: 18px;
  padding-right: 18px;
  max-width: 1236px;
  margin-left: auto;
  margin-right: auto;
}


/* _timeline.css */
.timeline {
  position: relative;
  margin: 30px auto;
  padding: 60px 0;

}
.timeline::before {
  content: "";
  position: absolute;
  top: 0;
  left: 10%;
  width: 4px;
  height: 100%;
  background-color: #8d94b1;
}
@media (min-width: 800px){
  .timeline::before{
    left: 50%;
    margin-left: -2px;
  }
}
.timeline__item {
  margin-bottom: 100px;
  position: relative;
}
.timeline__item::after{
  content: "";
  clear: both;
  display: table;
}
.timeline__item:nth-child(2n) .timeline__item__content {
  float: right;
}
.timeline__item:nth-child(2n) .timeline__item__content::before {
  content: '';
  right: 40%;
}
@media (min-width: 800px){
  .timeline__item:nth-child(2n) .timeline__item__content::before{
    left: inherit;
  }
}
.timeline__item:nth-child(2n) .timeline__item__content__date {
  background-color: #b292c5;
}
.timeline__item:nth-child(2n) .timeline__item__content__description {
  color: #b292c5;
}
.timeline__item:last-child {
  margin-bottom: 0;
}
.timeline__item-bg {
  -webkit-transition: all 1s ease-out;
  transition: all 1s ease-out;
  color: #fff;
}
.timeline__item-bg:nth-child(2n) .timeline__item__station {
  background-color: #7646b5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content {
  background-color: #7646b5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content::before {
  background-color: #b292c5;
}
.timeline__item-bg:nth-child(2n) .timeline__item__content__description {
  color: #fff;
}
.timeline__item-bg .timeline__item__station {
  background-color: #0072e8;
}
.timeline__item-bg .timeline__item__content {
  background-color: #0072e8;
}
.timeline__item-bg .timeline__item__content::before {
  background-color: #65adb7;
}
.timeline__item-bg .timeline__item__content__description {
  color: #fff;
}
.timeline__item__station {
  background-color: #9aa0b9;
  width: 40px;
  height: 40px;
  position: absolute;
  border-radius: 50%;
  padding: 10px;
  top: 0;
  left: 10%;
  margin-left: -33px;
  border: 4px solid #8d94b1;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__station{
    left: 50%;
    margin-left: -30px;
    width: 60px;
    height: 60px;
    padding: 15px;
    border-width: 6px;
  }
}
.timeline__item__content {
  width: 80%;
  background: #fff;
  padding: 20px 30px;
  border-radius: 6px;
  float: right;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__content{
    width: 40%;
    float: inherit;
    padding: 30px 40px;
  }
}
.timeline__item__content::before {
  content: '';
  position: absolute;
  left: 10%;
  background: #8d94b1;
  top: 20px;
  width: 10%;
  height: 4px;
  z-index: -1;
  -webkit-transition: all .3s ease-out;
  transition: all .3s ease-out;
}
@media (min-width: 800px){
  .timeline__item__content::before{
    left: 40%;
    top: 30px;
    height: 4px;
    margin-top: -2px;
  }
}
.timeline__item__content__date {
  margin: 0;
  padding: 8px 12px;
  font-size: 15px;
  margin-bottom: 10px;
  background-color: #65adb7;
  color: #fff;
  display: inline-block;
  border-radius: 4px;
  border: 2px solid #fff;
}
.timeline__item__content__description {
  margin: 0;
  padding: 0;
  font-size: 16px;
  line-height: 24px;
  font-weight: 300;
  color: #65adb7;
}
@media (min-width: 800px){
  .timeline__item__content__description{
    font-size: 19px;
    line-height: 28px;
  }
}

/* _site-footer.css */
.site-footer {
  padding: 50px 0 200px 0;

}
.site-footer__text {
  color: #e6e6e6;
  font-size: 14px;
  text-align: center;
}
.site-footer__text__link {
  color: #8287a9;
}
</style>

</head>
<body background="image/bg.jpg" ;
      style="background-repeat:no-repeat ;background-size:100% 100%;background-attachment: fixed;">

<script src="js/jquery.waypoints.min.js"></script>

<header class="site-header">
  <div class="wrapper">
    <h1 class="site-header__title">jquery Vertical Time Axis</h1>
  </div>
</header>

<section class="timeline">
  <div class="wrapper">
    <div class="timeline__item timeline__item--0">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1977 Aug. 20</h2>
        <p class="timeline__item__content__description">Voyager 2 launched from Kennedy Space Flight Center</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--1">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1977 Sept. 5</h2>
        <p class="timeline__item__content__description">Voyager 1 launched from Kennedy Space Flight Center, Voyager 1 returns first spacecraft photo of Earth and Moon</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--2">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1979 Mar. 5</h2>
        <p class="timeline__item__content__description">Voyager 1 makes its closest approach to Jupiter</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--3">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1979 July 9</h2>
        <p class="timeline__item__content__description">Voyager 2 makes its closest approach to Jupiter</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--4">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1980 Nov. 12</h2>
        <p class="timeline__item__content__description">Voyager 1 flies by Saturn, Voyager 1 begins its trip out of the Solar System</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--5">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1981 Aug. 25</h2>
        <p class="timeline__item__content__description">Voyager 2 flies by Saturn</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--6">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1982</h2>
        <p class="timeline__item__content__description">Deep Space Network upgrades two 26-m antennas to 34-m</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--7">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1986 Jan. 24</h2>
        <p class="timeline__item__content__description">Voyager 2 has the first-ever encounter with Uranus, Deep Space Network begins expansion of 64-m antennas to 70-m</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--8">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1987</h2>
        <p class="timeline__item__content__description">Voyager 2 'observes' Supernova 1987A</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--9">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1988</h2>
        <p class="timeline__item__content__description">Voyager 2 returns first color images of Neptune</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--10">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1989 Aug. 25</h2>
        <p class="timeline__item__content__description">Voyager 2 is the first spacecraft to observe Neptune, Voyager 2 begins its trip out of the Solar System, below the ecliptic plane</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--11">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1990 Jan. 1</h2>
        <p class="timeline__item__content__description">Begins Voyager Interstellar Mission</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--12">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1990 Feb. 14</h2>
        <p class="timeline__item__content__description">Last Voyager Images - Portrait of the Solar System</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--13">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">1998 Feb. 17</h2>
        <p class="timeline__item__content__description">Voyager 1 passes Pioneer 10 to become the most distant human-made object in space</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--14">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">2004 Dec. 15</h2>
        <p class="timeline__item__content__description">Voyager 1 crosses Termination Shock</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--15">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">2007 Sep. 5</h2>
        <p class="timeline__item__content__description">Voyager 2 crosses Termination Shock</p>
      </div>
    </div>
    <div class="timeline__item timeline__item--16">
      <div class="timeline__item__station"></div>
      <div class="timeline__item__content">
        <h2 class="timeline__item__content__date">2012 Aug. 25</h2>
        <p class="timeline__item__content__description">Voyager 1 enters Interstellar Space</p>
      </div>
    </div>
  </div>
</section>

<script>
function customWayPoint(className, addClassName, customOffset) {
  var waypoints = $(className).waypoint({
    handler: function(direction) {
      if (direction == "down") {
        $(className).addClass(addClassName);
      } else {
        $(className).removeClass(addClassName);
      }
    },
    offset: customOffset
  });
}

var defaultOffset = '50%';

for (i = 0; i < 17; i++) {
  customWayPoint('.timeline__item--' + i, 'timeline__item-bg', defaultOffset);
}
</script>

</body>
</html>

