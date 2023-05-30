<?php
    require './config.php';
    require 'dao/UsuarioDaoMysql.php';

    $usuarioDao = new UsuarioDaoMysql($pdo);
    $lista = $usuarioDao->readAll();
?>

<?php foreach($lista as $usuarios): ?>
    <tr>
        <th scope="row"><?=$usuarios->getId()?></th>
            <td><?=$usuarios->getNome()?></td> 
            <td><?=$usuarios->getEndereco()?></td> 
            <td><?=$usuarios->getCep()?></td>
            <td><?=$usuarios->getTelResidencial()?></td>
        <td>
            <a href="detalhes.php?id=<?=$usuarios->getId()?>">
                <button class="btn btn-warning">Detalhes</button> 
            </a>
        </td>
    </tr> 
<?php endforeach; ?>