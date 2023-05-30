<?php 
require 'config.php';
require 'dao/UsuarioDaoMysql.php';

$usuarioDao = new UsuarioDaoMysql($pdo);

$nome = filter_input(INPUT_POST, 'nome');
$endereco = filter_input(INPUT_POST, 'endereco');
$cep = filter_input(INPUT_POST, 'cep');
$telresidencial = filter_input(INPUT_POST, 'telresidencial');
$telcelular = filter_input(INPUT_POST, 'telcelular');
$email = filter_input(INPUT_POST, 'email');
$sexo = filter_input(INPUT_POST, 'sexo');
$observacoes = filter_input(INPUT_POST, 'observacoes'); 
$senha = filter_input(INPUT_POST, 'senha'); 



if ($nome && $endereco && $cep && $telresidencial && $telcelular && $email && $sexo && $observacoes && $senha){

    if($usuarioDao->readByEmail($email) === false){
        $novoUsuario = new Usuario();
        $novoUsuario->setNome($nome);
        $novoUsuario->setEndereco($endereco);
        $novoUsuario->setCep($cep);
        $novoUsuario->setTelResidencial($telresidencial);
        $novoUsuario->setTelCelular($telcelular);
        $novoUsuario->setEmail($email);
        $novoUsuario->setSexo($sexo);
        $novoUsuario->setObservacoes($observacoes);
        $novoUsuario->setSenha($senha);

        $usuarioDao->create($novoUsuario);

        header("Location: lista-de-usuarios.php");
        exit;
        
    }else{
        header("Location: adicionar.php");
        exit;
    }


}else{
    header("Location: adicionar.php");
    exit;
}