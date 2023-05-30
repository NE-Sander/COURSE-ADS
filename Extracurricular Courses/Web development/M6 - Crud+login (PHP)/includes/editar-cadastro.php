<?php
require './config.php';
require 'dao/UsuarioDaoMysql.php';

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
<form class="form-control mb-5" method="post" action="editar_action.php">
    <input type="hidden" name="id" value="<?=$info->getId();?>">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Nome</label>
                <input class="form-control " type="text" value="<?=$info->getNome();?>" name="nome">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Endereço</label>
                <input class="form-control mb-3" type="text" name="endereco" value="<?=$info->getEndereco();?>">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Cep</label>
                <input class="form-control mb-3" type="text" name="cep" value="<?=$info->getCep();?>">
            </div> 
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Tel Residencial</label>
                <input class="form-control mb-3" type="number" name="telresidencial" value="<?=$info->getTelResidencial();?>">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Tel Celular</label>
                <input class="form-control mb-3" type="text" name="telcelular" value="<?=$info->getTelCelular();?>">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Email</label>
                <input class="form-control mb-3" type="text" name="email" value="<?=$info->getEmail();?>">
            </div> 
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Sexo</label>
                <input class="form-control mb-3" type="text" name="sexo" value="<?=$info->getSexo();?>">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">Observações</label>
                <input class="form-control mb-3" type="text" name="observacoes" value="<?=$info->getObservacoes();?>">
            </div>
            <div class="col-lg-4">
                <label class="mt-2 mb-2">senha</label> 
                <input class="form-control mb-3" type="password" name="senha" value="<?=$info->getSenha();?>">
 
                
            </div> 
        </div>
    </div>


    <button class="ms-4 mb-3 btn btn-success" type="submit">Editar</button>
</form>