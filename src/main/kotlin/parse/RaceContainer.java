package parse;

import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class RaceContainer extends BaseCharacteristics<Race> {
    public RaceContainer(IReadParse iReadParse) {
        super(iReadParse);
    }
    /* @Override
    protected Field[] retrievingFields() {
        Class<?> current = getInstance().getClass();
        Field[] fields = current.getDeclaredFields();
        return fields;
    }*/
    @Override
    protected Type getType() {
        Type type = new TypeToken<Race>(){}.getType();
        return type;
    }
    @Override
    protected Race getInstance() {
        return new Race();
    }

}
