package dev.rainbowmirror.closeathand.interfaces.user;

import dev.rainbowmirror.closeathand.domain.user.UserCommands;
import dev.rainbowmirror.closeathand.domain.user.UserInfo;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class SignupRequest {
        @NotEmpty(message = "check userName")
        private String userName;

        @NotEmpty(message = "check userName")
        private String account;

        @NotEmpty(message = "check userName")
        private String password;

        public UserCommands.UserCommand toCommand(){
            return UserCommands.UserCommand.builder()
                    .userName(userName)
                    .account(account)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class SignupResponse {
        private final String userToken;
        private final String userName;
        private final String height;
        private final String gender;

        public SignupResponse(UserInfo userInfo) {
            this.userToken = userInfo.getUserToken();
            this.userName = userInfo.getUserName();
            this.height = userInfo.getHeight();
            this.gender = userInfo.getGender();
        }
    }

    @Getter
    @Setter
    @ToString
    public static class updateRequest {
        private String userToken;
        private String userName;
        private String height;
        private String gender;
        private String account;
        private String password;
        public UserCommands.UpdateCommand toCommand(){
            return UserCommands.UpdateCommand.builder()
                    .userToken(userToken)
                    .userName(userName)
                    .height(height)
                    .gender(gender)
                    .account(account)
                    .password(password)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class UpdateResponse {
        private final String userToken;
        private final String userName;
        private final String height;
        private final String gender;
        public UpdateResponse(UserInfo userInfo) {
            this.userToken = userInfo.getUserToken();
            this.userName = userInfo.getUserName();
            this.height = userInfo.getHeight();
            this.gender = userInfo.getGender();
        }
    }

    @Getter
    @ToString
    public static class DeleteResponse {
        private final String userToken;
        private final String userName;
        private final String height;
        private final String gender;
        public DeleteResponse(UserInfo userInfo) {
            this.userToken = userInfo.getUserToken();
            this.userName = userInfo.getUserName();
            this.height = userInfo.getHeight();
            this.gender = userInfo.getGender();
        }
    }
}
