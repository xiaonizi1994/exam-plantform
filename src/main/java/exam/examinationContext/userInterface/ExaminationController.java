package exam.examinationContext.userInterface;

import exam.examinationContext.application.CreateExaminationCommand;
import exam.examinationContext.application.ExaminationApplicationService;
import exam.examinationContext.domain.modal.examination.Examination;
import exam.examinationContext.infrastructure.MemoryExaminationReadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExaminationController {
    private final ExaminationApplicationService examinationApplicationService;
    private final MemoryExaminationReadRepository examinationReadRepository;

    public ExaminationController(ExaminationApplicationService examinationApplicationService, MemoryExaminationReadRepository examinationReadRepository) {
        this.examinationApplicationService = examinationApplicationService;
        this.examinationReadRepository = examinationReadRepository;
    }

    @PostMapping("/examination")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED) ExaminationDTO create(@RequestBody CreateExaminationCommand command) {
        final Examination examination = examinationApplicationService.createExamination(command);
        return ExaminationDTO.from(examination);
    }

    @PutMapping("/examination/{examinationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ExaminationDTO getExamination(@PathVariable String examinationId) {

        return examinationApplicationService.getExamination(examinationId);
    }

}
