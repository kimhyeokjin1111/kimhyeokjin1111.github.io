package com.example.hippobookproject.batch;

import com.example.hippobookproject.dto.Categorie.BookDto;
import com.example.hippobookproject.dto.book.AladinItemDto;
import com.example.hippobookproject.mapper.book.BookMapper;
import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BookRegisterJobConfig {
    //    JobRepository 는 Spring Batch의 핵심 객체이다.
    //    배치 작업의 실행 상태, 진행 상황, 이력 등을 저장하고 관리한다.
    //    JobRepository는 DB에 배치작업에 관련된 여러 데이터를 저장한다.
    private final JobRepository jobRepository;
    //    스프링에서 트랜잭션을 관리하는 인터페이스
    //    배치작없에서 트랜잭션을 관리해야하므로 이 객체의 도움을 받는다.
    private final PlatformTransactionManager platformTransactionManager;

    private final BookMapper bookMapper;
    private final BookService bookService;

    @Bean
    public ItemReader<AladinItemDto> apiItemReader(){
        return new ApiItemReader(bookService);
    }

    @Bean
    public ItemProcessor<AladinItemDto,AladinItemDto> apiItemProcessor(){
        Set<String> isbnSet = bookMapper.selectIsbn();


        return item -> {
            if(isbnSet.contains(item.getIsbn())) { return null; }
            isbnSet.add(item.getIsbn());
            return item;
        };


    }

    @Bean
    public ItemWriter<AladinItemDto> apiItemWriter(){
        return items -> {
            for (AladinItemDto item : items){
                bookMapper.insertAllBook(item);
            }
        };
    }

    @Bean
    public Step apiStep(){
        return new StepBuilder("aladinBookStep", jobRepository)
                .<AladinItemDto,AladinItemDto>chunk(10,platformTransactionManager)
                .reader(apiItemReader())
                .processor(apiItemProcessor())
                .writer(apiItemWriter())
                .build();
    }

    @Bean
    public Job apiJob(){
        return new JobBuilder("apiJob", jobRepository)
                .start(apiStep())
                .preventRestart() //배치 작업이 실패했을 때 재시작하지 못하도록 설정
                .build();
    }
}
