package lys.test.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TestFileSystemJNDI {

	public static void main(String[] args) throws NamingException {

		Hashtable env = new Hashtable();
		String name = "C:\\easymock-3.2.zip";
		// 文件系统服务的提供者
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		Context ctx = new InitialContext(env);
		// 通过上下文查找名称对应的对象
		Object obj = ctx.lookup(name);
		System.out.println("名称：[" + name + "]绑定的对象是:" + obj);

	}

}
