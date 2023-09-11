package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        addCheck(CheckName.REQUIRED, value -> value instanceof Map);
    }

    public void required() {
        required = true;
    }

    public void sizeof(int size) {
        addCheck(CheckName.SIZE_OF, value -> ((Map<?, ?>) value).size() == size);
    }

    public void shape(Map<String, BaseSchema> schemas) {
        addCheck(CheckName.SHAPE, value -> schemas.entrySet()
                .stream()
                .allMatch(e -> {
                    Object v = ((Map<?, ?>) value).get(e.getKey());
                    return e.getValue()
                            .isValid(v);
                }));
    }
}
