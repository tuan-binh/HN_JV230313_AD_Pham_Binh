import ra.config.ConfigScanner;
import ra.config.ValidateSinger;
import ra.config.ValidateSong;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.modal.Singer;
import ra.modal.Song;

import java.util.Calendar;
import java.util.Date;

public class Main {

   static SingerController singerController = new SingerController();
   static SongController songController = new SongController();

   public static void main(String[] args) {
      int choose;
      while (true) {
         System.out.println("************************MUSIC-MANAGEMENT*************************");
         System.out.println("1. Quản lý ca sĩ ");
         System.out.println("2. Quản lý bài hát");
         System.out.println("3. Tìm kiếm bài hát");
         System.out.println("4. Thoát");
         System.out.println("*****************************************************************");
         System.out.print("Mời bạn lựa chọn: ");
         choose = ConfigScanner.scanner().nextInt();
         switch (choose) {
            case 1:
               // menu manager singer
               menuManagerSinger();
               break;
            case 2:
               // menu manager song
               menuManagerSong();
               break;
            case 3:
               // search
               menuSearch();
               break;
            case 4:
               System.out.println("Cảm ơn bạn đã sử dụng chương trình");
               System.exit(0);
               break;
            default:
               System.err.println("Vui lòng chọn lại (1 -> 4)");
               break;
         }
      }
   }
   // Phương thức làm việc

   // ============ quản lý ca sĩ ============
   public static void menuManagerSinger() {
      int choose;
      while (true) {
         System.out.println("**********************SINGER-MANAGEMENT*************************");
         System.out.println("1. Thêm thông tin ca sĩ");
         System.out.println("2. Hiển thị danh sách ca sĩ");
         System.out.println("3. Sửa thông tin ca sĩ");
         System.out.println("4. Xóa thông tin ca sĩ");
         System.out.println("5. Thoát");
         System.out.println("*****************************************************************");
         System.out.print("Mời bạn lựa chọn: ");
         choose = ConfigScanner.scanner().nextInt();
         switch (choose) {
            case 1:
               // add
               addNewSinger();
               break;
            case 2:
               // show
               showListSinger();
               break;
            case 3:
               // edit
               editSinger();
               break;
            case 4:
               // delete
               deleteSinger();
               break;
            case 5:
               // out
               break;
            default:
               System.err.println("Vui lòng chọn lại (1 -> 5)");
               break;
         }
         if (choose == 5) {
            break;
         }
      }
   }

   // add new singer
   public static void addNewSinger() {
      System.out.print("Nhập vào số lượng bạn muốn thêm: ");
      int n = ConfigScanner.scanner().nextInt();
      for (int i = 0; i < n; i++) {
         System.out.println("Ca sĩ thứ " + (i + 1));
         Singer singer = new Singer();
         singer.setSingerId(singerController.getNewId());
         // check name
         while (true) {
            System.out.print("Nhập tên ca sĩ: ");
            String name = ConfigScanner.scanner().nextLine();
            if (ValidateSinger.checkSpace(name)) {
               singer.setSingerName(name);
               break;
            }
         }
         // check age
         while (true) {
            System.out.print("Nhập tuổi ca sĩ: ");
            int age = ConfigScanner.scanner().nextInt();
            if (ValidateSinger.validateAge(age)) {
               singer.setAge(age);
               break;
            }
         }
         // check nationality
         while (true) {
            System.out.print("Nhập vào quốc tịch: ");
            String nationality = ConfigScanner.scanner().nextLine();
            if (ValidateSinger.checkSpace(nationality)) {
               singer.setNationality(nationality);
               break;
            }
         }
         System.out.print("Nhập vào giới tính (true: Nam false: Nữ): ");
         singer.setGender(ConfigScanner.scanner().nextBoolean());
         // check genre
         while (true) {
            System.out.print("Nhập vào tên thể loại: ");
            String genre = ConfigScanner.scanner().nextLine();
            if (ValidateSinger.checkSpace(genre)) {
               singer.setGenre(genre);
               break;
            }
         }
         singerController.save(singer);
      }
   }

   // show list singer
   public static void showListSinger() {
      if (singerController.getSize() == 0) {
         System.err.println("Danh sách trống");
         return;
      }
      for (Singer singer : singerController.getAll()) {
         if (singer != null) {
            System.out.println(singer);
         }
      }
      System.out.println("-------------------------------------------------");
   }

