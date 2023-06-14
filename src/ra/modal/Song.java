package ra.modal;

import java.util.Date;

public class Song {
   private String songId;
   private String songName;
   private String description;
   private Singer singer;
   private String songWriter;
   private Date createdDate;
   private boolean songStatus = true;

   public Song() {
   }

   public Song(String songId, String songName, String description, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
      this.songId = songId;
      this.songName = songName;
      this.description = description;
      this.singer = singer;
      this.songWriter = songWriter;
      this.createdDate = createdDate;
      this.songStatus = songStatus;
   }

   public String getSongId() {
      return songId;
   }

   public void setSongId(String songId) {
      this.songId = songId;
   }

   public String getSongName() {
      return songName;
   }

   public void setSongName(String songName) {
      this.songName = songName;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Singer getSinger() {
      return singer;
   }

   public void setSinger(Singer singer) {
      this.singer = singer;
   }

   public String getSongWriter() {
      return songWriter;
   }

   public void setSongWriter(String songWriter) {
      this.songWriter = songWriter;
   }

   public Date getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(Date createdDate) {
      this.createdDate = createdDate;
   }

   public boolean isSongStatus() {
      return songStatus;
   }

   public void setSongStatus(boolean songStatus) {
      this.songStatus = songStatus;
   }

   @Override
   public String toString() {
      return "-------------------------------------------------\n" +
              "ID: " + songId + " | Name: " + songName + " | Singer: " + singer.getSingerName() +
              "\nSongWriter: " + songWriter + " | CreatedDate: " + createdDate;
   }
}
