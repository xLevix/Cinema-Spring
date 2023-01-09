package com.kino.springjwt.service;

import com.kino.springjwt.entity.SamplePerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, UUID> {

}