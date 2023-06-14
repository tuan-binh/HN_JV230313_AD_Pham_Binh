package ra.config;

public class ValidateSinger {
   //   validate không được để trống
   public static boolean checkSpace(String str) {
      if (str.trim().equals("")) {
         System.err.println("Không được để trắng hoặc bỏ trống");
         return false;
      }
      return true;
   }
//   validate age
   public static boolean validateAge(int age) {
      if(age<=0) {
         System.err.println("Tuổi không hợp lệ");
         return false;
      }
      return true;
   }
}
