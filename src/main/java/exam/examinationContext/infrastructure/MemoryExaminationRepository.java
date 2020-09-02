package exam.examinationContext.infrastructure;

import exam.examinationContext.domain.modal.examination.Examination;
import exam.examinationContext.domain.modal.examination.ExaminationId;
import exam.examinationContext.domain.modal.examination.ExaminationRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MemoryExaminationRepository implements ExaminationRepository {
    private Set<Examination> examinations = new HashSet<>();

    @Override
    public Examination find(ExaminationId examinationId) {
        return examinations.stream().filter(examination-> examination.getExaminationId()
            .equals(examinationId))
            .findFirst()
            .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(Examination examination) {
        examinations.add(examination);
    }

    @Override
    public List<Examination> getAll() {
        return examinations.stream().collect(Collectors.toList());
    }
}
