

<?php
#created by pawan Bhattarai

require_once 'user(model).php';
require_once 'user(controller).php';
// require_once '../login/index(view).php';
require_once '../dbconfig.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $email = $_POST['email'];
    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirmPassword = $_POST['confirm_password'];
    $role = $_POST['role'];

    $isBuyer = 0;
    $isSeller = 0;

    if (in_array('buyer', $role)) {
        $isBuyer = 1;
    }

    if (in_array('seller', $role)) {
        $isSeller = 1;
    }

    if ($password !== $confirmPassword) {
        echo "Password and Confirm Password do not match";
        exit;
    }

if ($isBuyer === 0 && $isSeller === 0) {
    throw new Exception("Please select your role (Buyer/Seller)");
}

$userController = new UserController($conn);

try {
    $registered = $userController->register($email, $username, $password, $isBuyer, $isSeller);

    if ($registered) {
        header("Location:../login/index(view).php");
        exit;
    } else {
        throw new Exception("Registration failed");
    }
} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}
}
//updated by pawan Bhattarai