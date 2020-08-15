package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Demo;
import com.pojo.Demo2;
import com.pojo.People;

@Controller
public class DemoController {
	
	//四.传参
	//1. 把内容写到方法(HandlerMethod)参数中,SpringMVC只要有这个内容就注入内容.
	//2. 基本数据类型参数
//		2.1 默认保证参数名称和请求中传递的参数名相同
//	<input type="text" name="name"/>
//	<input type="text" name="age"/>
	@RequestMapping("demo")
	public String demo(String name, int age) {
		System.out.println("执行代码" + name + age);
		return "main";
	}
	
//	2.2 如果请求参数名和方法参数名不对应使用@RequestParam()赋值
//	<input type="text" name="name1"/>
//	<input type="text" name="age1"/>
	@RequestMapping("demo4")
	public String demo4(@RequestParam("name1") String name, @RequestParam("age1") int age) {
		System.out.println("执行代码" + name + age);
		return "main";
	}

//	2.3 如果方法参数是基本数据类型(不是封装类) 可以通过@RequestParam 设置默认值.
//	2.3.1 防止没有参数时500
	@RequestMapping("page")
	public String page(@RequestParam(defaultValue = "2") int pageSize, @RequestParam(defaultValue = "1") int pageNum) {
		System.out.println("执行代码" + pageSize + pageNum);
		return "main";
	}

	//2.4 可以强制要求必须有某个参数
	@RequestMapping("demo5")
	public String demo5(@RequestParam(required = true) String name) {
		System.out.println("要求必须传值" + name);
		return "main";
	}
	
	//3. HandlerMethod 中参数是对象类型
//	3.1 请求参数名和对象中属性名对应(get/set 方法)
//	<input type="text" name="name"/>
//	<input type="text" name="age"/>
	@RequestMapping("demo2")
	public String demo2(People peo) {
		System.out.println("执行代码2" + peo);
		return "main";
	}

//	<input type="text" name="name"/>
//	<input type="text" name="age"/>
	@RequestMapping("demo3")
	public String demo3(People peo, String name, int age, HttpServletRequest req, HttpSession session) {
		req.setAttribute("demo123", "测试");
		System.out.println("执行代码3-" + peo + name + age);
		return "main";
	}

	//4. 请求参数中包含多个同名参数的获取方式
//	4.1 复选框传递的参数就是多个同名参数
//	<input type="text" name="name"/>
//	<input type="text" name="age"/>
//	<input type="checkbox" name="hover" value="学习1" >
//	<input type="checkbox" name="hover" value="学习2" >
//	<input type="checkbox" name="hover" value="学习3" >
//	<input type="checkbox" name="hover" value="学习4" >
	@RequestMapping("demo6")
	public String demo6(String name, int age, @RequestParam("hover") List<String> hover) {
		System.out.println("要求必须传值" + name + age + hover);
		return "main";
	}

	//5. 请求参数中   对象.属性   格式
//	5.1 jsp 中代码
//	<input type="text" name="peo.name"/>
//	<input type="text" name="peo.age"/>
//	5.2 新建一个类
//		5.2.1 对象名和参数中点前面名称对应
//	5.3 控制器
	@RequestMapping("demo7")
	public String demo7(Demo demo) {
		System.out.println("要求必须传值" + demo);
		return "main";
	}

/*	6. 在请求参数中传递集合对象类型参数
	6.1 jsp 中格式
	<input type="text" name="peo[0].name"/>
	<input type="text" name="peo[0].age"/>
	<input type="text" name="peo[1].name"/>
	<input type="text" name="peo[1].age"/>
	6.2 新建类
	6.3 控制器*/
	@RequestMapping("demo8")
	public String demo8(Demo2 demo) {
		System.out.println("要求必须传值" + demo);
		return "main";
	}

//	<a href="demo9?age=123&name=abc">跳转</a>
	@RequestMapping("demo9")
	public String demo9(String name, int age) {
		System.out.println("执行代码" + name + age);
		return "main";
	}

/*	 7. restful 传值方式.
	7.1 简化jsp 中参数编写格式
	7.2 在jsp 中设定特定的格式
	 <a href="demo10/123/abc">跳转</a>
	7.3 在控制器中
		7.3.1 在@RequestMapping 中一定要和请求格式对应
		7.3.2 {名称} 中名称自定义名称
		7.3.3 @PathVariable 获取@RequestMapping 中内容,默认按照方法参数名称去寻找.*/
	@RequestMapping("demo10/{age}/{name1}")
	public String demo10(@PathVariable(value = "name1") String name, @PathVariable int age) {
		System.out.println("执行代码" + name + age);
		return "/main";
	}

	//四.跳转方式
	//1. 默认跳转方式请求转发.
	//2. 设置返回值字符串内容
	//2.1 添加redirect:资源路径  重定向
	//2.2 添加forward:资源路径    或省略forward:转发
	//如果希望不执行自定义视图解析器, 在方法返回值前面添加forward:或redirect:
	//转发
	@RequestMapping("demo11")
	public String demo11(String name, int age) {
		System.out.println("执行代码" + name + age);
		return "forward:/main.jsp";
	}

	// 重定向
	@RequestMapping("demo12")
	public String demo12(String name, int age) {
		System.out.println("执行代码" + name + age);
		return "redirect:/main.jsp";
	}

	// 自定义视图解析器加跳转
	@RequestMapping("demo13")
	public String demo13(String name, int age) {
		System.out.println("执行代码" + name + age);
		return "forward:demo14";
	}
	@RequestMapping("demo14")
	public String demo14() {
		System.out.println("执行代码14");
		return "main";
	}
	
/*	六.@ResponseBody
	1. 在方法上只有@RequestMapping时,无论方法返回值是什么认为需要跳转
	2. 在方法上添加@ResponseBody(恒不跳转)
		2.1 如果返回值满足key-value 形式(对象或map)
			2.1.1 把响应头设置为application/json;charset=utf-8
			2.1.2 把转换后的内容输出流的形式响应给客户端.
		2.2 如果返回值不满足key-value,例如返回值为String
			2.2.1 把相应头设置为text/html
			2.2.2 把方法返回值以流的形式直接输出.
			2.2.3 如果返回值包含中文,出现中文乱码
				2.2.3.1 produces 表示响应头中Content-Type 取值.
	3. 底层使用Jackson 进行json 转换,在项目中一定要导入jackson 的jar
		3.1 spring4.1.6 对jackson 不支持较高版本,jackson 2.7 无效.
		*/
	//如何把对象输出出来
	@RequestMapping("demo15")
	public void demo15(HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.print("abc");
		out.flush();
		out.close();
	}
	//如何把对象输出出来
//	@RequestMapping("demo16")
	@RequestMapping(value="demo16",produces="application/json;charset=utf-8")
	@ResponseBody
	public People demo16() throws IOException {
		People peo = new People();
		peo.setName("中文");
		peo.setAge(111);
		return peo;
	}
	//如何把对象输出出来
	@RequestMapping(value="demo17",produces="text/html;charset=utf-8")
	@ResponseBody
	public String demo17() throws IOException {
		return "中文";
	}
}
