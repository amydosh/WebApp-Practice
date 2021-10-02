 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Available Flights</title>
</head>
<body>


<b>Search for Available Flights:</b><br>
<form method="post" action="searchflightresults.jsp">
	Departure Location: <input type="text" name="departloc"><br>
 	Destination: <input type="text" name="destinationloc"><br>
 	Desired Departure Date (MM-DD-YYYY): <input type="text" name="departdate"><br>

<button type="submit">Search</button><br><br>

If you'd like to return to the main menu, please click <a href="index.jsp">here</a>.





</form>

</body>
</html>