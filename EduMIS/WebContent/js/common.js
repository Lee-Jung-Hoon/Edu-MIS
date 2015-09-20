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
$('.btn-message').on('click', function(){
	if ($(this).next().css('display') == 'none') {
		$(this).next().css('opacity', 0).slideDown('slow').animate(
			{ opacity: 1 },
			{ queue: false, duration: 'slow' }
		).parent().addClass('primary-zindex');
		$('body').addClass('login-layer');
	}
});
$('.btn-message-close').on('click', function(){
	$(this).parent().removeClass('primary-zindex').fadeOut();
	$('body').removeClass('login-layer');
});