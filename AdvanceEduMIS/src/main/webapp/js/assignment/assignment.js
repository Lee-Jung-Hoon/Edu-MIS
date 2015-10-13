/**
 * 
 */
function ckSDate() {
	alert("날짜확인함수")
	return true;
}
	
function moveRegist() {
	location.href = "adAssRegist.do";
}

function prePage() {
  location.href = "assList.do?reqIndex=${thisPage-1}";
}

function nextPage() {
  location.href = "assList.do?reqIndex=${thisPage+1}";
}