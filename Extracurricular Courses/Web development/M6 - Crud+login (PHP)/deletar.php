<?php

    session_start();
    require './config.php';
    require 'dao/UsuarioDaoMysql.php';

    $usuarioDao = new UsuarioDaoMysql($pdo);

    $id = filter_input(INPUT_GET, 'id');
    
    if($id && $_SESSION['status'] == 1){
        $usuarioDao->delete($id);
    }

    header("Location: lista-de-usuarios.php");
    exit;