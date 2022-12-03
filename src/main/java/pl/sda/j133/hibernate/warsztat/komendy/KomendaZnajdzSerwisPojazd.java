package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

public class KomendaZnajdzSerwisPojazd implements Komenda {
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZnajdzSerwisPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz serwis pojazdu";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

            SerwisPojazdu serwis = session.get(SerwisPojazdu.class, id);

            if (serwis != null) {

                System.out.println(serwis);

            } else {
                System.err.println("Taki serwis nie istnieje");
            }

        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
