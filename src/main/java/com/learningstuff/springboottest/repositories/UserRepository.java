package com.learningstuff.springboottest.repositories;

import com.learningstuff.springboottest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
