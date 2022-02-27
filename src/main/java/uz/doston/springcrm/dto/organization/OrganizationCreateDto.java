package uz.doston.springcrm.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.dto.BaseDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
//@Builder
@NoArgsConstructor
public class OrganizationCreateDto implements BaseDto {

    @Size(min = 1,max = 30,message = "value for title must be between {min} and {max}")
    private String name;

    @NotNull(message = "Please input logo")
    private MultipartFile logo;

    private Point location;

}
