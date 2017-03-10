window.onload=function(){
    var loginBox=document.getElementById("loginBox");
    var registerBox=document.getElementById("registerBox");
    var updateBox=document.getElementById("updateBox");
    var mask=document.getElementById("mask");
    var loginX=document.getElementById("loginX");
    var registerX=document.getElementById("registerX");
    var updateX=document.getElementById("updateX");
    var loginA=document.getElementById("loginA");
    var registerA=document.getElementById("registerA");
    var updateA=document.getElementById("updateA");
    var registerMes=document.getElementById("registerMes");
    var loginMes=document.getElementById("loginMes");
    var updateMes=document.getElementById("updateMes");
    
    loginA.addEventListener("click",function(){
        mask.style.display="block";
        loginBox.style.display="block";
    },false);

    registerA.addEventListener("click",function(){
        mask.style.display="block";
        registerBox.style.display="block";
    },false);
    
    updateA.addEventListener("click",function(){
        mask.style.display="block";
        updateBox.style.display="block";
    },false);

    loginX.addEventListener("click",function(){
    	loginMes.style.display="none";
        mask.style.display="none";
        loginBox.style.display="none";
    },false);

    registerX.addEventListener("click",function(){
    	registerMes.style.display="none";
        mask.style.display="none";
        registerBox.style.display="none";
    },false);
    
    updateX.addEventListener("click",function(){
    	updateMes.style.display="none";
        mask.style.display="none";
        updateBox.style.display="none";
    },false);

};
