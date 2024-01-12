
<?php
#created by pawan Bhattarai
class User
{
    private $email;
    private $username;
    private $password;

    private $is_buyer;

    private $is_seller;

    public function __construct($email, $username, $password,$is_buyer,$is_seller)
    {
        $this->email = $email;
        $this->username = $username;
        $this->password = $password;
        $this->is_buyer=$is_buyer;
        $this->is_seller=$is_seller;
    }

    public function getEmail()
    {
        return $this->email;
    }

    public function getUsername()
    {
        return $this->username;
    }

    public function getPassword()
    {
        return $this->password;
    }
    public function getis_buyer()
    {
        return $this->is_buyer;
    }
    public function getis_seller()
    {
        return $this->is_seller;
    }
}
#updated by pawan Bhattarai