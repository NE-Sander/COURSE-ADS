<?php 
require './config.php';
require 'dao/UsuarioDaoMysql.php';

$usuarioDao = new UsuarioDaoMysql($pdo); 
$email = filter_input(INPUT_POST, 'email');
$senha = filter_input(INPUT_POST, 'senha'); 

if($email && $senha){
    $usuarioDao->login($email, $senha);

    header("Location: detalhes.php?id=".$_SESSION['id']);
}
