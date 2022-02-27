package uz.doston.springcrm.service.organization;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.entity.organization.Logo;
import uz.doston.springcrm.mapper.BaseMapper;
import uz.doston.springcrm.mapper.organization.OrganizationLogoMapper;
import uz.doston.springcrm.repository.organization.OrganizationLogoRepository;
import uz.doston.springcrm.service.base.AbstractService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class OrganizationLogoService extends AbstractService<BaseMapper, OrganizationLogoRepository> {

    public static final String UPLOAD_DIRECTORY = "src/main/resources/logo";

    public OrganizationLogoService(OrganizationLogoRepository repository) {
        super(repository);
    }

    public Logo create(MultipartFile file) throws IOException {
        Logo logo = new Logo();
        String[] strings = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        logo.setFormat(strings[strings.length - 1]);
        logo.setImageName(file.getName());
        logo.setGeneratedName(UUID.randomUUID().toString());
        logo.setSize(file.getSize());
        repository.save(logo);
        Path path = Paths.get(UPLOAD_DIRECTORY + "/" + logo.getGeneratedName() + "." + logo.getFormat());
        Files.copy(file.getInputStream(), path);
        return logo;

    }

    public Logo get(Long id) {
        return repository.findById(id).get();
    }

}
