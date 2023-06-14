package ra.service;

import ra.modal.Singer;

public class SingerService {
   private Singer[] listSinger = new Singer[100];
   private int size = 3;
   // contructor


   public SingerService() {
      listSinger[0] = new Singer(1,"Thủy tiên",25,"Việt Nam",false,"KPOP");
      listSinger[1] = new Singer(2,"Hồ quang hiếu",40,"Việt Nam",true,"KPOP");
      listSinger[2] = new Singer(3,"Đen vâu",32,"Việt Nam",true,"RAP");
   }

   public Singer[] getAll() {
      return listSinger;
   }

   public int getSize() {
      return size;
   }

   // thêm và sửa thông tin ca sĩ
   public void save(Singer singer) {
      if (findById(singer.getSingerId()) == null) {
         if (size == 100) {
            System.err.println("~~ Danh sách đã đầy ~~");
            return;
         }
         for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i] == null) {
               listSinger[i] = singer;
               size++;
               break;
            }
         }
         System.out.println("~~ Thêm thành công ~~");
      } else {
         for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i].getSingerId() == singer.getSingerId()) {
               listSinger[i] = singer;
               break;
            }
         }
         System.out.println("~~ Sửa thành công ~~");
      }
   }

   //   delete singer
   public void deleteSinger(int id) {
      if (findById(id) != null) {
         for (int i = 0; i < listSinger.length; i++) {
            if (listSinger[i].getSingerId() == id) {
               listSinger[i] = null;
               size--;
               break;
            }
         }
         System.out.println("~~ Xóa thành công ~~");
      } else {
         System.err.println("~~ Sách này không có ~~");
      }
   }

   // lấy id mới tiếp theo
   public int getNewId() {
      int idMax = 0;
      for (Singer b : listSinger) {
         if (b != null && idMax < b.getSingerId()) {
            idMax = b.getSingerId();
         }
      }
      return idMax + 1;
   }

   //   find book by id
   public Singer findById(int id) {
      for (Singer book : listSinger) {
         if (book != null && book.getSingerId() == id) {
            return book;
         }
      }
      return null;
   }
}
