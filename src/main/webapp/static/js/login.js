//zhoulongpneg 2015-10-26
$(function($) {
	var _ctx = $("meta[name='_ctx']").attr("content");
	
	var validateAccount = function () {
		if($.trim($('#account').prop('value')) == '') {
			console.log('登录账户不能为空！');
//			$('#account-tip').css('display', 'inline-block');
			$('#account-tip').html('登录账户不能为空！');
			return false;
		} 
		var reg = /\w+[@]{1}\w+[.]\w+/;
		if(!reg.test($('#account').prop('value'))) {
			console.log('邮箱格式不正确！例如[1507637678@qq.com]');
			$('#account-tip').html('邮箱格式不正确！例如[1507637678@qq.com]');
			return false;
		}
		$('#account-tip').html('');
		return true;
	};
	
	var passwordValidate = function() {
		if($('#password').prop('value').length < 6) {
			$('#password-tip').html('密码输入不正确！');
			return false;
		}
		$('#password-tip').html('');
		return true;
	};
	
	var replaceAll = function(str) {
		
	};
	
	$('#login-btn').click(function(evt) {
		if(validateAccount() == false) return false;
		if(passwordValidate() == false) return false;
		
		$(this).css('display', 'none');
		$('#progress-bar').css('display', 'block');
		$('#progress-bar').children('div').addClass('active');
		
		var acc = $('#account').prop('value');
		var cryptoKey = CryptoJS.enc.Utf8.parse("1234567890abcdef");//0102030405060708
		var cryptoIv  = CryptoJS.enc.Utf8.parse('6666661234567890');//0102030405060708
		var pwdText = CryptoJS.enc.Utf8.parse($('#password').prop('value'));  
		var encryptedPasswd = CryptoJS.AES.encrypt(pwdText, cryptoKey, { iv: cryptoIv,mode:CryptoJS.mode.CBC});
		
//		encryptedPasswd.re
		
		$.post(_ctx+'/login/'+acc+'/'+encryptedPasswd, {}, function(response) {
			$('#progress-bar').css('display', 'none');
			$('#login-btn').css('display', 'inline-block');
			$('#progress-bar').children('div').removeClass('active');
			if(response.result == 'error') {
				$('#error-msg').html(response.msg);
			} else if(response.status == 0) {
//				window.location = '/zhoulp/weixin/promote/register';
			} else {
//				window.location = '/zhoulp/weixin/promote/manage';
			}
		}, 'json');
		
	});
	
	$('#agreement').change(function(evt) {
		if($(this).attr('checked') == 'checked') {
			$(this).attr('checked', false);
			$('#login-btn').attr('disabled', 'disabled');
		} else {
			$(this).attr('checked', true);
			$('#login-btn').removeAttr('disabled');
		}
	});
	
});