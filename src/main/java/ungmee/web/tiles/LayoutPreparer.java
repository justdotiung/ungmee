package ungmee.web.tiles;


import java.util.List;
import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ungmee.web.entity.SoloView;
import ungmee.web.security.CustomUserDetails;
import ungmee.web.service.MemberShipService;
import ungmee.web.service.PushService;

@Component
public class LayoutPreparer implements ViewPreparer{
	
	@Autowired
	private PushService pushService;
	@Autowired
	private MemberShipService msService;
	
	@Override
	public void execute(Request tilesRequest, AttributeContext attributeContext) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			final CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
			final int id = user.getId();
			SoloView solo = msService.getSoloInfo(id);
			System.out.println("tiles id : " +id);
			int count = pushService.getNewPushCount(id);
			System.out.println(count);
			List<Map<String,Object>> list = pushService.getNewPushList(id);
			
			Map<String,Object> model = tilesRequest.getContext("request");
			model.put("count", count);
			model.put("list",list);
			model.put("user",solo);
		}
	}
}

//      // ********** <로그인 된 상태>에서 만 실행되는 코드 ******************
//      // course list for the authenticated user
//       if (!(auth instanceof AnonymousAuthenticationToken)) {
//           final UserDetails userDetails = (UserDetails) auth.getPrincipal();
//           final String username = userDetails.getUsername();
//           
//           Member member = memberDao.get(username);
//           
//           Map<String, Object> model = tilesRequest.getContext("request");           
//           model.put("member", member);
//       }


