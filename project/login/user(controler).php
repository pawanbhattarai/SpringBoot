
<?php
#created by pawan Bhattarai
class UserController
{
    private $conn;

    public function __construct($conn)
    {
        $this->conn = $conn;
    }

    public function login($username, $password, $isBuyer,$isSeller)
    {
        // Sanitize the inputs
        $username = mysqli_real_escape_string($this->conn, $username);
        $password = mysqli_real_escape_string($this->conn, $password);

        // here we are trying to select the data according to the given input username or email
        $query ="SELECT * FROM project WHERE (username = '$username' OR email='$username') AND (is_buyer = '$isBuyer' AND is_seller = '$isSeller')";
        $result = mysqli_query($this->conn, $query);
        $user = mysqli_fetch_assoc($result);

        if ($user && password_verify($password, $user['password'])) {
            return true;
        } else {
            // Invalid username or password
            return false;
        }
    }
}

#updated by pawan Bhattarai