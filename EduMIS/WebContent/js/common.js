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