package com.ruban.controller;

import com.ruban.entity.Follow;
import com.ruban.entity.User;
import com.ruban.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/Follow")
public class FollowController {
    @Autowired
    private FollowService service;
    @RequestMapping(value = "/following/{log}", method = RequestMethod.GET)
    @ResponseBody
    public  List<User> getFollowing(@PathVariable("log") String login) {
        return service.getAllByLog(login);
    }

    @RequestMapping(value = "/follower", method = RequestMethod.POST)
    @ResponseBody
    public Follow saveFollow(@RequestBody Follow follow) {
        return service.save(follow);
    }

    @RequestMapping(value = "/follower/{log}", method = RequestMethod.GET)
    @ResponseBody
    public  List<User> getFollower(@PathVariable("log") String login) {
        return service.getByAllFollower(login);
    }


    @RequestMapping(value = "/isFollowed/{source}/{dest}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean saveFollow(@PathVariable("source") String source,@PathVariable("dest") String dest) {
        return service.IsFollowed(source,dest);
    }
}
