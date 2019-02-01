package Car;

public class Car {
   public String make;
   public String model;
   public int horsePower;

   public String getInfo(){
      return this.make+" "+this.model+" - "+this.horsePower+" HP.";
   }

   public String getMake() {
      return make;
   }

   public void setMake(String make) {
      this.make = make;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getHorsePower() {
      return horsePower;
   }

   public void setHorsePower(int horsePower) {
      this.horsePower = horsePower;
   }
}
