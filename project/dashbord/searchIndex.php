<?php
require_once 'SearchController.php';
require_once '../dbconfig.php';

// Create an instance of the SearchController class
$searchController = new SearchController($conn);

// Check if the search form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $keyword = $_POST['keyword'];

    // Perform the search
    $searchController->search($keyword);
}
?>
