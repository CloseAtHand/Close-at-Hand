package dev.rainbowmirror.closeathand.domain.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{
    private final UserStore userStore;
    private final UserReader userReader;
    @Override
    public UserInfo getUserInfo(String userToken) {
        User user = userReader.getUser(userToken);
        return new UserInfo(user);
    }

    @Override
    public UserInfo insertUser(UserCommand.CreateCommand command) {
        User initUser = command.toEntity();
        User user = userStore.store(initUser);
        return new UserInfo(user);
    }

    @Override
    public UserInfo updateUser(UserCommand.UpdateCommand command) {
        User beforeUser = userReader.getUser(command.getUserToken());
        beforeUser.update(command);
        return new UserInfo(beforeUser);
    }

    @Override
    public UserInfo enableUser(String userToken) {
        User beforeUser = userReader.getUser(userToken);
        beforeUser.enable();
        return new UserInfo(beforeUser);
    }

    @Override
    public UserInfo disableUser(String userToken) {
        User beforeUser = userReader.getUser(userToken);
        beforeUser.disable();
        return new UserInfo(beforeUser);
    }

    @Override
    public UserInfo checkDuplicate(String account) {
        var user = userReader.getByAccount(account).orElse(null);
        if (user == null) return null;
        else return new UserInfo(user);
    }
}
