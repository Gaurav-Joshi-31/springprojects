package com.foobar;

public class Bar {
private String name;
private int age;
private Foo foo;
public Bar(String name, int age) {
	this.name = name;
	this.age = age;
}
public void setFoo(Foo foo) {
	this.foo = foo;
}

public void processFooName() {
	System.out.println("name ="+foo.getName());
}
@Override
public String toString() {
	return "Bar [name=" + name + ", age=" + age + "]";
}


}
