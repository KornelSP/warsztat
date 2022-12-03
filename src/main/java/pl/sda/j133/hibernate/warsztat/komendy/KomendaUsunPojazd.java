package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

public class KomendaUsunPojazd implements Komenda {
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaUsunPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pojazd pojazd = session.get(Pojazd.class, id);
            if (pojazd != null) {
                session.remove(pojazd);
                System.out.println("Usunięto pojazd.");
            } else {
                System.out.println("Nie znaleziono pojazdu z takim id!");
            }

            transaction.commit();

        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
