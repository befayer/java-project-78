package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        addCheck(CheckName.REQUIRED, value -> value instanceof String && !((String) value).isEmpty());
    }

    public void required() {
        required = true;
    }

    public void contains(String substring) {
        addCheck(CheckName.CONTAINS, value -> ((String) value).contains(substring));
    }

    public void minLength(int length) {
        addCheck(CheckName.MIN_LENGTH, value -> ((String) value).length() >= length);
    }

}