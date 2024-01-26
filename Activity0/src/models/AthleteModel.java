package models;

public class AthleteModel {
    private String id, age, height, weight;
    private String sex;
    private String name, team, games, city, sport, medal;

    /**
     * Default constructor (Null object of AthleteModel)
     */
//    public AthleteModel(){
//        id = -1;
//        age = -1;
//        height = -1;
//        name = null;
//        sex = 'z';
//        team = null;
//        games = null;
//        city = null;
//        sport = null;
//        medal = null;
//    }

    /**
     * Constructor class overload
     *
     * @param id        ID of the athlete
     * @param name      Name of the athlete
     * @param sex       Sex of the athlete
     * @param age       Age of the athlete
     * @param height    Height of the athlete
     * @param weight    Weight of the athlete
     * @param team      Team of the athlete
     * @param games     Games played by the athlete
     * @param city      City of the athlete
     * @param sport     Sport played by the athlete
     * @param medal     Medal earned by the athlete
     */
//    public AthleteModel(int id, String name, char sex, int age, int height, int weight, String team,
//    String games, String city, String sport, String medal){
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        this.age = age;
//        this.height = height;
//        this.weight = weight;
//        this.team = team;
//        this.games = games;
//        this.city = city;
//        this.sport = sport;
//        this.medal = medal;
//    }
    public AthleteModel(String id, String name, String sex, String age, String height, String weight, String team,
                        String games, String city, String sport, String medal){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.games = games;
        this.city = city;
        this.sport = sport;
        this.medal = medal;
    }

    public String getId() {
        return id;
    }

    // Getter and setter methods
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public char getSex() {
//        return sex;
//    }
//
//    public void setSex(char sex) {
//        this.sex = sex;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }

    @Override
    public String toString() {
        return id.replaceAll("\"", "")+ "," + age.replaceAll("\"", "")+ "," + height.replaceAll("\"", "")+ "," +
                weight.replaceAll("\"", "")+ "," + sex.replaceAll("\"", "")+ "," + name.replaceAll("\"", "")+ ","
                + team.replaceAll("\"", "")+ "," + games.replaceAll("\"", "")+ "," + city.replaceAll("\"", "")+ ","
                + sport.replaceAll("\"", "")+ "," + medal.replaceAll("\"", "");
    }
}
