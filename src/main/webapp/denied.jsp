<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Access denied</title>
    <link rel="stylesheet" href="https://unpkg.com/tachyons@4.12.0/css/tachyons.min.css"/>
    <style type="text/css">
        html{
            font-family: "Ubuntu", serif;
            font-size: 18px;
        }
        li {
            list-style-type: none;
        }
        .icon{
            width: 1em;
            height: 1em;
        }
        .flex-row .pa2:not(:first-child){
            margin-top: 0;
            margin-left: 8px;
        }
        ul .inline-flex{
            margin-top: 8px;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<h3 class="ma0 pa2 normal">${date}</h3>
<h1 class="ma0 pa2">${path}</h1>
<hr/>
<div class="flex-row pt2 pb2">
    <h1>Access denied</h1>
</div>
</body>
<script src="https://unpkg.com/feather-icons"></script>
<script>
    feather.replace()
</script>
</html>