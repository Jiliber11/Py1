
import java.util.Scanner;

public class MiProyecto {
    public static void main(String[] args) {
        // Crea una instancia de FabricaDeTrajes
        FabricaDeTrajes fabrica = new FabricaDeTrajes() {
            @Override
            public void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
                
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de componente que desea añadir (Chaqueta, Pantalón, Falda, Blusa): ");
        String tipoComponente = scanner.nextLine();

        System.out.println("Ingrese el id del componente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Validar que el id del componente no exista anteriormente
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                throw new IdException("El id del componente ya existe en el almacén.");
            }
        }

        System.out.println("Ingrese el nombre del componente: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la talla del componente: ");
        String talla = scanner.nextLine();

        System.out.println("Ingrese el color del componente: ");
        String color = scanner.nextLine();

        System.out.println("¿Es comunitario? (true/false): ");
        boolean esComunitario = scanner.nextBoolean();

        System.out.println("Ingrese el precio del componente: ");
        double precio = scanner.nextDouble();

        // Ajustar el precio del componente según las reglas especificadas
        switch (tipoComponente.toLowerCase()) {
            case "chaqueta":
                System.out.println("Ingrese el número de botones de la chaqueta: ");
                int numBotones = scanner.nextInt();
                precio += numBotones * 2; // Se añaden 2 euros por cada botón
                break;
            case "pantalón":
            case "falda":
                System.out.println("¿Tiene cremallera? (true/false): ");
                boolean conCremallera = scanner.nextBoolean();
                if (conCremallera) {
                    precio += 1; // Se añade 1 euro si tiene cremallera
                }
                break;
        }
            }
              if (tipoComponente.equalsIgnoreCase("blusa")) {
            System.out.println("¿Es manga larga? (true/false): ");
            boolean mangaLarga = scanner.nextBoolean();
            for (Componente componente : componentesEnAlmacen) {
                if (componente instanceof Blusa && componente.getColor().equalsIgnoreCase(color)) {
                    Blusa blusaExistente = (Blusa) componente;
                    if (blusaExistente.isMangaLarga() != mangaLarga) {
                        throw new MangaException("No se puede añadir una blusa de manga larga al almacén si no existe ya en el almacén una blusa de manga corta del mismo color, y viceversa.");
                    }
                }
            }
        }

        // Validar la proporción de componentes extracomunitarios
        if (!esComunitario && (contarComponentesExtracomunitarios() + 1) > componentesEnAlmacen.size() / 2) {
            throw new MuchoExtracomunitarioException("No se puede añadir un componente extracomunitario porque ya hay más del 50% de componentes extracomunitarios en el almacén.");
        }

