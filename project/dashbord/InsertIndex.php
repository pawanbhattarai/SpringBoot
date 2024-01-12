<?php
require_once 'BookInsertController.php';
require_once '../dbconfig.php';

// Create an instance of the BookInsertController class
$bookInsertController = new BookInsertController($conn);
// new BookInsertController($conn);

// Check if the book insert form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $bookData = array(
        'title' => $_POST['title'],
        'author' => $_POST['author'],
        'price' => $_POST['price'],
        'category' => $_POST['category']
    );

    try {
        // Insert the book
        $bookInsertController->insertBook($bookData);
        echo "Book inserted successfully";
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
}
?>
