package api.members.members_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.members.members_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
