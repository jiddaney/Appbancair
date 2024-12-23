class Validator {
    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]{2,}");
    }
    public static boolean isValidemail(String email) {
        return email.matches("[a-zA-Z0-9._%+6]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    }
    public static boolean isValidPhone(String phone) {
        return phone.matches("^(06|07|05)\\d{8}$");
    }
}
