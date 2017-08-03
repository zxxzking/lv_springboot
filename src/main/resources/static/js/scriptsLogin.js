
jQuery(document).ready(function() {

    $('.page-container form').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        var password2 = $(this).find('.password2').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
        if(password2 == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '165px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password2').focus();
            });
            return false;
        }
        if(password != password2){
            $(this).find('.tip').fadeOut('fast', function(){
                $(this).css('display', 'inline');
            });
            $(this).find('.tip').fadeIn('fast', function(){
                $(this).parent().find('.password2').focus();
            });
            return false;
        }


    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
