package roles;

public class AvailableDates {



    private String date;

    private String installer;

    public AvailableDates(String date, String installer) {

        this.date = date;
        this.installer=installer;
    }


    public String getDate() {
        return date;
    }




    public String getInstaller() {
        return installer;
    }



}
