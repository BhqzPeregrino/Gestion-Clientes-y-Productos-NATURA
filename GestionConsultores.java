import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GestionConsultores {
    protected ArrayList<Consultor> consultores;

    public GestionConsultores() {
        consultores = new ArrayList<>();
    }

    public void agregarConsultor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del consultor: ");
        int id;
    
        while (true) {
            try {
                id = scanner.nextInt();
                if (!consultorExistente(id)) {
                    break;
                } else {
                    System.out.println("El ID ingresado ya está en uso. Por favor, ingrese otro ID.");
                    System.out.print("Ingrese el ID del consultor: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un ID válido (número entero).");
                System.out.print("Ingrese el ID del consultor: ");
                scanner.next();
            }
        }
    
        System.out.print("Ingrese el nombre del consultor: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del consultor: ");
        String apellido = scanner.next();
    
        System.out.print("Ingrese el teléfono del consultor: ");
        String telefono;
    
        while (true) {
            telefono = scanner.next();
            if (!telefonoExistente(telefono)) {
                break;
            } else {
                System.out.println("El teléfono ingresado ya está en uso. Por favor, ingrese otro teléfono.");
                System.out.print("Ingrese el teléfono del consultor: ");
            }
        }
    
        System.out.print("Ingrese la dirección del consultor: ");
        String direccion = scanner.next();
    
        Consultor consultorNuevo = new Consultor(id, nombre, apellido, telefono, direccion);
        consultores.add(consultorNuevo);
        System.out.println("\nConsultor agregado correctamente.");
    }

    
    private boolean consultorExistente(int id) {
        for (Consultor consultor : consultores) {
            if (consultor.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean telefonoExistente(String telefono) {
        for (Consultor consultor : consultores) {
            if (consultor.getTelefono().equals(telefono)) {
                return true;
            }
        }
        return false;
    }


    private Consultor buscarConsultor(int id) {
        for (Consultor consultor : consultores) {
            if (consultor.getId() == id) {
                return consultor;
            }
        }
        return null;
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