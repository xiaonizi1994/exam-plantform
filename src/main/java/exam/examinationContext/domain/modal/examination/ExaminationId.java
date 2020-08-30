package exam.examinationContext.domain.modal.examination;

import exam.examinationContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class ExaminationId implements ValueObject<ExaminationId> {
    private String id;

    @Override
    public boolean sameValueAs(ExaminationId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExaminationId that = (ExaminationId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static ExaminationId nextId() {
        //TODO Generate ID
        return null;
    }
}
