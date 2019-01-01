package com.devson.pagination.web.domain;

import com.devson.pagination.web.repository.BoardRepository;
import com.devson.pagination.web.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MappingTest {
    @Autowired UserRepository userRepository;
    @Autowired BoardRepository boardRepository;

    @Test
    public void 일대일_매핑_테스트() {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    UserEntity user = UserEntity.builder()
                            .name("tester" + i)
                            .build();

                    userRepository.save(user);

                    boardRepository.save(BoardEntity.builder()
                            .title("test" + i)
                            .writer(user)
                            .build());
                });

        LongStream.rangeClosed(1, 100)
                .forEach(i -> {
                    assertThat(boardRepository.findById(i).get().getWriter().getName(), is("tester" + i));
                });
    }

}
