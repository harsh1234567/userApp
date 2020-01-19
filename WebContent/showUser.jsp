
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     ${data}
   <table>
   <tr><td>First name</td>
   <td>last name</td>
   <td>email</td>
   <td>action</td>
   </tr>   
  <c:forEach var="user" items="${message}">
    <tr>
   <td>
    <c:out value="${user.firstName}" />
  </td>
<td>
   <c:out value="${user.lastName}" />
 </td>
<td>
    <c:out value="${user.email}" />
    </td>
    <td>
 <form action="deleteServlet" method="POST">
    <input type="hidden" name="email" value=<c:out value="${user.email}"/>>
       <input type="submit" value="delete" />
 </form> 
    </td>
    </tr>
</c:forEach>
</table>
</body>
</html>