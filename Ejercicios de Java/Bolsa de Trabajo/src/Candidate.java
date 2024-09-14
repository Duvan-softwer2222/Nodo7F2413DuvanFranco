public class Candidate {
    private String name;
    private String qualifications;
    private String experience;

    public Candidate(String name, String qualifications, String experience) {
        this.name = name;
        this.qualifications = qualifications;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getExperience() {
        return experience;
    }

    public void applyToJob(JobOffer job) {
        System.out.println(name + " ha aplicado al puesto de trabajo:");
        System.out.println(job);
        System.out.println("Calificaciones: " + qualifications);
        System.out.println("Experiencia: " + experience);
    }
}
