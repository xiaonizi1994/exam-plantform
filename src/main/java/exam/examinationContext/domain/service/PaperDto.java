package exam.examinationContext.domain.service;

import exam.examinationContext.domain.modal.examination.Examination.Paper;
import exam.examinationContext.domain.modal.examination.Examination.Paper.BlankQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class PaperDto {
    private String name;
    private List<BlankQuizDto> blankQuizzes;

    public static Paper toPaper(PaperDto paperDto) {
        return new Paper(paperDto.name,
                paperDto.getBlankQuizzes().stream()
                        .map(BlankQuizDto::toBlankQuiz)
                        .collect(Collectors.toList())
        );
    }

    @AllArgsConstructor
    public static class BlankQuizDto {
        private String id;
        private int number;
        private String teacherId;
        private String content;
        private String referenceAnswer;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;

        public static BlankQuiz toBlankQuiz(BlankQuizDto blankQuizDto) {
            return new BlankQuiz(blankQuizDto.id,
                    blankQuizDto.number,
                    blankQuizDto.teacherId,
                    blankQuizDto.content,
                    blankQuizDto.referenceAnswer,
                    blankQuizDto.createTime,
                    blankQuizDto.updateTime);
        }
    }
}
