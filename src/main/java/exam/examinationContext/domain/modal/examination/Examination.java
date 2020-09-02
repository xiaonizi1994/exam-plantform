package exam.examinationContext.domain.modal.examination;

import exam.examinationContext.shared.Entity;
import exam.examinationContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"examinationId"})
public class Examination implements Entity<Examination> {
    private ExaminationId examinationId;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private LocalDateTime startTime;
    private String teacherId;
    private Paper Paper;

    public Examination(ExaminationId examinationId, String teacherId, Paper paper, LocalDateTime startTime, LocalDateTime endTime) {
        this.examinationId = examinationId;
        this.teacherId = teacherId;
        this.Paper = paper;
        this.startTime = startTime;
        this.endTime = endTime;
        createTime = LocalDateTime.now();
    }

    public static Examination create(ExaminationId examinationId, String teacherId, Paper paper, LocalDateTime startTime, LocalDateTime endTime) {
        validateDueTime(startTime, endTime);
        return new Examination(examinationId, teacherId, paper, startTime, endTime);
    }

    private static void validateDueTime(LocalDateTime startTime, LocalDateTime endTime) {
        long dueTimeMinutes = Duration.between(startTime, endTime).toMinutes();
        if ( dueTimeMinutes > 2 * 60) {
            throw new IllegalDueTimeException(dueTimeMinutes);
        }
    }

    public ExaminationId getExaminationId() {
        return examinationId;
    }

    public Paper getPaper(){
        return Paper;
    }

    public String getTeacherId(){
        return teacherId;
    }

    @Override
    public boolean sameIdentityAs(Examination other) {
        return examinationId.sameValueAs(other.getExaminationId());
    }

    @Getter
    @AllArgsConstructor
    public static class Paper implements ValueObject<Paper> {
        private String name;
        private List<BlankQuiz> blankQuizzes;

        @Override
        public boolean sameValueAs(Examination.Paper other) {
            return false;
        }

        @Getter
        @AllArgsConstructor
        public static class BlankQuiz implements ValueObject<BlankQuiz> {
            private String id;
            private int number;
            private String teacherId;
            private String content;
            private String referenceAnswer;
            private LocalDateTime createTime;
            private LocalDateTime updateTime;

            @Override
            public boolean sameValueAs(BlankQuiz other) {
                return false;
            }
        }
    }
}
