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

