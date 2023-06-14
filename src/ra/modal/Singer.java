package ra.modal;

public class Singer {
   private int singerId;
   private String singerName;
   private int age;
   private String nationality;
   private boolean gender;
   private String genre;

   public Singer() {
   }

   public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
      this.singerId = singerId;
      this.singerName = singerName;
      this.age = age;
      this.nationality = nationality;
      this.gender = gender;
      this.genre = genre;
   }

   public int getSingerId() {
      return singerId;
   }

   public void setSingerId(int singerId) {
      this.singerId = singerId;
   }

   public String getSingerName() {
      return singerName;
   }

   public void setSingerName(String singerName) {
      this.singerName = singerName;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getNationality() {
      return nationality;
   }

   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   public boolean isGender() {
      return gender;
   }

   public void setGender(boolean gender) {
      this.gender = gender;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   @Override
   public String toString() {
      return "-------------------------------------------------\n" +
              "ID: " + singerId + " | Name: " + singerName + " | Age: " + age +
              " | Nationality: " + nationality + " | gender: " + (gender ? "Nam" : "Nữ") + " | Genre: " + genre;
   }
}
