package exam.examinationContext.infrastructure;

import exam.examinationContext.domain.modal.examination.Examination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemoryExaminationReadRepository {
    public List<Examination> getAllByReversedOrder() {
        return null;
    }
}
