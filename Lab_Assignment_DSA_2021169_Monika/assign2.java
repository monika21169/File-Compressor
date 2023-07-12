import org.w3c.dom.ls.LSOutput;

import java.util.*;

class Admin{
    private String user_name;
    private String roll_no;
    Admin(){

     }
     Admin(String user_name,String roll_no){
        this.user_name=user_name;
        this.roll_no=roll_no;
     }
    static Scanner sd1 = new Scanner(System.in);
     ArrayList<Admin> enter_admin(ArrayList <Admin> listOfAdmin){
//         System.out.println("Dear Admin");
         System.out.println("Please enter your username and password");
         String name=sd1.nextLine();
         String roll_no=sd1.nextLine();
         listOfAdmin.add(new Admin(name,roll_no));
         return listOfAdmin;
     }
     static class log_in_admin{
         String user;
         String pass;

         log_in_admin(){

         }
         log_in_admin(String user,String pass){
             this.user=user;
             this.pass=pass;

         }
          void log_in(ArrayList<Admin> listOfAdmin,ArrayList <Add_Categ> listOfCateg){
              System.out.println("Dear Admin");
              System.out.println("Please enter your username and password");
              String name=sd1.nextLine();
              String roll_no=sd1.nextLine();
              for(Admin a: listOfAdmin){
                  if(a.user_name.compareTo(name)==1) {
                      if (a.roll_no.compareTo(roll_no) == 1) {
                          int in_6=1;
                          while (in_6==1){
                              System.out.println("Welcome " + a.user_name + "!!");
                              System.out.println("Please choose any one of the following actions:");
                              System.out.println("1) Add category");
                              System.out.println("2) Delete category");
                              System.out.println("3) Add Product");
                              System.out.println("4) Delete Product");
                              System.out.println("5) Set Discount on Product");
                              System.out.println("6) Add giveaway deal");
                              System.out.println("7) Back");
                              int in_7 = sd1.nextInt();
                              if(in_7==1){
                                    Add_Categ ad=new Add_Categ();
                                    ad.add_in(listOfCateg);
                              }
                              else if(in_7==2){
                                  Admin da=new Admin();
                                  da.delete_categ(listOfCateg);

                              }
                              else if(in_7==3){
                                  add_prod ad_p=new add_prod();
                                  ad_p.add_pro(listOfCateg);

                              }
                              else if(in_7==4){

                              }
                              else if(in_7==5){

                              }
                              else if(in_7==6){

                              }
                              else {
                                in_6=0;
                              }
                         }
                      }
                  }
              }
          }
     }

     static class Add_Categ extends Admin{
         int categ_ID;
         String name_categ;
         ArrayList <String> prod;
         int num_pro;

         Add_Categ(){

         }
         Add_Categ(int categ_ID,String name_categ,ArrayList<String> prod,int num_pro){
             this.categ_ID=categ_ID;
             this.name_categ=name_categ;
             this.prod=prod;
             this.num_pro=num_pro;
         }
         ArrayList<Add_Categ> add_in(ArrayList <Add_Categ> listOfCateg){
             System.out.println("Add category ID");
             int categ_ID=sd1.nextInt();
             //Add_Categ.categ_ID+=1;
             System.out.println(categ_ID);
             System.out.println("Add name of the category");
             String name=sd1.nextLine();
             ArrayList<String> prod=new ArrayList<>();
             System.out.println("Add a Product:-");
             System.out.println("How many information about product you want to add: ");
             int in_pro=sd1.nextInt();
             System.out.print("Product Name: ");
             String p_n=sd1.nextLine();
             System.out.print("Product ID: ");
             String p_i=sd1.nextLine();
             prod.add(p_n);
             prod.add(p_i);
             for(int i=2;i<in_pro-1;i+=1){
                 String p=sd1.nextLine();
                 prod.add(p);
             }
             System.out.print("Price: ");
             String p_p=sd1.nextLine();
             prod.add(p_p);
             listOfCateg.add(new Add_Categ(categ_ID,name,prod,in_pro));

             return listOfCateg;
         }

     }
    static class add_prod extends Add_Categ{
         ArrayList<String> product;
         add_prod(){

         }
         add_prod(ArrayList<String> product){
             this.product=product;
         }
        ArrayList<Add_Categ> add_pro(ArrayList <Add_Categ> listOfCateg){
            System.out.println("Enter category ID");
            int cat_id=sd1.nextInt();
            for(Add_Categ adc: listOfCateg){
                if(cat_id == adc.categ_ID){
                    System.out.println("Add a Product:-");
                    for(int j=0;j<abc.in_pro;j++){
                        String sd=sd1.nextLine();
                    }
                }
            }
             return listOfCateg;
        }


    }

    ArrayList<Add_Categ> delete_categ (ArrayList<Add_Categ> listOfCateg){
        System.out.println("Enter category ID you want to delete");
        int cat_id_del=sd1.nextInt();
        for(Add_Categ acv:listOfCateg){
            if (acv.categ_ID==cat_id_del){
                listOfCateg.remove(acv.categ_ID);
                listOfCateg.remove(acv.name_categ);
                listOfCateg.remove(acv.prod);
            }
        }
         return  listOfCateg;
    }





}


