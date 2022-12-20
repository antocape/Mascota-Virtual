package modelos;

public class MiMascota extends Mascota {

    static int count;
    public static int getCount() {
        return count;
    }
    public MiMascota(String nombre, String propietario) {
        super(nombre, propietario);
        this.id = ++count;
    }

    @Override
    public String toString() {
        return "La Mascota de nombre : " + nombre + '\n'
                + "nació el día " + fechaNacimiento.getDayOfWeek() + ", "
                + fechaNacimiento.getDayOfMonth() + " de "
                + fechaNacimiento.getMonth() + " del año "
                + fechaNacimiento.getYear() + '\n'
                + "a la hora : " + fechaNacimiento.getHour() + ":"
                + fechaNacimiento.getMinute() + '\n'
                + "actualmente se encuentra " + ((isLive) ? "vivo\n" : "muerto\n")
                + "su nivel de Energía se encuentra en : " + nivelEnergia + "%\n"
                + "el nivel de Hambre en : " + nivelHambre + '\n'
                + "el nivel de Cansancio : " + nivelCansancio + '\n'
                + "el nivel de Felicidad : " + nivelFelicidad + '\n'
                + "el nivel de Aburrimiento : " + nivelAburrimiento + '\n'
                + "y su actual propietario es : " + propietario + '\n';
    }



}


