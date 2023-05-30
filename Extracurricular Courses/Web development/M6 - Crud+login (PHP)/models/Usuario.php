<?php
class Usuario {
    private $id;
    private $nome;
    private $endereco;
    private $cep;
    private $telresidencial;
    private $telcelular;
    private $email;
    private $sexo;
    private $observacoes;
    private $status;
    private $senha; 


    //ID | get, set
    public function getId(){
        return $this->id;
    }
    public function setId($i){
        $this->id = trim($i);
    }

    //Nome | get, set
    public function getNome(){
        return $this->nome;
    }
    public function setNome($n){
        $this->nome = ucwords(trim($n));
    }

    //endereco | get, set
    public function getEndereco(){
        return $this->endereco;
    }
    public function setEndereco($e){
        $this->endereco = $e;
    }

    //cep | get, set
    public function getCep(){
        return $this->cep;
    }
    public function setCep($cep){
        $this->cep = $cep;
    }

    //telresidencial get, set
    public function getTelResidencial(){
        return $this->telresidencial;
    }
    public function setTelResidencial($telresidencial){
        $this->telresidencial = $telresidencial;
    }

    //telcelular get, set
    public function getTelCelular(){
        return $this->telcelular;
    }
    public function  setTelCelular($telcelular){
        $this->telcelular = $telcelular;
    }

    //email get, set
    public function getEmail(){
        return $this->email;
    }
    public function setEmail($e){
        $this->email = strtolower(trim($e));
    }

    //sexo get, set
    public function getSexo(){
        return $this->sexo;
    }
    public function  setSexo($sexo){
        $this->sexo = $sexo;
    }

    //observacoes get,set
    public function getObservacoes(){
        return $this->observacoes;
    }
    public function  setObservacoes($observacoes){
        $this->observacoes = $observacoes;
    }

    //status
    public function getStatus(){
        return $this->status;
    }
    public function  setStatus($status){
        $this->status = $status;
    }

    //senha get, set
    public function getSenha(){
        return $this->senha;
    }
    public function  setSenha($senha){
        $this->senha = $senha;
    }

}


interface UsuarioDAO {
    public function create(Usuario $u);
    public function readAll();
    public function readByEmail($email);
    public function login($email, $senha);
    public function update(Usuario $u);
    public function delete($id);
    
}