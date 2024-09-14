import java.util.ArrayList;
import java.util.List;

public class Employer {
    private String name;
    private List<JobOffer> jobOffers;

    public Employer(String name) {
        this.name = name;
        this.jobOffers = new ArrayList<>();
    }

    public void postJob(String title, String industry, String location, String contractType, String description) {
        JobOffer jobOffer = new JobOffer(title, industry, location, contractType, description, this.name);
        jobOffers.add(jobOffer);
    }

    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public String getName() {
        return name;
    }
}
