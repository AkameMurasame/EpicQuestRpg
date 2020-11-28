package br.com.epicquest.rpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.epicquest.rpg.entity.Friendlist;

@Repository
public interface FriendListRepository extends JpaRepository<Friendlist, Long> {
	@Query("SELECT i FROM Friendlist i WHERE i.userId.id = :idUserRequest AND i.friendId.id = :iduserRecpt")
	public Friendlist getFriendlyRequest(@Param("idUserRequest") long idUserRequest, @Param("iduserRecpt") long iduserRecpt);
	
	@Query("SELECT i FROM Friendlist i WHERE (i.userId.id = :userId or i.friendId.id = :userId) AND i.status = 1")
	public List<Friendlist> getFriendList(@Param("userId") long userId);
}
