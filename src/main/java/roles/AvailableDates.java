package roles;

public class AvailableDates {



    private String day;
    private String month;
    private String year;

    private String installer;

    public AvailableDates(String day, String month, String year, String installer) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.installer=installer;
    }


    public String getDay() {
        return day;
    }


    public String getMonth() {
        return month;
    }


    public String getYear() {
        return year;
    }


    public String getInstaller() {
        return installer;
    }



}
