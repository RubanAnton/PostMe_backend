package com.ruban.service;

import com.ruban.entity.Follow;
import com.ruban.entity.User;
import java.util.List;


public interface FollowService {

    List<User> getAllByLog(String login);
    List<User> getByAllFollower(String login);
    Follow save (Follow f);
    Boolean IsFollowed (String source,String dest);
}
