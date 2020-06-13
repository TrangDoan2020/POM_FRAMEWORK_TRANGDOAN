package pageUIs;

public class ProfilePageUI {
    public static final String USER_MENU = "//button[@id='user_menu']";
    public static final String ITEM_ON_MENU = "//div[contains(@class,'userMenu')]//a[.='%s']";
    public static final String CHANGE_AVATAR_BUTTON = "//button[contains(text(),'Thay đổi')]";
    public static final String CHOOSE_PHOTO_FROM_COMPUTER_BUTTON = "//div[@class='dropzone']";
    public static final String UPLOAD_SUBMIT_BUTTON = "//button[starts-with(@class,'primary')]";
    //public static final String UPLOAD_SUBMIT_BUTTON = "//div[contains(@class,'uploadSubmit')]//button[contains(@class,'primary')]";
    public static final String FIRST_NAME_TEXTBOX ="//input[@name='firstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@name='lastName']";
    public static final String GENDER_CHECKBOX = "//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String BIRTHDAY_DATE_PICKER = "//div[@class='DayPickerInput']";
    public static final String MONTH_DATE_PICKER = "//select[@id='month']";
    public static final String YEAR_DATE_PICKER = "//select[@id='year']";
    public static final String DAY_DATE_PICKER = "//div[starts-with(@class,'DayPicker-Day') and text()='%s']";
    public static final String USER_SUBMIT_BUTTON = "//button[contains(@class,'userSubmit')]";
    public static final String FIRST_NAME_ERROR_MESSAGE = "//input[@name='firstName']/following-sibling::div[contains(@class,'errorMessage')]";
    public static final String LAST_NAME_ERROR_MESSAGE = "//input[@name='lastName']/following-sibling::div[contains(@class,'errorMessage')]";
    public static final String SUCCESS_MESSAGE = "//div[starts-with(@class,'toast')]/div/p";
}
