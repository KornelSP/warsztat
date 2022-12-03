package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazd implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun serwis pojazdu";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


        if (dataAccessObject.delete(SerwisPojazdu.class, id)) {
            System.out.println("Usunięto serwis.");
        } else {
            System.out.println("Nie znaleziono serwisu z takim id!");
        }
    }
}
