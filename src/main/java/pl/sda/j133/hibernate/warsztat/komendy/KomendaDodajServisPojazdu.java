package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaDodajServisPojazdu implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;
    private DataAccessObject<Pojazd> dataAccessObjectPojazd;
    private DataAccessObject<Mechanik> dataAccessObjectMechanik;


    public KomendaDodajServisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectPojazd = new DataAccessObject<>();
        this.dataAccessObjectMechanik = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj serwis pojazdu";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id serwisowanego pojazdu:");
        String idSerwis = Komenda.scanner.nextLine();
        Long idPojazd = Long.parseLong(idSerwis);

        Optional<Pojazd> pojazdOptional = dataAccessObjectPojazd.find(Pojazd.class, idPojazd);
        if (pojazdOptional.isEmpty()) {
            System.err.println("Pojazd nie istnieje w bazie");
            return;
        }

        System.out.println("Podaj id mechanika:");
        String idMechanikString = Komenda.scanner.nextLine();
        Long idMechanik = Long.parseLong(idMechanikString);

        Optional<Mechanik> mechanikOptional = dataAccessObjectMechanik.find(Mechanik.class, idMechanik);
        if (mechanikOptional.isEmpty()) {
            System.err.println("Mechanik nie istnieje w bazie");
            return;
        }

        System.out.println("Podja opis serwisu");
        String opis = Komenda.scanner.nextLine();

    SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
            .mechanik(mechanikOptional.get())
            .pojazd(pojazdOptional.get())
            .opis(opis)
            .build();
    dataAccessObject.insert(serwisPojazdu);
        System.out.println("Dodano serwis!");
    }
}

