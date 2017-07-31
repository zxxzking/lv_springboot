$(function(){
    //异步校验用户名是否被占用
    $("#username").blur(function(){
        var userName = $(this).val();
        var that = $(this);
        if(userName == null||userName == ''){
            return;
        }
        $.ajax({
            type:"post",
            url:"/user/checkUserName",
            async:true,
            data:{
                userName:userName
            },
            success:function(res){
                var result = res.result;
                if(!result){
                    $(".tip2").css("display","inline")
                }else{
                    $(".tip2").css("display","none")
                }
            }
        });
    })

    $("#form").submit(function(){
        $.ajax({
            type:"post",
            url:"/user/register",
            async:true,
            data:$("#form").serialize(),
            success:function(res){
               console.log(res)
            }
        });

    })
})