import java.util.ArrayList;
import java.util.Scanner;

public class GestionConsultores {
    private ArrayList<Consultor> consultores;

    public GestionConsultores() {
        consultores = new ArrayList<>();
    }

    private int generarIdConsultor() {
        return consultores.size() + 1;
    }

    private String generarCodigoConsultor() {
        return "C" + (consultores.size() + 1);
    }

    private Consultor buscarConsultor(int id) {
        for (Consultor consultor : consultores) {
            if (consultor.getId() == id) {
                return consultor;
            }
        }
        return null;
    }

    public void agregarConsultor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del consultor: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del consultor: ");
        String apellido = scanner.next();
        System.out.print("Ingrese el telefono del consultor: ");
        String telefono = scanner.next();
        System.out.print("Ingrese la direccion del consultor: ");
        String direccion = scanner.next();
        Consultor consultorNuevo = new Consultor(generarCodigoConsultor(), generarIdConsultor(), nombre, apellido, telefono, direccion);
        consultores.add(consultorNuevo);
        System.out.println("\nConsultor agregado correctamente.");
    }

    public void buscarConsultor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del consultor a buscar: ");
        int id = scanner.nextInt();
        Consultor consultorEncontrado = buscarConsultor(id);
        if (consultorEncontrado != null) {
            System.out.println("\nConsultor encontrado: " + consultorEncontrado.getId() + " - Nombre: " + consultorEncontrado.getNombre() + " " + consultorEncontrado.getApellido() + " - Telefono: " + consultorEncontrado.getTelefono() + " - Direccion: " + consultorEncontrado.getDireccion());
        } else {
            System.out.println("\nConsultor no encontrado.");
        }
    }

    public void modificarConsultor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del consultor a modificar: ");
        int id = scanner.nextInt();
        Consultor consultorModificado = buscarConsultor(id);
        if (consultorModificado != null) {
            System.out.print("Ingrese el nuevo nombre del consultor: ");
            String nuevoNombre = scanner.next();
            System.out.print("Ingrese el nuevo apellido del consultor: ");
            String nuevoApellido = scanner.next();
            System.out.print("Ingrese el nuevo telefono del consultor: ");
            String nuevoTelefono = scanner.next();
            System.out.print("Ingrese la nueva direccion del consultor: ");
            String nuevaDireccion = scanner.next();
            consultorModificado.setNombre(nuevoNombre);
            consultorModificado.setApellido(nuevoApellido);
            consultorModificado.setTelefono(nuevoTelefono);
            consultorModificado.setDireccion(nuevaDireccion);
            System.out.println("\nConsultor modificado correctamente.");
        } else {
            System.out.println("\nConsultor no encontrado.");
        }
    }

    public void eliminarConsultor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del consultor a eliminar: ");
        int id = scanner.nextInt();
        Consultor consultorEliminado = buscarConsultor(id);
        if (consultorEliminado != null) {
            consultores.remove(consultorEliminado);
            System.out.println("\nConsultor eliminado correctamente.");
        } else {
            System.out.println("\nConsultor no encontrado.");
        }
    }

    public void listarConsultores() {
        System.out.println("\nLista de consultores:");
        for (int i = 0; i < consultores.size(); i++) {
            Consultor consultor = consultores.get(i);
            System.out.println("ID: " + consultor.getId() + " - Nombre: " + consultor.getNombre() + " " + consultor.getApellido() + " - Telefono: " + consultor.getTelefono() + " - Direccion: " + consultor.getDireccion());
        }
    }
}