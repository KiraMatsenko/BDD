package data;

import lombok.Value;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataHelper {

    public static UserInfo validUser() {
        return new UserInfo("vasya", "qwerty123");
    }

    public static UserInfo invalidPassword() {
        return new UserInfo("vasya", "qwerty1234");
    }

    public static UserInfo invalidUser() {
        return new UserInfo("kolya", "123qwerty");
    }

    @Value
    public static class UserInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerifyInfo {
        private String code;

        public static String getCorrectCode() {
            return new String("12345");
        }

        public static String getIncorrectCode() {
            return new String("54321");
        }
    }

    @Value
    public static class CardsInfo {
        private String cardNumber;

        public static String getCard1() {
            return new String("5559 0000 0000 0001");
        }

        public static String getCard2() {
            return new String("5559 0000 0000 0002");
        }
    }
}