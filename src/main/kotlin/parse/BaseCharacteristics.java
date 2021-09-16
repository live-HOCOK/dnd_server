package parse;
import java.lang.reflect.Type;
import java.util.*;

public abstract class BaseCharacteristics<T> extends ArrayList<T> {

    protected abstract Type getType();

    protected abstract T getInstance();

   /* public BaseCharacteristics (IReadParse iReadParse){
        addAll(iReadParse.get(getInstance()));
    }*/
   public BaseCharacteristics (IReadParse iReadParse){
       addAll(iReadParse.get(getType()));
   }
}
