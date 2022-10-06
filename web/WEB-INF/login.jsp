<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&family=Itim&display=swap"
    rel="stylesheet">

  <link rel="stylesheet" href="./styles/global.css">
  <link rel="stylesheet" href="./styles/login.css">

  <title>Login</title>
</head>

<body>
    <form action="post" action="LoginController" class="container">
    <div class="loginForm">
      <img src="./assets/Logo.png" alt="">

      <input type="text" name="email" class="loginInput" placeholder="Email">
      <input type="text" name="password" class="loginInput" placeholder="Senha">

      <button type="submit" class="loginButton">
        Entrar
      </button>

      <a href="#">Realizar Cadastro</a>
    </div>
  </form>
</body>

</html>