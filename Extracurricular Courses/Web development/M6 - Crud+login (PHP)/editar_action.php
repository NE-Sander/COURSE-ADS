<?php 
require './config.php';
require 'dao/UsuarioDaoMysql.php';

$usuarioDao = new UsuarioDaoMysql($pdo);

$id = filter_input(INPUT_POST, 'id');
$nome = filter_input(INPUT_POST, 'nome');
$endereco = filter_input(INPUT_POST, 'endereco');
$cep = filter_input(INPUT_POST, 'cep');
$telresidencial = filter_input(INPUT_POST, 'telresidencial');
$telcelular = filter_input(INPUT_POST, 'telcelular');
$email = filter_input(INPUT_POST, 'email');
$sexo = filter_input(INPUT_POST, 'sexo');
$observacoes = filter_input(INPUT_POST, 'observacoes'); 
$senha = filter_input(INPUT_POST, 'senha'); 

if ($id || $nome || $endereco || $cep || $telresidencial || $telcelular || $email || $sexo || $observacoes || $senha){
    $usuario = new Usuario();
    $usuario->setId($id);
    $usuario->setNome($nome);
    $usuario->setEndereco($endereco);
    $usuario->setCep($cep);
    $usuario->setTelResidencial($telresidencial);
    $usuario->setTelCelular($telcelular);
    $usuario->setEmail($email);
    $usuario->setSexo($sexo);
    $usuario->setObservacoes($observacoes);
    $usuario->setSenha($senha);

    $usuarioDao->update( $usuario );
     

    header("Location: detalhes.php?id=".$id);
    exit;

}else {
    header("Location: editar.php?id=".$id);
    exit;
}

