package com.kodilla.integration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;

@Configuration
public class FileIntegrationConfiguration {

    @Bean
    IntegrationFlow fileIntegrationFlow(FileReadingMessageSource fileAdapter,
                                        FileTransformer fileTransformer,
                                        FileWritingMessageHandler outputFileHandler) {
        return IntegrationFlows.from(fileAdapter, config ->config.poller(Pollers.fixedDelay(1000)))
                .transform(fileTransformer, "transFormFile")
                .handle(outputFileHandler)
                .get();
    }

    @Bean
    FileReadingMessageSource fileAdapter(){
        FileReadingMessageSource fileReadingMessageSource =new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(new File("1.3Integration/fileIntegration/src/main/resources/data/input"));
        return fileReadingMessageSource;
    }

    @Bean
    FileTransformer fileTransformer(){
        return new FileTransformer();
    }

    @Bean
    FileWritingMessageHandler outputFileHandler(){
        File direcotry =  new File("1.3Integration/fileIntegration/src/main/resources/data/output");
        FileWritingMessageHandler handler= new FileWritingMessageHandler(direcotry);
        handler.setExpectReply(false);
        return handler;
    }

}
