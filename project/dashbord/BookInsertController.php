<?php

class BookInsertController
{
    private $conn;

    public function __construct($conn)
    {
        $this->conn = $conn;
    }

    public function insertBook($bookData)
    {
        $title = mysqli_real_escape_string($this->conn, $bookData['title']);
        $author = mysqli_real_escape_string($this->conn, $bookData['author']);
        $price = mysqli_real_escape_string($this->conn, $bookData['price']);
        $category = mysqli_real_escape_string($this->conn, $bookData['category']);

        // Validate the input data
        if (empty($title) || empty($author) || empty($price) || empty($category)) {
            throw new Exception("Please fill in all the fields");
        }

        // Insert the book into the database
        $query = "INSERT INTO book (b_name, b_author, b_price, b_category) VALUES ('$title', '$author', '$price', '$category')";
        $result = mysqli_query($this->conn, $query);

        if (!$result) {
            throw new Exception("Failed to insert book into the database");
        }

        return true;
    }
}
