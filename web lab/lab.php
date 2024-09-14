<?php
echo"Harry styles";
$name="Harry";
echo "Name using Variable declaration<br>";
echo $name;
$num1=15;
$num2=16;
$sum=$num1+$num2;
echo"Sum of two numbers:";
echo $num1."+".$num2."=".$num;
$fruits =array("Apple","Banana","Orange");
echo "Fruits:";
foreach ($fruist as $fru) {
    # code...
    echo $fru."<br>";
}
function example(){
    $var = "Message displayed using function";
    echo $var;
    
}
example();

$link=mysqli_connect("localhost","root","");
//check connection
if ($link==false){
    die("Error:could not connect".mysqli_connect_error());
}
echo "Connected successful";
//close connection
mysqli_close($link);


?>