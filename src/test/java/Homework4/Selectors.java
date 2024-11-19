package Homework4;

public class Selectors {
    // main page
    public static final String MAIN_PAGE_HEADER = "body > app-root > " +
            "div > mat-sidenav-container > mat-sidenav-content > app-search-result > " +
            "div > div > div.heading.mat-elevation-z6 > div.ng-star-inserted";
    public static final String MAIN_TEXT = "All Products";

    public static final String ACCOUNT_BUTTON = "navbarAccount";

    public static final String LOGIN_BUTTON = "navbarLoginButton";
    public static final String OVERLAY_BUTTON = ".cdk-overlay-backdrop";
    public static final String DISMISS = "#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted";


    // login page
    public static final String LOGIN_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-login > div > mat-card > h1";
    public static final String LOGIN_TEXT = "Login";
    public static final String REGISTER_URL = "#newCustomerLink > a";


    public static final String REGISTER_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1";
    public static final String REGISTER_TEXT = "User Registration";
    public static final String MODAL_OK_BUTTON = "#mat-dialog-0 > app-welcome-banner > " +
            "div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button." +
            "mat-button-base.mat-primary.ng-star-inserted";
    public static final String MODAL = "mat-form-field";
    public static final String REGISTER_EMAIL = "emailControl";
    public static final String REGISTER_PASSWORD = "passwordControl";
    public static final String REGISTER_CONFIRM = "repeatPasswordControl";
    public static final String SECURITY_QUESTION = "securityQuestion";

    public static final String SECURITY_QUESTION1 = "#mat-option-4 > span"; // css
    public static final String SECURITY_ANSWER = "securityAnswerControl";
    public static final String REGISTER_SUBMIT_BUTTON = "registerButton";
    public static final String COOKIES_MODAL = "cdk-overlay-0";
    public static final String RESULT_MESSAGE = "simple-snack-bar span";
    public static final String INVALID_EMAIL = "mat-error-19";
    public static final String INVALID_EMAIL_TEXT = "Email address is not valid.";
    public static final String INVALID_PASSWORD = "mat-error-20";
    public static final String REPEAT_PASSWORD_TEXT = "Please repeat your password.";
    public static final String REPEAT_PASSWORD = "mat-error-21";
    public static final String WRONG_PASSWORD = "mat-error-16";
    public static final String INVALID_PASSWORD_TEXT="Please provide a password.";
    public static final String WRONG_PASSWORD_TEXT = "Passwords do not match";
    public static final String NO_ANSWER = "mat-error-18";
    public static final String NO_ANSWER_TEXT = "Please provide an answer to your security question.";


}
