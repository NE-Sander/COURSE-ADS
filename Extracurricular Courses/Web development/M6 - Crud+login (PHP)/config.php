<?php

$db_name = 'cadastro';
$db_host = 'localhost';
$db_user = 'root';
$db_pass = '';
if(!isset($_SESSION)) 
{ 
    session_start(); 
} 

$pdo = new PDO("mysql:dbname=".$db_name.";host=".$db_host, $db_user, $db_pass);
