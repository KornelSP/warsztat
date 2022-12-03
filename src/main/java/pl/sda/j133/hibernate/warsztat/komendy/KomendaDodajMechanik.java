package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

public class KomendaDodajMechanik implements Komenda {
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaDodajMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie mechanika");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje mechanika");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje mechanika");
        String specjalizacje = Komenda.scanner.nextLine();


        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacje(kwalifikacje)
                .specjalizacja(specjalizacje)

                .build();

        dataAccessObject.insert(mechanik);
    }
}
