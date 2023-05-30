<?php
session_start();
require './config.php';
require 'dao/UsuarioDaoMysql.php';

if(!isset($_SESSION['id']) && empty($_SESSION['id'])){
    header("Location: index.php");
}

$usuarioDao = new UsuarioDaoMysql($pdo);

$info = false;
$id = filter_input(INPUT_GET, 'id');
    
if($id) {
    $info = $usuarioDao->readById($id);
}
if($info === false){
    header("Location: index.php");
    exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Detalhes</title>
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

                <li class="list-group-item"><a href="detalhes.php?id=<?=$_SESSION['id'];?>">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                    </svg> Perfil</a>
                </li>

                <li class="list-group-item"><a href="adicionar.php">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                    </svg> Criar nova conta
                    </a>
                </li>

                <li class="list-group-item"><a href="lista-de-usuarios.php">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
                    <path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
                    <path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
                    </svg>  Lista de Usuários</a>
                </li>

                <li class="list-group-item"><a href="exit.php">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
                    <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
                    </svg>  Sair</a>
                </li>
                    
            </ul>
        </div>

        <div class="col-lg-10 p-0 m-0">

            <div class=" p-2 text-center border-bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-1 pt-1 text-start">
                        <a href="lista-de-usuarios.php">
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-table" viewBox="0 0 16 16">
                        <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm15 2h-4v3h4V4zm0 4h-4v3h4V8zm0 4h-4v3h3a1 1 0 0 0 1-1v-2zm-5 3v-3H6v3h4zm-5 0v-3H1v2a1 1 0 0 0 1 1h3zm-4-4h4V8H1v3zm0-4h4V4H1v3zm5-3v3h4V4H6zm4 4H6v3h4V8z"/>
                        </svg>
                        </a>
                        </div>
                        <div class="col-lg-11 text-center">
                            <h3><?=$info->getNome();?></h3>
                        </div>
                    </div>
                </div>
            </div>

            <ul class="list-group list-group-flush">
                <li class="list-group-item"><strong>Endereço:</strong> <?=$info->getEndereco();?></li>
                <li class="list-group-item"><strong>Cep:</strong> <?=$info->getCep();?></li>
                <li class="list-group-item"><strong>Tel Residencial:</strong><?=$info->getTelResidencial();?></li>
                <li class="list-group-item"><strong>Tel Celular:</strong><?=$info->getTelCelular();?></li>
                <li class="list-group-item"><strong>Email:</strong><?=$info->getEmail();?></li>
                <li class="list-group-item"><strong>Sexo:</strong><?=$info->getSexo();?></li>
                <li class="list-group-item"><strong>Observações:</strong><?=$info->getObservacoes();?></li>
                <li class="list-group-item"><strong>Status:</strong>
                    <?php
                        if($info->getStatus() == 0){
                            echo 'Funcionário';
                        }
                        if($info->getStatus() == 1){
                            echo 'Administrador';
                        }
                    ?>
                </li>
 
            </ul>
            <div class="container-fluid mt-5">
                <div class="row">
                    <div class="col-lg-12 text-start">
                        <a href="editar.php?id=<?=$info->getId();?>"><button class="btn btn-warning">Editar</button></a>
                   
                        <?php if($_SESSION['status'] == 1):?>
                           <a href="deletar.php?id=<?=$info->getId();?>"><button class="btn btn-danger" onclick="return confirm('Tem certeza que deseja Excluir?')">Deletar</button></a>
                        <?php endif;?>
                    </div> 
                </div>
            </div>
        </div>
    </div>
</div>
    
</body>
</html>