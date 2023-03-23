package multi.second.project.domain.planner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import multi.second.project.domain.gallery.domain.Gallery;
import multi.second.project.domain.planner.domain.Planner;


@Repository
public interface PlannerRepository extends JpaRepository<Gallery, Long>, PlannerRepositoryExtension{

	Page<Planner> findByMemberUserId(String userId, Pageable pageable);
	
}
