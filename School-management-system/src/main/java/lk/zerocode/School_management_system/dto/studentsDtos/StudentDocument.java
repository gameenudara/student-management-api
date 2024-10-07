package lk.zerocode.School_management_system.dto.studentsDtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class StudentDocument {

    private MultipartFile documentLink;

}
