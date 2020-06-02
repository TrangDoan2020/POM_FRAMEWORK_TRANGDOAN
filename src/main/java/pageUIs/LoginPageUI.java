package pageUIs;

public class LoginPageUI {
    public static final String RED_POPUP = "//div[@class='modal-content']/button[starts-with(@class,'close')]";
    public static final String WHITE_POPUP = "//button[starts-with(@class,'closeBtn')]";
    public static final String BTN_LOGIN_ON_TOP_BAR = "//button[@id='login']";
    public static final String LNKSENDOID = "//span[text()='Đã có SendoID']";
    public static final String TXTUSERNAME = "//input[@name='username']";
    public static final String TXTPASSWORD = "//input[@name='password']";
    public static final String BTN_LOGIN_ON_LOGIN_POPUP = "//button[starts-with(@class,'btnLogin')]";
    public static final String ERRORMESSAGE = "//p[starts-with(@class,'error')]";
    public static final String USER_MENU = "//button[@id='user_menu']";
    public static final String QUIT_BUTTON =    "//button[contains(@class,'quit')]";
    public static final String ITEM_ON_MENU = "//div[contains(@class,'userMenu')]//span[text()='%s']";
    //public static final String ITEM_ON_MENU = "//div[contains(@class,'userMenu')]//a[.='%s']";
}
