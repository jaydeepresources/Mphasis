package com.mphasis.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.app.crud.Post;
import com.mphasis.app.crud.Status;
import com.mphasis.app.dao.PostDAOImpl;

@Controller
public class PostsController {

	private static final Logger logger = LoggerFactory.getLogger(PostsController.class);

	PostDAOImpl impl = new PostDAOImpl();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addPost(@RequestParam() String title, @RequestParam() String body) {
		Post res = impl.insert(new Post(0, title, body));

		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "Your post has been added successfully !");

		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updatePost(@RequestParam() int id, @RequestParam() String title, @RequestParam() String body) {

		try {
			Post res = impl.update(new Post(id, title, body));
			ModelAndView mv1 = new ModelAndView("success");
			mv1.addObject("msg", "Your post has been updated successfully !");
			return mv1;
		} catch (Exception e) {
			ModelAndView mv2 = new ModelAndView("error");
			mv2.addObject("msg", "Your post couldn't be updated successfully !");
			return mv2;
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deletePost(@RequestParam() int id) {

		try {
			Status res = impl.delete(new Post(id, "", ""));
			ModelAndView mv1 = new ModelAndView("success");
			mv1.addObject("msg", "Your post has been deleted successfully !");
			return mv1;
		} catch (Exception e) {
			ModelAndView mv2 = new ModelAndView("error");
			mv2.addObject("msg", "Your post couldn't be deleted successfully !");
			return mv2;
		}

	}

}
