 <?php 
    session_start();
    if(isset($_SESSION['id']) && !empty($_SESSION['id'])){
        header("Location: detalhes.php?id=".$_SESSION['id']);
        exit;
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Home</title>
</head>
<body>

<div class="container-fluid">
    <div class="row" style="height: 100vh">

    <div class="col-lg-2 border-end">
            <ul class="list-group mt-4">
                <?php if(!isset($_SESSION['status']) && empty($_SESSION['status'])):?>
                    <li class="list-group-item"><a href="./">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                    <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                    </svg> Login
                    </a>
                    </li>
                <?php endif;?> 
                    
            </ul>
        </div>

        <div class="col-lg-10 p-0 m-0">
            <div class="p-3 text-center border-bottom">
                <h3>Login</h3>
            </div>

            <!-- Formulário  -->
            <div class="container mt-3">
            <form class="form-control" method="post" action="login_action.php">
                <label class="mt-2 mb-2">Email</label>
                <input class="form-control" name="email" type="text" placeholder="email">
                
                <label class="mt-2 mb-2">Senha</label>
                <input class="form-control mb-3" name="senha" type="text" placeholder="senha">

                <button class="btn btn-success" type="submit">Login</button>
            </form>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>