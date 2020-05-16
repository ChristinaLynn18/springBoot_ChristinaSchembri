package p3.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import p3.jdbctemplate.dao.CatDAO;
import p3.jdbctemplate.model.Cat;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/rest/v1/cats")
public class CatRestController {
	private static final Logger logger = LoggerFactory.getLogger(CatRestController.class);

	@Autowired
	@Qualifier("catDAOImpl")
	private CatDAO catDAO;

	@RequestMapping(value="/echoMessage", method=RequestMethod.GET)
	
	@ApiOperation(value = "To test this REST end point is alive via echo",
	  		notes = "An optional message value can be passed into this echo service, via msg query param, to use in echoed String",
	  		response = String.class)
	public String echoMessage(@ApiParam(value = "optional message value to pass", required = false) @RequestParam(value="msg", defaultValue="Christina") String message) {
		logger.debug("echoMessage with message:{}", message);
		return "echoMessage echoes: " + message;
	}
	
	@GetMapping({"", "/all"})
	public  List<Cat> findAll() {
		List<Cat> cats = catDAO.findAll();
		return cats;
	}
	
	@GetMapping({"/{id}"})
	public  Optional<Cat> findById(@PathVariable Long id) {
		Optional<Cat> cat = catDAO.findById(id);
		return cat;
	}
	
	@GetMapping({"/byType{type}"})
	public  Optional<List<Cat>> findByType(@PathVariable String type) {
		Optional<List<Cat>> oCats = catDAO.findByType(type);
		return oCats;
	}
}
