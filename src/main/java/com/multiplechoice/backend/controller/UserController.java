/**
 * 
 */
package com.multiplechoice.backend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multiplechoice.backend.entities.User;
import com.multiplechoice.backend.service.UserService;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {
	private Logger logger = Logger.getLogger(this.getClass());

    @Autowired 
    private UserService userService;
    /** 
     * @Title: addPage 
     * @Description: 
     * @param mm 
     * @return    
     */ 
     @RequestMapping("addpage.jhtml")
     public String addPage(ModelMap mm)
     { 
         logger.info("add page...");
         return "/register";
     } 
     
     /** 
      * @Title: Regiseter 
      * @Description: Users add operation 
      * @param request 
      * @param response 
      * @param user 
      * @throws IOException 
      * @throws ServletException    
      */ 
      @RequestMapping("register.jhtml")
      public void Regiseter(HttpServletRequest request, HttpServletResponse response, User user)throws IOException, ServletException
      { 
          int result =0; 
          if (user != null)
          { 
              result = userService.addUser(user); 
          } 
          if (result >0) 
          { 
              logger.info("registration success..");
              response.sendRedirect("allUser.jhtml");
          } 
          else
          { 
              logger.error("registration failed");
              request.getRequestDispatcher("/500.jhtml").forward(request, response);
          } 
      } 
      
      /**
       * @Title: listUser
       * @Description: display all user
       * @param mm
       * @return info list user 
       */
      @RequestMapping("allUser.jhtml")
      public String listUser(ModelMap mm){
    	  List<User> list = userService.getUserList();
    	  mm.put("list", list);
		return "/userlist";
      }
      
      /** 
       * @Title: editUser 
       * @Description: Edit user information page
       * @param id 
       * @param mm 
       * @return    parameter 
       */ 
      @RequestMapping("editUser.jhtml")
      public String editUser(String id, ModelMap mm){
    	  User user = userService.getUser(Integer.parseInt(id));
    	  mm.put("user", user);
    	  return "/register";
      }
      
      /** 
       * @Title: updateUser 
       * @Description: Update user information
       * @param request 
       * @param response 
       * @param user 
       * @throws IOException 
       * @throws ServletException 
       * @throws Exception    parameter 
       */ 
      @RequestMapping("updateUser.jhtml")
      public void updateUser(HttpServletRequest request, HttpServletResponse response, User user) throws IOException, ServletException{
    	  int result = userService.updateUser(user);
    	  if(result > 0){
    		  logger.info("Update user data successful");
    		  response.sendRedirect("allUser.jhtml");
    	  }else{
    		  logger.error("Update user data failed");
    		  request.getRequestDispatcher("500.jhtml").forward(request, response);
    	  }
      }
      
      /** 
       * @Title: deleteUserById 
       * @Description: Delete a user record 
       * @param request 
       * @param response 
       * @param id 
       * @throws Exception    parameter 
       */ 
      @RequestMapping("deleteUser.jhtml")
      public void deleteUserById(HttpServletRequest request, HttpServletResponse response,String id) throws Exception 
      { 
          int result = userService.deleteUser(Integer.parseInt(id));
          if (result >0) 
          { 
              logger.info("Delete user data successful..");
              response.sendRedirect("allUser.jhtml");

          } 
          else
          { 
              logger.error("Delete user data failed..");
              request.getRequestDispatcher("500.jhtml").forward(request, response);

          } 
      } 
}
