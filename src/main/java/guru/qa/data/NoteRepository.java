package guru.qa.data;

import guru.qa.domain.Note;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/* Хранилище заметок.
MockNoteRepository хранит заметки в обычном ArrayList в памяти.                                      */




public interface NoteRepository {

  List<Note> findAllByUsername(String username);

  void save(Note note);

  class MockNoteRepository implements NoteRepository {

    private List<Note> store = new ArrayList<>(
        List.of(
            new Note("Tanya", "Выучи автоматизацию наконец!"),
            new Note("Tanya", "Начни меньше работать!")
        )
    );

    @Override
    public List<Note> findAllByUsername(String username) {
      if ("Tanya".equals(username)) {
        return store;
      }
      return Collections.emptyList();
    }

    @Override
    public void save(Note note) {
      if ("Tanya".equals(note.username())) {
        store.add(note);
      }
    }
  }

}
