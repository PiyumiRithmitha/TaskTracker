package app.classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String password;
    private String contact; // Add contact field

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() { // Add getter for contact
        return contact;
    }

    public int getUserId() { // Add getter for id
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setContact(String contact) { // Add setter for contact
        this.contact = contact;
    }

    public boolean register(String firstName, String lastName, String email, String role, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DbConnector.getConnection();
            // Check if email already exists
            String checkEmailQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
            stmt = conn.prepareStatement(checkEmailQuery);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // Email already exists
                return false;
            }

            // Hash the password before storing
            String hashedPassword = MD5.getMd5(password);

            // Insert new user
            String insertQuery = "INSERT INTO users (first_name, last_name, email, user_role, password) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, role);
            stmt.setString(5, hashedPassword);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to log in an existing user
    public User login(String email, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DbConnector.getConnection();
            // Hash the provided password for comparison
            String hashedPassword = MD5.getMd5(password);
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, hashedPassword);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                setUserId(userId);
                setFirstName(rs.getString("first_name"));
                setRole(rs.getString("user_role"));

                return this; // Return the role of the user
            } else {
                return null; // No matching user found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to get a list of users for the admin dashboard
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DbConnector.getConnection();
            String sql = "SELECT first_name, last_name, email, user_role FROM users WHERE user_role != ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "admin"); // Exclude admin role
            rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("user_role"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    public boolean deleteUser(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DbConnector.getConnection();
            String sql = "DELETE FROM users WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if deletion was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of an error
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean updateProfile(String email, String firstName, String lastName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean updated = false;

        try {
            conn = DbConnector.getConnection();
            String sql = "UPDATE users SET first_name = ?, last_name = ? WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);

            updated = pstmt.executeUpdate() > 0; // Check if at least one row was updated
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updated;
    }

    public boolean updatePassword(String email, String newPassword) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean updated = false;

        try {
            conn = DbConnector.getConnection();
            String sql = "UPDATE users SET password_hash = ? WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, MD5.getMd5(newPassword));
            pstmt.setString(2, email);

            updated = pstmt.executeUpdate() > 0; // Check if at least one row was updated
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updated;
    }

    public User getUserDetailsByEmail(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DbConnector.getConnection();
            String sql = "SELECT first_name, last_name, email FROM users WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                // Add additional fields if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public String getPasswordHash(String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String passwordHash = null;

        try {
            conn = DbConnector.getConnection();
            String sql = "SELECT password_hash FROM users WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                passwordHash = rs.getString("password_hash");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return passwordHash;
    }

}