   // edit singer
   public static void editSinger() {
      System.out.print("Bạn muốn sửa ca sĩ có id là: ");
      int id = ConfigScanner.scanner().nextInt();
      Singer singer = singerController.findById(id);
      if (singer == null) {
         System.err.println("Không có ca sĩ này");
         return;
      }
      while (true) {
         System.out.printf("Nhập tên ca sĩ mới (tên cũ: %s): ", singer.getSingerName());
         String name = ConfigScanner.scanner().nextLine();
         if (ValidateSinger.checkSpace(name)) {
            singer.setSingerName(name);
            break;
         }
      }
      // check age
      while (true) {
         System.out.printf("Nhập tuổi ca sĩ mới (tuổi cũ: %d): ", singer.getAge());
         int age = ConfigScanner.scanner().nextInt();
         if (ValidateSinger.validateAge(age)) {
            singer.setAge(age);
            break;
         }
      }
      // check nationality
      while (true) {
         System.out.printf("Nhập vào quốc tịch mới (quốc tịch cũ: %s): ", singer.getNationality());
         String nationality = ConfigScanner.scanner().nextLine();
         if (ValidateSinger.checkSpace(nationality)) {
            singer.setNationality(nationality);
            break;
         }
      }
      System.out.printf("Nhập vào giới tính mới (giới tính cũ: %s)(true: Nam false: Nữ): ", singer.isGender() ? "Nam" : "Nữ");
      singer.setGender(ConfigScanner.scanner().nextBoolean());
      // check genre
      while (true) {
         System.out.printf("Nhập vào tên thể loại mới (thể loại cũ: %s): ", singer.getGenre());
         String genre = ConfigScanner.scanner().nextLine();
         if (ValidateSinger.checkSpace(genre)) {
            singer.setGenre(genre);
            break;
         }
      }
      singerController.save(singer);
   }

   // delete singer
   public static void deleteSinger() {
      System.out.print("Bạn muốn xóa ca sĩ có id là: ");
      int id = ConfigScanner.scanner().nextInt();
      singerController.delete(id);
   }

   // ============ quản lý bài hát ============
   public static void menuManagerSong() {
      int choose;
      while (true) {
         System.out.println("**********************SONG-MANAGEMENT*************************");
         System.out.println("1. Thêm bài hát");
         System.out.println("2. Hiển thị danh sách bài hát");
         System.out.println("3. Sửa thông tin bài hát");
         System.out.println("4. Xóa bài hát");
         System.out.println("5. Thoát");
         System.out.println("**************************************************************");
         System.out.print("Mời bạn lựa chọn: ");
         choose = ConfigScanner.scanner().nextInt();
         switch (choose) {
            case 1:
               // add
               addNewSong();
               break;
            case 2:
               // show
               showListSong();
               break;
            case 3:
               // edit
               editSong();
               break;
            case 4:
               // delete
               deleteSong();
               break;
            case 5:
               // out
               break;
            default:
               System.err.println("Vui lòng chọn lại (1 -> 5)");
               break;
         }
         if (choose == 5) {
            break;
         }
      }
   }

   // add song to list song
   public static void addNewSong() {
      Date date = new Date();
      System.out.print("Nhập vào số lượng bạn muốn thêm: ");
      int n = ConfigScanner.scanner().nextInt();
      for (int i = 0; i < n; i++) {
         System.out.println("Bài hát thứ " + (i + 1));
         Song song = new Song();
         song.setSongId(songController.getNewId());
         // check name song
         while (true) {
            System.out.print("Nhập tên bài hát: ");
            String name = ConfigScanner.scanner().nextLine();
            if (ValidateSong.checkSpace(name)) {
               song.setSongName(name);
               break;
            }
         }
         // check mô tả
         while (true) {
            System.out.print("Nhập mô tả bài hát: ");
            String description = ConfigScanner.scanner().nextLine();
            if (ValidateSong.checkSpace(description)) {
               song.setDescription(description);
               break;
            }
         }
         // check singer
         while (true) {
            System.out.print("Bạn muốn chọn id singer nào: ");
            int id = ConfigScanner.scanner().nextInt();
            Singer singer = singerController.findById(id);
            if (singer != null) {
               song.setSinger(singer);
               break;
            } else {
               System.err.println("Không có ca sĩ đó");
            }
         }
         // check song writer
         while (true) {
            System.out.print("Nhập tên người sáng tác: ");
            String nameWriter = ConfigScanner.scanner().nextLine();
            if (ValidateSong.checkSpace(nameWriter)) {
               song.setSongWriter(nameWriter);
               break;
            }
         }
         song.setCreatedDate(date);
         songController.save(song);
      }
   }

   // show list song
   public static void showListSong() {
      if (songController.getSize() == 0) {
         System.err.println("Danh sách bài hát trống");
         return;
      }
      for (Song song : songController.getAll()) {
         if (song != null) {
            System.out.println(song);
         }
      }
      System.out.println("-------------------------------------------------");
   }

