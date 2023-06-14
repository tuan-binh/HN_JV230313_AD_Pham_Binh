package ra.config;

public class ValidateSong {
   //   validate không được để trống
   public static boolean checkSpace(String str) {
      if (str.trim().equals("")) {
         System.err.println("Không được để trắng hoặc bỏ trống");
         return false;
      }
      return true;
   }
}
