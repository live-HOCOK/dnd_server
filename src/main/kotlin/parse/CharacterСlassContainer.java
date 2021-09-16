package parse;

import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class CharacterСlassContainer extends BaseCharacteristics<CharacterСlass> {
    @Override
    protected Type getType() {
        Type type = new TypeToken<CharacterСlass>(){}.getType();
        return type;
    }

    public CharacterСlassContainer(IReadParse iReadParse) {
        super(iReadParse);
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
