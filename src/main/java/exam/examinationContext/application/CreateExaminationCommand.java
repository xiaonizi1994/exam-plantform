package exam.examinationContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateExaminationCommand {
    private String teacherId;
    private Paper paper;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Value
    public static class Paper {
        private String name;
        List<BlankQuiz> blankQuizzes;
    }

    @Value
    public static class BlankQuiz {
        private String id;
        private int number;
        private String teacherId;
        private String content;
        private String referenceAnswer;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;
    }


}
