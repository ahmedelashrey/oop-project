public class User {
  private String username;
  private String password; // In a real system, this would be hashed and not stored in plain text

  public User(String username, String password) {
      this.username = username;
      this.password = password;
  }

  public boolean authenticate(String username, String password) {
      return this.username.equals(username) && this.password.equals(password);
  }

  public String getUsername() {
      return username;
  }
}
