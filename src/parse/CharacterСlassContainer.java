import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class CharacterСlassContainer extends BaseCharacteristics<CharacterСlass> {
    public CharacterСlassContainer(String path) throws FileNotFoundException {
        super(path);
    }
/*
    @Override
    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }*/

    @Override
    protected CharacterСlass getInstance() {
        return new CharacterСlass();
    }

}
