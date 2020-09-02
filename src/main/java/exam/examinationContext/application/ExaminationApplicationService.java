package exam.examinationContext.application;

import exam.examinationContext.domain.modal.examination.Examination;
import exam.examinationContext.domain.modal.examination.Examination.Paper;
import exam.examinationContext.domain.modal.examination.ExaminationId;
import exam.examinationContext.domain.modal.examination.ExaminationRepository;
import exam.examinationContext.domain.service.PaperDto;
import exam.examinationContext.userInterface.ExaminationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExaminationApplicationService {

    private ExaminationRepository examinationRepository;

    @Autowired
    public ExaminationApplicationService(ExaminationRepository examinationRepository) {
        this.examinationRepository = examinationRepository;
    }

    public Examination createExamination(CreateExaminationCommand command) {
        PaperDto paperDto = paperFrom(command);
        Paper paper = PaperDto.toPaper(paperDto);
        final String teacherId = command.getTeacherId();
        final ExaminationId examinationId = ExaminationId.nextId();
        final LocalDateTime startTime = command.getStartTime();
        final LocalDateTime endTime = command.getEndTime();

        final Examination examination = Examination.create(examinationId, teacherId, paper, startTime, endTime);
        examinationRepository.save(examination);

        return examination;
    }

    public ExaminationDTO getExamination(String examinationId) {
        final Examination examination = examinationRepository.find(new ExaminationId(examinationId));
        return ExaminationDTO.from(examination);
    }

    private PaperDto paperFrom(CreateExaminationCommand command) {
        List<PaperDto.BlankQuizDto> blankQuizDtos = command.getPaper().getBlankQuizzes().stream()
               .map(blankQuizDto -> new PaperDto.BlankQuizDto(
                       blankQuizDto.getId(),
                       blankQuizDto.getNumber(),
                       blankQuizDto.getTeacherId(),
                       blankQuizDto.getContent(),
                       blankQuizDto.getReferenceAnswer(),
                       blankQuizDto.getCreateTime(),
                       blankQuizDto.getUpdateTime()))
               .collect(Collectors.toList());
        return new PaperDto(command.getPaper().getName(), blankQuizDtos);
    }
}
