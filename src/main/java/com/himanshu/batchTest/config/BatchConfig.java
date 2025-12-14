package com.himanshu.batchTest.config;

import com.himanshu.batchTest.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.batch.core.Step;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
public Job jobBean(JobRepository jobRepository, JobComplitionListner listener, DataSourceTransactionManager transactionManager,
                   ItemReader<Product> reader,ItemProcessor<Product,Product> processor,
                   ItemWriter<Product> writer)
    {
        return new JobBuilder("job" ,jobRepository)
                .listener(listener)
                .start(steps(jobRepository, transactionManager, reader, processor, writer))
                .build();
    }

    @Bean
    public Step steps(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      ItemReader<Product> reader,ItemProcessor<Product,Product> processor,
                      ItemWriter<Product> writer)
    {
        return new StepBuilder("jobSteps",jobRepository)
                .<Product,Product>chunk(100,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public FlatFileItemReader<Product> reader()
    {
        return new FlatFileItemReaderBuilder<Product>()
                .name("ItemReader")
                .resource(new ClassPathResource("products_10000_records.csv"))
                .linesToSkip(1)
                .delimited()
                .names("productId","title","description","price","discount")
                .targetType(Product.class)
                .build();
    }

    @Bean
    public ItemProcessor<Product,Product> itemProcessor()
    {
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Product> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Product>()
                .sql("INSERT INTO products(product_id, title, description, price, discount, discounted_price) " +
                        "VALUES (:productId, :title, :description, :price, :discount, :discountedPrice)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
}
