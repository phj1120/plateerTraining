package org.parkh.b1.todo.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.parkh.b1.todo.domain.Reply;
import org.parkh.b1.todo.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class ReplyRepositoryTest {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReplies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            Long tno = (long) (Math.random() * 100) + 1;
            Todo todo = Todo.builder().id(tno).build(); // equals, hashcode 를 id 로만 비교되도록 해줬으므로 같은 엔티티로 취급

            int replyCount = (int) (Math.random() * 5);

            for (int j = 0; j < replyCount; j++) {
                Reply reply = Reply.builder()
                        .todo(todo)
                        .build();
                replyRepository.save(reply);
            }
        });
    }

//
//    @Test
//    public void testInsert() {
//        IntStream.rangeClosed(1, 100).forEach((i) -> {
//            Todo todo = Todo.builder()
//                    .title("Title" + i)
//                    .writer("user" + i)
//                    .build();
//            log.info(todoRepository.save(todo));
//        });
//    }


}