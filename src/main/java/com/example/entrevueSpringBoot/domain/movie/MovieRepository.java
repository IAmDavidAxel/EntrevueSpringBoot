package com.example.entrevueSpringBoot.domain.movie;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Film,Integer>
{

}
