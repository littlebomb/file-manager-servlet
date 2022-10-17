<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>FileManager</title>
    <link rel="stylesheet" href="https://unpkg.com/tachyons@4.12.0/css/tachyons.min.css"/>
    <style type="text/css">
        html{
            font-family: "Ubuntu", serif;
            font-size: 12px;
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
    <div class="inline-flex ml2">
        <i data-feather="arrow-up-circle" class="icon"></i>
        <a class="ml2" href="?path=${parent}">Up</a><br>
    </div>
    <div class="flex ma0 pa0">
        <li class="pa2">
            <span class="b">Файл</span>
            <ul class="flex-column flex ma0 pa0">
                <c:forEach var="directory" items="${directories}">
                    <li class="inline-flex">
                        <i data-feather="folder" class="yellow icon"></i>
                        <a href="?path=${directory.getAbsolutePath()}" class="ml2">${directory.getName()}/</a>
                    </li>
                </c:forEach>
                <c:forEach var="file" items="${files}">
                    <li class="inline-flex">
                        <i data-feather="file" class="gray icon"></i>
                        <a href="?path=${file.getAbsolutePath()}" class="ml2">${file.getName()}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li class="pa2">
            <span class="b">Размер</span>
            <ul class="flex-column flex ma0 pa0">
                <c:forEach var="dir" items="${directories}">
                    <li class="inline-flex">
                        <span class="ml2">Папка</span>
                        <i data-feather="file" class="white icon"></i>
                    </li>
                </c:forEach>
            </ul>
            <ul class="flex-column flex ma0 pa0">
                <c:forEach var="file" items="${files}">
                    <li class="inline-flex">
                        <span class="ml2">${file.length()} B</span>
                        <i data-feather="file" class="white icon"></i>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </div>
</div>
</body>
<script src="https://unpkg.com/feather-icons"></script>
<script>
    feather.replace()
</script>
</html>