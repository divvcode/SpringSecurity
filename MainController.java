
package com.example.SpringSecurity.Controllers;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.service.UserService;

import ch.qos.logback.classic.Logger;

public class MainController {
	@Autowired
	private UserService userService;
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
    String currID = null;
    	
	 @GetMapping(value="/")
     public String showHomePage(ModelMap model, 
    		 @RequestParam(value="name", required=false, defaultValue="World") String name){
	     model.addAttribute("name", name);    
		 return "home";
     }
	 
	 @PostMapping(value="/index")
	 public String showIndexPage(@RequestParam("namelogin") String namelogin, @RequestParam("passwordlogin") String passwordlogin, ModelMap modelMap)
	 {
		 try {
			 User u = userService.GetUserByName(namelogin);
			 if(u.getName().equals(namelogin) && u.getPassword().equals(passwordlogin))
		     {
			     return "index";
			 }
			 else 
			 {
				 return "home";
			 }
		 }
		 catch(NullPointerException e) {
			 return "home";
		 }
	 }
	 
	 public boolean isNumber(String s)
	 {
		 if(s == null)
			 return false;
		 try
		 {
			 double db = Double.parseDouble(s);
		 }
		 catch(NumberFormatException e)
		 {
			 return false;
		 }
		 return true;
	 }
	 
	 @PostMapping("/update")                     
	 public String saveDetails(@RequestParam("id") String id, ModelMap modelMap) {
	        
		try 
		{
			User user = userService.GetUserById(Integer.valueOf(id));
			ArrayList<User> userList = new ArrayList<>();
			if(user != null)
			{
				userList.add(user);
				Iterable<User> users = userList;
				currID = id;
				modelMap.put("user", users);
			}
			else
				return "nouser";
		} 
		catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			return "nouser";
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
		modelMap.put("ID", id);
        return "update";           
	 }
	 
	 @PostMapping("/update1")                     
	 public String updateDetails(@RequestParam("nameedit") String nameedit, @RequestParam("emailedit") String emailedit, @RequestParam("passwordedit") String passwordedit, ModelMap modelMap) {
		 ArrayList<User> userList = new ArrayList<>();
		 try
		 {
			 User u = userService.GetUserById(Integer.valueOf(currID));
			 userService.setUser(u, nameedit, emailedit, passwordedit);
			 userList.add(u);
			 Iterable<User> users = userList;
			 modelMap.put("user", users);
		 }
		 catch (NumberFormatException e)
		 {
			e.printStackTrace();
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 modelMap.put("IDedit", currID);
		 
		 return "update1";
	 }

}
