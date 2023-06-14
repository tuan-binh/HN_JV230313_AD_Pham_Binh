package ra.controller;

import ra.modal.Singer;
import ra.modal.Song;
import ra.service.SongService;

public class SongController {
   private SongService songService = new SongService();

   public Song[] getAll() {
      return songService.getAll();
   }

   public int getSize() {
      return songService.getSize();
   }

   public void save(Song song) {
      songService.save(song);
   }

   public void delete(String id) {
      songService.deleteSinger(id);
   }

   public String getNewId() {
      return songService.getNewId();
   }

   public Song findById(String id) {
      return songService.findById(id);
   }

   public void sortSong() {
      songService.sortSong();
   }

   public void sortNguoc() {
      songService.sortNguoc();
   }
}
