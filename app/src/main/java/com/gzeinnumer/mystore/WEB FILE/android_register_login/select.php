<?php
	define('DB_HOST','localhost');
	define('DB_USER','id8359153_root');
	define('DB_PASS','123456');
	define('DB_NAME','id8359153_users');
	//define('DB_USER','root');
	//define('DB_NAME','users');

	$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
	if(mysqli_connect_error()){
		echo "Failed connect to Mysql".mysql_connect_error();
		die();
	}

	$sql = "SELECT * FROM users_table;";
	$stmt = $conn->prepare($sql);
	$stmt->execute();

	$stmt->bind_result($id,$name,$email,$password);

	/*$user = array();
	while($stmt -> fetch()){
		$temp[] = array();
		$temp['id'] = $id;
		$temp['nama'] = $name;
		$temp['email'] = $email;
		$temp['password'] = $password;
		array_push($user,$temp);


	}
	echo json_encode($user);

	*/
	$user['users'] = array();
	while($stmt -> fetch()){
		
		$user['users'][] = array(
		"id" => $id,
		"name" => $name,
		"email" => $email,
		"password" => $password);
		
		
	}
	echo json_encode($user);
