
<?php
#created by pawan Bhattarai
class UserController
{
    private $conn;

    public function __construct($conn)
    {
        $this->conn = $conn;
    }

    public function register($email, $username, $password,$is_buyer,$is_seller)
    {
        // Sanitize the inputs
        $email = mysqli_real_escape_string($this->conn, $email);
        $username = mysqli_real_escape_string($this->conn, $username);
        $hashedPassword = password_hash($password, PASSWORD_DEFAULT);

        // Check if username or email already exists in the database
        $query = "SELECT * FROM project WHERE username = '$username' OR email='$email'";
        $resultS = mysqli_query($this->conn, $query);
        $existingUser = mysqli_fetch_assoc($resultS);

      if($existingUser['is_buyer'] == $is_buyer || $existingUser['is_seller'] == $is_seller) {
        throw new Exception("Username or email already exists");
       
        }else{
        // here we insert the input data in our database!
        $query = "INSERT INTO project (email, username, password,is_buyer,is_seller) VALUES ('$email', '$username', '$hashedPassword',$is_buyer,$is_seller)";
        $result = mysqli_query($this->conn, $query);

        if ($result) {
            return true; // Successful registration
        } else {
            return false; // Registration failed
        }
    }
}
}