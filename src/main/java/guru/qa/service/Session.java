package guru.qa.service;

import guru.qa.domain.User;

/* Session.java и UserSession.java
Session — это текущий "залогиненный пользователь".

EmptySession — в начале программы (никто не залогинен).
UserSession — когда пользователь успешно вошёл.

Метод unwrap() — "распакуй и дай мне User".

*/


public interface Session {

  User unwrap();

  class EmptySession implements Session {
    @Override
    public User unwrap() {
      return null;
    }
  }

}
