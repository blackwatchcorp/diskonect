package com.blackwatch.diskonect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {
  @GetMapping
  public String index(@ModelAttribute("model") ModelMap model) {
    return "index";
  }

  @GetMapping("/hello")
  @ResponseBody
  public String test() {
    return "HELLO";
  }
}
