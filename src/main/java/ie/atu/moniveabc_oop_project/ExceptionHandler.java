package ie.atu.moniveabc_oop_project;

public class ExceptionHandler {

    // Handle user registration exceptions
    public static void handleRegistration(Runnable registrationLogic) {
        try {
            registrationLogic.run();  // Execute the registration code
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    // Handle generic exceptions
    public static void handleGeneric(Runnable logic) {
        try {
            logic.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}