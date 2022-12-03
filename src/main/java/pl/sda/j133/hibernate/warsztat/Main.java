package pl.sda.j133.hibernate.warsztat;

import pl.sda.j133.hibernate.warsztat.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> ListaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanik(),
                        new KomendaListaPojazd(),
                        new KomendaListaMechanik(),
                        new KomendaZnajdzPojazd(),
                        new KomendaZnajdzMechanik(),
                        new KomendaUsunPojazd(),
                        new KomendaUsunMechanik(),
                        new KomendaDodajServisPojazdu(),
                        new KomendaListaServisPojazd(),
                        new KomendaZnajdzSerwisPojazd(),
                        new KomendaUsunSerwisPojazd()

                )
        );

        System.out.println("Lista dostępnych komend:");
        ListaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("");
        System.out.println("Podaj komendę");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : ListaKomend) {
            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }
    }
}
