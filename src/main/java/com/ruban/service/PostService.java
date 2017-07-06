package com.ruban.service;

import com.ruban.entity.Twit;
import java.util.List;


public interface PostService {
    List<Twit> getAll();
    Twit save( String log, String post);
    List<Twit> getAllUserPost(String login);

}
