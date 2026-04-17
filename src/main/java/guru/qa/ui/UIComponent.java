package guru.qa.ui;

import guru.qa.service.Session;


/* Пакет guru.qa.ui — пользовательский интерфейс
UIComponent.java (интерфейс)

 Это контракт. Все экраны должны реализовывать этот интерфейс.
Метод render() получает текущую сессию и возвращает новую (или ту же).
 */


public interface UIComponent {

  Session render(Session session);

  class MockUIComponent implements UIComponent {
    @Override
    public Session render(Session session) {
      System.out.println("MockUIComponent!");
      return session;
    }
  }

}
