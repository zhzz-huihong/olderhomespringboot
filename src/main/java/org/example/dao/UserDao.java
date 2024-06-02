package org.example.dao;

import org.example.pojo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author haoren
 * @date 2024/06/02 15:14
 **/
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
}
