<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
</head>
<body>
	<script>
		var msg = "${msg}";
		var url = "${url}";
		alert(msg);
		location.href = url;
	</script>
</body>
</html>