class Customer{
    String name;
    int age;
    int phone_number;
    String email_id;
    String password;
    String categ;
    protected float amount;

    Customer(){

    }
    Customer(String name, int age, int phone_number,String email_id, String password,String categ,float amount){
        this.name=name;
        this.age=age;
        this.phone_number=phone_number;
        this.email_id=email_id;
        this.password=password;
        this.categ="NORMAL";
        this.amount=1000;

    }
    static Scanner sd = new Scanner(System.in);
    ArrayList<Customer> Sign_up(ArrayList <Customer> list0fcust){
//        Scanner sd = new Scanner(System.in);
        String name=sd.nextLine();
        int age=sd.nextInt();
        int phone_number=sd.nextInt();
        String email_id=sd.nextLine();
        String password=sd.nextLine();

        list0fcust.add(new Customer(name,age,phone_number,email_id,password,categ,amount));
        System.out.println("customer successfully registered!!");
        return list0fcust;
    }

    static class log_in extends Customer {
        String name;
        String email_id;
        String password;
        log_in() {

        }
        log_in(String name,String email_id,String password){
            this.name=name;
            this.email_id=email_id;
            this.password=password;
        }
        int log_inf(ArrayList <Customer> list0fcust){
            String name=sd.nextLine();
            String email_id=sd.nextLine();
            String password=sd.nextLine();
            int r=0;
            for(Customer c:list0fcust){
                if((c.name).compareTo(name)==1){
                    if((c.email_id).compareTo(email_id)==1){
                        if((c.password).compareTo(password)==1){
                            r=1;
                            int in_5=1;
                            while (in_5==1){
                                System.out.println("Welcome "+c.name+"!!");
                                System.out.println("1) browse products");
                                System.out.println("2) browse deals");
                                System.out.println("3) add a product to cart");
                                System.out.println("4) add products in deal to cart");
                                System.out.println("5) view coupons");
                                System.out.println("6) check account balance");
                                System.out.println("7) view cart");
                                System.out.println("8) empty cart");
                                System.out.println("9) checkout car");
                                System.out.println("10) upgrade customer status");
                                System.out.println("11) Add amount to wallet");
                                System.out.println("12) back");
                                int in_4=sd.nextInt();
                                if(in_4==1) {

                                }
                                else if(in_4==2){

                                }
                                else if(in_4==3){

                                }
                                else if(in_4==4){

                                }
                                else if(in_4==5){

                                }
                                else if(in_4==6){
                                    System.out.println("Current account balance is Rupees "+c.amount );

                                }
                                else if(in_4==7){

                                }
                                else if(in_4==8){

                                }
                                else if(in_4==9){

                                }
                                else if(in_4==10){
                                    upgrade u=new upgrade();

                                }
                                else if(in_4==11){

                                }
                                else{
                                    in_5=0;
                                    return 0;
                                }
                            }

                        }
                    }
                }
                else{
                    continue;
                }
            }
            return r;

        }
    }

    static class upgrade extends log_in{

        upgrade(){
            super();
            System.out.println("CURRENT STATUS: "+this.categ);
            System.out.println("CHOOSE NEW STATUS: ");
            String cat=sd.nextLine();
            if(this.amount>=200){
                if(cat=="PRIME"){
                    this.categ=cat;
                    this.amount-=200;
                }
                else{
                    if(this.amount>=300){
                        if(cat=="ELITE"){
                            this.categ=cat;
                            this.amount-=300;
                        }
                    }
                }
            }
            System.out.println("STATUS UPDATED TO "+this.categ);
        }


    }

    static class explore_prod extends upgrade{

    }
    static class add_prod extends explore_prod{

    }
    static class pay extends  add_prod{

    }

}


public class Main {
    public static void main(String[] args) {

        ArrayList <Customer> list0fcust=new ArrayList<Customer>();
        ArrayList <Admin> listOfAdmin=new ArrayList<Admin>();
        ArrayList <Admin.Add_Categ> listOfCateg= new ArrayList <>();
        int in_1=1;
        while (in_1==1){
            System.out.println("WELCOME TO FLIPZON");
            System.out.println("1) Enter as Admin");
            System.out.println("2) Explore the Product Catalog");
            System.out.println("3) Show Available Deals");
            System.out.println("4) Enter as Customer");
            System.out.println("5) Exit the Application");
            Scanner sc = new Scanner(System.in);
            int s1=sc.nextInt();
            if(s1==1){

            }
            else if (s1==2){

            }
            else if (s1==3) {

            }
            else if (s1==4) {
                int in_2 = 1;
                while (in_2 == 1) {
                    System.out.println("1) Sign up");
                    System.out.println("2) Log in");
                    System.out.println("3) Back");
                    int in_3 = sc.nextInt();
                    Customer cs = new Customer();
                    Customer.log_in cs_1=new Customer.log_in();
                    if (in_3 == 1) {
                        cs.Sign_up(list0fcust);
                    }
                    else if (in_3 == 2) {
                        cs_1.log_inf(list0fcust);
                    }
                    else{
                        in_2=0;
                    }

                }
            }
            else if (s1==5) {
                in_1=0;
            }
            else {
                System.out.println("INVALID OPTION");
            }
        }

    }
}