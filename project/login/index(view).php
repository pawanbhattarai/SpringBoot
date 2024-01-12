<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ebook Store ||Ankit Pawan</title>
    <link rel="stylesheet" href="../css/style.css" />
</head>

<body>
    <div class="login">
        <div class="container">
            <div class="login__wrapper">
                <h2 class="form-title">Login Page</h2>
                <form method="POST" class="login-form" action="login.php">
                    <input type="text" name="username" placeholder="Username" required><br>
                    <input type="password" name="password" placeholder="Password" required><br>
                    <button>login</button>

                    <div class="BS-form-input">
                        <div class="loginBuyer__wrap">
                            <label for="buyer">Buyer</label>
                            <input type="radio" name="role[]" id="buyer" value="buyer">
                        </div>
                        <div class="loginSeller__wrap">
                            <label for="seller">Seller</label>
                            <input type="radio" name="role[]" id="seller" value="seller">
                        </div>
                    </div>
                </form>
                <p class="message">Not registered yet? <a href="../register/register(view).php" class="register-link">
                        Click here</a></p>
            </div>
        </div>
    </div>

</body>

</html>