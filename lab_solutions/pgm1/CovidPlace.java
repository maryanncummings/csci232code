import java.util.Scanner;

public class CovidPlace implements Comparable<CovidPlace> {
    private String continent;
    private String country;
    private String date;
    private Long total_cases;
    private Long new_cases;
    private Long population;

    public CovidPlace(String[] lineData) {
        
        continent = new String(lineData[0]); // token containing continent
        country = new String(lineData[1]); // token containing country 
        date = new String(lineData[2]); // token containing date
        total_cases = Long.parseLong(lineData[3]); // token containing total covid cases
        new_cases = Long.parseLong(lineData[4]); // token containing new covid cases
        population = Long.parseLong(lineData[5]); // token containing population in country 
    }

    public CovidPlace() {
        country = new String("none");
    }

    public int compareTo(CovidPlace another) {
        if (this.new_cases < another.new_cases) return -1;
        if (this.new_cases > another.new_cases) return 1;
        //System.out.println("country is " + this.country + " " +
        //                   "this.newcases " + this.new_cases +
       //                 " another.newcases " + another.new_cases);
        return 0;
    }

    public String Location() {
        return country;
    }

    public String Continent() {
        return continent;
    }

    public String Date() {
        return date;
    }

    public Long TotalCases() {
        return total_cases;
    }

    public Long NewCases() {
        return new_cases;
    }

    public Long Population() {
        return population;
    }
}


