<html>
<body>

<?php
$name = $_POST["name"];
$age = $_REQUEST["age"];
echo $name . "<br>" . $age . "<br>";

foreach ($_POST as $key => $value) {
	echo $key . ":" . $value . "<br>";
}
?>

</body>
</html>

