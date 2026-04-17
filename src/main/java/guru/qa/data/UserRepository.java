package guru.qa.data;

import guru.qa.domain.User;
import java.util.Optional;


/* Пакет guru.qa.data — работа с данными
 Repository = хранилище данных.

MockUserRepository — для тестов (жёстко прописан пользователь Tanya).
FileUserRepository — читает пользователей из файла users.csv.

Используется библиотека OpenCSV для чтения CSV.
                                                */




public interface UserRepository {

  Optional<User> findByUsername(String username);

  class MockUserRepository implements UserRepository {
    @Override
    public Optional<User> findByUsername(String username) {
      if ("Tanya".equals(username)) {
        return Optional.of(
            new User(
                "Tanya",
                "12345"
            )
        );
      } else {
        return Optional.empty();
      }
    }
  }
}




