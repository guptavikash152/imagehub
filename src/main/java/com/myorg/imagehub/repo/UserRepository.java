package com.myorg.imagehub.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myorg.imagehub.model.UserProfile;

@Repository
public interface UserRepository extends CrudRepository<UserProfile, String>{

}
