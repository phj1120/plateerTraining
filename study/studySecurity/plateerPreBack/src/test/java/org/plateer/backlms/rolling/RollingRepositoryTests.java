package org.plateer.backlms.rolling;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.backlms.member.entity.Member;
import org.plateer.backlms.member.repository.MemberRepository;
import org.plateer.backlms.reply.domain.Reply;
import org.plateer.backlms.reply.repository.ReplyRepository;
import org.plateer.backlms.rolling.domain.Rolling;
import org.plateer.backlms.rolling.repository.RollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@Transactional
public class RollingRepositoryTests {
    @Autowired
    RollingRepository rollingRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Test
    @Rollback(value = false)
    public void initDB() {
        // 사용자 생성
        List<Member> members = new ArrayList<>();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            Member member = new Member("memberId" + UUID.randomUUID().toString().substring(0, 10), "password" + i, "name" + i);
            members.add(memberRepository.save(member));
        });

        // Rolling 생성, 댓글 생성
        // 사용자가 신청 -> 관리자 확인 후 생성
        IntStream.rangeClosed(1, 110).forEach(i -> {
            int randomNum = getRandomNum(members.size());
            System.out.println(randomNum);
            Member member = members.get(randomNum);

            Rolling rolling = Rolling.builder()
                    .title("플래티어 프로젝트 ..")
                    .writer(member.getMemberName())
                    .target(member.getMemberName())
                    .imgSrc("https://source.unsplash.com/random/" + i)
                    .createDt(LocalDate.now().plusDays(i))
                    .build();
            rollingRepository.save(rolling);

            IntStream.rangeClosed(1, getRandomNum(10)).forEach(j -> {
                Reply reply = Reply.builder()
                        .title("title" + j)
                        .content("content" + j)
                        .rolling(rolling)
                        .writer(members.get(getRandomNum(members.size())))
                        .build();
                replyRepository.save(reply);
            });
        });
    }

    private int getRandomNum(int max) {
        return (int) (Math.random() * max);
    }


    @Test
    public void testRollingInsert() {
        IntStream.rangeClosed(1, 125).forEach(i -> {
            Rolling rolling = Rolling.builder()
                    .title("플래티어 프로젝트 .. [" + i + "]")
                    .writer("홍길동.." + i)
                    .target("이순신" + i)
                    .imgSrc("https://source.unsplash.com/random/" + i)
                    .createDt(LocalDate.now().plusDays(i))
                    .build();

            rollingRepository.save(rolling);
        });
    }


    @Test
    public void testPrint() {
        log.info("############################");
        log.info(getRandomNum(10));
    }

}
