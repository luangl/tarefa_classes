package anotacao;

import java.lang.annotation.*;

/**
 * @author Luan Glaab
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoChave {

    String value();
}
