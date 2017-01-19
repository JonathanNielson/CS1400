public class TaxCalculation {

   public static void main (String[] args) {
   
      double dFoodTax = 0.03;
      double dOtherTax = 0.0675;
      double dFoodBill = 150.0;
      double dOtherBill = 50.0;
      double dSubTotal = 0.0;
      double dTotalTax = 0.0;
      double dTotal = 0.0;
     
      dSubTotal = (dFoodBill + dOtherBill);
      
      dTotalTax = ((dFoodTax * dFoodBill) + (dOtherTax * dOtherBill));
      
      dTotal = (dTotalTax + dFoodBill + dOtherBill);
      
      System.out.println("Your Subtotal is: " + dSubTotal);
      System.out.println("The total tax for your bill is: " + dTotalTax);
      System.out.println("Your Grand Total is: " + dTotal);
   
   
   }

}