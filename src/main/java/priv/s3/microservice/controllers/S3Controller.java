package priv.s3.microservice.controllers;

import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.s3.microservice.services.S3Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

@RestController
public class S3Controller {

    @Autowired
    private S3Services s3Services;

    @RequestMapping(value="/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] greeting(@RequestParam(value="name", defaultValue="World") String name) throws IOException {
        List<String> fileNames=s3Services.listFileNames();
        Random rand = new Random();
        String fileName = fileNames.get(rand.nextInt(fileNames.size()));
        InputStream inputStream=s3Services.downloadFile(fileName);
        return IOUtils.toByteArray(inputStream);
    }
}
