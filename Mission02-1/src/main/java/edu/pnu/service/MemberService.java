package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberService {
	private List<MemberVO> list = new ArrayList<>();
}
