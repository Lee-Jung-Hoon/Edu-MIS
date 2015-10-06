var io = require("socket.io")();

var idArr   = [];   //사용자의 이름과 브라우져를 고유하게 구분하는 배열

io.listen(10004);   //응답받는 포트번호

//로그인 할때 이벤트 발생
io.sockets.on("connection", function(socket) {
  socket.on("login", function(info) {
    console.log("접속한 사람 아이디 : " + info.no);
    idArr[info.no] = socket.id;
    console.log("idArr : " + JSON.stringify(idArr));
  });
  
  //data -> 받는사람이름을 받음.  새메세지 또는 답장 전달 할때 이벤트 발생
  socket.on("msg", function(data) {
    console.log("메세지 작성 : "  + data.recvNo + ", 보내는 이름 : " + data.sendName);
    console.log("소켓 아이디 : "  + idArr[data.recvNo]);
    if(idArr[data.recvNo]) {
      io.to(idArr[data.recvNo]).emit("msg", data.sendName);  //보낸사람 이름을 넘겨줌.
    }
  });

  //data -> 받는사람이름을 받음.  새메세지 또는 답장 전달 할때 이벤트 발생
  socket.on("adminMsg", function(sendName) {
	  console.log("보내는 이름 : " + sendName);
	  console.log("소켓 아이디 : "  + idArr[1]);
	  io.to(idArr[1]).emit("msg", sendName);  //보낸사람 이름을 넘겨줌.
  });
  
  // 연결이 종료되었을때
  socket.on('disconnect', function() {
    console.log(socket.id + '가 종료되었습니다.');
  });
});


//<script src="http://localhost:10004/socket.io/socket.io.js"></script>
//<script>
//  $(document).ready(function () {
//    vars socket = io.connect("localhost:10004");
//
//    socket.emit("setName", name);   //로그인하는 부분에 추가  
//
//    socket.emit("countUp", "메세지는 받는 사람 이름(recvName), 보낸사람이름(sendName)"); //메세지전달(새,답) 부분에 추가.
//
//    socket.on("countUp", function(data) {
//     //이벤트가 발생될 경우, 카운트 증가시키는 부분 작성 + 말풍선 띄움
//    })
//    
//</script>

//  <* 로그아웃을 하거나 브라우져를 닫을 경우 nameArr을 수정해야...?>
