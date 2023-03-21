package multi.second.project.domain.planner;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import multi.second.project.domain.group.domain.TravelGroup;
import multi.second.project.domain.group.repository.TravelGroupRepository;
import multi.second.project.domain.member.UserPrincipal;
import multi.second.project.domain.planner.dto.PlanRecommandRequest;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecommandService {

	private final TravelGroupRepository travelGroupRepository;
	
	public String generateTravelPlan(PlanRecommandRequest dto) {
		
		String question = dto.getMonth() + "월에 " + dto.getParticipantCnt() + "명이 함께 가는" + dto.getLocation() + " 여행 일정 짜줘";
		return question;
	}

	public Long findTravelGroupIdxByUserId() {
		TravelGroup group = travelGroupRepository.findTravelGroupByMembersUserId(UserPrincipal.getUserPrincipal().getUserId());
		return group.getTgIdx();
	}
	
	
}
