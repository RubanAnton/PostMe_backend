package com.ruban.service;

import com.ruban.entity.Follow;
import com.ruban.entity.User;
import com.ruban.repository.FollowRepository;
import com.ruban.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    private UserRepository repository_user;
    @Autowired
    private FollowRepository repository_follow;

    public List<User> getAllByLog(String login){
        List<User> us= new ArrayList<User>();
        List<User> user_all=repository_user.findAll();
        List<Follow> fl=repository_follow.findAll();
        for (Follow item: fl) {
            if(item.getFollower().equals(login)){
                String destination_user=item.getFollowing();
                for (User userr: user_all) {
                    if(userr.getLogin().equals(destination_user)){us.add(userr);}
                }
            }

        }
        return us;
    }

    public List<User> getByAllFollower(String login){
        List<User> us= new ArrayList<User>();
        List<User> user_all=repository_user.findAll();
        List<Follow> fl=repository_follow.findAll();
        for(Follow item : fl){
            if(item.getFollowing().equals(login)){
                String source = item.getFollower();
                for(User userr : user_all){
                    if(userr.getLogin().equals(source)){us.add(userr);}
                }
            }
        }
        return us;
    }

    public  Follow save (Follow follow){
        return repository_follow.saveAndFlush(follow);
    }

    public  Boolean IsFollowed (String source,String dest){
        List<Follow> lf=repository_follow.findAll();
        for (Follow item:lf) {
            if(item.getFollower().equals(source) && item.getFollowing().equals(dest)){
                return true;
            }
        }
        return false;
    }
}