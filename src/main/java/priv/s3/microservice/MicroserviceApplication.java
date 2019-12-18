package priv.s3.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import priv.s3.microservice.services.S3Services;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroserviceApplication  implements CommandLineRunner {

    @Autowired
    private S3Services s3Services;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        printFileNames();
    }

    public void printFileNames(){
        List<String> fileNames=s3Services.listFileNames();
        Stream.of(fileNames).forEach(System.out::println);
    }
}
