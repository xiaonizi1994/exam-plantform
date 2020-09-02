package exam.examinationContext.userInterface;

import exam.examinationContext.domain.modal.examination.Examination;
import exam.examinationContext.domain.modal.examination.ExaminationId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ExaminationDTO {
    private ExaminationId examinationId;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private String teacherId;
    private Examination.Paper Paper;

    public static ExaminationDTO from(Examination examination) {
        return new ExaminationDTO(examination.getExaminationId(),
                examination.getCreateTime(),
                examination.getEndTime(),
                examination.getStartTime(),
                examination.getTeacherId(),
                examination.getPaper()
        );
    }

    public static ExaminationDTO to(ExaminationDTO examinationDTO) {
        return new ExaminationDTO(examinationDTO.getExaminationId(),
                examinationDTO.getCreateTime(),
                examinationDTO.getEndTime(),
                examinationDTO.getStartTime(),
                examinationDTO.getTeacherId(),
                examinationDTO.getPaper()
        );
    }
}
