
package model;

/**
 *
 * @author dinhv
 */
public class Job {
    private String JobID;
    private String Title;
    private String DateClose;
    private String DateOpen;
    private String Location;
    private String Type;
    private String Description;
    private String Skills;

    public Job() {
    }

    public Job(String JobID, String Title, String DateClose, String DateOpen, String Location, String Type, String Description, String Skills) {
        this.JobID = JobID;
        this.Title = Title;
        this.DateClose = DateClose;
        this.DateOpen = DateOpen;
        this.Location = Location;
        this.Type = Type;
        this.Description = Description;
        this.Skills= Skills;
    }

    public String getJobID() {
        return JobID;
    }

    public void setJobID(String JobID) {
        this.JobID = JobID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDateClose() {
        return DateClose;
    }

    public void setDateClose(String DateClose) {
        this.DateClose = DateClose;
    }

    public String getDateOpen() {
        return DateOpen;
    }

    public void setDateOpen(String DateOpen) {
        this.DateOpen = DateOpen;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String Skill) {
        this.Skills = Skill;
    }



    @Override
    public String toString() {
        return "Job{" + "JobID=" + JobID + ", Title=" + Title + ", DateClose=" + DateClose + ", DateOpen=" + DateOpen + ", Location=" + Location + ", Type=" + Type + ", Description=" + Description + ", Skill=" + Skills +  '}';
    }
    

   

 
}
