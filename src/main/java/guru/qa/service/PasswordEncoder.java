package guru.qa.service;



/* Пароли никогда не хранят в открытом виде.
Здесь используется простой Base64 (это не безопасно для реальной программы, только для обучения).

encode("12345") → что-то вроде MTIzNDU=
decode — обратно.                                    */




public interface PasswordEncoder {

  String encode(String password);
  String decode(String password);

  class MockPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String password) {
      return password;
    }

    @Override
    public String decode(String password) {
      return password;
    }
  }

}
