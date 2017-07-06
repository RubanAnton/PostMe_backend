package com.ruban.controller;


import com.ruban.entity.Twit;
import com.ruban.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/PostList")
public class PostController {

    @Autowired
    private PostService service;
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    @ResponseBody
    public List<Twit> getAllPost() {
        return service.getAll();
    }


    @RequestMapping(value = "/savePost/{log}/{post}", method = RequestMethod.GET)
    @ResponseBody
    public Twit savePost(@PathVariable("log") String log,@PathVariable("post") String post) {
        return service.save(log,post);
    }
//
    @RequestMapping(value = "/postUser/{log}",method = RequestMethod.GET)
    @ResponseBody
    public List<Twit> getAllUserPost(@PathVariable("log") String login){return service.getAllUserPost(login);}

}
