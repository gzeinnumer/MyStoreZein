<?php
	define('DB_HOST','localhost');
	define('DB_USER','id8359153_root2');
	//define('DB_USER','root');
	define('DB_PASS','123456');
	define('DB_NAME','id8359153_product');
	//define('DB_NAME','users');

	$conn = new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);
	if(mysqli_connect_error()){
		echo "Failed connect to Mysql".mysql_connect_error();
		die();
	}

	$sql = "SELECT * FROM product;";
	$stmt = $conn->prepare($sql);
	$stmt->execute();

	$stmt->bind_result($id,$title,$description,$rating,$price,$image);

	$product['products'] = array();
	while($stmt -> fetch()){

		$product['products'][] = array(
		"id" => $id,
		"title" => $title,
		"desciption" => $description,
		"rating" => $rating,
		"price" => $price,
		"image" => $image);


	}
	echo json_encode($product);
