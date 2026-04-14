package guru.qa.ui;

import guru.qa.data.NoteRepository;
import guru.qa.domain.Note;
import guru.qa.domain.User;
import guru.qa.service.Session;
import java.util.List;
import javax.swing.JOptionPane;

public class MainUIComponent implements UIComponent{

  private final NoteRepository noteRepository;

  public MainUIComponent(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public Session render(Session session) {
    final User user = session.unwrap();
    List<Note> currentNotes = noteRepository.findAllByUsername(user.username());
    renderNotes(currentNotes);
    final String newNoteText = JOptionPane.showInputDialog("New note: ");
    noteRepository.save(
        new Note(
            user.username(),
            newNoteText
        )
    );
    renderNotes(currentNotes);
    int flag = getConfirmation();
    if (flag == 0) {
      return render(session);
    } else {
      System.exit(0);
    }
    return session;
  }

  private int getConfirmation() {
    return JOptionPane.showConfirmDialog(
        null,
        "Continue?",
        "Confirmation",
        JOptionPane.OK_CANCEL_OPTION
    );
  }

  private void renderNotes(List<Note> notes) {
    JOptionPane.showMessageDialog(
        null,
        notes,
        "Current notes:",
        JOptionPane.INFORMATION_MESSAGE
    );
  }
}
