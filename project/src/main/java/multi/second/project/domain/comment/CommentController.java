package multi.second.project.domain.comment;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import multi.second.project.domain.comment.dto.request.CommentModifyRequest;
import multi.second.project.domain.comment.dto.request.CommentRegistRequest;
import multi.second.project.domain.gallery.dto.request.GalleryModifyRequest;
import multi.second.project.domain.gallery.dto.request.GalleryRegistRequest;
import multi.second.project.domain.gallery.dto.response.GalleryDetailResponse;
import multi.second.project.domain.member.dto.Principal;
import multi.second.project.infra.util.file.dto.FilePathDto;

@Controller
@AllArgsConstructor
@RequestMapping("comment")
public class CommentController {
	
	private final CommentService commentService;

	//갤러리 특정 포스트에서 댓글 작성 시
	@PostMapping("comment")
	public String comment(
			@SessionAttribute(name="auth", required=false) Principal principal,
			CommentRegistRequest dto
			) {
		commentService.createComment(dto);
		
		
		return "redirect:/";
	}
	
	//갤러리 특정 포스트에서 댓글 수정 시(해야되나?)
	@PostMapping("comment-modify")
	public String modify(
			CommentModifyRequest dto,
			@SessionAttribute("auth") Principal principal
			) {
		
		dto.setUserId(principal.getUserId());
		commentService.updateComment(dto);
		
		return "redirect:/";
	}
	
	//갤러리 특정 포스트에서 댓글 삭제 시(is_del이 true일 경우 "삭제된 댓글입니다."로 보여지게 할 것) 
	@PostMapping("comment-delete")
	public String delete(
			Long cmIdx, 
			@SessionAttribute("auth") Principal principal
			) {
		
		commentService.deleteComment(cmIdx, principal);
		
		return "redirect:/";
	}
	
	
	
	
}
