<?php

class SearchController
{
    private $conn;

    public function __construct($conn)
    {
        $this->conn = $conn;
    }

    public function search($keyword)
    {
        // Perform search logic here
        // You can use the $keyword parameter to search for relevant results

        // Example: Display search results
        $results = $this->performSearch($keyword);
        $this->displayResults($results);
    }

    private function performSearch($keyword)
    {
        //here we perform the actual search query using the provided $keyword
        $escapedKeyword = mysqli_real_escape_string($this->conn, $keyword);

        $query = "SELECT * FROM book WHERE b_name LIKE '%$escapedKeyword%' OR b_author LIKE '%$escapedKeyword%' OR b_category LIKE '%$escapedKeyword%'";
        $result = mysqli_query($this->conn, $query);

        $results = array();

        if ($result) {
            while ($row = mysqli_fetch_assoc($result)) {
                $results[] = $row;
            }
        }

        return $results;
    }

    private function displayResults($results)
    {
        // Display the search results on the view

        echo '<ul>';
        foreach ($results as $result) {
            echo '<li>';
            echo 'Title: ' . $result['b_name'] . '<br>';
            echo 'Author: ' . $result['b_author'] . '<br>';
            echo 'Price: $' . $result['b_price'] . '<br>';
            echo 'Category: ' . $result['b_category'] . '<br>';
            echo '</li>';
        }
        echo '</ul>';
    }
}
