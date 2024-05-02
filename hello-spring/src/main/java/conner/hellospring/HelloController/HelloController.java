package conner.hellospring.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//정적 컨텐츠 : 그냥 그저 파일만 받아와주는 패턴
//MVC와 템플릿엔진 : 컨트롤러와 템플릿엔진을 이용해 뷰를 동적으로 렌더링하는 패턴(html을 리턴)
//API : html이 아닌 데이터 자체를 동적으로 리턴하는 패턴

@Controller
public class HelloController {

    @GetMapping("hello") //hello에 대한 GET
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //data에 hello!!라는 값을 삽입해서 model에 담기: model(data:hello!!)
        return "hello"; //viewResolver가 templates안에서 hello라는 파일을 찾아 랜더링
    }

    //MVC
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API
    @GetMapping("hello-String")
    @ResponseBody //http의 body부분에 그대로 삽입(String)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //API
    @GetMapping("hello-api")
    @ResponseBody //http의 body부분에 그대로 삽입(객체 -> json 형식 데이터)
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;


//        Getter and Setter : property 접근 방식으로 외부에서 멤버변수에 접근하기 위한 방법
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    //SUAN
    @GetMapping("hello-suan")
    @ResponseBody
    public String hellosuan(@RequestParam("suan") String name) {
        return "사랑해 " +name;
    }

}
