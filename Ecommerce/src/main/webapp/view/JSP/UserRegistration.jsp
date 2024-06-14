<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Registration form</title>
<link rel="stylesheet" href="../CSS/UserRegistration.css" />
</head>
<body>
	<div class="body">
		<div class="container">
			<h1 class="form-title">Registration</h1>
			<form action="/Ecommerce/register" method="post" enctype="multipart/form-data">
				<div class="main-user-info">
					<div class="user-input-box">
						<label for="fullName">Full Name</label> 
						<input type="text" name="userName" placeholder="Enter your full Name" required/>
					</div>
					<div class="user-input-box">
						<label for="email">Email</label> 
						<input type="text" name="userEmail" placeholder="Enter your full Email" required/>
					</div>
					<div class="user-input-box">
						<label for="email">Phone Number</label> 
						<input type="text" name="userNumber" placeholder="Enter Phone Number" />
					</div>
					<div class="user-input-box">
						<label for="address">Address</label> 
						<input type="text" name="userAddress" placeholder="Enter your Address" required/>
					</div>
					<div class="user-input-box">
						<label style="color: rgb(95, 93, 93);" class="img-upload" for="upload">Upload Photo</label> 
						<input type="file" name="userPhoto" id="upload" required/>
					</div>
					<div class="user-input-box">
						<label for="password">Password</label> 
						<input type="password" name="userPassword" placeholder="Enter Password" required/>
					</div>
				</div>
				<div class="gender-details-box">
					<span class="gender-title">Gender</span>
					<div class="gender-category">
						<input type="radio" name="gender" id="male" value="Male" /> 
						<label for="male">Male</label> 
						<input type="radio" name="gender" id="female" value="Female" /> 
						<label for="female">Female</label>
						<input type="radio" name="gender" id="other" value="Other" /> 
						<label for="others">Other</label>
					</div>
				</div>
				<div class="form-submit-btn">
					<input type="submit" value="Register" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
