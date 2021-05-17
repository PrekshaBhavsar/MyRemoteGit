package com.example.SportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportyShoes.entity.Admin;
import com.example.SportyShoes.entity.Shoes;
import com.example.SportyShoes.entity.User;
import com.example.SportyShoes.repository.AdminRepository;
import com.example.SportyShoes.repository.ShoesRepository;
import com.example.SportyShoes.repository.UserRepository;
import com.example.SportyShoes.service.AdminService;
import com.example.SportyShoes.service.ShoesService;
import com.example.SportyShoes.service.UserService;


@Controller
@RequestMapping("/sportyshoes")
public class ShoesController {
	
	@Autowired
	private ShoesService service;
	
	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private UserService Uservice;
	
	@Autowired
	private ShoesRepository repository;
	
	@Autowired
	private UserRepository Urepository;
	
	@Autowired
	private AdminRepository Adminrepository;

	
	@RequestMapping(value ="/Home",method = RequestMethod.GET)	
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value ="/Adminlogin",method = RequestMethod.GET)	
	public String login() {
		return "Adminlogin";
	}
	
	@RequestMapping(value ="/UserSignUp",method = RequestMethod.GET)	
	public String SignUp() {
		return "UserSignUp";
	}
	
	@RequestMapping(value ="/Checkout",method = RequestMethod.GET)	
	public String Checkout() {
		return "Checkout";
	}
	
	
	@RequestMapping(value ="/UserSignUp",method = RequestMethod.POST)	
	public String UserSignUp(ModelMap model,@RequestParam("uname") String Name,@RequestParam("password") String Password, @RequestParam("email") String Email) {
		
		User user1 = new User(Name,Email,Password);
		Urepository.save(user1);
		
		model.put("UserName", Name);
		return "UserAfterLogin";
	}
	
	@RequestMapping(value ="/UserSignIn",method = RequestMethod.GET)	
	public String SignIn() {
		return "UserSignIn";
	}
	
	@RequestMapping(value ="/UserSignIn",method = RequestMethod.POST)	
	public String UserSignIn(ModelMap model,@RequestParam("emailid") String Email,@RequestParam("password") String Password) {
		
		//User user1 = new User(Email,Password);
		User user1 = Uservice.findUserByEmail(Email);
		//System.out.println(user1.getName()+" "+user1.getPassword());
		if((user1.getPassword()).equals(Password)) {
			
			model.put("UserName", user1.getName());
			return "UserAfterLogin";
		}
		else {
			model.put("ErrorMessage", "Invalid Credentials");
			return "UserSignIn";
		}

	}
	
	
	@RequestMapping(value ="/AdminChangePassword",method = RequestMethod.GET)	
	public String AdminChangePassword() {
		return "AdminChangePassword";
	}
	
	@RequestMapping(value ="/Adminlogin",method = RequestMethod.POST)		
	public String loginvalid(ModelMap model,@RequestParam("uname") String name, @RequestParam("pass") String pass) {
		
		Admin admin1 = new Admin();
		admin1 = adminservice.findAdminByName(name);
		if((admin1.getPassword()).equals(pass)) {
			
			return "AllShoesData";
		}
		else {
			model.put("ErrorMessage", "Invalid Credentials");
			return "Adminlogin";
		}
	}
	@RequestMapping(value ="/AdminChangePassword",method = RequestMethod.POST)		
	public String loginvalid(ModelMap model,@RequestParam("uname") String name,@RequestParam("Currentpass") String Curpass,@RequestParam("Newpass") String Newpass) {
	
		Admin admin1 = new Admin();
		admin1 = adminservice.findAdminByName(name);
		if((admin1.getPassword()).equals(Curpass)) {
			
			admin1.setPassword(Newpass);
			Adminrepository.save(admin1);
			return "AllShoesData";
		}
		else {
			model.put("ErrorMessage", "Wrong CurrentPassword");
			return "AdminChangePassword";
		}
	}			
	
	@RequestMapping(value ="/AddShoes1",method = RequestMethod.POST)
	public String registerShoes(@RequestParam("addsize") String size, @RequestParam("addcolor") String color,
			@RequestParam("addgender") String gender, @RequestParam("addbrand") String brand,
			@RequestParam("adddate") String date) {
		String Ispuchased = "No";

		service.addShoes(size, color, gender, brand,date,Ispuchased);

		return "redirect:/sportyshoes/AllShoesData";
	}
	
	@RequestMapping(value ="/AllShoesData",method = RequestMethod.GET)
		public String loadAll(Model model) {
		List<Shoes> AllShoes = service.ListAllShoes();
		System.out.println("AllShoes "+ AllShoes);
		model.addAttribute("AllShoes",AllShoes);
		
			return "AllShoesData";			
		}
	
	@RequestMapping(value = "/filterByGender", method = RequestMethod.POST)
	public String FilterbyGender(Model model,@RequestParam("fgender") String Gender) {
		List<Shoes> FilterByGender = service.retrieveByGender(Gender);
		model.addAttribute("AllShoes",FilterByGender);
		return "AllShoesData";
	}
	
	@RequestMapping(value = "/filterByColor", method = RequestMethod.POST)
	public String filterByColor(Model model,@RequestParam("fcolor") String Color) {
		List<Shoes> filterByColor = service.retrieveByColor(Color);
		model.addAttribute("AllShoes",filterByColor);
		return "AllShoesData";
	}
	
	@RequestMapping(value = "/filterByBrand", method = RequestMethod.POST)
	public String filterByBrand(Model model,@RequestParam("fbrand") String Brand) {
		List<Shoes> filterByBrand = service.retrieveByBrand(Brand);
		model.addAttribute("AllShoes",filterByBrand);
		return "AllShoesData";
	}
	
	@RequestMapping(value = "/filterByPurchase", method = RequestMethod.POST)
	public String filterByIspurchased(Model model,@RequestParam("fpurchased") String Ispurchased) {
		List<Shoes> filterByIspurchased = service.retrieveByIspurchased(Ispurchased);
		model.addAttribute("AllShoes",filterByIspurchased);
		return "AllShoesData";
	}
	
	@RequestMapping(value = "/filterByDate", method = RequestMethod.POST)
	public String filterByDate(Model model,@RequestParam("fdate") String Date) {
		List<Shoes> filterByDate = service.retrieveByDate(Date);
		model.addAttribute("AllShoes",filterByDate);
		return "AllShoesData";
	}
	
	@RequestMapping(value = "/filterByAll", method = RequestMethod.GET)
	public String filterByAll(Model model,@RequestParam String Gender,@RequestParam String Color, 
			@RequestParam String Brand,@RequestParam String Ispurchased,@RequestParam String Date) {
		System.out.println("filter = "+Color+" "+Gender +" "+Brand+" "+Ispurchased+" "+Date);
		List<Shoes> filterByAll = service.retrieveByAll(Gender, Color, Brand, Ispurchased, Date);
		System.out.println(filterByAll);
		model.addAttribute("AllShoes",filterByAll);
		return "AllShoesData";
	}
	
	@RequestMapping(value ="/PurchaseReport",method = RequestMethod.GET)	
	public String PurchaseReport() {
		return "PurchaseReport";
	}
	
	@RequestMapping(value = "/PurchaseReport1", method = RequestMethod.POST)
	public String deleteRecord(Model model,@RequestParam("Reportdate") String Date) {
		String ispurchased = "Yes";
		System.out.println("Report date :" +Date);
		List<Shoes> PurchaseReportData = service.retrieveBypurchasedate(ispurchased, Date);
		System.out.println("ReportEntry :" +PurchaseReportData);
	    model.addAttribute("AllPurchasedShoes",PurchaseReportData);
		return "PurchaseReport";
	}
	
	@RequestMapping(value = "/delete-Shoe", method = RequestMethod.GET)
	public String deleteRecord(@RequestParam Long id) {
		System.out.println("id delete = "+ id);
		service.deletebyid(id);
		return "redirect:/sportyshoes/AllShoesData";
	}

	
	@RequestMapping(value = "/update-Shoe", method = RequestMethod.POST)
	public String UpdateRecord(@RequestParam("getId") Long Id,@RequestParam("updatesize") String Size, 
			@RequestParam("updatecolor") String Color,@RequestParam("updategender") String Gender, 
			@RequestParam("updatebrand") String Brand,@RequestParam("updatedate") String Date) {
		System.out.println("update = "+ Id +" "+ Size +" "+ Color +" "+Gender+" "+Brand +" "+Date);
		
		repository.updateProduct(Id, Size, Color, Brand, Gender, Date);
		return "redirect:/sportyshoes/AllShoesData";
	}
	
	@RequestMapping(value ="/AllUser",method = RequestMethod.GET)
	public String loadAllUser(Model model) {
	List<User> AllUserdata = Urepository.findAll();
	model.addAttribute("AllUserdata",AllUserdata);
	
		return "AllUser";			
	}
	

}
