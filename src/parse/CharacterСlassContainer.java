import java.lang.reflect.Field;

public class CharacterСlassContainer extends BaseCharacteristics<CharacterСlass> {
    @Override
    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }

    @Override
    protected CharacterСlass getInstance() {
        return new CharacterСlass();
    }

}
