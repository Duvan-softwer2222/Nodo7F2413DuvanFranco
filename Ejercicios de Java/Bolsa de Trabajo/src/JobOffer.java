public class JobOffer {
    private String title;
    private String industry;
    private String location;
    private String contractType;
    private String description;
    private String employerName;

    public JobOffer(String title, String industry, String location, String contractType, String description, String employerName) {
        this.title = title;
        this.industry = industry;
        this.location = location;
        this.contractType = contractType;
        this.description = description;
        this.employerName = employerName;
    }

    public String getTitle() {
        return title;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLocation() {
        return location;
    }

    public String getContractType() {
        return contractType;
    }

    public String getDescription() {
        return description;
    }

    public String getEmployerName() {
        return employerName;
    }

    @Override
    public String toString() {
        return "Título: " + title + "\nIndustria: " + industry + "\nUbicación: " + location +
                "\nTipo de contrato: " + contractType + "\nDescripción: " + description +
                "\nEmpleador: " + employerName;
    }
}
