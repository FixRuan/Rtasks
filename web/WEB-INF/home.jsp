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
        <link rel="stylesheet"s href="./styles/home.css">
        <title>Home</title>
    </head>
    <body>
  <header>
    <img src="./assets/Logo.png" alt="alt" />
  </header>

  <div class="container">
    <div class="headerButtons">
      <a href="CreateTask" class="createTaskButton btn">
        Criar
        <i class="ph-plus-circle"></i>
      </a>

        <form method="post" action="HomeController">
            <button type="submit" class="loggoutButton btn">
                Sair
                <i class="ph-sign-out"></i>
            </button>
        </form>
      
    </div>


    <section class="taskSection">
      <div class="info">
        <div class="createdTasks">
          <span>Tarefas criadas</span>
          <div class="createdQuantity">
            <p>4</p>
          </div>
        </div>

        <div class="completedTasks">
          <span>concluídas</span>
          <div class="completedQuantity">
            <p>2 de 4</p>
          </div>
        </div>
      </div>
    </section>
      
    <div class="tasks">
        <!-- 
      <div class="withoutTask">
        <i class="ph-clipboard-text"></i>
        <span>Você ainda não tem tarefas cadastradas</span>
        <p>Crie tarefas e organize seus itens a fazer</p>
      </div>
        -->
        
    <div class="task">
        <div class="imageContainer">
          <img src="./assets/shop.svg" alt="">
        </div>

        <span>
          Integer urna interdum massa libero auctor neque
          turpis turpis semper. Duis vel sed fames integer. Integer
          urna interdum massa libero auctor neque turpis turpis
          semper. Duis vel sed fames integer.Integer urna interdum.
        </span>

        <button class="removeTask">
          <i class="ph-trash"></i>
        </button>
      </div>
    </div>
      
    <div class="task">
        <div class="imageContainer">
          <img src="./assets/shop.svg" alt="">
        </div>

        <span>
          Integer urna interdum massa libero auctor neque
          turpis turpis semper. Duis vel sed fames integer. Integer
          urna interdum massa libero auctor neque turpis turpis
          semper. Duis vel sed fames integer.Integer urna interdum.
        </span>

        <button class="removeTask">
          <i class="ph-trash"></i>
        </button>
      </div>
    </div>
  </div>
</body>
</html>
