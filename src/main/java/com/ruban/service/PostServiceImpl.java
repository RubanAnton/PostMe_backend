package com.ruban.service;

import com.ruban.entity.Twit;
import com.ruban.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {



    @Autowired
    private PostRepository repository;
    @Transactional(readOnly=true)
    public List<Twit> getAll() {
        return repository.findAll();
    }

    public Twit save(String log,String post) {
        Twit tw=new Twit();
        tw.setLogin(log);
        tw.setPostText(post);
        return repository.saveAndFlush(tw);
    }

    public List<Twit> getAllUserPost(String login) {
        List<Twit> twit = new ArrayList<Twit>();
        List<Twit> all_l=repository.findAll();
        for (Twit l: all_l
             ) {
         if(l.getLogin().equals(login)){twit.add(l);}

        }
        return twit;
    }
}
