package frameworkUtils;

public class Selectors {
    // main page
        public static final String ALL_PRODUCTS_SELECTOR = "body > app-root > " +
            "div > mat-sidenav-container > mat-sidenav-content > app-search-result > " +
            "div > div > div.heading.mat-elevation-z6 > div.ng-star-inserted";

    // login page
        public static final String MODAL_OK_BUTTON = "#mat-dialog-0 > app-welcome-banner > " +
            "div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button." +
            "mat-button-base.mat-primary.ng-star-inserted";
        public static final String USERNAME_ID = "email";
        public static final String PASSWORD_ID = "password";
        public static final String SUBMIT_ID = "loginButton";

        public static final String REGISTER_URL = "#newCustomerLink > a";

    // register page

        public static final String REGISTER_HEADER = "body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-register > div > mat-card > h1";
        public static final String REGISTER_EMAIL = "emailControl";
    public static final String REGISTER_PASSWORD = "passwordControl";
    public static final String REGISTER_CONFIRM = "repeatPasswordControl";
    public static final String SECURITY_QUESTION = "#mat-select-0 > div";
    public static final String SECURITY_QUESTION1 = "#mat-option-0 > span";
    public static final String SECURITY_ANSWER = "securityAnswerControl";
    public static final String REGISTER_SUBMIT_BUTTON = "registerButton";
    public static final String BUTTON_MODAL_DISSAPEAR = "cdk-overlay-0";
}
