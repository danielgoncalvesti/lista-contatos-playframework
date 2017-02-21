package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by danielgoncalvesti on 20/02/17.
 */
public class ContatoDao {

    private static AtomicLong uuid = new AtomicLong();
    private static Map<Long, Contato> contatos = new ConcurrentHashMap<Long, Contato>();

    public static List<Contato> findAll(){
        List<Contato> resultado = new ArrayList<Contato>();

        for(Contato contato: contatos.values()){
            resultado.add(contato);
        }
        return resultado;
    }

    public static void salvar(Contato contato){
        contato.id = uuid.incrementAndGet();
        contatos.put(contato.id, contato);
    }


}
