<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="dashboard.css" rel="StyleSheet"/>
<body>
<header>Your Trading Dashboard</header>


<img src="bitcoin.jpg" alt="Bitcoin stock">
<img src="tesla.jpg" alt="Tesla stock">
<img src="microsoft.jpg" alt="Microsoft stock">
<img src="amd.jpg" alt="AMD stock">



<button type="button" class="btn btn-default btn-sm" onClick= "orderHistory()">
	<span class="glyphicon glyphicon-log-out"></span> My order history
</button>

<script type="text/javascript">
	function orderHistory(){
		location.href="/allorders/${userId}"
	}
</script>



<button type="button" class="btn btn-default btn-sm" onClick= "support()">
	<span class="glyphicon glyphicon-log-out"></span> Get support with stocks
</button>
<!--- Create page for trading support because location.href won't work --->
<script type="text/javascript">
	function accountDetails(){
		location.href="/support"
	}
</script>



<button type="button" class="btn btn-default btn-sm" onClick= "logout()">
	<span class="glyphicon glyphicon-log-out"></span> Log out
</button>

<script type="text/javascript">
	function logout(){
		location.href="/"
	}
</script>


</body>
</html>