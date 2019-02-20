<?php
	define('DB_HOST','localhost');
	define('DB_PASS','123456');
	define('DB_USER','id8359153_root');
	define('DB_NAME','id8359153_users');
	//local host
	//define('DB_USER','root');
	//define('DB_NAME','users');

	$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
	if(mysqli_connect_error()){
		echo "Failed connect to Mysql".mysql_connect_error();
		die();
	}

	$name = $_POST['name'];
	$email = $_POST['email'];
	$password = $_POST['password'];

	$password = password_hash($password, PASSWORD_DEFAULT);

	$sql = "INSERT INTO users_table(name, email, password) VALUES('".$name."','".$email."','".$password."');";
	$stmt = $conn->prepare($sql);
	$stmt->execute();
	/*
	if(mysqli_query($conn, $sql)){
		$result["success"] = "1";
		$result["message"] = "success";

		echo json_encode($result);
		mysqli_close($conn);

	} else{
		$result["success"] = "0";
		$result["message"] = "failed";

		echo json_encode($result);
		mysqli_close($conn);

	}
	*/


?>