   // edit song
   public static void editSong() {
      Date date = new Date();
      System.out.print("Bạn muốn xóa bài hát có id là: ");
      String idSong = ConfigScanner.scanner().nextLine();
      Song song = songController.findById(idSong);
      if (song == null) {
         System.err.println("Không có bài hát này trong danh sách");
         return;
      }
      // check name song
      while (true) {
         System.out.printf("Nhập tên bài hát (tên cũ: %s): ", song.getSongName());
         String name = ConfigScanner.scanner().nextLine();
         if (ValidateSong.checkSpace(name)) {
            song.setSongName(name);
            break;
         }
      }
      // check mô tả
      while (true) {
         System.out.printf("Nhập mô tả bài hát (mô tả cũ: %s): ", song.getDescription());
         String description = ConfigScanner.scanner().nextLine();
         if (ValidateSong.checkSpace(description)) {
            song.setDescription(description);
            break;
         }
      }
      // check singer
      while (true) {
         System.out.printf("Bạn muốn chọn id singer nào (singer cũ: %s): ", song.getSinger().getSingerName());
         int id = ConfigScanner.scanner().nextInt();
         Singer singer = singerController.findById(id);
         if (singer != null) {
            song.setSinger(singer);
            break;
         } else {
            System.err.println("Không có ca sĩ đó");
         }
      }
      // check song writer
      while (true) {
         System.out.printf("Nhập tên người sáng tác (tên cũ: %s): ", song.getSongWriter());
         String nameWriter = ConfigScanner.scanner().nextLine();
         if (ValidateSong.checkSpace(nameWriter)) {
            song.setSongWriter(nameWriter);
            break;
         }
      }
      song.setCreatedDate(date);
      songController.save(song);
   }

   // delete song
   public static void deleteSong() {
      System.out.print("Bạn muốn xóa bài hát có id là: ");
      String id = ConfigScanner.scanner().nextLine();
      songController.delete(id);
   }

   // ============ menu search ============
   public static void menuSearch() {
      int choose;
      while (true) {
         System.out.println("*********************SEARCH-MANAGEMENT************************");
         System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
         System.out.println("2. Tìm kiếm bài hát theo tên hoặc thể loại");
         System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tăng dần");
         System.out.println("4. Hiển thị 10 bài hát được đăng gần nhất");
         System.out.println("5. Thoát");
         System.out.println("**************************************************************");
         System.out.print("Mời bạn lựa chọn: ");
         choose = ConfigScanner.scanner().nextInt();
         switch (choose) {
            case 1:
               // search bài hát tên ca sĩ hoặc thể loại
               search1();
               break;
            case 2:
               // search bài hát qua tên hoặc thể loại
               search2();
               break;
            case 3:
               // hiện thị danh sách bài bài theo thứ tự tăng dần
               sortSong();
               break;
            case 4:
               // hiển thị 10 bài hát gần nhất
               printTenSong();
               break;
            case 5:
               // out
               break;
            default:
               System.err.println("Vui lòng chọn lại (1 -> 5)");
               break;
         }
         if (choose == 5) {
            break;
         }
      }
   }

   // search bài hát tên ca sĩ hoặc thể loại
   public static void search1() {
      System.out.print("Nhập vào từ bạn muốn tìm: ");
      String text = ConfigScanner.scanner().nextLine();
      text.toLowerCase();
      boolean found = false;
      if (text.equals("")) {
         System.err.println("Nhập không hợp lệ");
      } else {
         for (Song song : songController.getAll()) {
            if (song != null) {
               if (song.getSinger().getSingerName().toLowerCase().contains(text) || song.getSinger().getGenre().toLowerCase().contains(text)) {
                  System.out.println(song);
                  found = true;
               }
            }
         }
         if (!found) {
            System.err.println("Không có bài hát nào");
         }
      }
   }

   // search bài hát qua tên hoặc thể loại
   public static void search2() {
      System.out.print("Nhập vào từ bạn muốn tìm: ");
      String text = ConfigScanner.scanner().nextLine();
      text.toLowerCase();
      boolean found = false;
      if (text.equals("")) {
         System.err.println("Nhập không hợp lệ");
      } else {
         for (Song song : songController.getAll()) {
            if (song != null) {
               if (song.getSongName().toLowerCase().contains(text) || song.getSinger().getGenre().toLowerCase().contains(text)) {
                  System.out.println(song);
                  found = true;
               }
            }
         }
         if (!found) {
            System.err.println("Không có bài hát nào");
         }
      }
   }

   // sort song
   public static void sortSong() {
      songController.sortSong();
      showListSong();
   }

   // print song 10 mới nhất
   public static void printTenSong() {
      songController.sortNguoc();
      Song[] list = songController.getAll();
      for (int i = 0; i < 10; i++) {
         System.out.println(list[i]);
      }
   }
}