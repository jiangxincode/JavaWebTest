package edu.jiangxin.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonTest {

	public static void main(String[] args) throws IOException {
		Student student1 = new Student();  
		student1.setId(5237);
		student1.setName("jingshou");
		student1.setBirthDay(new Date());
		
		Student student3 = new Student();  
	    student3.setId(5117);  
	    student3.setName("saiya");  
	    student3.setBirthDay(new Date());  
	    
	    ObjectMapper mapper = new ObjectMapper();
	      
	    //Convert between List and JSON
	    List<Student> stuList = new ArrayList<Student>();
	    stuList.add(student1);
	    stuList.add(student3);
	    String jsonfromList = mapper.writeValueAsString(stuList);
	    System.out.println(jsonfromList);
	    
	    //List Type is not required here.
	    List stuList2 = mapper.readValue(jsonfromList, List.class);
	    System.out.println(stuList2);    
	    System.out.println("************************************");
	    
	    //Convert Map to JSON
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("studentList", stuList);
	    map.put("class", "ClassName");
	    String jsonfromMap =  mapper.writeValueAsString(map);
	    System.out.println(jsonfromMap);
	    
	    Map map2 =  mapper.readValue(jsonfromMap, Map.class);
        System.out.println(map2);
        System.out.println(map2.get("studentList"));    
	    System.out.println("************************************");   
	    
	    //Convert Array to JSON
	    Student[] stuArr = {student1, student3};
	    String jsonfromArr =  mapper.writeValueAsString(stuArr);
	    System.out.println(jsonfromArr); 
	    Student[] stuArr2 =  mapper.readValue(jsonfromArr, Student[].class);
	    System.out.println(Arrays.toString(stuArr2));
	}

}