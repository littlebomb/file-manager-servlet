<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://unpkg.com/tachyons@4.12.0/css/tachyons.min.css"/>
    <style type="text/css">
        html{
            font-family: "Ubuntu", serif;
            font-size: 12px;
        }
        li {
            list-style-type: none;
        }
        a{
            text-decoration: none;
        }
        .back-whitesmoke{
            background: whitesmoke;
        }
        .text-center{
            text-align: center;
        }
        .password{
            border-right: none;
            border-radius: 6px 0 0 6px;
        }
        .eye{
            background: #c4c4c4;
            border-top: 2px solid gray;
            border-right: 2px solid gray;
            border-bottom: 2px solid gray;
        }
        .right-btn{
            border-radius: 0 6px 6px 0;
        }
        .plus{
            height: 1em;
            width: 1em;
        }
        .back-link{
            color:blue;
            font-size: 12px;
            text-decoration: none;
        }
        form input, form button{
            border-radius: 6px;
        }
        form button{
            background: #888888;
        }
        form input{
            border: 2px solid grey;
            outline: none;
        }
    </style>
</head>
<body class="h-100">
<div class="h-100 w-100 flex flex-column items-center back-whitesmoke justify-center">
    <div class="pa4 justify-between flex flex-column">
        <h1 class="ma0 text-center">Войти в аккаунт</h1>
        <div class="relative">
            <form class="flex-column pb3" method="post">
                <p><input name="login" class="w-100 pa2" required type="text" placeholder="Логин"></p>
                <p><input name="password" class="w-100 pa2" required type="password" placeholder="Пароль" minlength="3"></p>

                <p>
                    <button class="w-100 pa2 white justify-center items-center flex relative pointer" type="submit">
                        Войти
                        <i data-feather="log-in" class="plus log-in ml2"></i>
                    </button>
                </p>
            </form>
            <div class="inline-flex justify-between w-100">
                <div class="flex-column">
                    <a class="back-link flex pointer" href="./register">
                        <span>Cоздать аккаунт</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://unpkg.com/feather-icons"></script>
<script>
    feather.replace()
</script>
</html>