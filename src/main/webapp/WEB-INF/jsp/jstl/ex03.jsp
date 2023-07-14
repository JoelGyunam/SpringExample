<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포맷 라이브러리</title>
</head>
<body>

	<h1>JSTL 포맷 라이브러리</h1>

	<h3>숫자 출력</h3>
	<c:set var="number" value="1234354" />
	<h4><fmt:formatNumber>${number }</fmt:formatNumber></h4>
	<h4><fmt:formatNumber value = "${number }" /></h4>
	
	<h3>퍼센트</h3>
	<h4><fmt:formatNumber type="percent" value = "0.43" /></h4>
	<h4><fmt:formatNumber type="percent" value = "${number*13}"/></h4>
	
	<h3>통화</h3>
	<h4><fmt:formatNumber type="currency" value="${number }"/></h4>
	<h4><fmt:formatNumber type="currency" value="${number }" currencySymbol="*"/></h4>
	
	<h3>소수점 표현</h3>
	<c:set var="pi" value="3.1415926435" />
	<h4>${pi }</h4>
	<h4><fmt:formatNumber value = "${pi }" pattern="#.##"/></h4>
	<h4><fmt:formatNumber value = "${pi }" pattern="0.00"/></h4>
	<fmt:formatNumber value = "${pi }" pattern="#.##" var = "pi2"/>
	<h4>${pi2 }</h4>
	
	
	<h3>날짜 포맷</h3>
	<h4>${now }</h4>
	<h4><fmt:formatDate value="${now }" pattern = "yyyy년 MM월 dd일 hh시 mm분 ss초"/></h4>
	
	<%-- Sting -> Date -> String --%>
	${dateString }
	<fmt:parseDate value = "${dateString }" var = "date" pattern = "yyyy/MM/dd HH:mm:ss"/>
	${date }
	
	
</body>
</html>