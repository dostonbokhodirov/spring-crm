package uz.doston.springcrm.entity.file;

import org.springframework.core.io.Resource;

import javax.persistence.Id;
import java.util.UUID;


public class FileUploads{

    @Id
    private UUID id;
    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private String path;
    private Resource resource;
}
