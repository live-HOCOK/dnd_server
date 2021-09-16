package parse;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public abstract class BaseParseToJson implements IReadParse{
    public abstract <T>ArrayList get(Type type);
}
