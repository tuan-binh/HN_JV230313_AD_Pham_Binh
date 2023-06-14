package ra.service;

import ra.modal.Singer;
import ra.modal.Song;

import java.util.Date;

public class SongService {
   private Song[] listSong = new Song[100];
   private int size = 0;

   public Song[] getAll() {
      return listSong;
   }

   public int getSize() {
      return size;
   }

   // thêm và sửa thông tin bài hát
   public void save(Song song) {
      if (findById(song.getSongId()) == null) {
         if (size == 100) {
            System.err.println("~~ Danh sách đã đầy ~~");
            return;
         }
         for (int i = 0; i < listSong.length; i++) {
            if (listSong[i] == null) {
               listSong[i] = song;
               size++;
               break;
            }
         }
         System.out.println("~~ Thêm thành công ~~");
      } else {
         for (int i = 0; i < listSong.length; i++) {
            if (listSong[i].getSongId().equals(song.getSongId())) {
               listSong[i] = song;
               break;
            }
         }
         System.out.println("~~ Sửa thành công ~~");
      }
   }

   //   delete song
   public void deleteSinger(String id) {
      if (findById(id) != null) {
         for (int i = 0; i < listSong.length; i++) {
            if (listSong[i].getSongId().equals(id)) {
               listSong[i] = null;
               size--;
               break;
            }
         }
         System.out.println("~~ Xóa thành công ~~");
      } else {
         System.err.println("~~ Sách này không có ~~");
      }
   }

   public String getNewId() {
      String id = "S";
      int idMax = 0;
      for (Song song : listSong) {
         if (song != null) {
            int songId = Integer.parseInt(song.getSongId().replace("S", "0"));
            if (idMax < songId) {
               idMax = songId;
            }
         }
      }
      idMax += 1;
      String newId = Integer.toString(idMax);
      if (newId.length() == 1) {
         id += "0" + 0 + newId;
      }
      if (newId.length() == 2) {
         id += "0" + newId;
      }
      if (newId.length() == 3) {
         id = newId;
      }
      return id;
   }

   //   find book by id
   public Song findById(String id) {
      for (Song song : listSong) {
         if (song != null && song.getSongId().equals(id)) {
            return song;
         }
      }
      return null;
   }

   // sort bài hát theo thứ tự id
   public void sortSong() {
      for (int i = 0; i < listSong.length; i++) {
         if(listSong[i] != null) {
            int idI = Integer.parseInt(listSong[i].getSongId().replace("S", "0"));
            for (int j = i + 1; j < listSong.length; j++) {
               if(listSong[j] != null) {
                  int idJ = Integer.parseInt(listSong[j].getSongId().replace("S", "0"));
                  if (idI > idJ) {
                     Song temp = listSong[i];
                     listSong[i] = listSong[j];
                     listSong[j] = temp;
                  }
               }
            }
         }
      }
   }

   // sort ngược để lấy 10 bài mới nhất theo id
   public void sortNguoc() {
      for (int i = 0; i < listSong.length; i++) {
         if(listSong[i] != null) {
            int idI = Integer.parseInt(listSong[i].getSongId().replace("S", "0"));
            for (int j = i + 1; j < listSong.length; j++) {
               if(listSong[j] != null) {
                  int idJ = Integer.parseInt(listSong[j].getSongId().replace("S", "0"));
                  if (idI < idJ) {
                     Song temp = listSong[i];
                     listSong[i] = listSong[j];
                     listSong[j] = temp;
                  }
               }
            }
         }
      }
   }
}
