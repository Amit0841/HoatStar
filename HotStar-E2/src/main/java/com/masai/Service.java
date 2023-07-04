package com.masai;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.masai.Dto.Content;
import com.masai.Dto.User;



@org.springframework.stereotype.Service
public class Service {
	
Set<Content> setCont =new TreeSet<>();
Set<User> setUser =new TreeSet<>();

//@PostConstruct
//void innit(){
//	setCont.add(new Content(1, "Dit", "nice Movie", "Funny Movie", "3 Hr"));
//	setUser.add(new User(1, "a", "koko78.gmail.com"));
//}

// add Content
public ResponseEntity<String> addContent(Content c) {
	if(c==null)
		return new ResponseEntity<String>("Content is invalid",HttpStatus.BAD_REQUEST);
	boolean o=setCont.stream().anyMatch(a->a.getContentId()==c.getContentId());
	
	if(o)
	return new ResponseEntity<String>("Content Already Present",HttpStatus.BAD_REQUEST);
	
	boolean o1=setCont.stream().anyMatch(a->a.getDescription().equals(c.getDescription()));
	if(o1)
	return new ResponseEntity<String>("Content Description same on ContentId "+c.getContentId(),HttpStatus.BAD_REQUEST);
	setCont.add(c);
	return new ResponseEntity<String>("added",HttpStatus.OK);
}

//get Content
public ResponseEntity<List<Content>> browseContent() {
	List<Content> list=new ArrayList<>();
	
	setCont.forEach(a->list.add(a));
	if(list.isEmpty())
		throw new IllegalArgumentException("No content is There");
	
	return new ResponseEntity<List<Content>>(list,HttpStatus.OK);
}

//add user
public ResponseEntity<String> registerUser(User user) {
	if(user==null)
		return new ResponseEntity<String>("User is invalid",HttpStatus.BAD_REQUEST);
	
	boolean o=setUser.stream().anyMatch(a->a.getUserId()==user.getUserId());
	if(o)
	return new ResponseEntity<String>("User Already Present ",HttpStatus.BAD_REQUEST);
	
	boolean o1=setUser.stream().anyMatch(a->a.getEmail().equals(a.getEmail()) );
	if(o1)
	return new ResponseEntity<String>("User Email Already Present ",HttpStatus.BAD_REQUEST);
	
	setUser.add(user);
	System.out.println(setUser.size());
	return new ResponseEntity<String>("User Added",HttpStatus.OK);
}
// Content To Stream
public ResponseEntity<String> chooseContentToStream(Integer userId, Integer contentId) {
	
	List<User> u=setUser.stream().filter(a->a.getUserId()==userId).toList();
	if(u.isEmpty())
		return new ResponseEntity<String>("User Not Present ",HttpStatus.BAD_REQUEST);
	User q=u.get(0);
	
	List<Content> c=setCont.stream().filter(a->a.getContentId()==contentId).toList();
	if(c.isEmpty())
		return new ResponseEntity<String>("content Not Present ",HttpStatus.BAD_REQUEST);
	
	boolean boo=q.getContentToStream().stream().anyMatch(a->a.getContentId()==contentId);
	
	if(boo)
	return new ResponseEntity<String>("content Already Stream by user",HttpStatus.BAD_REQUEST);
	
	q.getContentToStream().add(c.get(0));
	
	return new ResponseEntity<String>("Content Stream by user",HttpStatus.OK);
}
// get users
public ResponseEntity<List<User>> browseUser() {
	List<User> list=new ArrayList<>();
	
	setUser.forEach(a->list.add(a));
	
	return new ResponseEntity<List<User>>(list,HttpStatus.OK);
}

public List<Content> provideRecommendations(Integer userId) {
	List<Content> clist=new ArrayList<>();
	
	List<User> u=setUser.stream().filter(a->a.getUserId()==userId).toList();
	if(u.isEmpty())
		throw new IllegalArgumentException("User Not Present "+userId);
	User q=u.get(0);
	
	List<Content>e= q.getContentToStream().stream().filter(a->a.getCategory()!="").toList();
	
	if(e.isEmpty())
		throw new IllegalArgumentException("User Not View any content "+userId);
	
	List<Content> c=setCont.stream().filter(a->a.getCategory().equals(e.get(0).getCategory())).toList();
	
	return c;
}


}
