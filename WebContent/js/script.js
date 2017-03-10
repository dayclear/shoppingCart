window.onload=function(){
    var cartTable = document.getElementById('cartTable');
    var tr = cartTable.children[1].getElementsByTagName("tr");
    var checkInputs = document.getElementsByClassName('check');
    var checkAllInputs = document.getElementsByClassName('check-all');
    var selectedTotal = document.getElementById('selectedTotal');
    var priceTotal = document.getElementById('priceTotal');
    var selected = document.getElementById('selected');
    var footer = document.getElementById('footer');
    var selectedViewList = document.getElementById('selectedViewList');
    var deleteAll = document.getElementById('deleteAll');

    //计算总计金钱
    function getTotal() {
        var seleted = 0;
        var price = 0;
        var HTMLstr = '';
        for (var i = 0, len = tr.length; i < len; i++) {
            if (tr[i].getElementsByTagName('input')[0].checked) {
                tr[i].className = 'on';
                seleted += parseInt(tr[i].getElementsByTagName('input')[1].value);
                price += parseFloat(tr[i].cells[4].innerHTML);
                HTMLstr += "<div><img src=" + tr[i].getElementsByTagName('img')[0].src + "><span class='del'"+"index=" + i + ">取消选择</span></div>";
            }
            else {
                tr[i].className = '';
            }
        }
        selectedTotal.innerHTML = seleted;
        priceTotal.innerHTML = price.toFixed(2);
        selectedViewList.innerHTML = HTMLstr;

        if (seleted == 0) {
            footer.className = 'footer';
        }
    }

    //check框添加点击事件
    for(var i=0;i<checkInputs.length;i++){
       checkInputs[i].addEventListener("click",function(){
           if(this.className.indexOf("check-all")>-1){
               for(var j=0;j<checkInputs.length;j++){
                   checkInputs[j].checked=this.checked;
               }
           }else{
               if(this.checked==false){
                   for(var ckAll=0;ckAll<checkAllInputs.length;ckAll++){
                       checkAllInputs[ckAll].checked=false;
                   }
               }
           }
           getTotal();
       },false)
    }

    //使用事件代理
    for(var j=0;j<tr.length;j++){

        //增加和减少数量按钮加入点击事件
        tr[j].addEventListener("click",function(e){
            e=e||window.event;
            var el=e.srcElement;
            var inputNum=this.getElementsByTagName("input")[1];
            var val=parseInt(inputNum.value);
            switch(el.className){
                case "reduceNum":
                    if(val>1){
                        inputNum.value=val-1;
                    }else{
                        alert("物品不能再减少了");
                    }
                    getSubTotal(this);
                    break;
                case "addNum":
                    inputNum.value=val+1;
                    getSubTotal(this);
                    break;
                case 'delete':
                    this.parentNode.removeChild(this);
                    break;
                default:
                    break;
            }
            getTotal();
        },false);

        //手动输入数量时，添加键盘抬起事件
        tr[j].getElementsByTagName('input')[1].onchange = function () {
            var val = parseInt(this.value);
            var tr = this.parentNode.parentNode;//input父级元素是td，再父级才是tr
            if (isNaN(val) || val < 1) {
                val = 1;
            }
            this.value=val;
            getSubTotal(tr);
            getTotal();
        }
    }

    //计算小计的价格
    function getSubTotal(tr) {
        var tds = tr.cells;
        var price = parseFloat(tds[2].innerHTML);
        var count = parseInt(tr.getElementsByTagName('input')[1].value);
        var SubTotal = parseFloat(price * count);
        tds[4].innerHTML = SubTotal.toFixed(2);
    }


    //查看以选中的商品
    selected.onclick = function () {
        if (footer.className == 'footer') {
            if (selectedTotal.innerHTML != 0) {
                footer.className = 'footer show';
            }
        }
        else {
            footer.className = 'footer';
        }
    };

    //在查看的div浮层里面删除商品
    selectedViewList.onclick = function (e) {
        e = e || window.event;
        var el = e.srcElement;
        if (el.className == 'del') {
            var index = parseInt(el.getAttribute('index'));
            checkInputs[index+1].click();
        }
    };

    //开始进入购物车时全部选中
    for(var k=0;k<tr.length;k++){
        getSubTotal(tr[k]);
    }
    checkAllInputs[0].click();
};