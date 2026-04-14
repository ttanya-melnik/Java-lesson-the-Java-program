package guru.qa.ui;

import guru.qa.service.Session;

public interface UIComponent {

  Session render(Session session);

  class MockUiComponent implements UIComponent {

    @Override
    public Session render(Session session) {
      System.out.println("Mock Ui component!");
      return session;
    }
  }

}
