<html>
<body>

<?php
$pref = "hello world~";
$name = $_REQUEST["name"];
echo $pref . "<br>" . $name . "<br>";


foreach ($_GET as $key => $value) {
	echo $key . ":" . $value . "<br>";
}
?>

<br>
<form action="welcome.php" method="post">
Name: <input type="text" name="name" />
Age: <input type="text" name="age" />
<input type="submit" />
</form>

</body>
</html>
