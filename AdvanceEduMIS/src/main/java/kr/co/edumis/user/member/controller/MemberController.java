package kr.co.edumis.user.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.edumis.user.member.service.MemberService;
import kr.co.edumis.user.member.vo.MemberVO;

@Controller
@RequestMapping("/user/member")
public class MemberController {
	@Autowired
	private MemberService service;

	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public ModelAndView join(MultipartHttpServletRequest req, MemberVO member) throws Exception {

		ModelAndView mav = new ModelAndView("/user/main");
		String realPath = servletContext.getRealPath("/memberFile");

		File file = new File(realPath);
		if (!file.exists()) {
			System.out.println(file.mkdirs());
		} else {
			System.out.println("디렉토리 존재함..");
		}

		Iterator<String> iter = req.getFileNames();
		while (iter.hasNext()) {

			String formFileName = iter.next();
			MultipartFile mult = req.getFile(formFileName);

			String oriName = mult.getOriginalFilename();

			if (oriName != null && !oriName.equals("")) {

				String ext = "";
				int index = oriName.lastIndexOf(".");
				if (index != -1) {
					ext = oriName.substring(index);
				}

				long fileSize = mult.getSize();
				String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;

				mult.transferTo(new File(realPath + "/" + saveFileName));

				service.insertMember(member);
			}
		}
		return mav;
	}

	@RequestMapping("/joinForm.do")
	public String joinForm() throws ServletException, IOException {
		return "redirect:/user/joinForm";
	}
}