        // Crear y añadir el componente al almacén
        Componente componente = null;
        switch (tipoComponente.toLowerCase()) {
            case "chaqueta":
                componente = new Chaqueta(id, nombre, talla, color, esComunitario, precio, numBotones);
                break;
            case "pantalón":
                componente = new Pantalon(id, nombre, talla, color, esComunitario, precio, conCremallera);
                break;
            case "falda":
                componente = new Falda(id, nombre, talla, color, esComunitario, precio, conCremallera);
                break;
            case "blusa":
                componente = new Blusa(id, nombre, talla, color, esComunitario, precio, mangaLarga);
                break;
        }
        if (componente != null) {
            componentesEnAlmacen.add(componente);
            System.out.println("Componente añadido al almacén exitosamente.");
        }
    }

    
    private int contarComponentesExtracomunitarios() {
        int contador = 0;
        for (Componente componente : componentesEnAlmacen) {
            if (!componente.isEsComunitario()) {
                contador++;
            }
        }
        return contador;
    }
}

            @Override
            public void listarComponentes() {
        if (componentesEnAlmacen.isEmpty()) {
            System.out.println("No hay componentes en el almacén.");
        } else {
            System.out.println("Componentes en el almacén:");
            for (Componente componente : componentesEnAlmacen) {
                System.out.println(componente);
            }

            @Override
             public void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException {
        Scanner scanner = new Scanner(System.in);

        // Listar blusas existentes y pedir al usuario que elija una
        System.out.println("Blusas existentes en el almacén:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Blusa) {
                System.out.println("ID: " + componente.getId() + ", Nombre: " + componente.getNombre());
            }
        }
        System.out.println("Ingrese el ID de la blusa que desea para el traje: ");
        int idBlusa = scanner.nextInt();
        Blusa blusaSeleccionada = null;
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == idBlusa && componente instanceof Blusa) {
                blusaSeleccionada = (Blusa) componente;
                break;
            }
        }
        if (blusaSeleccionada == null) {
            System.out.println("No se ha encontrado ninguna blusa con el ID especificado.");
            return;
        }

        // Listar chaquetas existentes y pedir al usuario que elija una
        System.out.println("Chaquetas existentes en el almacén:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Chaqueta) {
                System.out.println("ID: " + componente.getId() + ", Nombre: " + componente.getNombre());
            }
        }
        System.out.println("Ingrese el ID de la chaqueta que desea para el traje: ");
        int idChaqueta = scanner.nextInt();
        Chaqueta chaquetaSeleccionada = null;
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == idChaqueta && componente instanceof Chaqueta) {
                chaquetaSeleccionada = (Chaqueta) componente;
                break;
            }
        }
        if (chaquetaSeleccionada == null) {
            System.out.println("No se ha encontrado ninguna chaqueta con el ID especificado.");
            return;
        }

        // Listar faldas y pantalones existentes y pedir al usuario que elija uno
        System.out.println("Faldas y pantalones existentes en el almacén:");
        for (Componente componente : componentesEnAlmacen) {
            if (componente instanceof Falda || componente instanceof Pantalon) {
                System.out.println("ID: " + componente.getId() + ", Nombre: " + componente.getNombre());
            }
        }
        System.out.println("Ingrese el ID de la falda o pantalón que desea para el traje: ");
        int idFaldaPantalon = scanner.nextInt();
        Componente faldaPantalonSeleccionado = null;
        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == idFaldaPantalon && (componente instanceof Falda || componente instanceof Pantalon)) {
                faldaPantalonSeleccionado = componente;
                break;
            }
        }
        if (faldaPantalonSeleccionado == null) {
            System.out.println("No se ha encontrado ninguna falda o pantalón con el ID especificado.");
            return;
        }

        // Validaciones adicionales antes de crear el traje
        if (!sonColoresAmigos(blusaSeleccionada.getColor(), chaquetaSeleccionada.getColor())) {
            throw new ColoresException("Los colores de la blusa y la chaqueta no son amigos.");
        }
        if (!blusaSeleccionada.getTalla().equals(chaquetaSeleccionada.getTalla())) {
            throw new TallaException("La talla de la blusa y la chaqueta no son iguales.");
        }
        if (!blusaSeleccionada.getTalla().equals(faldaPantalonSeleccionado.getTalla())) {
            throw new TallaException("La talla de la blusa y el pantalón/falda no son iguales.");
        }
        for (Traje traje : trajesEnAlmacen) {
            if (traje.getNombre().equals(blusaSeleccionada.getNombre())) {
                throw new TrajeYaExisteException("Ya existe un traje con el nombre de la blusa especificada.");
            }

 // Crear el traje y añadirlo al almacén
        Traje nuevoTraje = new Traje(chaquetaSeleccionada, blusaSeleccionada, faldaPantalonSeleccion)


            @Override
            public void listarTrajes() {
        if (trajesEnAlmacen.isEmpty()) {
            System.out.println("No hay trajes en el almacén.");
        } else {
            System.out.println("Trajes en el almacén:");
            for (Traje traje : trajesEnAlmacen) {
                System.out.println(traje);
            }


            @Override
              public void activarDesactivarRebajas() {
        sonRebajas = !sonRebajas;
        System.out.println(sonRebajas ? "Rebajas activadas." : "Rebajas desactivadas.");
        
        // Ajustar los precios de los componentes
        for (Componente componente : componentesEnAlmacen) {
            if (sonRebajas) {
                componente.setPrecio(componente.getPrecio() * 0.9); // 10% de descuento
            } else {
                componente.setPrecio(componente.getPrecio() / 0.9); // Restaurar precio original
            }
        }

        // Ajustar los precios de los trajes
        for (Traje traje : trajesEnAlmacen) {
            if (sonRebajas) {
                traje.setPrecio(traje.getPrecio() * 0.9); // 10% de descuento
            } else {
                traje.setPrecio(traje.getPrecio() / 0.9); // Restaurar precio original
            }

            @Override
             public void crearEnvío() {
        Scanner scanner = new Scanner(System.in);
        Envio nuevoEnvio = new Envio();

        while (true) {
            System.out.println("Trajes disponibles en el almacén:");
            for (Traje traje : trajesEnAlmacen) {
                System.out.println("Nombre: " + traje.getNombre());
            }

            System.out.println("Ingrese el nombre del traje que desea añadir al envío (o 'salir' para finalizar): ");
            String nombreTraje = scanner.nextLine();
            if (nombreTraje.equalsIgnoreCase("salir")) {
                break;
            }

            Traje trajeSeleccionado = null;
            for (Traje traje : trajesEnAlmacen) {
                if (traje.getNombre().equalsIgnoreCase(nombreTraje)) {
                    trajeSeleccionado = traje;
                    break;
                }
            }

            if (trajeSeleccionado == null) {
                System.out.println("No se ha encontrado ningún traje con el nombre especificado.");
            } else {
                nuevoEnvio.agregarTraje(trajeSeleccionado);
                trajesEnAlmacen.remove(trajeSeleccionado);
                System.out.println("Traje añadido al envío.");
            }
        }

        if (!nuevoEnvio.getTrajes().isEmpty()) {
            envios.add(nuevoEnvio);
            System.out.println("Envío creado exitosamente con los siguientes trajes:");
            System.out.println(nuevoEnvio);
        } else {
            System.out.println("No se ha creado el envío porque no se han añadido trajes.");
        }
        };
        
       
    }
}
