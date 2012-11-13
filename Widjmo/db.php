<!doctype html>
<html lang="en">

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
	echo "connection enabled<br/>";
	mysql_select_db($dbname, $link);
	
	//$query = "select * from _employer";
	$query = "insert into _employer values ('3', 'Evgeniy')";
	$result = mysql_query($query, $link);
	
	while($rows = mysql_fetch_array($result, MYSQL_ASSOC))
	{
		echo $rows['id_employer'], " ", $rows['name'], "<br/>";
	}
	
	// Закрываем соединение
	mysql_close($link);
?>
	<div class="container">
		<input type="button" value="Hide Dialog"/>
	</div>
</html>
