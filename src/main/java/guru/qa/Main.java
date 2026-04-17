package guru.qa;

import guru.qa.data.FileUserRepository;
import guru.qa.data.NoteRepository;
import guru.qa.data.UserRepository;
import guru.qa.service.Base64PasswordEncoder;
import guru.qa.service.Session;
import guru.qa.ui.LoginUIComponent;
import guru.qa.ui.MainUIComponent;
import guru.qa.ui.UIContainer;
import java.nio.file.Path;

/* Что делает программа?

Показывает окно логина.
Если логин и пароль верные — открывает главное окно с заметками.
Пользователь может добавлять новые заметки.
Всё хранится либо в памяти (Mock), либо в CSV-файле.


Архитектура (как устроено):

UI — всё, что видит пользователь (окна).
Domain — бизнес-сущности (User, Note).
Data — работа с данными (репозитории).
Service — вспомогательные сервисы (кодирование пароля, сессия).



Это точка входа в программу (как index.html в веб).
Здесь создаётся контейнер, в который кладутся два экрана:
Экран логина
Главный экран с заметками
И сразу запускается первый экран (render()).
*/


public class Main {
  public static void main(String[] args) {
    new UIContainer(
        new LoginUIComponent(
            new FileUserRepository(
                Path.of("users.csv")
            ),
            new Base64PasswordEncoder()
        ),
        new MainUIComponent(
            new NoteRepository.MockNoteRepository()
        )
    ).render(
        new Session.EmptySession()
    );
  }
  }

