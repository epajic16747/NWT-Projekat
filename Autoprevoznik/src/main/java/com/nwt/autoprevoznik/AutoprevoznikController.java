package com.nwt.autoprevoznik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AutoprevoznikController {
	
	@Autowired
	private AutoprevoznikService autoprevoznikService;
	
	
	@RequestMapping("/prevoznici")
	public List<Autoprevoznik> prikaziPrevoznike()
	{
		return autoprevoznikService.prikaziPrevoznike();
		
	}
	

}
