package com.ics.demo.groupAspring.service;

import com.ics.demo.groupAspring.models.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();
    Actor findById(Long id);
    Actor create (Actor  actor);
    Actor update (Actor actor);
    Actor update( Long id, Actor actor);
    void delete(Long id);
}
