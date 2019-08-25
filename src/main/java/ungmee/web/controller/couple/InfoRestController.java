package ungmee.web.controller.couple;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.CoupleService;


@RestController("coupleInfoRestController")
@RequestMapping("/couple/info")
public class InfoRestController {
	
	@Autowired
	private CoupleService coupleService;

	@PostMapping("accept")
	public int accept(Authentication auth , int cId) {
		CustomUserDetails aUser = (CustomUserDetails) auth.getPrincipal();
		int id = aUser.getId();
		int result = coupleService.proposeAccept(cId,id);
		return result;
	}
	
	@GetMapping("refuse")
	public int reject( int coupleId) {
		
		int result = coupleService.prposeRefuse(coupleId);
		return result;
	}
}

