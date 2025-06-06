<?php
$host = "localhost";
$dbname = "teretana";
$username = "root";
$password = "";

$conn = new mysqli($host, $username, $password, $dbname);

// Provera konekcije
if ($conn->connect_error) {
    die("Konekcija neuspešna: " . $conn->connect_error);
}

// Prikupljanje podataka iz forme
$ime = $_POST['ime'];
$prezime = $_POST['prezime'];
$email = $_POST['email'];
$telefon = $_POST['telefon'];
$napomena = $_POST['napomena'];
$vreme = date("Y-m-d H:i:s"); // trenutni timestamp

// SQL upit
$sql = "INSERT INTO korisnici (ime, prezime, email, telefon, napomena, vreme_prijave)
        VALUES ('$ime', '$prezime', '$email', '$telefon', '$napomena', '$vreme')";

if ($conn->query($sql) === TRUE) {
    echo "Uspešno ste poslali podatke!";
} else {
    echo "Greška: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>