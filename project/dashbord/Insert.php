<!DOCTYPE html>
<html>
<head>
    <title>Book Insert</title>
</head>
<body>
    <h1>Book Insert</h1>
    <form method="POST" action="http://localhost:8083/book/save" enctype="multipart/form-data">
        <div>
            <label for="b_name">Title:</label>
            <input type="text" id="b_name" name="b_name" required>
        </div>
        <div>
            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required>
        </div>
        <div>
            <label for="whoUser">User:</label>
            <input type="text" id="whoUser" name="whoUser" required>
        </div>
        <div>
        <label for="categoryIds">Category:</label>
            <select id="categoryIds" name="categoryIds" required multiple>
            </select>
        </div>
        <div>
            <label for="coverFile">Cover Image:</label>
            <input type="file" id="coverFile" name="coverFile" accept="image/*">
        </div>
        <div>
            <label for="bookFile">Book PDF:</label>
            <input type="file" id="bookFile" name="bookFile" accept=".pdf" required>
        </div>
        <button type="submit">Insert Book</button>
    </form>
</body>
</html>
