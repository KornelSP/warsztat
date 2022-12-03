package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

public class KomendaUsunMechanik implements Komenda {
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


        if (dataAccessObject.delete(Mechanik.class, id)) {
            System.out.println("Usunięto mechanika.");
        } else {
            System.out.println("Nie znaleziono mechanika z takim id!");
        }
    }
}
