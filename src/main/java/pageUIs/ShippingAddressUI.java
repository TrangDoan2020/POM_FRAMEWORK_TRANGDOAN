package pageUIs;

public class ShippingAddressUI {
    public static final String USER_MENU = "//button[@id='user_menu']";
    public static final String ITEM_ON_MENU = "//div[contains(@class,'userMenu')]//a[.='%s']";
    public static final String LNK_SHIPPING_ADDRESS = "//a[text()='Địa chỉ nhận hàng']";
    public static final String EDIT_BUTTON = "//button[contains(@class,'edit')]";
    public static final String FIRST_NAME_TEXTBOX = "//input[@name = 'firstName']";
    public static final String LAST_NAME_TEXTBOX = "//input[@name = 'lastName']";
    public static final String ADDRESS_TEXTBOX = "//input[@name = 'address']";
    public static final String DRP_CITY = "//select[@id='region']";
    public static final String DRP_DISTRICT = "//select[@id='district']";
    public static final String DRP_WARD = "//select[@id='ward']";
    public static final String PHONE_NUMBER_TEXTBOX = "//input[@name = 'phone']";
    public static final String ADDRESS_SUBMIT_BUTTON = "//button[starts-with(@class, 'addressSubmit')]";
    public static final String FIRST_NAME_ERROR_MESSAGE = "//input[@name = 'firstName']/following-sibling::div[contains(text(),'Nội dung bắt buộc')]";
    public static final String LAST_NAME_ERROR_MESSAGE = "//input[@name = 'lastName']/following-sibling::div[contains(text(),'Nội dung bắt buộc')]";
    public static final String ADDRESS_ERROR_MESSAGE = "//input[@name = 'address']/following-sibling::div[contains(text(),'Nội dung bắt buộc')]";
    public static final String DRP_CITY_ERROR_MESSAGE = "//div[starts-with(@class,'toast')]/div/p";
    public static final String DRP_DISTRICT_ERROR_MESSAGE = "//div[starts-with(@class,'toast')]/div/p";
    public static final String DRP_WARD_ERROR_MESSAGE = "//div[starts-with(@class,'toast')]/div/p";
    public static final String PHONE_NUMBER_ERROR_MESSAGE = "//input[@name = 'phone']/following-sibling::div[contains(text(),'Nội dung bắt buộc')]";
    public static final String SUCCESS_MESSAGE = "//div[starts-with(@class,'toast')]/div/p";
}
