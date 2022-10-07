package com.training.spring.advanced.security;

import org.springframework.data.repository.CrudRepository;

public interface IRestUserDao extends CrudRepository<RestUser,String> {

}
