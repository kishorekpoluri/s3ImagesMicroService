package priv.s3.microservice.services;

import java.io.InputStream;
import java.util.List;

public interface S3Services {

    public InputStream downloadFile(String keyName);
    public void uploadFile(String keyName, String uploadFilePath);
    public List<String> listFileNames();
}
