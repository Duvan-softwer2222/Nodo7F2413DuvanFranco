import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobPortal jobPortal = new JobPortal();

        // Registro de empleadores
        Employer employer1 = new Employer("Tech Solutions");
        Employer employer2 = new Employer("HealthCare Inc.");

        jobPortal.registerEmployer(employer1);
        jobPortal.registerEmployer(employer2);

        // Los empleadores publican ofertas
        employer1.postJob("Desarrollador Java", "Tecnología", "Madrid", "Tiempo completo", "Desarrollo de aplicaciones Java.");
        employer1.postJob("Administrador de sistemas", "Tecnología", "Barcelona", "Tiempo parcial", "Administración de servidores.");
        employer2.postJob("Enfermero", "Salud", "Valencia", "Tiempo completo", "Cuidado de pacientes en hospital.");

        // Búsqueda de empleos
        System.out.println("Introduce industria (o presiona Enter para omitir): ");
        String industry = scanner.nextLine();
        if (industry.isEmpty()) industry = null;

        System.out.println("Introduce ubicación (o presiona Enter para omitir): ");
        String location = scanner.nextLine();
        if (location.isEmpty()) location = null;

        System.out.println("Introduce tipo de contrato (o presiona Enter para omitir): ");
        String contractType = scanner.nextLine();
        if (contractType.isEmpty()) contractType = null;

        List<JobOffer> searchResults = jobPortal.searchJobs(industry, location, contractType);

        System.out.println("\nResultados de la búsqueda:");
        if (searchResults.isEmpty()) {
            System.out.println("No se encontraron trabajos que coincidan con los criterios.");
        } else {
            for (JobOffer job : searchResults) {
                System.out.println("\n" + job);
            }

            // Aplicación a empleo
            System.out.print("\n¿Deseas aplicar a un empleo? (sí/no): ");
            String apply = scanner.nextLine();
            if (apply.equalsIgnoreCase("sí")) {
                System.out.print("Introduce el título del trabajo al que deseas aplicar: ");
                String jobTitle = scanner.nextLine();

                for (JobOffer job : searchResults) {
                    if (job.getTitle().equalsIgnoreCase(jobTitle)) {
                        System.out.print("Introduce tu nombre: ");
                        String name = scanner.nextLine();

                        System.out.print("Introduce tus calificaciones: ");
                        String qualifications = scanner.nextLine();

                        System.out.print("Introduce tu experiencia: ");
                        String experience = scanner.nextLine();

                        Candidate candidate = new Candidate(name, qualifications, experience);
                        candidate.applyToJob(job);
                    }
                }
            }
        }
    }
}
