package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.dao.UserDao;
import com.niit.model.User;

@Controller
public class RegisterController {
	@Autowired
	UserDao userdao;
	@RequestMapping(value="add", method=RequestMethod.POST)
		public ModelAndView Success(@ModelAttribute("Register")User user)
		{
				userdao.addUser(user);
				ModelAndView model=new ModelAndView("Register","User", new User());
				model.setViewName("Login");
				return model;
		}

		@RequestMapping(value="Register", method=RequestMethod.GET)
		public ModelAndView getLogin(@ModelAttribute("Register")User user)
		{
				System.out.println("Register");
				ModelAndView model=new ModelAndView("Register");
				return model;
		}
}
