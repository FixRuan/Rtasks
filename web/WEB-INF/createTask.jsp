<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&family=Itim&display=swap"
          rel="stylesheet">
        <script src="https://unpkg.com/phosphor-icons"></script>
        
        <link rel="stylesheet" href="./styles/global.css"/>
        <link rel="stylesheet" href="./styles/home.css"/>
        <link rel="stylesheet" href="./styles/createTask.css" />
        <title>Create Task</title>
    </head>
    <body>
        <header>
          <img src="./assets/Logo.png" alt="alt" />
        </header>
        
        <div class="container">
            <div class="backToHome">
                <a href="HomeController"><i class="ph-caret-left"></i>
                Voltar
                </a>
            </div>
            
            <form>
                <textarea name="task" placeholder="Tarefa" class="taskInput"></textarea>
                <div class="ImageInput">
                    <label for="image">
                        Carregar Imagem
                        <i class="ph-upload-simple"></i>
                    </label>    
                </div>
                <input type="file" name="image" id="image"/>
                
                <button class="addTask" type="submit">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
