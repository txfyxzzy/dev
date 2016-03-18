<?php
/*
//302临时重定向
$url = "http://localhost/PHPMySQLv4/Chapter 28/login.php";
header("Location:$url");
exit;
*/

//301永久重定向

$http_protocol = $_SERVER['SERVER_PROTOCOL'];   //http协议版本

//如果是其他协议，则默认为HTTP/1.0
if ( 'HTTP/1.1' != $http_protocol && 'HTTP/1.0' != $http_protocol )
    $http_protocol = 'HTTP/1.0';

//响应301状态码
header("$http_protocol 301 Moved Permanently !!");

//指定重定向的URL
$new_url = 'http://localhost/PHPMySQLv4/Chapter 28/member.php';
header("Location:$new_url"); 
?>