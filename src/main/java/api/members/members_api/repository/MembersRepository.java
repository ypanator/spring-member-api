package api.members.members_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.members.members_api.entity.Member;

@Repository
public interface MembersRepository extends JpaRepository<Member, Integer>, MembersDAO {
    
}
