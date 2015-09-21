$('.btn-menu').on('click',function(){
	if ($('body').hasClass('show-menu')) {
		$('body').removeClass('show-menu').addClass('hide-menu');
		$('#fp-nav').show();
	} else {
		$('body').removeClass('hide-menu').addClass('show-menu');
		$('#fp-nav').hide();
	}
	return false;
});
$('.login a').on('click',function(){
	$(this).next().css('opacity', 0).slideDown('slow').animate(
		{ opacity: 1 },
		{ queue: false, duration: 'slow' }
	);
	$('body').addClass('login-layer');
	return false;
});
$('.login .btn-close').on('click',function(){
	$(this).parent().fadeOut();
	$('body').removeClass('login-layer');
});

/* ------------------------------------------ 메시지 영역 ------------------------------------------*/

// 메시지 버튼 클릭시
$('.btn-message').on('click', function(){
	if ($(this).next().css('display') == 'none') {
		$('.message-inner li > a').removeClass('open').removeClass('on').next().hide();
		$('.btn-return').click();
		$(this).next().css('opacity', 0).slideDown('slow').animate(
			{ opacity: 1 },
			{ queue: false, duration: 'slow' }
		).parent().addClass('primary-zindex');
		$('body').addClass('login-layer');
	}
});

// 닫기 버튼 클릭 시
$('.btn-message-close').on('click', function(){
	$(this).parent().fadeOut().parent().removeClass('primary-zindex');
	$('.text-content').find('textarea').val('');
	$('body').removeClass('login-layer');
	$('.message-receive-inner span').remove();
});

// 쪽지 메시지 링크 클릭 시
$('.message-inner li > a').on('click', function(){
	if ($(this).hasClass('open')) {
		$(this).removeClass('open').removeClass('on').next().hide().find('textarea').val('');
	} else {
		$(this).addClass('open').addClass('on').next().show().parent().siblings().find('>a').removeClass('open').removeClass('on').next().hide().find('textarea').val('');
	}
	$('.message-inner').animate({scrollTop: $(this).parent().index() * 30+'px'}, 'fast');
});	

// 쪽지 메시지 링크 마우스 오버, 포커스 &  아웃, 블러 액션
$('.message-inner li > a').on('mouseenter focus', function(){
	$(this).addClass('on');
}).on('mouseleave blur', function(){
	if ($(this).hasClass('open')) {
		return false;
	} else {
		$(this).removeClass('on');
	}	
});

// 쪽지 레이어 새로운 쪽지 버튼 클릭 시
$('.btn-write').on('click', function(){
	$('.message-inner li > a').removeClass('open').removeClass('on').next().hide().find('textarea').val('');
	$(this).parent().hide().next().show();
});

// 새로운 쪽지 + 버튼 클릭 시
$('.btn-plus').on('click', function(){
	$('.layer-side').show();
	$('.layer-side').find(':checkbox').prop('checked', false);
});

// 새로운 쪽지 우측 레이어 체크박스 버튼 전체선택 클릭 시
$('#list-all').change(function () {
	if (this.checked) {
		$('.layer-side').find(':checkbox').prop('checked', true);
	} else {
		$('.layer-side').find(':checkbox').prop('checked', false);
	}
});
// 새로운 쪽지 우측 레이어 하단 확인 버튼 클릭 시
$('.layer-side .btn-check').on('click', function(){
	$('.layer-side ul').find(':checkbox:checked').filter(function (index, item) {
		var memoId = document.getElementsByName("memoId");
		for (var i = 0; i < memoId.length; i++)
		{
			if ($(this).attr("id") == memoId[i].value)
			{
				return false;
			}
		}
		return true;
	})
	.each(function (index, item) {
		$('.message-receive-inner').append('<span>'+$(this).prev().text()+'<input type="hidden" name="memoId" value="'+$(this).attr('id')+'" /><button type="button" class="btn-cancel-s">취소</button></span>');
	});
	$(this).parent().hide();
	$('.btn-cancel-s').on('click', function(){
		$(this).parent().remove();
	});
});


// 새로운 쪽지 레이어 되돌아가기 버튼 클릭 시
$('.btn-return').on('click', function(){
	$('.layer-side').find(':checkbox').prop('checked', false).parents('.layer-side').hide();
	$('.text-receive').val('');
	$('.message-receive-inner span').remove();
	$(this).parent().hide().prev().show();
});
/* ------------------------------------------------------------------------------------ */