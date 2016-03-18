<?php
$var_string = "hello world!";
$json_string = $_POST["txt_json"];
$raw_string = $GLOBALS['HTTP_RAW_POST_DATA'];
$input_string = file_get_contents("php://input");

$file=fopen("/home/benz/json.txt","w+") or exit("unable to open file");
fwrite($file, $input_string);
fclose($file);

?>
