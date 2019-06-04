<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:choose>
	<c:when test="${correct1 != null}">
		<input style="color: green;"  type="radio"
			name="option">
		<label for="option1" style="font-size: 20px;color: green;">${option1}<i style=" color: green;" class="fa fa-check"></i></label>
	</c:when>
	<c:when test="${wrong1 != null}">
		<input style="color: red;"  type="radio"
			name="option">
		<label for="option1" style="font-size: 20px; color: red;">${option1}<i style="color: red;" class="fa fa-times"></i></label>
	</c:when>
	<c:when test="${answer1 != null}">
		<input style="color: blue;"  type="radio"
			name="option">
		<label for="option1" style="font-size: 20px; color: blue;">${option1}<i style=" color:blue;" class="fa fa-check"></i></label>
	</c:when>
	<c:otherwise>
		<input type="radio" name="option">
		<label for="option1" style="font-size: 20px;">${option1}</label>
	</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${correct2 != null}">
		<input style="color: green;"  type="radio"
			name="option">
		<label for="option2" style="font-size: 20px; color: green;">${option2}<i style=" color: green;" class="fa fa-check"></i></label>
	</c:when>
	<c:when test="${wrong2 != null}">
		<input style="color: red;"  type="radio"
			name="option">
		<label for="option2" style="font-size: 20px; color: red;">${option2}<i style="color: red;" class="fa fa-times"></i></label>
	</c:when>
	<c:when test="${answer2 != null}">
		<input style="color: blue;"  type="radio"
			name="option">
		<label for="option2" style="font-size: 20px; color: blue;">${option2}<i style=" color:blue;" class="fa fa-check"></i></label>
	</c:when>
	<c:otherwise>
		<input type="radio" name="option">
		<label for="option2" style="font-size: 20px;">${option2}</label>
	</c:otherwise>
</c:choose>
<br>
<c:choose>
	<c:when test="${correct3 != null}">
		<input style="color: green;"  type="radio"
			name="option">
		<label for="option3" style="font-size: 20px; color: green;">${option3}<i style=" color: green;" class="fa fa-check"></i></label>
	</c:when>
	<c:when test="${wrong3 != null}">
		<input style="color: red;"  type="radio"
			name="option">
		<label for="option3" style="font-size: 20px; color: red;">${option3}<i style="color: red;" class="fa fa-times"></i></label>
	</c:when>
	<c:when test="${answer3 != null}">
		<input style="color: blue;"  type="radio"
			name="option">
		<label for="option3" style="font-size: 20px; color: blue;">${option3}<i style=" color:blue;" class="fa fa-check"></i></label>
	</c:when>
	<c:otherwise>
		<input type="radio" name="option">
		<label for="option3" style="font-size: 20px;">${option3}</label>
	</c:otherwise>
</c:choose>
<br>
<c:if test="${not4 == null}">
<c:choose>
	<c:when test="${correct4 != null}">
		<input style="color: green;"  type="radio"
			name="option">
		<label for="option4" style="font-size: 20px; color: green;">${option4} <i style=" color: green;" class="fa fa-check"></i></label>
	</c:when>
	<c:when test="${wrong4 != null}">
		<input style="color: red;"  type="radio"
			name="option">
		<label for="option4" style="font-size: 20px; color: red;">${option4}<i style="color: red;" class="fa fa-times"></i></label>
	</c:when>
	<c:when test="${answer4 != null}">
		<input style="color: blue;"  type="radio"
			name="option">
		<label for="option4" style="font-size: 20px; color: blue;">${option4} <i style=" color:blue;" class="fa fa-check"></i></label>
	</c:when>
	<c:otherwise>
		<input type="radio" name="option">
		<label for="option4" style="font-size: 20px;">${option4}</label>
	</c:otherwise>
</c:choose>
</c:if>