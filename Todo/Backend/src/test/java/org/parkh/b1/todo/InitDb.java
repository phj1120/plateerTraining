package org.parkh.b1.todo;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.parkh.b1.todo.domain.Reply;
import org.parkh.b1.todo.domain.Todo;
import org.parkh.b1.todo.repository.ReplyRepository;
import org.parkh.b1.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class InitDb {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void initDb() {
        LocalDate date = LocalDate.now().minusDays(50);

        IntStream.rangeClosed(1, 100).forEach((i) -> {
            Todo todo = Todo.builder()
                    .title("Title" + i)
                    .writer("user" + i)
                    .dueDate(date.plusDays(i))
                    .build();
            todoRepository.save(todo);

            int replyCount = (int) (Math.random() * 5);
            for (int j = 0; j < replyCount; j++) {
                Reply reply = Reply.builder()
                        .todo(todo)
                        .build();
                replyRepository.save(reply);
            }
        });
    }
}
