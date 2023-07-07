package com.view;

import java.util.Scanner;

import com.models.cConfig;

public class menuCreate {
    private static Scanner input = new Scanner(System.in);

    public static void menuCreate() {
            while(true) {
            
            System.out.print("\n====    MENU    ====\n"
            + "1. Register \n"
            + "2. Change Password \n"
            + "0. Exit\n"
            + "Input [1/2] :");
            
            String pilihan = input.next();

            if ( pilihan.equalsIgnoreCase("0")) {
                break;
            }

            switch (pilihan) {
                case "1":
                    register();
                    break;
                case "2":
                    changePassword();
                    break;
                case "0":
                    System.out.println("Exit App");
                    break;            
                default:
                    System.out.println("Wrong Choice!!!");
                    break;
            }
            
            // Close Scanner
            // input.close();
        }
    }
    public static void register() {
        // Header
        System.out.println("\n====    REGISTER    ====");
        // Isif

        System.out.print("Username : ");
        String regUsername = input.next();
        System.out.print("Password : ");
        String regPass = input.next();
        System.out.print("Re-Input Password : ");
        String regPass2 = input.next();

        if(regPass.equals(regPass2)) {
            System.out.println("REGISTER SUCCESS !");
            cConfig.register(regUsername, regPass);
        } else {
            System.out.println("Wrong Password");
            System.out.println("Failed to Add User!!");
        }
    }

    public static void changePassword() {
        
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n====    VALIDATION    ====\n");

        System.out.print("Username :");
        String userid = inputScanner.nextLine();

        System.out.print("Password :");
        String pass = inputScanner.nextLine();


        cConfig LoginUsecase = new cConfig();
        String sValidate = LoginUsecase.LoginValidate(userid, pass);

        if (sValidate.equals("")) {
            System.out.print("Input Password :");
            String passBaru = inputScanner.nextLine();
            System.out.print("Re-Input Your New Password :");
            String passBaru2 = inputScanner.nextLine();
            if(passBaru.equals(passBaru2)) {
                System.out.println("SUCCESS - Password has been updated");
                cConfig.upPassDataUser(userid,passBaru);
            } else {
                System.out.println("Failed! New Password Doesn't Match");
            }
            
        } else {
            System.out.println();
            System.out.println("LOGIN FAILED :( " +sValidate);
            menuCreate();
        }
        // inputScanner.close();

    }

    public static void dataUser() {
        // Header
        System.out.println("\n=    REGISTER    =");
        System.out.println(cConfig.dataUser());
    }
}
