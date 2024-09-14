import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentManager manager = new DocumentManager();

        // Crear documentos
        System.out.println("Introduce el nombre del documento a crear (escribe 'fin' para terminar):");
        while (true) {
            String docName = scanner.nextLine();
            if (docName.equalsIgnoreCase("fin")) {
                break;
            }
            manager.createDocument(docName);
        }

        // Operaciones sobre documentos
        while (true) {
            System.out.println("\n1. Listar documentos\n2. Modificar documento\n3. Ver historial de versiones\n4. Restaurar versión\n5. Salir");
            System.out.print("Elige una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (option == 5) {
                System.out.println("Saliendo...");
                break;
            }

            switch (option) {
                case 1:
                    manager.listDocuments();
                    break;

                case 2:
                    System.out.print("Introduce el nombre del documento a modificar: ");
                    String docToModify = scanner.nextLine();
                    Document document = manager.getDocument(docToModify);

                    if (document != null) {
                        System.out.print("Introduce el nuevo contenido: ");
                        String newContent = scanner.nextLine();
                        document.modifyContent(newContent);
                        System.out.println("Contenido actualizado.");
                    } else {
                        System.out.println("Documento no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce el nombre del documento para ver el historial: ");
                    String docToView = scanner.nextLine();
                    Document documentToView = manager.getDocument(docToView);

                    if (documentToView != null) {
                        documentToView.displayVersions();
                    } else {
                        System.out.println("Documento no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el nombre del documento para restaurar una versión: ");
                    String docToRestore = scanner.nextLine();
                    Document documentToRestore = manager.getDocument(docToRestore);

                    if (documentToRestore != null) {
                        System.out.print("Introduce el número de versión a restaurar: ");
                        int version = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        documentToRestore.restoreVersion(version);
                    } else {
                        System.out.println("Documento no encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
