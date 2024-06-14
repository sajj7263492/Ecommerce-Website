package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AESEncryption;

public class UserDAO {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/e-commerce";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public String registerUser(User user) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO user VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getFullName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPhoneNum());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getPhotoPath());
			pst.setString(6, user.getGender());
			pst.setString(7, user.getPassword());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Registration Successful!";
			} else {
				return "Registration Failed !";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public boolean validateLogin(String id, String pass) {
		boolean status = false;
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM user where email=? and password=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, id);

			String encryptedPassword = AESEncryption.encrypt(pass);
			pst.setString(2, encryptedPassword);

			ResultSet rs = pst.executeQuery();
			status = rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public User fetchUserDetails(String userId) {
		Connection connection = null;
		User user = null;
		try {
			connection = getConnection();
			String query = "SELECT * FROM user WHERE email=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, userId);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String fullName = table.getString(1);
				String email = table.getString(2);
				String phone = table.getString(3);
				String address = table.getString(4);
				String photopath = table.getString(5);
				String gender = table.getString(6);
				String password = table.getString(7);
				String decPassword = AESEncryption.decrypt(password);

				user = new User(fullName, email, phone, address, photopath, decPassword, gender);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

	}

	public boolean validateAdminLogin(String id, String pass) {
		boolean status = false;
		try {
			Connection connection = getConnection();
			String query = "SELECT * FROM admin where id=? and password=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, id);

			String encryptedPassword = AESEncryption.encrypt(pass);
			pst.setString(2, encryptedPassword);

			ResultSet rs = pst.executeQuery();
			status = rs.next();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public String addProduct(Product product) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO product VALUES(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setString(3, product.getProductPrice());
			pst.setString(4, product.getProductBrand());
			pst.setString(5, product.getProductImage());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Product added successfully!";
			} else {
				return "Failed to add product!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public ArrayList<Product> fetchProducts() {
		Connection connection = null;
		ArrayList<Product> productList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT * FROM product";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String productId = table.getString(1);
				String productName = table.getString(2);
				String productPrice = table.getString(3);
				String productBrand = table.getString(4);
				String productImagePath = table.getString(5);

				Product product = new Product(productId, productName, productPrice, productBrand, productImagePath);
				productList.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	public String addToCart(Cart cart) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO cart VALUES(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, cart.getUserId());
			pst.setString(2, cart.getProductId());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Added to cart successfully!";
			} else {
				return "Not added to cart!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
				return "Already in the cart!";
			} else {
				System.out.println(e.getMessage());
				return e.getMessage();
			}
		}
	}

	public ArrayList<Product> fetchCartDetails(String userId) {
		Connection connection = null;
		ArrayList<Product> cartList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT p.product_image,p.product_name, p.product_brand, p.product_price,c.product_id FROM cart c INNER JOIN product p on c.product_id=p.product_id WHERE user_id=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, userId);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String productImage = table.getString(1);
				String productName = table.getString(2);
				String productBrand = table.getString(3);
				String productPrice = table.getString(4);
				String productId = table.getString(5);

				Product product = new Product(productId, productName, productPrice, productBrand, productImage);
				cartList.add(product);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cartList;
	}

	public String deleteCartItem(String productId) {
		try {
			Connection con = getConnection();
			String query = "DELETE FROM cart WHERE product_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, productId);
			int rows = pst.executeUpdate();
			con.close();
			if (rows != 0) {
				return "Successfully Deleted";
			} else {
				return "Something is wrong";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public String makeOrder(Orders order) {
		try {
			Connection con = getConnection();
			String query = "INSERT INTO ordered VALUES(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, order.getOrderId());
			pst.setString(2, order.getProductId());
			pst.setString(3, order.getUserId());
			pst.setString(4, order.getOrderDate());
			pst.setString(5, order.getOrderTime());
			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Order successful!";
			} else {
				return "Order failed!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}
	
	public Product fetchProductById(String product_Id) {
			Product product=null;
			Connection connection=null;
			try {
				connection=getConnection();
				String query="SELECT * FROM product where product_id=?";
				PreparedStatement pst=connection.prepareStatement(query);
				pst.setString(1,product_Id);
				ResultSet table=pst.executeQuery();
				while(table.next()) {
					String productId=table.getString(1);
					String productName=table.getString(2);
					String productPrice=table.getString(3);
					String productBrand=table.getString(4);
					String imagePath=table.getString(5);
					
					product=new Product(productId, productName, productPrice, productBrand, imagePath);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return product;	
		}
	public String updateProduct(Product product) {
		try {
			Connection con = getConnection();
			String query = "Update product set product_name=?, product_price=?, product_brand=?,product_image=? where product_id=?";
			PreparedStatement pst = con.prepareStatement(query);	
			pst.setString(1, product.getProductName());
			pst.setString(2, product.getProductPrice());
			pst.setString(3, product.getProductBrand());
			pst.setString(4, product.getProductImage());
			pst.setString(5, product.getProductId());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Product updated successfully!";
			} else {
				return "Failed to update product!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}
	
	public ArrayList<OrderDetails> fetchOrderDetails() {
		Connection connection = null;
		ArrayList<OrderDetails> orderList = new ArrayList<>();
		try {
			connection = getConnection();
			String query = "SELECT o.order_id,u.photo ,u.fullname,p.product_name,p.product_image, p.product_brand, p.product_price,o.order_date,o.order_time FROM ordered o JOIN product p ON o.product_id=p.product_id JOIN user u ON o.user_id=u.email";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet table = pst.executeQuery();
			while (table.next()) {
				String orderId=table.getString(1);
				String userPhoto=table.getString(2);
				String fullName=table.getString(3);
				String productName=table.getString(4);
				String productImage=table.getString(5);
				String productBrand=table.getString(6);
				String productPrice=table.getString(7);
				String orderDate=table.getString(8);
				String orderTime=table.getString(9);

				OrderDetails details=new OrderDetails(orderId, userPhoto, fullName, productImage, productName, productBrand, productPrice, orderDate, orderTime);
				orderList.add(details);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}
	
	public String deleteProduct(String productId) {
		try {
			Connection con = getConnection();
			String query = "DELETE FROM product WHERE product_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, productId);
			int rows = pst.executeUpdate();
			con.close();
			if (rows != 0) {
				return "Successfully Deleted!";
			} else {
				return "Something is wrong";
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}
	
	public String updateUser(User user) {
		try {
			Connection con = getConnection();
			String query = "Update user set fullname=?, phone=?,address=?,photo=?,gender=?,password=? where email=?";
			PreparedStatement pst = con.prepareStatement(query);	
			pst.setString(1, user.getFullName());
			pst.setString(2, user.getPhoneNum());
			pst.setString(3, user.getAddress());
			pst.setString(4, user.getPhotoPath());
			pst.setString(5, user.getGender());
			pst.setString(6,user.getPassword());
			pst.setString(7, user.getEmail());

			int rows = pst.executeUpdate();
			con.close();

			if (rows != 0) {
				return "Profile updated successfully!";
			} else {
				return "Failed to update profile!";
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}
	
	
	

}
