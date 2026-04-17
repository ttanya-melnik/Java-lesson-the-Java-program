package guru.qa.ui;

import guru.qa.service.Session;


/* Пакет guru.qa.ui — пользовательский интерфейс

  "for..." Принимает несколько компонентов и по очереди их вызывает.
   Сначала Login, потом MainUIComponent.
    */


public final class UIContainer implements UIComponent {
  private final UIComponent[] components;

  public UIContainer(UIComponent... components) {
    this.components = components;
  }

  @Override
  public Session render(Session session) {
    Session currentSession = session;
    for (UIComponent component : components) {
      currentSession = component.render(currentSession);
    }
    return currentSession;
  }
}
