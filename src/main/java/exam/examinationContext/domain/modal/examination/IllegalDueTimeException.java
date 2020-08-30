package exam.examinationContext.domain.modal.examination;

class IllegalDueTimeException extends IllegalArgumentException {

    public IllegalDueTimeException(long actual) {
        super("OverExaminationDueTimeException: exception:120 minutes, actual:" + actual);
    }
}
