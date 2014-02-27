package ${query.resolve("root.package.name")};

  public class ${query.resolve("type.name")}{
  
  	private static ${query.resolve("type.name")} instance = null;
   
  	private ${query.resolve("type.name")}(){
	}
	
	public static ${query.resolve("type.name")} getInstance() {
		if(instance==null){
			instance = new ${query.resolve("type.name")}();
		}
		return instance;
	}
   
  }