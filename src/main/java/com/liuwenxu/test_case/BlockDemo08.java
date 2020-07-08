package com.liuwenxu.test_case;

public class BlockDemo08 {
	static int a=8;
	double d=1.1;

	//空构造
	public BlockDemo08() {
		System.out.println("我是空构造...");
	}

	//构造块
	{
		System.out.println(a);
		System.out.println(d);
		a++;
		this.d++;
	}
	{
		System.out.println(a);
		System.out.println(d);
	}

	//静态块
	static{
		System.out.println("我是静态块1");
	}
	static{
		System.out.println("我是静态块2");
	}
	static{
		System.out.println("我是静态块3");
	}

	public static void main(String[] args) {
		System.out.println("main");
		int a=10;
		//普通语句块
		{
			a=5;
			//System.out.println(a);  //5
		}
		//System.out.println(a);  //5

		//创建对象
		BlockDemo08 bd1=new BlockDemo08();
		BlockDemo08 bd2=new BlockDemo08();
	}
}
