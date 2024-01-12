<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ebook Store ||Ankit Pawan</title>
    <link rel="stylesheet" href="../css/style.css" />
</head>

<body>
    <div class="register">
        <div class="register__wrapper">
            <h2 class="form-title">Register Page</h2>
            <form method="POST" action="http://localhost:8083/user/add" class="register-form">
                <div class="form-input">
                    <input type="email" name="email" placeholder="Email" required>
                </div>
                <div class="form-input">
                    <input type="text" name="username" placeholder="Username" required>
                </div>
                <div class="form-input">
                    <input type="password" name="password" placeholder="Password" required>
                </div>
                <div class="form-input">
                    <input type="password" name="confirm_password" placeholder="Confirm Password" required>
                </div>
                <div class="form-submit">
                    <input type="submit" value="Register">
                </div>
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
            <p class="message">Already registered? <a href="../login/index(view).php" class="login-link"> Click here</a>
            </p>
        </div>
    </div>
</body>

</html>