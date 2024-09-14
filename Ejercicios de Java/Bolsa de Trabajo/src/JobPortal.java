import java.util.ArrayList;
import java.util.List;

public class JobPortal {
    private List<Employer> employers;

    public JobPortal() {
        this.employers = new ArrayList<>();
    }

    public void registerEmployer(Employer employer) {
        employers.add(employer);
    }

    public List<JobOffer> searchJobs(String industry, String location, String contractType) {
        List<JobOffer> result = new ArrayList<>();
        for (Employer employer : employers) {
            for (JobOffer job : employer.getJobOffers()) {
                if ((industry == null || job.getIndustry().equalsIgnoreCase(industry)) &&
                        (location == null || job.getLocation().equalsIgnoreCase(location)) &&
                        (contractType == null || job.getContractType().equalsIgnoreCase(contractType))) {
                    result.add(job);
                }
            }
        }
        return result;
    }
}
