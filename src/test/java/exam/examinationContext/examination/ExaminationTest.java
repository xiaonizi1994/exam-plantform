package exam.examinationContext.examination;

import exam.examinationContext.domain.modal.examination.Examination;
import exam.examinationContext.domain.modal.examination.ExaminationId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExaminationTest {

    @Test
    public void should_create_examination_with_new() {
        final ExaminationId examinationId = new ExaminationId("examination-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final LocalDateTime startTime = LocalDateTime.of(2020, Month.SEPTEMBER, 1, 14, 46, 56);
        final LocalDateTime endTime = LocalDateTime.of(2020, Month.SEPTEMBER, 1, 14, 46, 56);
        List<Examination.Paper.BlankQuiz> blankQuizzes = Arrays.asList(
                new Examination.Paper.BlankQuiz("1",'1',"teacherId","content", "referenceAnswer", LocalDateTime.now(), LocalDateTime.now()),
                new Examination.Paper.BlankQuiz("2",'2',"teacherId","content", "referenceAnswer", LocalDateTime.now(), LocalDateTime.now()),
                new Examination.Paper.BlankQuiz("3",'3',"teacherId","content", "referenceAnswer", LocalDateTime.now(), LocalDateTime.now())
        );
        Examination.Paper paper = new Examination.Paper("name", blankQuizzes);

        Examination examination = Examination.create(examinationId, teacherId, paper, startTime, endTime);

        assertThat(examination, is(notNullValue()));

        assertThat(examination.getExaminationId(), is(new ExaminationId("examination-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
        assertThat(examination.getTeacherId(), is(teacherId));
    }
}
