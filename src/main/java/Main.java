
import acciones.HacerPopo;
import enumeradores.AlmacenAlimentos;
import enumeradores.EntretenimientosEnum;
import modelos.DukeMascota;
import modelos.LastMascotita;
import modelos.Mascota;
import modelos.MiMascota;
import persistencia.mysql.MySQLConnection;
import persistencia.persistenceCollections.IMascotaPersistenceUseList;
import utils.actas.RegistroCivilMascotas;

import java.sql.Connection;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        IMascotaPersistenceUseList persistence = new IMascotaPersistenceUseList();


        DukeMascota duke = new DukeMascota( "Duke-Tonita", "Antonella");
        System.out.println(duke);
        DukeMascota duke2 = new DukeMascota( "Duke-Litoral", "Antonella");
        System.out.println(duke2);
        MiMascota cota = new MiMascota( "Cota-Cota", "Antonella");
        System.out.println(cota);
        LastMascotita tita = new LastMascotita( "Tita-Tita", "Antonella");
        System.out.println(tita);


        System.out.println("La cantidad de DukeMascota creadas es: " + DukeMascota.getCount());
        System.out.println("La cantidad de LastMascotitas creadas es: " + LastMascotita.getCount());
        System.out.println("La cantidad de LastMascotitas creadas es: " + MiMascota.getCount());


        persistence.guardar(duke);
        persistence.guardar(duke2);
        persistence.guardar(cota);
        persistence.guardar(tita);


        for(Mascota mascota : persistence.getAllMascotas()){
            System.out.println(mascota.getNombre());
        }

        //COMER

        System.out.println("antes de comer " + duke.getNivelEnergia());
        duke.comer(AlmacenAlimentos.ASADO);
        System.out.println("despues de comer " + duke.getNivelEnergia());

        //DIVERTIRSE

        duke.jugar(EntretenimientosEnum.POKER);
        duke.jugar(EntretenimientosEnum.PASEAR);
        duke.jugar(EntretenimientosEnum.PASEAR);
        duke.jugar(EntretenimientosEnum.PERINOLA);
        duke.jugar(EntretenimientosEnum.BAILAR);
        duke.jugar(EntretenimientosEnum.BAILAR);

        //DORMIR

        System.out.println("antes de dormir " +  duke.getNivelEnergia());
        duke.dormir(LocalTime.of(0, 25));
        System.out.println("despues de dormir " + duke.getNivelEnergia());

        //HACER POPO

        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.ENSALADA);
        duke.comer(AlmacenAlimentos.SOPA);

        System.out.println("Duke comió " + duke.getComidasIngeridas() + " comidas y tiene que evacuar.");
        duke.irAlBaño();
        System.out.println("Duke ya evacuó y tiene " + duke.getComidasIngeridas() + " comidas en su interior.");

        //CAUSA DE MUERTE


        System.out.println("La mascota se murió " + duke.getCausaDeMuerte());
        duke.causaDeMuerte();

        //ACTAS

        duke.comer(AlmacenAlimentos.ASADO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        duke.comer(AlmacenAlimentos.PORORO);
        RegistroCivilMascotas.confeccionarActa(duke);
        RegistroCivilMascotas.guardarActa(duke);
        RegistroCivilMascotas.leerActaNacimiento(duke);
        RegistroCivilMascotas.leerActaDefuncion(duke);

        MySQLConnection conexion = new MySQLConnection();
        Connection connection = conexion.establecerConexion();
        conexion.cerrarConexion(connection);

    }
}
