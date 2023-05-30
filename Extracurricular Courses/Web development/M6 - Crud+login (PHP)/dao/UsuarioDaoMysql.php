<?php 
require_once 'models/Usuario.php';

class UsuarioDaoMysql implements UsuarioDAO{
    private $pdo;

    public function __construct(PDO $engine){
        $this->pdo = $engine;
    }

    public function create(Usuario $u){
        $sql = $this->pdo->prepare("INSERT INTO usuarios (nome, endereco, cep, telresidencial, telcelular, email, sexo, observacoes, senha) VALUES (:nome, :endereco, :cep, :telresidencial, :telcelular, :email, :sexo, :observacoes, :senha)");
        $sql->bindValue(':nome', $u->getNome()); 
        $sql->bindValue(':endereco', $u->getEndereco()); 
        $sql->bindValue(':cep', $u->getCep()); 
        $sql->bindValue(':telresidencial', $u->getTelResidencial()); 
        $sql->bindValue(':telcelular', $u->getTelCelular()); 
        $sql->bindValue(':email', $u->getEmail()); 
        $sql->bindValue(':sexo', $u->getSexo());  
        $sql->bindValue(':observacoes', $u->getObservacoes());  
        $sql->bindValue(':senha', $u->getSenha());  
        $sql->execute();

        $u->setId( $this->pdo->lastInsertId() );
        return $u;
    }

    public function readAll(){
        $array = [];

        $sql = $this->pdo->query("SELECT * FROM usuarios");
        if($sql->rowCount() > 0){
            $data = $sql->fetchAll();

            foreach($data as $item){
                $u = new Usuario();
                $u->setId($item['id']);
                $u->setNome($item['nome']);
                $u->setEndereco($item['endereco']);
                $u->setCep($item['cep']);
                $u->setTelResidencial($item['telresidencial']);
                $u->setTelCelular($item['telcelular']);
                $u->setEmail($item['email']);
                $u->setSexo($item['sexo']);
                $u->setObservacoes($item['observacoes']);
                $u->setSenha($item['senha']);
                $u->setStatus($item['status']);

                $array[] = $u;
            }
        }

        return $array;
    }

    public function readByEmail($email){
        $sql= $this->pdo->prepare("SELECT * FROM usuarios WHERE email = :email");
        $sql->bindValue(':email', $email);
        $sql->execute();

        if($sql->rowCount() > 0){
            $data = $sql->fetch();

            $u = new Usuario();
            $u->setId($data['id']);
            $u->setNome($data['nome']);
            $u->setEndereco($data['endereco']);
            $u->setCep($data['cep']);
            $u->setTelResidencial($data['telresidencial']);
            $u->setTelCelular($data['telcelular']);
            $u->setEmail($data['email']);
            $u->setSexo($data['sexo']);
            $u->setObservacoes($data['observacoes']);
            $u->setSenha($data['senha']);
            
            return $u;
        }else {
            return false;
        }
    }

    public function login($email, $senha){
        $sql= $this->pdo->prepare("SELECT * FROM usuarios WHERE email = :email AND senha = :senha");
        $sql->bindValue(':email', $email);
        $sql->bindValue(':senha', $senha);
        $sql->execute();

        if($sql->rowCount() > 0){
            $sql = $sql->fetch();
            
            $_SESSION['id'] = $sql['id'];
            $_SESSION['nome'] = $sql['nome'];
            $_SESSION['status'] = $sql['status'];

            return true;
        }else{
            return false;
        }

    }


    public function readByid($id){
        $sql= $this->pdo->prepare("SELECT * FROM usuarios WHERE id = :id");
        $sql->bindValue(':id', $id);
        $sql->execute();

        if($sql->rowCount() > 0){
            $data = $sql->fetch();

            $u = new Usuario();
            $u->setId($data['id']);
            $u->setNome($data['nome']);
            $u->setEndereco($data['endereco']);
            $u->setCep($data['cep']);
            $u->setTelResidencial($data['telresidencial']);
            $u->setTelCelular($data['telcelular']);
            $u->setEmail($data['email']);
            $u->setSexo($data['sexo']);
            $u->setObservacoes($data['observacoes']);
            $u->setSenha($data['senha']);

            $u->setStatus($data['status']);
            
            return $u;
        }else {
            return false;
        }
    }
    public function update(Usuario $u){
        $sql = $this->pdo->prepare("UPDATE usuarios SET  nome = :nome, endereco = :endereco, cep = :cep, telresidencial = :telresidencial, telcelular = :telcelular, email = :email, sexo = :sexo, observacoes = :observacoes, senha = :senha WHERE id = :id ");
        $sql->bindValue(':nome', $u->getNome()); 
        $sql->bindValue(':endereco', $u->getEndereco()); 
        $sql->bindValue(':cep', $u->getCep()); 
        $sql->bindValue(':telresidencial', $u->getTelResidencial()); 
        $sql->bindValue(':telcelular', $u->getTelCelular()); 
        $sql->bindValue(':email', $u->getEmail()); 
        $sql->bindValue(':sexo', $u->getSexo());  
        $sql->bindValue(':observacoes', $u->getObservacoes());  
        $sql->bindValue(':senha', $u->getSenha());  
        $sql->bindValue(':id', $u->getId());  

        $sql->execute();

        return true;
    }

    public function delete($id){
        $sql = $this->pdo->prepare("DELETE FROM usuarios WHERE id = :id");
        $sql->bindValue(':id', $id);

        $sql->execute();

    }



}

