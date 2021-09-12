package parse;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class RaceContainer extends BaseCharacteristics<Race> {
    public RaceContainer(String path) throws FileNotFoundException {
        super(path);
    }

   /* @Override
    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }*/

    @Override
    protected Race getInstance() {
        return new Race();
    }

}
