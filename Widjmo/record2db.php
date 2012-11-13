<?php
    $dbhost = "localhost"; // Хост
	$dbuser = "root"; // Имя пользователя
	$dbpassword = "511215"; // Пароль
	$dbname = "site"; // Имя базы данных
	$link = mysql_connect($dbhost, $dbuser, $dbpassword);
	if ($link == 0)
	{
		exit();
	}
	mysql_select_db($dbname, $link);
	$query = "insert into _employer (`name`, `biography`, `birth_date`) values ('";
	$query = $query . $_POST["worker_name"];
	$query = $query  . "', '";
	$query = $query  . $_POST["about_employer"];
	$query = $query  . "', '";
	$query = $query  . $_POST["popdate"];
	$query = $query  . "')";
	$result = mysql_query($query, $link);
	
	
	
	// Закрываем соединение
	mysql_close($link);
?>