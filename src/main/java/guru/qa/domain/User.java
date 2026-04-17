package guru.qa.domain;


/* Пакет guru.qa.domain — сущности
   Простой класс с именем и паролем.
 */


public class User {

  private final String username;
  private final String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String username() {
    return username;
  }

  public boolean isPasswordEquals(String password) {
    return this.password.equals(password);
  }
}
