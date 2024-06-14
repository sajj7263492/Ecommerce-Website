package model;

public class User {
	private String fullName;
	private String email;
	private String phoneNum;
	private String address;
	private String photoPath;
	private String password;
	private String gender;
	
	public User(String fullName, String email, String phoneNum, String address, String photoPath, String password,
			String gender) {
		this.fullName = fullName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
		this.photoPath = photoPath;
		this.password = password;
		this.gender = gender;
	}
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
