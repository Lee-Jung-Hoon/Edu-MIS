

$(document).ready(function() {
	$("#close-writeForm").click(function(){
		$(".writeForm").css({
			display : "none"
		});
	});
	
	$(".btn-txt1").on("click", function() {
		$('.test01').slideUp();
		$(".writeForm").css({
			display : "block"
		});

	});

	
	
	
	
});












	$(function() {
		$("#datepicker").datepicker({
			showOtherMonths : true,
			selectOtherMonths : true
		});
	});
	$(function() {
		$("#datepicker2").datepicker({
			showOtherMonths : true,
			selectOtherMonths : true
		});
	});

	function search() {

		// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
		var infowindow = new daum.maps.InfoWindow({
			zIndex : 1
		});

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		var ps = new daum.maps.services.Places();

		// 키워드로 장소를 검색합니다
		ps.keywordSearch(prompt("키워드 검색"), placesSearchCB);

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
		function placesSearchCB(status, data, pagination) {
			if (status === daum.maps.services.Status.OK) {

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				var bounds = new daum.maps.LatLngBounds();

				for (var i = 0; i < data.places.length; i++) {
					displayMarker(data.places[i]);
					bounds.extend(new daum.maps.LatLng(data.places[i].latitude,
							data.places[i].longitude));
				}

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
				map.setBounds(bounds);
			}
		}

		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {

			// 마커를 생성하고 지도에 표시합니다
			var marker = new daum.maps.Marker(
					{
						map : map,
						position : new daum.maps.LatLng(place.latitude,
								place.longitude)
					});

			// 마커에 클릭이벤트를 등록합니다
			daum.maps.event.addListener(marker, 'click', function() {
				confirm(place.title + "이(가) 맞습니까?")
				// 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
				infowindow
						.setContent('<div style="padding:5px;font-size:12px;">'
								+ place.title + '</div>');
				infowindow.open(map, marker);
			});
			var httpRequest;
			function requestMsg() {
				httpRequest = new XMLHttpRequest();
				httpRequest.onreadystatechange = responseMsg;
				httpRequest.open("GET", "/place/regschedule.do?latitude="
						+ latitude + "&longitude=" + longitude, true)
				httpRequest.send(null);
			}
			function responseMsg() {
				if (httpRequest.readyState == 4) {
					if (httpRequest.status == 200) {
						var msgView = document.getElementById("msgView");
						msgView.innerHTML = httpRequest.responseText;
					}
				}
			}
		}
	}







	//나가기기능
	function closewindow(elementId) {
		var arr = new Array();
		arr = document.getElementsByTagName("input");
		var value = '';
		for (var i = 0; i < arr.length; i++) {
			if (arr[i].checked) {
				value = arr[i].value;
				break;
			}
		}
		window.close();
		window.opener.document.getElementById(elementId).value = value;
	}