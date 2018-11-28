package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categorydao;
	@RequestMapping(value="/all/addCategory", method=RequestMethod.POST)
		public ModelAndView Success(@ModelAttribute("Categorys")Category category)
		{
				categorydao.addCategory(category);
				ModelAndView model=new ModelAndView("AddCategory","Category", new Category());
				return model;
		}

		@RequestMapping(value="/all/AddCategory", method=RequestMethod.GET)
		public ModelAndView getLogin(@ModelAttribute("Categorys")Category category)
		{
				System.out.println("Category");	
				ModelAndView model=new ModelAndView("AddCategory");
				return model;
		}
		
		@RequestMapping(value="/all/ViewCategory", method=RequestMethod.GET)
		public ModelAndView viewPage(@ModelAttribute("Categorys")Category category)
		{
				System.out.println("ViewCategory");	
				ModelAndView model=new ModelAndView();
				model.addObject("categorylist",categorydao.getAllCategory());
				
				model.setViewName("ViewCategory");
				
				return model;
		}
		
		@RequestMapping(value="/all/DeleteCategory", method = RequestMethod.GET)
		public ModelAndView deleteCategory(@RequestParam int id,Model d)
		{
            categorydao.deleteCategory(id);
		    System.out.println("DeleteCategory");
		    ModelAndView model = new ModelAndView();
		    model.addObject("categorylist", categorydao.getAllCategory());
	        model.setViewName("ViewCategory");
		    return model;
		}
		
		@RequestMapping(value="/all/edit", method=RequestMethod.POST)
		public ModelAndView editCategory(@ModelAttribute("cate")Category category)
		{
				categorydao.updateCategory(category);
				ModelAndView model=new ModelAndView();
				model.addObject("categorylist",categorydao.getAllCategory());
				model.setViewName("ViewCategory");
				return model;
		}

		@RequestMapping(value="/all/EditCategory", method=RequestMethod.GET)
		public ModelAndView getEdit(@RequestParam int id,Model d)
		{
			    Category category=categorydao.selectCategory(id);
		        d.addAttribute("Cate",category);
			    ModelAndView model=new ModelAndView("EditCategory","Category", new Category());
				return model;
		}

}
