
<?php
#created by pawan Bhattarai
require_once 'user(model).php';
require_once 'user(controler).php';
require_once '../dbconfig.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $role = $_POST['role'];

    $isBuyer = 0;
    $isSeller = 0;

    if (in_array('buyer', $role)) {
        $isBuyer = 1;
    }

    if (in_array('seller', $role)) {
        $isSeller = 1;
    }

    if ($isBuyer === 0 && $isSeller === 0) {
        $message = "Please select your role (Buyer/Seller)";
    } else {

    $userController = new UserController($conn);
    $loggedIn = $userController->login($username, $password,$isBuyer,$isSeller);

    if ($loggedIn) {
        echo "Login successful";
        header("Location:../dashbord/dashbord.html");
        // Redirect to the eBook's dashboard!
    } else {
        echo "Invalid username or password";
        // Display an error message
    }
    }
}
#updated by pawan Bhattarai