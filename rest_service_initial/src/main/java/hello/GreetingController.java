package hello;
	
	import java.util.concurrent.atomic.AtomicLong;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	
	@RestController
	public class GreetingController {
	 private static final String template = "Hello, %s!";
	 private final AtomicLong counter = new AtomicLong();
	 @RequestMapping("/greeting")
	 public Greeting greeting(@RequestParam(value="name", defaultValue="World")
	String name) 
	 {
	return new Greeting(counter.incrementAndGet(),
	String.format(template, name));
	 }
	 
	private String history = "";
	
	@RequestMapping("/calculator/add")
	public String add(@RequestParam("op1") String op1, @RequestParam("op2") String op2)
    {
	     double op1_d=Double.parseDouble(op1);
	     double op2_d=Double.parseDouble(op2);
	     String result = op1+" + "+op2+" = "+String.valueOf(op1_d+op2_d);
         history = history + result + "<br>";
         return result;
    }
	
	@RequestMapping("/calculator/subtract")
	public String subtract(@RequestParam("op1") String op1, @RequestParam("op2") String op2)
	{
	    double op1_d = Double.parseDouble(op1);
	    double op2_d = Double.parseDouble(op2);
	    String result = op1 + " - " + op2 + " = " + String.valueOf(op1_d - op2_d);
	    history = history + result + "<br>";
	    return result;
	}

	@RequestMapping("/calculator/multiply")
	public String multiply(@RequestParam("op1") String op1, @RequestParam("op2") String op2)
	{
	    double op1_d = Double.parseDouble(op1);
	    double op2_d = Double.parseDouble(op2);
	    String result = op1 + " * " + op2 + " = " + String.valueOf(op1_d * op2_d);
	    history = history + result + "<br>";
	    return result;
	}

	@RequestMapping("/calculator/divide")
	public String divide(@RequestParam("op1") String op1, @RequestParam("op2") String op2) 
	{
	    double op1_d = Double.parseDouble(op1);
	    double op2_d = Double.parseDouble(op2);
	    if (op2_d == 0) {
	        return "Infinity";
	}
	    String result = op1 + " / " + op2 + " = " + String.valueOf(op1_d / op2_d);
	    history = history + result + "<br>";
	    return result;
	}

	@RequestMapping("/calculator/clear")
	public String clear()
	{
	    history = "";
	    return "Calculator history cleared.";
	}

	@RequestMapping("/calculator/history")
	public String history()
	{
	    return history;
	}
}
	
	


	 
