package uz.doston.springcrm.entity.file;

import uz.doston.springcrm.entity.Auditable;

public class File extends Auditable {
    private String coverPath;

    private FileUploads uploads;
    private String name;

}
