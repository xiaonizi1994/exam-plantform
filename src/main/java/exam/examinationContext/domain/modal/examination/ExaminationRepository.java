package exam.examinationContext.domain.modal.examination;

import org.springframework.stereotype.Component;

import java.util.List;

public interface ExaminationRepository {
    Examination find(ExaminationId examinationId);

    void save(Examination examination);

    List<Examination> getAll();
}
