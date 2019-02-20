<?php
	define('DB_HOST','localhost');
	define('DB_USER','root');
	define('DB_PASS','123456');
	define('DB_NAME','users');

	
		
	$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
	if(mysqli_connect_error()){
		echo "Failed connect to Mysql".mysql_connect_error();
		die();
	}

	$sql = "SELECT * FROM users_table;";
	$stmt = $conn->prepare($sql);						
	$stmt->execute();
	
	$stmt->bind_result($id,$nama,$email,$password);
	$product = array();
	while($stmt -> fetch()){
		$temp = array();
		$temp['id'] = $id;
		$temp['nama'] = $nama;
		$temp['email'] = $email;
		$temp['password'] = $password;
		array_push($product,$temp);
	}
	echo json_encode($product);
