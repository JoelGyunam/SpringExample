<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 추가</title>
</head>
<body>
	<h1>사용자 추가</h1>

		<div>
			<label>이름</label> <input type = "text" name = "name" id="name">
		</div>
		<div>	
			<label>생년월일</label> <input type = "text" name = "birthday" id="birthday">
		</div>
		<div>				
			<label>이메일</label> <input type = "text" name = "email" id="email">
		</div>
		<div>				
			<label>자기소개</label> <textarea rows="5" cols="50" name = "introduce" id="introduce"></textarea>
		</div>
		<div>				
			<button type="button" id="addBtn">추가</button>
		</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			$("#addBtn").on("click",function(){
				//유효성 검사
				let name = $("#name").val();
				let birthday = $("#birthday").val();
				let email = $("#email").val();
				let introduce = $("#introduce").val();
				
				if(name == ""){
					alert("이름을 입력하세요");
					return;
				}
				if(birthday == ""){
					alert("생일을 입력하세요");
					return;
				}
				if(email == ""){
					alert("이메일을 입력하세요");
					return;
				}
				if(introduce == ""){
					alert("소개를 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get"
					,url:"/ajax/user/add"
					,data:{"name":name,"birthday":birthday,"email":email,"introduce":introduce}
					,success:function(data){
						// 성공 : {"result":"success"}
						// 실패 : {"result":"fail"}
						if(data.result == "success"){
							//리스트페이지로 이동
							location.href="/ajax/user/list";
						} else{
							alert("추가 실패");
						}
					}
					, error:function(){
						alert("추가 에러");
					}
				});
			});
		});
	</script>
</body>
</html>