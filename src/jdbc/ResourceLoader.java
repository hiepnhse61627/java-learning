package jdbc;

import java.util.ResourceBundle;

public class ResourceLoader {

  private String url;
  private String username;
  private String password;

  public ResourceLoader() {
    var resourceBundle = ResourceBundle.getBundle("resources.mysql_bank_db");

    this.url = resourceBundle.getString("url");
    this.username = resourceBundle.getString("username");
    this.password = resourceBundle.getString("password");
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "ResourceLoader{" +
        "url='" + url + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
