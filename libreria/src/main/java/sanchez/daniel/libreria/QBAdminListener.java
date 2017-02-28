package sanchez.daniel.libreria;

import java.util.HashMap;

/**
 * Created by daniel.rodriguez on 24/01/2017.
 */
public interface QBAdminListener { //Interface, sirve de plantilla para modificaciones futuras. Métodos implementados en QBAdmin
    public void idiomasDescargados(HashMap<Integer, String> idiomasDesc);
}