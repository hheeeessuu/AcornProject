<%@page import="com.dto.TableDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/lib/jquery.js"></script>
<script type='text/javascript' src='jquery/lib/jquery.bgiframe.min.js'></script>
<script type='text/javascript' src='jquery/lib/jquery.ajaxQueue.js'></script>
<script type='text/javascript' src='jquery/jquery.autocomplete.js'></script>
<link rel="stylesheet" type="text/css" href="jquery/jquery.autocomplete.css" />
</head>
<body>

<script>
	var availableTags = [
							'BTC',
							'ETH',
							'DASH',
							'LTC',
							'ETC',
							'XRP',
							'BCH',
							'XMR',
							'ZEC',
							'QTUM',
							'BTG',
							'EOS',
							'ICX',
							'VEN',
							'TRX',
							'ELF',
							'MITH',
							'MCO',
							'OMG',
							'KNC',
							'GNT',
							'HSR',
							'ZIL',
							'ETHOS',
							'PAY',
							'WAX',
							'POWR',
							'LRC',
							'GTO',
							'STEEM',
							'STRAT',
							'ZRX',
							'REP',
							'AE',
							'XEM',
							'SNT',
							'ADA'
						];
	</script>

 	<script>
	$(document).ready(function() {
	    $("#searchbox").autocomplete(availableTags,{ 
	        matchContains: true,
	        selectFirst: false
	    });
	});
	</script>
	
 <table border="1"> 
   <tr>
    <td colspan="15">
    <form action="MyBoardListServlet">
      검색<select name="searchName">
       <option value="currency">currency</option>
      </select>
      <input type="text" id="searchbox" name="searchValue">
      <input type="submit" value="검색">
      </form>
    </td>
   </tr>
 
   <tr>
     <td>bithumb_pk</td>
     <td>bithumb_date</td>
     <td>currency</td>
     <td>opening_price</td>
     <td>closing_price</td>
     <td>min_price</td>
     <td>max_price</td>
     <td>average_price</td>
     <td>units_traded</td>
     <td>volume_1day</td>
     <td>volume_7day</td>
     <td>buy_price</td>
     <td>sell_price</td>
     <td>fluctate_24h</td>
     <td>fluctate_rate_24h</td>
   </tr>
   
   	<c:forEach var="dto" items="${list}">
   	<tr>
		<td>${dto.bithumb_pk}</td>
		<td>${dto.bithumb_date}</td>
		<td>${dto.currency}</td>
		<td>${dto.opening_price}</td>
		<td>${dto.closing_price}</td>
		
		<td>${dto.min_price}</td>
		<td>${dto.max_price}</td>
		<td>${dto.average_price}</td>
		<td>${dto.units_traded}</td>
		<td>${dto.volume_1day}</td>
		
		<td>${dto.volume_7day}</td>
		<td>${dto.buy_price}</td>
		<td>${dto.sell_price}</td>
		<td>${dto.fluctate_24h}</td>
		<td>${dto.fluctate_rate_24h}</td>
	</tr>
   	</c:forEach>
 </table>

</body>
</html>


