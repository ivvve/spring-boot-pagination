package com.devson.pagination;

import com.devson.pagination.web.domain.BoardEntity;
import com.devson.pagination.web.domain.UserEntity;
import com.devson.pagination.web.repository.BoardRepository;
import com.devson.pagination.web.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class PaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginationApplication.class, args);
    }

    /**
     * 154 개의 사용자와 게시물을 생성
     * @param userRepository
     * @param boardRepository
     * @return
     */
    @Bean
    public CommandLineRunner initData(UserRepository userRepository, BoardRepository boardRepository) {
        return args ->
                IntStream.rangeClosed(1, 154).forEach(i -> {
                    UserEntity user =  UserEntity.builder()
                            .name("tester" + i)
                            .build();

                    userRepository.save(user);

                    BoardEntity board = BoardEntity.builder()
                            .title("test" + i)
                            .writer(user)
                            .build();

                    boardRepository.save(board);
                });
    }
}