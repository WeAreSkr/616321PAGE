var dialogInstace , onMoveStartId;	//	用于记录当前可拖拽的对象

// var zIndex = 9000;

//	获取元素对象
function g(id){return document.getElementById(id);}

//	自动居中元素（el = Element）
function autoCenter( el ){
    var bodyW = document.documentElement.clientWidth;
    var bodyH = document.documentElement.clientHeight;

    var elW = el.offsetWidth;
    var elH = el.offsetHeight;

    el.style.left = (bodyW-elW)/2 + 'px';
    el.style.top = (bodyH-elH)/2 + 'px';

}

//	自动扩展元素到全部显示区域
function fillToBody( el ){
    el.style.width  = document.documentElement.clientWidth  +'px';
    el.style.height = document.documentElement.clientHeight + 'px';
}

//	Dialog实例化的方法
function Dialog( dragId , moveId ){

    var instace = {} ;

    instace.dragElement  = g(dragId);	//	允许执行 拖拽操作 的元素
    instace.moveElement  = g(moveId);	//	拖拽操作时，移动的元素

    instace.mouseOffsetLeft = 0;			//	拖拽操作时，移动元素的起始 X 点
    instace.mouseOffsetTop = 0;			//	拖拽操作时，移动元素的起始 Y 点

    instace.dragElement.addEventListener('mousedown',function(e){

        var e = e || window.event;

        dialogInstace = instace;
        instace.mouseOffsetLeft = e.pageX - instace.moveElement.offsetLeft ;
        instace.mouseOffsetTop  = e.pageY - instace.moveElement.offsetTop ;

        // instace.moveElement.style.zIndex = zIndex ++;
    })

    return instace;
}

//	在页面中侦听 鼠标弹起事件
document.onmouseup = function(e){

    dialogInstace = false;
    clearInterval(onMoveStartId);

}

//	在页面中侦听 鼠标移动事件
document.onmousemove = function(e) {
    var e = e || window.event;
    var instace = dialogInstace;
    if (instace) {

        var maxX = document.documentElement.clientWidth -  instace.moveElement.offsetWidth;
        var maxY = document.documentElement.clientHeight - instace.moveElement.offsetHeight ;

        instace.moveElement.style.left = Math.min( Math.max( ( e.pageX - instace.mouseOffsetLeft) , 0 ) , maxX) + "px";
        instace.moveElement.style.top  = Math.min( Math.max( ( e.pageY - instace.mouseOffsetTop ) , 0 ) , maxY) + "px";
    }
    if(e.stopPropagation) {
        e.stopPropagation();
    } else {
        e.cancelBubble = true;
    }
};

//	拖拽对话框实例对象
Dialog('dialogDrag','dialogMove');

function onMoveStart(){

}
//	拖拽对话框实例对象
Dialog('dialogDrag1','dialogMove1');

function onMoveStart(){

}

//	重新调整对话框的位置和遮罩，并且展现
function showDialog(){
    g('dialogMove').style.display = 'block';
    g('mask').style.display = 'block';
    autoCenter( g('dialogMove') );
    fillToBody( g('mask') );
}
//	重新调整对话框的位置和遮罩，并且展现
function showDialog1(){
    g('dialogMove1').style.display = 'block';
    g('mask1').style.display = 'block';
    autoCenter( g('dialogMove1') );
    fillToBody( g('mask1') );
}
//	关闭对话框
function hideDialog(){
    g('dialogMove').style.display = 'none';
    g('mask').style.display = 'none';
}
function hideDialog1(){
    g('dialogMove1').style.display = 'none';
    g('mask1').style.display = 'none';
}
// 弹出登录框结束