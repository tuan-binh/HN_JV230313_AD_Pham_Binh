package ra.controller;

import ra.modal.Singer;
import ra.service.SingerService;

public class SingerController {

   private SingerService singerService = new SingerService();

   public Singer[] getAll() {
      return singerService.getAll();
   }

   public int getSize() {
      return singerService.getSize();
   }

   public void save(Singer singer) {
      singerService.save(singer);
   }

   public void delete(int id) {
      singerService.deleteSinger(id);
   }

   public int getNewId() {
      return singerService.getNewId();
   }

   public Singer findById(int id) {
      return singerService.findById(id);
   }
}
