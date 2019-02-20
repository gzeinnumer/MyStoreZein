<?php

$conn = mysqli_connect("192.168.1.5","root","123456","users");

if($conn){
	echo "Sukses";
} else {
	echo "Gagal";
}

?>