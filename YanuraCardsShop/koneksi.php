<?php
$server="localhost";
$username="id13901215_root";
$password="M5bIw+cqaN#No1*\";
$dbname="id13901215_dbjsonxavier";

//koneksi
$conn = new mysqli ($server, $username, $password,$dbname);

//check koneksi
if ($conn->connect_error){
    die("Connection Failed".$conn->connect_error);
}
$sql= "SELECT * FROM menu";
$result = $conn->query($sql);
$data=array();

if($result->num_rows>0){
    while ($row=$result->fetch_assoc()){
        $data[]=$row;
    }
}
else{
    echo"data kosong";
}
echo json_encode($data);
$conn->close();
?>