    package lk.zerocode.School_management_system.dto;

    import lk.zerocode.School_management_system.dto.studentsDtos.MedicalRecordDto;
    import lk.zerocode.School_management_system.dto.studentsDtos.NicDto;
    import lk.zerocode.School_management_system.dto.studentsDtos.PreviousSchoolDto;
    import lk.zerocode.School_management_system.dto.studentsDtos.StudentDocument;
    import lombok.Data;
    import org.springframework.web.multipart.MultipartFile;

    import java.time.LocalDate;
    import java.util.List;

    @Data
    public class StudentDto {

        private String registrationNumber;
        private MultipartFile profileImage;
        private String name;
        private LocalDate admissionDate;
        private String clas;
        private String address;
        private LocalDate birthDate;
        private String gender;
        private String religion;
        private List<PreviousSchoolDto> previousSchools;
        private List<MedicalRecordDto> medicalRecords;
        private String additionalInfo;
        private List<NicDto> nicDtoList;
        private MultipartFile birthCertificate;
        private List<StudentDocument> studentDocumentList;

    }
