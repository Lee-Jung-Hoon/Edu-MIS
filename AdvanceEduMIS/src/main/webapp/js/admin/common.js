/* ------------------------------------------ 메시지 영역 ------------------------------------------*/
// 실시간 노드 서버 접속 소켓 정의
var socket;

// 메시지 버튼 클릭시
$(document).ready(function(){
	// 쪽지 목록 사용자 클릭 이벤트 처리
	$('#memberUL').on('click', "[type=checkbox]", function(){
		if ($(this).prop("checked")) {
			$('.message-receive-inner')
			.append('<span>' + $(this).prev().text() + 
					'    <input type="hidden" name="memoId" id="memoId' + $(this).attr('id') + '" value="' + $(this).attr('id') + '" />' +
			        '    <button type="button" class="btn-cancel-s">취소</button>' +
					'</span>');
			$('.btn-cancel-s').on('click', function(){
				$(this).parent().remove();
				$('#memberUL [id="' + $(this).prev().val() + '"]').prop("checked", false);
			});
		} else {
			$('#memoId' + $(this).attr('id')).parent().remove();
		}	
		
		/*
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
		*/	   
			   
			   
			   
		
		
		
	});
	
	
	$('.btn-menu').on('click',function(){

		if(!adminLogin) {
			alert("로그인 후 사용가능합니다.");
			return false;
		} 
		
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
    //리스트 추가 부분
    if ($('.btn-message').next().css('display') == 'none') {
      $('.message-inner li > a').removeClass('open').removeClass('on').next().hide();
      
      $('.btn-return').click();
      $('.btn-message').next().css('opacity', 0).slideDown('slow').animate(
          { opacity: 1 },
          { queue: false, duration: 'slow' }
      ).parent().addClass('primary-zindex');
      $('body').addClass('login-layer');

      //쪽지추가 부분
      $.ajax({
        type : "get",
        url : "/AdvanceEduMIS/talk/receiveList.do"
      }).done (function (data) {
        $("#messageUL").html(data);
        $(".count").html($("#count").val());
        //쪽지추가 부분
        
        // 쪽지 메시지 링크 클릭 시
        $('.message-inner li > a').on('click', function(){
          if ($(this).hasClass('open')) {
            $(this).removeClass('open').removeClass('on').next().hide().find('textarea').val('');
        
          } else {
            $(this).addClass('open').addClass('on').next().show().parent().siblings().find('>a').removeClass('open').removeClass('on').next().hide().find('textarea').val('');
          }
          $('.message-inner').stop().animate({scrollTop: $(this).parent().index() * 30+'px'}, 'fast');
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
      });
    }
  });
  
  //닫기 버튼 클릭 시
  $('.btn-message-close').on('click', function(){
      $(this).parent().fadeOut().parent().removeClass('primary-zindex');
      $('.text-content').find('textarea').val('');
      $('body').removeClass('login-layer');
      $('.message-receive-inner span').remove();
  });
  
  //쪽지 레이어 새로운 쪽지 버튼 클릭 시
  $('.btn-write').on('click', function(){
      $('.message-inner li > a').removeClass('open').removeClass('on').next().hide().find('textarea').val('');
      $(this).parent().hide().next().show();
  });
  
//새로운 쪽지 + 버튼 클릭 시
$('.btn-plus').on('click', function(){
  $.ajax({
    type : "get",
    url : "/AdvanceEduMIS/talk/memberList.do"
  }).done (function (data) {
    $("#memberUL").html(data);
    // 쪽지추가 부분
    $('.layer-side').show();
    $('.layer-side').find(':checkbox').prop('checked', false);
  });
});
  
  //새로운 쪽지 우측 레이어 체크박스 버튼 전체선택 클릭 시
  $('#list-all').change(function () {
	  $('[id *= memoId]').parent().remove();
	  if (this.checked) {
		  $('.layer-side').find(':checkbox').prop('checked', true);
		  $('#memberUL :checked').each(function () {
			  $('.message-receive-inner')
			  .append('<span>' + $(this).prev().text() + 
					  '    <input type="hidden" name="memoId" id="memoId' + $(this).attr('id') + '" value="' + $(this).attr('id') + '" />' +
					  '    <button type="button" class="btn-cancel-s">취소</button>' +
			  '</span>');
			  $('.btn-cancel-s').on('click', function(){
				  $(this).parent().remove();
				  $('#memberUL [id="' + $(this).prev().val() + '"]').prop("checked", false);
			  });
		  });
	  } else {
		  $('.layer-side').find(':checkbox').prop('checked', false);
	  }
  });
  
  //새로운 쪽지 우측 레이어 하단 확인 버튼 클릭 시
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
  
  //새로운 쪽지 우측 레이어 하단 확인 버튼 클릭 시
  $('.layer-side .btn-check').on('click', function(){
   /*	  
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
   */
   $(this).parent().hide();
   $('.btn-cancel-s').on('click', function(){
     $(this).parent().remove();
   });
  });
  
  
  //새로운 쪽지 레이어 되돌아가기 버튼 클릭 시
  $('.btn-return').on('click', function(){
   $('.layer-side').find(':checkbox').prop('checked', false).parents('.layer-side').hide();
   $('.text-receive').val('');
   $('.message-receive-inner span').remove();
   $(this).parent().hide().prev().show();
  });
  
  //메시지 알림 삭제
  $('.btn-ring-del').on('click', function(){
   $(this).parent().remove();
  });
});


// 답변/새메세지 전송
  function sendTalk(no, recvNo, sendName) {
    if (no) {
      //답변 talk
      var con = $("#" + no);
      var content = con.val();
      if(!content){
        alert("내용을 입력해주세요");
      } else {
          $.post("/AdvanceEduMIS/talk/reTalk.do", {
          no : no,
          content : content
        }, function() {
          con.parents('li').remove();
          $(".count").html($(".count").html()-1);
        });
        socket.emit("msg", {recvNo : recvNo, sendName : sendName } );
      }
      
    } else {   
      //새로운 talk
      var sendNameList = document.getElementsByName("memoId");
      var name;
        var content = ($(".text-receive").val());
        if(!content){
          alert("내용을 입력해주세요");
        } else if (!sendNameList.length){
          alert("받을 사람을 선택해주세요");
          
        } else {
          for(var i = 0; i < sendNameList.length; i++) {
            name += "/" + sendNameList[i].value;
            socket.emit("msg", {recvNo : sendNameList[i].value, sendName : sendName } );
          }
          console.log("name : " + name);
          $.post("/AdvanceEduMIS/talk/newTalk.do", {
	          name : name,
	          content : content
          }, function() {
        	  $('.btn-return').click();
          });
        }
    }
  }
  
  // x버튼 클릭시 처리할 함수
  function checkTalk(no) {
    $.post("/AdvanceEduMIS/talk/changeCheck.do", {
      no : no
    }, function () {
      $("#" + no).parents('li').remove();
      $(".count").html($(".count").html()-1);
    })
  }
  
  
/* ------------------------------------------------------------------------------------ */