package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.List;

public class KomendaListaServisPojazd implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListaServisPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista serwis pojazd";
    }

    @Override
    public void obsluga() {

        List<SerwisPojazdu> serwisy = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisy.forEach(System.out::println);


    }
}
