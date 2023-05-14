package com.myorg.imagehub.repo;

import org.springframework.data.repository.CrudRepository;

import com.myorg.imagehub.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, String>{

}
