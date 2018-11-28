package com.niit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;


@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierdao;
	@RequestMapping(value="/all/addSupplier", method=RequestMethod.POST)
		public ModelAndView Success(@ModelAttribute("Suppliers")Supplier supplier)
		{
				supplierdao.addSupplier(supplier);
				ModelAndView model=new ModelAndView("AddSupplier","Supplier", new Supplier());
				return model;
		}

	@RequestMapping(value="/all/AddSupplier", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("Suppliers")Supplier supplier)
	{
			System.out.println("Supplier");	
			ModelAndView model=new ModelAndView("AddSupplier");
			return model;
	}

	@RequestMapping(value="/all/ViewSupplier", method=RequestMethod.GET)
	public ModelAndView viewPage(@ModelAttribute("Suppliers")Supplier supplier)
	{
			System.out.println("ViewSupplier");	
			ModelAndView model=new ModelAndView();
			model.addObject("supplierlist",supplierdao.getAllSupplier());
			
			model.setViewName("ViewSupplier");
			
			return model;
	}
	
	@RequestMapping(value="/all/DeleteSupplier", method = RequestMethod.GET)
	public ModelAndView deleteSupplier(@RequestParam int id,Model d)
	{
        supplierdao.deleteSupplier(id);
	    System.out.println("DeleteSupplier");
	    ModelAndView model = new ModelAndView();
	    model.addObject("supplierlist", supplierdao.getAllSupplier());
        model.setViewName("ViewSupplier");
	    return model;
	}
	
	@RequestMapping(value="/all/edits", method=RequestMethod.POST)
	public ModelAndView editSupplier(@ModelAttribute("Supp")Supplier supplier)
	{
			supplierdao.updateSupplier(supplier);
			ModelAndView model=new ModelAndView();
			model.addObject("supplierlist",supplierdao.getAllSupplier());
			model.setViewName("ViewSupplier");
			return model;
	}

	@RequestMapping(value="/all/EditSupplier", method=RequestMethod.GET)
	public ModelAndView getEdit(@RequestParam int id,Model d)
	{
		    Supplier supplier=supplierdao.selectSupplier(id);
	        d.addAttribute("Supp",supplier);
		    ModelAndView model=new ModelAndView("EditSupplier","Supplier", new Supplier());
			return model;
	}
}
